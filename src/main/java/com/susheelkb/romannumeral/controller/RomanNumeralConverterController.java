/**
 * 
 */
package com.susheelkb.romannumeral.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.susheelkb.romannumeral.domain.RomanNumber;
import com.susheelkb.romannumeral.service.RomanNumeralConverterService;

import  org.slf4j.Logger;

/**
 * 
 * @author susheel.kaparaboyna
 *
 */
@RestController
@Validated
public class RomanNumeralConverterController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private RomanNumeralConverterService romanNumeralConverterService;
	
	@GetMapping("/romannumeral")
    public ResponseEntity<RomanNumber> toRomanNum( @RequestParam("query") Integer number) {	
		RomanNumber romanNumber = romanNumeralConverterService.toRomanNumber(number);
		logger.info("API-CALLED "+number);
		return ResponseEntity.ok(romanNumber);
    }
}
