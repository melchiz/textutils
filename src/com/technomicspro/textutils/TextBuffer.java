/**
 * 
 */
package com.technomicspro.textutils;

/**
 * @author Melchiz Oyamo
 * @author <a href="http://www.technomicspro.com">Technomicspro Inc. </a>
 * @version 1.0
 * 
 *
 */
public class TextBuffer {

	private StringBuffer val;

	/**
	 * Constructs a text buffer with no characters in it and an initial capacity of
	 * 16 characters.
	 */
	public TextBuffer() {
		set(new StringBuffer());
	}

	/**
	 * Returns the value of this text buffer object
	 * 
	 * @return the value of this text buffer object
	 */
	public StringBuffer toStringBuffer() {
		return val;
	}

	/**
	 * @param val
	 *            the value to set
	 */
	private void set(StringBuffer val) {
		this.val = val;
	}

}
