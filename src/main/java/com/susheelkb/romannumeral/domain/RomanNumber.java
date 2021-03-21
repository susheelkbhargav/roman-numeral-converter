package com.susheelkb.romannumeral.domain;

public class RomanNumber {
	private int input;
	private String output;

	/**
	 * 
	 */
	public RomanNumber() {

	}

	/**
	 * 
	 * @param input
	 * @param output
	 */
	public RomanNumber(int input, String output) {
		this.input = input;
		this.output = output;
	}

	/**
	 * 
	 * @return
	 */
	public int getInput() {
		return input;
	}

	/**
	 * 
	 * @param input
	 */
	public void setInput(int input) {
		this.input = input;
	}

	/**
	 * 
	 * @return
	 */
	public String getOutput() {
		return output;
	}

	/**
	 * 
	 * @param output
	 */
	public void setOutput(String output) {
		this.output = output;
	}

	/**
	 * 
	 * @return
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		RomanNumber that = (RomanNumber) obj;
		return (input == that.input) && output.equals(that.output);
	}

}
