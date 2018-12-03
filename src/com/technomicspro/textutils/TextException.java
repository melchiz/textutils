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
public class TextException extends Exception {

	private static final long serialVersionUID = 1L;

	public TextException(Text message) {
		super(message.toString());
	}

}
