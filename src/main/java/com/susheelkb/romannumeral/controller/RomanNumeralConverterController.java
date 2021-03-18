/**
 * 
 */
package com.susheelkb.romannumeral.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.susheelkb.romannumeral.domain.RomanNumber;
import com.susheelkb.romannumeral.service.RomanNumeralConverterService;

/**
 * 
 * @author susheel.kaparaboyna
 *
 */
@RestController
public class RomanNumeralConverterController {

	@Autowired
	private RomanNumeralConverterService romanNumeralConverterService;
	
	@GetMapping("/romannumeral")
    public ResponseEntity<RomanNumber> toRomanNum( @RequestParam("query") Integer number) {	
		RomanNumber romanNumber = romanNumeralConverterService.toRomanNumber(number);
		return ResponseEntity.ok(romanNumber);
    }
}
