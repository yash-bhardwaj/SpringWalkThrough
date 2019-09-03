/**
 * 
 */
package com.bmw.imiles.controller;

import java.util.Collections;

import javax.validation.Valid;
import javax.validation.constraints.Null;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bmw.imiles.model.ImilesRequest;
import com.bmw.imiles.model.ImilesResponse;
import com.bmw.imiles.service.ImilesWalletService;

/**
 * @author avadheshkumar
 *
 */
@RestController
@RequestMapping("/imiles")
public class ImilesWalletController {
	@Autowired
	ImilesWalletService imilesWalletService;

	@PreAuthorize("hasAnyRole('ADMIN','USER')")
	@GetMapping(value = "/getImiles", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<?> getImiles(@RequestParam(value = "gcid", required = false) String gcid,
			@RequestParam(value = "vin", required = false) String vin) {
		return imilesWalletService.getImilesBalanceInquiry(gcid, vin);
	}

	@PreAuthorize("hasAnyRole('ADMIN','USER')")
	@GetMapping("/getHello")
	ResponseEntity<?> getHello() {
		return new ResponseEntity<>(new ImilesResponse("success", HttpStatus.OK.value(), Collections.emptyList()),
				HttpStatus.OK);
	}

	@PreAuthorize("hasAnyRole('ADMIN','USER')")
	@PutMapping(value = "/{gcid}/updateRedeemImiles/{vin}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<?> updateRedeemImiles(@PathVariable("gcid") String gcid, @PathVariable("vin") String vin,
			@Valid @RequestBody(required = true) ImilesRequest imilesRequest) {
		imilesRequest.setGcid(gcid);
		imilesRequest.setVehicleNo(vin);
		return imilesWalletService.updateRedeemImiles(imilesRequest);
	}
}
