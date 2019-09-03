/**
 * 
 */
package com.bmw.imiles.service.impl;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bmw.imiles.entity.Imiles;
import com.bmw.imiles.model.ImilesRequest;
import com.bmw.imiles.model.ImilesResponse;
import com.bmw.imiles.repository.ImilesWalletRepository;
import com.bmw.imiles.service.ImilesWalletService;
import com.bmw.imiles.util.ImilesUtil;

/**
 * @author avadheshkumar
 *
 */
@Service
@Qualifier("imilesWalletService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class ImilesWalletServiceImpl implements ImilesWalletService {

	@Autowired
	private ImilesWalletRepository imilesWalletRepository;

	@Override
	public ResponseEntity<?> getImilesBalanceInquiry(String gcid, String vin) {
		try {
			List<?> imilesList = null != gcid && null != vin ? imilesWalletRepository.getImilesByGCIDAndVIN(gcid, vin, Boolean.TRUE) : imilesWalletRepository.findAll();
			return new ResponseEntity<>(new ImilesResponse("success", HttpStatus.OK.value(), imilesList), HttpStatus.OK);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<>(new ImilesResponse("Error", HttpStatus.EXPECTATION_FAILED.value(), null), HttpStatus.OK);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public ResponseEntity<?> updateRedeemImiles(@Valid ImilesRequest imilesRequest) {
		if(null != imilesRequest) {
			ResponseEntity<?> balanceEnquiryResponse = getImilesBalanceInquiry(imilesRequest.getGcid(), imilesRequest.getVehicleNo());
			ImilesResponse imilesResponse = (ImilesResponse)balanceEnquiryResponse.getBody();
			List<Imiles>imilesList =(List<Imiles>) imilesResponse.getData();
			
			if(null!=imilesList && !imilesList.isEmpty()) {
				Imiles updateImile = imilesList.get(0);
				Imiles transactedImile = ImilesUtil.createImiles(updateImile, imilesRequest);
				updateImile.setLatest(Boolean.FALSE);
				updateImile.setLastUpdationDate(new Date());
				imilesWalletRepository.saveAndFlush(updateImile);
				imilesWalletRepository.save(transactedImile);
				return new ResponseEntity<>(new ImilesResponse("success", HttpStatus.OK.value(), Collections.singletonList("Imiles successfully updated or redeemed")), HttpStatus.OK);
			}else {
				return new ResponseEntity<>(new ImilesResponse("success", HttpStatus.OK.value(), Collections.singletonList("No data found for gcid -> "+ imilesRequest.getGcid() +" or vin -> "+imilesRequest.getVehicleNo())), HttpStatus.OK);
			}
		}else
			return new ResponseEntity<>(new ImilesResponse("Error", HttpStatus.BAD_REQUEST.value(), Collections.singletonList("Invalid Imiles request")), HttpStatus.OK);
	}
}
