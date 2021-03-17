/**
 * 
 */
package com.susheelkb.romannumeral.service;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.springframework.stereotype.Service;

import com.susheelkb.romannumeral.domain.RomanNumber;

/**
 *
 * 
 * @author : Susheel Kaparaboyna
 *
 */
@Service
public class RomanNumeralConverterService {

	private static final Integer MIN_NUMBER_TO_CONVERT = 1;
	private static final Integer MAX_NUMBER_TO_CONVERT = 3999;	
	private static final Map<Integer, String> CORRESPONDING_ROMAN = new LinkedHashMap<Integer,String>();
	
	static {
		CORRESPONDING_ROMAN.put( 1000, "M" );
		CORRESPONDING_ROMAN.put( 900, "CM" );
		CORRESPONDING_ROMAN.put( 500, "D" );
		CORRESPONDING_ROMAN.put( 400, "CD" );
		CORRESPONDING_ROMAN.put( 100, "C" );
		CORRESPONDING_ROMAN.put( 90, "XC" );
		CORRESPONDING_ROMAN.put( 50, "L" );
		CORRESPONDING_ROMAN.put( 40, "XL" );
		CORRESPONDING_ROMAN.put( 10, "X" );
		CORRESPONDING_ROMAN.put( 9, "IX" );
		CORRESPONDING_ROMAN.put( 5, "V" );
		CORRESPONDING_ROMAN.put( 4, "IV" );
		CORRESPONDING_ROMAN.put( 1, "I");
		
	}
	
	/**
	 * Returns the Roman numeral equivalent of the given number.
	 * @param numberToConvert
	 * @return Roman Numeral
	 */
	
	public RomanNumber toRomanNumber(Integer numberToConvert) {
		RomanNumber romanNumber = new RomanNumber();
		if(numberToConvert >= MIN_NUMBER_TO_CONVERT && numberToConvert <= MAX_NUMBER_TO_CONVERT){
			romanNumber.setInput(numberToConvert);
			StringBuilder result = new StringBuilder();
			for(Entry<Integer, String> entry : CORRESPONDING_ROMAN.entrySet()){
				while(entry.getKey()<=numberToConvert){
					result.append(entry.getValue());
					numberToConvert-=entry.getKey();
				}
			}
			romanNumber.setOutput(result.toString());
			return romanNumber;
		}else{
			throw new RuntimeException( "The number entered must be between" + MIN_NUMBER_TO_CONVERT + "and"
											+ MAX_NUMBER_TO_CONVERT);
		}
		
	}
}