/**
 * 
 */
package com.bmw.imiles.ext.component.controller;

import java.util.Collections;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bmw.imiles.model.ImilesResponse;

/**
 * @author avadheshkumar
 *
 */
@RestController
@RequestMapping("/imiles/external")
public class ImilesExternalComponent {
@PostMapping(value = "/postImiles", produces=MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<?> postImiles(){
	
	System.out.println("Posting Imiles Data");
	return new ResponseEntity<>(new ImilesResponse("success", HttpStatus.OK.value(), Collections.singletonList("Imiles Data posted successfully")), HttpStatus.OK);
}
}
