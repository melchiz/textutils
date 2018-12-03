package com.technomicspro.textutils;

/**
 * @author Melchiz Oyamo
 * @author <a href="http://www.technomicspro.com">Technomicspro Inc. </a>
 * @version 1.0
 * 
 *
 */
public abstract class TextRegexPattern {

	/** Pattern p; */

	/**
	 * . Any character (may or may not match line terminators)
	 * 
	 * @see #CHAR_DOT
	 */
	public static final Text CHAR_ANY = new Text(".");

	/**
	 * . Any character (may or may not match line terminators)
	 * 
	 * @see #CHAR_ANY
	 */
	public static final Text CHAR_DOT = new Text(".");
	/**
	 * \d A digit: [0-9]
	 */
	public static final Text CHAR_DIGIT = new Text("\\d");
	/**
	 * \D A non-digit: [^0-9]
	 */
	public static final Text CHAR_NON_DIGIT = new Text("\\D");
	/**
	 * \h A horizontal whitespace character: [
	 * \t\xA0\u1680\u180e\u2000-\u200a\u202f\u205f\u3000]
	 */
	public static final Text CHAR_HORIZONTAL_WHITESPACE = new Text("\\h");
	/**
	 * \H A non-horizontal whitespace character: [^\h]
	 */
	public static final Text CHAR_NON_HORIZONTAL_WHITESPACE = new Text("\\H");
	/**
	 * \s A whitespace character: [ \t\n\x0B\f\r]
	 */
	public static final Text CHAR_WHITESPACE = new Text("\\s");
	/**
	 * \S A non-whitespace character: [^\s]
	 */
	public static final Text CHAR_NON_WHITESPACE = new Text("\\S");
	/**
	 * \v A vertical whitespace character: [\n\x0B\f\r\x85\u2028\u2029]
	 */
	public static final Text CHAR_VERTICAL_WHITESPACE = new Text("\\v");
	/**
	 * \V A non-vertical whitespace character: [^\v]
	 */
	public static final Text CHAR_NON_VERTICAL_WHITESPACE = new Text("\\V");
	/**
	 * \w A word character: [a-zA-Z_0-9]
	 */
	public static final Text CHAR_WORD = new Text("\\w");
	/**
	 * \W A non-word character: [^\w]
	 * 
	 */
	public static final Text CHAR_NON_WORD = new Text("\\W");
	/**
	 * \p{Lower} A lower-case alphabetic character: [a-z]
	 */
	public static final Text POSIX_LOWER = new Text("\\p{Lower}");
	/**
	 * \p{Upper} An upper-case alphabetic character:[A-Z]
	 */
	public static final Text POSIX_UPPER = new Text("\\p{Upper}");
	/**
	 * \p{ASCII} All ASCII:[\x00-\x7F]
	 */
	public static final Text POSIX_ASCII = new Text("\\p{ASCII}");
	/**
	 * \p{Alpha} An alphabetic character:[\p{Lower}\p{Upper}]
	 */
	public static final Text POSIX_ALPHA = new Text("\\p{Alpha}");
	/**
	 * \p{Digit} A decimal digit: [0-9]
	 */
	public static final Text POSIX_DIGIT = new Text("\\p{Digit}");
	/**
	 * \p{Alnum} An alphanumeric character:[\p{Alpha}\p{Digit}]
	 */
	public static final Text POSIX_ALNUM = new Text("\\p{Alnum}");
	/**
	 * \p{Punct} Punctuation: One of !"#$%&'()&#42;+,-./:;<=>?@[\]^_`{|}~
	 */
	public static final Text POSIX_PUNCTUATION = new Text("\\p{Punct}");
	/**
	 * \p{Graph} A visible character: [\p{Alnum}\p{Punct}]
	 */
	public static final Text POSIX_GRAPHIC = new Text("\\p{Graph}");
	/**
	 * \p{Print} A printable character: [\p{Graph}\x20]
	 */
	public static final Text POSIX_PRINT = new Text("\\p{Print}");
	/**
	 * \p{Blank} A space or a tab: [ \t]
	 */
	public static final Text POSIX_BLANK = new Text("\\p{Blank}");
	/**
	 * \p{Cntrl} A control character: [\x00-\x1F\x7F]
	 */
	public static final Text POSIX_CONTROL = new Text("\\p{Cntrl}");
	/**
	 * \p{XDigit} A hexadecimal digit: [0-9a-fA-F]
	 */
	public static final Text POSIX_HEX_DIGIT = new Text("\\p{XDigit}");
	/**
	 * \p{Space} A whitespace character: [ \t\n\x0B\f\r]
	 * 
	 */
	public static final Text POSIX_SPACE = new Text("\\p{Space}");
	/**
	 * Matches a digit character: [0-9]
	 */

	public static final Text DIGIT = Text.valueOf("[0-9]");

	/**
	 * Matches an expression with one or more digits
	 */
	public static final Text INTEGER = new Text(TextRegexPattern.CHAR_DIGIT, "+");

	/**
	 * Matches an expression of the format: [INTEGER][DOT][INTEGER] or
	 * [DOT][INTEGER], e.g 455.67, .89
	 */
	public static final Text DECIMAL = new Text(TextRegexPattern.INTEGER, "\\.", TextRegexPattern.INTEGER, "|\\.",
			TextRegexPattern.INTEGER);

	/**
	 * Matches an expression of the format: integer or decimal, e.g 575757, 455.67
	 */
	public static final Text NUMBER = new Text(TextRegexPattern.INTEGER, "|", TextRegexPattern.DECIMAL);
	/**
	 * Zero or more characters
	 */
	public static final Text TEXT = new Text(CHAR_ANY, "*");

	private TextRegexPattern() {
	}

}
