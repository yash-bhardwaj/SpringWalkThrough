package com.bmw.imiles.service;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;

import com.bmw.imiles.model.ImilesRequest;

/**
 * 
 * @author avadheshkumar
 *
 */
public interface ImilesWalletService {
	public ResponseEntity<?> getImilesBalanceInquiry(String gcid, String vin);

	public ResponseEntity<?> updateRedeemImiles(@Valid ImilesRequest imilesRequest);
}
