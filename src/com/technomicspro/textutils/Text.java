/**
 * this is a
 */
package com.technomicspro.textutils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * <p>
 * The Text class is a wrapper type for representing character strings. Text
 * objects are wrappers implemented as instances of the Java String class. Like
 * Java's Strings, Texts are are constant and their values are not modifiable
 * upon creation.
 * 
 * Here are some more examples of how strings can be used:
 * 
 * Text abc = new Text("abc"); System.out.println(abc); System.out.println(new
 * Text("abc").toString() + cde); Text c = "abc".substring(2,3); Text d =
 * cde.substring(1, 2);
 * </p>
 * 
 * 
 * <p>
 * The class Text includes not only methods for such purposes as examining
 * individual characters of the text sequence, comparing texts, searching texts,
 * extracting sub-texts, and creating a copy of a text with all characters
 * translated to uppercase, or lowercase, but also provides useful methods for
 * generating random cases, sentence cases, title cases, camel cases, titled
 * camel case
 * </p>
 * 
 * 
 * <p>
 * Like the Java String class, passing null arguments constructors or methods in
 * the Text class will trigger a NullPointerException to be thrown.
 * </p>
 * 
 * 
 * <p>
 * The Text class also offers methods for dealing with Unicode code points
 * (characters), besides those for manipulating Unicode code units (char
 * values), among other useful methods.
 * </p>
 * 
 * 
 * @author Melchiz Oyamo
 * @author <a href="http://www.technomicspro.com">Technomicspro Inc. </a>
 * @version 1.0
 * @since Version 1.0
 * 
 *
 */

public class Text implements Iterable<Text> {
	private String val;

	private int len;

	private static final String LETTERS_SMALL = "abcdefghijklmnopqrstuvwxyz";

	private static final String LETTERS_CAPS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

	private static final String NUMERICS = "0123456789";

	private static final String ALPHANUMERICS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

	private static final String LETTERS_VOWELS = "aeiou";

	private static final String LETTERS_CONSONANTS = "bcdfghjklmnpqrstvwxyz";

	// private static final String PUNCTUATIONS =
	// "`~!@#$%^&*()_-=+|\\{[}]:;\"'<,>.?/";

	private static final String PATH_ILLEGALS = "`~!#$%^*+\\|\\{}:;\"'<,>?/";

	private static final String PATH_ILLEGALS_WINDOWS = "\\/:?\"<>\\|";

	public Text() {
		this("");
	}

	/**
	 * Creates a text based on the the object argument. This has the same effect as
	 * {@link Text#valueOf(Object)} or making the method call {@link #toString()}
	 * 
	 * @param object
	 *            an object
	 */
	public Text(Object object) {
		this(object.toString());
	}

	/**
	 * Creates a text based on the the object arguments
	 * 
	 * @param o
	 *            an array of objects of arbitrary length
	 */
	public Text(Object... o) {
		this(new Text().c(o));
	}

	/**
	 * Creates a text based on the the string argument
	 * 
	 * @param text
	 *            a string object
	 */
	public Text(String text) {
		setText(text);
		len = (text != null) ? text.length() : 0;
	}

	/**
	 * Creates a text based on the the text arguments
	 * 
	 * @param text
	 *            a text object
	 */
	public Text(Text text) {
		this(text.toString());
	}

	/**
	 * @param data
	 *            the character array.
	 * @return Returns:a String that contains the characters of the character array.
	 */
	public static Text copyValueOf(char[] data) {
		return new Text(String.copyValueOf(data));

	}

	/**
	 * @param data
	 *            the character array.
	 * @param offset
	 *            initial offset of the subarray.
	 * @param count
	 *            length of the subarray.
	 * @return a Text that contains the characters of the specified subarray of the
	 *         character array.
	 * @throws IndexOutOfBoundsException
	 *             if offset is negative, or count is negative, or offset+count is
	 *             larger than data.length.
	 */
	public static Text copyValueOf(char[] data, int offset, int count) {
		return new Text(String.copyValueOf(data, offset, count));

	}

	public static Text format(java.util.Locale locale, Text format, java.lang.Object... args) {
		return new Text(String.format(locale, format.val, args));

	}

	public static Text format(Text format, java.lang.Object... args) {
		return new Text(String.format(format.val, args));

	}

	public static Text join(java.lang.CharSequence delimiter, java.lang.CharSequence... elements) {
		return new Text(String.join(delimiter, elements));

	}

	public static Text join(java.lang.CharSequence delimiter,
			java.lang.Iterable<? extends java.lang.CharSequence> elements) {
		return new Text(String.join(delimiter, elements));

	}

	public static Text valueOf(boolean bool) {
		return new Text(String.valueOf(bool));

	}

	public static Text valueOf(char c) {
		return new Text(String.valueOf(c));

	}

	public static Text valueOf(char[] chars) {
		return new Text(String.valueOf(chars));

	}

	public static Text valueOf(char[] data, int offset, int count) {
		return new Text(String.valueOf(data, offset, count));

	}

	public static Text valueOf(double d) {
		return new Text(String.valueOf(d));

	}

	public static Text valueOf(float f) {
		return new Text(String.valueOf(f));

	}

	public static Text valueOf(int i) {
		return new Text(String.valueOf(i));

	}

	public static Text valueOf(long l) {
		return new Text(String.valueOf(l));

	}

	public static Text valueOf(Object object) {
		return new Text(String.valueOf(object));

	}

	/**
	 * @param text
	 *            the text to append
	 * @return this+text
	 */
	public Text append(String text) {
		return this.cat(new Text(text));
	}

	public Text append(Object object) {
		return this.cat(new Text(object));
	}

	/**
	 * @param text
	 *            the text to append
	 * @return this+text
	 */
	public Text append(Text text) {
		return append(text.val);
	}

	public Text appendSpaced(Text text) {
		return append(" " + text.val.trim() + " ");
	}

	public Text c(Object... o) {
		Text t = new Text(val);
		for (Object text : o) {
			t = t.c(text);
		}
		return t;
	}

	public Text c(Object o) {
		return this.append(Text.valueOf(o));
	}

	public Text c(String... texts) {
		Text t = new Text(val);
		for (String text : texts) {
			t = t.append(text);
		}
		return t;
	}

	public Text c(Text... texts) {
		Text t = new Text(val);
		for (Text text : texts) {
			t = t.append(text);
		}
		return t;
	}

	public Text cat(Text text) {
		return new Text(val.concat(text.val));

	}

	public char charAt(int index) {
		return val.charAt(index);

	}

	public java.util.stream.IntStream chars() {
		return val.chars();
	}

	@Override
	public Text clone() {
		return new Text(val);
	}

	public int codePointAt(int index) {
		return val.codePointAt(index);

	}

	public int codePointBefore(int index) {
		return val.codePointBefore(index);

	}

	public int codePointCount(int beginIndex, int endIndex) {
		return val.codePointCount(beginIndex, endIndex);

	}

	public java.util.stream.IntStream codePoints() {
		return val.codePoints();
	}

	public int compareTo(Text text) {
		return val.compareTo(text.val);

	}

	public int compareToIgnoreCase(Text text) {
		return val.compareToIgnoreCase(text.val);

	}

	public Text concat(Text text) {
		return new Text(val.concat(text.val));

	}

	public boolean contains(java.lang.CharSequence cs) {
		return val.contains(cs);

	}

	/**
	 * Checks if this text contains one or more numeric characters
	 * 
	 * @return true if this text contains one or more numeric characters, or false
	 *         otherwise.
	 */
	public boolean containsNumbers() {
		for (char c : NUMERICS.toCharArray()) {
			if (contains("" + c))
				return true;
		}
		return false;
	}

	/**
	 * Checks if this text contains any of the characters in the following text:
	 * <em>`~!@#$%^&amp;&#42;()_-=+|\\{[}]:;\"'&lt;,&gt;.?/</em>
	 * 
	 * @return true if this text contains punctuation characters, or false
	 *         otherwise.
	 */
	public boolean containsPunctuations() {
		return len > replacePunctuations(new Text("")).len;
	}

	public boolean contentEquals(java.lang.CharSequence cs) {
		return val.contentEquals(cs);

	}

	public boolean contentEquals(StringBuffer sb) {
		return val.contentEquals(sb);

	}

	public boolean contentEquals(Text text) {
		return val.contentEquals(text.val);
	}

	public boolean contentEqualsIgnoreCase(Text text) {
		return toLowerCase().contentEquals(text.toLowerCase());
	}

	/**
	 * Return the number of space characters in this text
	 * 
	 * @return the number of space characters in this text
	 */
	public int countSpaces() {
		return len - lengthWithoutSpaces();
	}

	public Text cSpaced(String... texts) {
		Text t = new Text(val);
		for (String text : texts) {
			t = t.appendSpaced(new Text(text));
		}
		return t;
	}

	public Text cSpaced(Text... texts) {
		Text t = new Text(val);
		for (Text text : texts) {
			t = t.appendSpaced(text);
		}
		return t;
	}

	/**
	 * A method to return <em>a.dotted.textual.data.</em>. Basically, all spaces in
	 * the text are replaced with a single dot marker.
	 * 
	 * @return A.dotted.textual.data.
	 * @see #toDotSeparated()
	 */
	public Text dotted() {
		return toDotSeparated();
	}

	public boolean endsWith(Text suffix) {
		return val.endsWith(suffix.val);

	}

	@Override
	public boolean equals(Object other) {
		return val.equals(String.valueOf(other));
	}

	public boolean equalsIgnoreCase(Text text) {
		return val.equalsIgnoreCase(text.toString());

	}

	public boolean equalsIgnoreCase(Object object) {
		return val.equalsIgnoreCase(object.toString());

	}

	/**
	 * A method to return <em>a/forward/slashed/textual/data.</em>. Basically, all
	 * spaces in the text are replaced with a single dot marker.
	 * 
	 * @return A.dotted.textual.data.
	 * @see #toDotSeparated()
	 */
	public Text fowardSlashed() {
		return separate("/").subText(0, len);
	}

	public byte[] getBytes() {
		return val.getBytes();
	}

	public byte[] getBytes(java.nio.charset.Charset arg0) {
		return val.getBytes(arg0);

	}

	public byte[] getBytes(Text text) throws java.io.UnsupportedEncodingException {
		return val.getBytes(text.toString());

	}

	/**
	 * Copies characters from this string into the destination character array. The
	 * first character to be copied is at index srcBegin; the last character to be
	 * copied is at index srcEnd-1 (thus the total number of characters to be copied
	 * is srcEnd-srcBegin). The characters are copied into the subarray of dst
	 * starting at index dstBegin and ending at index: <br>
	 * 
	 * dstBegin + (srcEnd-srcBegin) - 1
	 * 
	 * 
	 * 
	 * @param srcBegin
	 *            - index of the first character in the string to copy.
	 * @param srcEnd
	 *            - index after the last character in the string to copy.
	 * @param dst
	 *            - the destination array.
	 * @param dstBegin
	 *            - the start offset in the destination array.
	 */
	public void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin) {
		val.getChars(srcBegin, srcEnd, dst, dstBegin);

	}

	/**
	 * Return a text whose value are the count characters extracted from the end of
	 * this text.
	 * 
	 * @param count
	 *            the number of characters to extract from the end of this text
	 * @return a text whose value are the count characters extracted from the end of
	 *         this text
	 */
	public Text getLastChars(int count) {
		try {
			if (length() < count)
				throw new TextIndexOutOfBoundsException(
						new Text("Length of ", val, "(", length(), ") is less than ", count));
		} catch (TextIndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		return subText(len - count);

	}

	/**
	 * @return the value of this text
	 */
	public Text getText() {
		return this;
	}

	@Override
	public int hashCode() {
		return val.hashCode();
	}

	/**
	 * A method to return <em>a-hyphenated-or-dash-separated-textual-data.</em>.
	 * Basically, all spaces in the text are replaced with a single dash or hyphen
	 * marker.
	 * 
	 * @return A-hyphenated-or-dash-separated-textual-data
	 * @see #toDashSeparated()
	 * 
	 */
	public Text hyphenated() {
		return toDashSeparated();
	}

	public int indexOf(int ch) {
		return val.indexOf(ch);

	}

	public int indexOf(int ch, int fromIndex) {
		return val.indexOf(ch, fromIndex);

	}

	public int indexOf(Text text) {
		return val.indexOf(text.val);

	}

	public int indexOf(Text text, int fromIndex) {
		return val.indexOf("" + text.toString(), fromIndex);

	}

	public Text intern() {
		return new Text(val.intern());
	}

	/**
	 * Checks if this text contains one or more letters of the English alphabet.
	 * 
	 * @return true if this text contains one or more letters of the English
	 *         alphabet, or false otherwise.
	 */
	public boolean isAlpha() {
		return !isEmpty() && replaceAll(new Text("[", ALPHABET, "]"), new Text()).isEmpty();
	}

	/**
	 * Checks if this text contains one or more numeric characters and one or more
	 * letters of the English alphabet
	 * 
	 * @return true if this text contains one or more numeric characters and one or
	 *         more letters of the English alphabet, or false otherwise.
	 */
	public boolean isAlphanumeric() {
		return containsNumbers() && replaceAll(new Text("[", ALPHANUMERICS, "]"), new Text()).isEmpty();
	}

	public boolean isEmpty() {
		return val.isEmpty();
	}

	public boolean isNull() {
		return val.contentEquals("null") || null == val;
	}

	@Override
	public Iterator<Text> iterator() {
		List<Text> list = new ArrayList<>();
		for (char c : val.toCharArray()) {
			list.add(new Text("" + c));
		}
		return list.iterator();
	}

	public int lastIndexOf(int ch) {
		return val.lastIndexOf(ch);

	}

	public int lastIndexOf(int ch, int fromIndex) {
		return val.lastIndexOf(ch, fromIndex);

	}

	public int lastIndexOf(Text text) {
		return val.lastIndexOf(text.val);

	}

	public int lastIndexOf(Text text, int fromIndex) {
		return val.lastIndexOf(text.val, fromIndex);

	}

	/**
	 * Returns the last word of the test. Words are space-delimited
	 * 
	 * @return the last word of the text
	 */
	public Text lastWord() {
		Text[] t = toWords();
		return t[t.length - 1];
	}

	public int length() {
		return len;
	}

	/**
	 * Return the length of this text when the spaces are removed
	 * 
	 * @return the length of this text when the spaces are removed
	 */
	public int lengthWithoutSpaces() {
		return removeSpaces().length();
	}

	public boolean matches(Text regex) {
		return val.matches(regex.val);

	}

	public int offsetByCodePoints(int index, int codePointOffset) {
		return val.offsetByCodePoints(index, codePointOffset);

	}

	/**
	 * @param object
	 *            an object to prepend to this text
	 * @return a text with the given object prepended
	 */
	public Text prepend(Object object) {
		return new Text(object).append(val);
	}

	/**
	 * @param object
	 *            one or more objects to prepend to this text
	 * @return a text with the given object(s) prepended
	 */
	public Text prepend(Object... object) {
		return new Text(object).append(val);
	}

	/**
	 * @param text
	 *            a string to prepend to this text
	 * @return a text with the given string prepended
	 */
	public Text prepend(String text) {
		return new Text(text).append(val);
	}

	/**
	 * @param object
	 *            an object whose string value is to be to prepended to this text
	 *            separated by a space
	 * @return a text with the given object prepended separated by a space
	 */
	public Text prependSpaced(Object object) {
		return new Text(object).appendSpaced(this);
	}

	/**
	 * @param object
	 *            one or more objects to prepend to this text separated by a space
	 * @return a text with the given object prepended
	 */
	public Text prependSpaced(Object... object) {
		return new Text(object).appendSpaced(this);
	}

	/**
	 * @param text
	 *            a string to prepend to this text separated by a space
	 * @return a text with the given string prepended separated by a space
	 */
	public Text prependSpaced(String text) {
		return new Text(text).appendSpaced(this);
	}

	public boolean regionMatches(boolean ignoreCase, int toffset, Text other, int ooffset, int len) {
		return val.regionMatches(ignoreCase, toffset, other.toString(), ooffset, len);

	}

	public boolean regionMatches(int toffset, Text other, int ooffset, int len) {
		return val.regionMatches(toffset, other.toString(), ooffset, len);

	}

	/**
	 * A method to remove English alphabet consonants from this text
	 * 
	 * @return A text with all the English alphabet consonants removed.
	 */
	public Text removeConsonants() {
		Text text = new Text(this.val).replaceAll(new Text("[", LETTERS_CONSONANTS, "]"), new Text(""));
		return text;

	}

	/**
	 * @return text without its first char
	 */
	public Text removeFirstChar() {
		if (isEmpty() || len == 1)
			return new Text();
		return subText(1);
	}

	/**
	 * @return text without its first word
	 */
	public Text removeFirstWord() {
		if (isEmpty() || toWords().length == 1) {
			return new Text();
		}
		return replaceAll(new Text("^(\\w+\\s)"), new Text(""));
	}

	/**
	 * Creates a text with all invalid path elements removed
	 * 
	 * @return a text with all invalid path elements removed
	 */
	public Text removeInvalidPathElements() {
		Text text = new Text(this.val).replaceAll(new Text("[", PATH_ILLEGALS, "]"), new Text(" "));
		text = text.replace('\\', ' ');
		return text;
	}

	public Text removeInvalidWindowsPathElements() {
		Text text = new Text(this.val).replaceAll(new Text("[", PATH_ILLEGALS_WINDOWS, "]"), new Text(" "));
		text = text.replace('\\', ' ');
		return text;
	}

	/**
	 * @return text without its last char
	 */
	public Text removeLastChar() {
		if (isEmpty())
			return new Text();
		return subText(0, len - 1);
	}

	/**
	 * @return text without its last word
	 */
	public Text removeLastWord() {
		if (isEmpty() || toWords().length == 1) {
			return new Text();
		}
		return replaceAll(new Text("(\\s\\w+)$"), new Text(""));
	}

	/**
	 * @return this text without space chars
	 */
	public Text removeSpaces() {
		return replace(" ", "");
	}

	/**
	 * A method to remove English alphabet vowels from this text
	 * 
	 * @return A text with all the English alphabet vowels removed.
	 */
	public Text removeVowels() {
		Text text = new Text(this.val).replaceAll(new Text("[", LETTERS_VOWELS, "]"), new Text(""));
		return text;
	}

	/**
	 * Returns a text resulting from replacing all occurrences of oldChar in this
	 * text with newChar. If the character oldChar does not occur in the character
	 * sequence represented by this text object, then a reference to this text
	 * object is returned. Otherwise, a text object is returned that represents a
	 * character sequence identical to the character sequence represented by this
	 * text object, except that every occurrence of oldChar is replaced by an
	 * occurrence of newChar.
	 * 
	 * @param oldChar
	 *            the old character.
	 * @param newChar
	 *            the new character.
	 * @return a text derived from this text by replacing every occurrence of
	 *         oldChar with newChar.
	 */
	public Text replace(char oldChar, char newChar) {
		return new Text(val.replace(oldChar, newChar));
	}

	public Text replace(java.lang.CharSequence target, java.lang.CharSequence replacement) {
		return new Text(val.replace(target, replacement));

	}

	/**
	 * @param target
	 *            the string to be replaced
	 * @param replacement
	 *            the string that replaces the target string
	 * @return a new string with the target portion replaced with the replacement
	 *         text
	 */
	public Text replace(String target, String replacement) {
		return new Text(val.replace(target, replacement));
	}

	public Text replaceAll(Text regex, Text replacement) {
		return new Text(val.replaceAll(regex.val, replacement.val));

	}

	/**
	 * @param regex
	 *            the regular expression of the string to be replaced
	 * @param replacement
	 *            the string that replaces the target string
	 * @return a new string with the target portion replaced with the replacement
	 *         text
	 */
	public Text replaceFirst(String regex, String replacement) {
		return new Text(val.replaceFirst(regex, replacement));
	}

	public Text replaceFirst(Text regex, Text replacement) {
		return new Text(val.replaceFirst(regex.val, replacement.val));

	}

	/**
	 * @param target
	 *            the string to be replaced
	 * @param replacement
	 *            the string that replaces the target string
	 * @return a new string with the target portion replaced with the replacement
	 *         text
	 */
	public Text replaceLast(String target, String replacement) { // TODO
		String[] s = val.split(target);
		if (s.length < 1) {
			return this;
		} else {
			StringBuilder b = new StringBuilder();
			for (int i = 0; i < s.length - 1; i++) {
				b.append(s[i] + target);
			}
			b.append(s[s.length - 1] + replacement);
			return new Text(b.toString());
			// Text t = lastIndexOf(text)
			// return replaceAll(new Text(target, "$"), new Text(replacement));
		}
	}

	public Text separate(String separator) {
		StringBuilder b = new StringBuilder();
		for (String e : val.split("\\s+")) {
			b.append(e + separator);
		}
		return new Text(b.toString()).replaceLast(separator, "");
	}

	/**
	 * @return the length of this text
	 */
	public int size() {
		if (this.val != null)
			return this.len;
		return 0;
	}

	/**
	 * @param text
	 *            upon which to split the this text object
	 * @return an array of texts
	 */
	public Text[] split(String text) {
		return split(new Text(text));
	}

	public Text[] split(Text regex) {
		String[] s = val.split(regex.val);
		Text[] texts = new Text[s.length];
		int i = 0;
		for (String string : s) {
			texts[i++] = new Text(string);
		}
		return texts;

	}

	public Text[] split(Text regex, int limit) {
		String[] s = val.split(regex.val, limit);
		Text[] texts = new Text[s.length];
		int i = 0;
		for (String string : s) {
			texts[i++] = new Text(string);
		}
		return texts;

	}

	public boolean startsWith(Text prefix) {
		return val.startsWith(prefix.val);

	}

	public boolean startsWith(Text prefix, int toffset) {
		return val.startsWith(prefix.val, toffset);

	}

	/**
	 * @return true if this text starts with a punctuation, otherwise false
	 */
	public boolean startsWithPunctuationMark() {
		// Pattern \A(\p{Punct})[.]
		// for (char c : PUNCTUATIONS.toCharArray()) {
		// if (charAt(0) == c)
		// return true;
		// }
		return val.matches("\\A(\\p{Punct})[.]*");
	}

	/**
	 * <p>
	 * Returns a character sequence that is a subsequence of this text. The
	 * character subsequence begins at the specified beginIndex and extends to the
	 * character at index endIndex - 1. Thus, the length of the character
	 * subsequence is endIndex-beginIndex.
	 * </p>
	 * 
	 * 
	 * Examples:
	 * 
	 * <ul>
	 * <li>new Text("hamburger").substring(4, 8) returns new Text("urge")</li>
	 * <li>new Text("smiles").substring(1, 5) returns new Text("mile").</li>
	 * </ul>
	 * 
	 * 
	 * @param beginIndex
	 *            the beginning index, inclusive.
	 * @param endIndex
	 *            the ending index, exclusive.
	 * @return the specified subtext
	 * @see #substring(int, int)
	 * @see #substring(int)
	 * @see #subText(int)
	 * @see #subText(int, int)
	 */
	public java.lang.CharSequence subSequence(int beginIndex, int endIndex) {
		return val.subSequence(beginIndex, endIndex);

	}

	/**
	 * <p>
	 * Returns a text that is a subtext of this text. The subtext begins at the
	 * specified beginIndex and extends to the character at the end of the text.
	 * Thus, the length of the subtext is the length of the text minus beginIndex.
	 * </p>
	 * 
	 * 
	 * Examples:
	 * 
	 * <ul>
	 * <li>new Text("hamburger").substring(4) returns new Text("urger")</li>
	 * <li>new Text("smiles").substring(1) returns new Text("miles").</li>
	 * </ul>
	 *
	 * 
	 * @param beginIndex
	 *            the beginning index, inclusive.
	 * 
	 * @return the specified subtext
	 * @see #subSequence(int, int)
	 * @see #substring(int, int)
	 * @see #subText(int)
	 * @see #subText(int, int)
	 */
	public Text substring(int beginIndex) {
		return new Text(val.substring(beginIndex));

	}

	/**
	 * <p>
	 * Returns a text that is a subtext of this text. The subtext begins at the
	 * specified beginIndex and extends to the character at index endIndex - 1.
	 * Thus, the length of the subtext is endIndex-beginIndex.
	 * </p>
	 * 
	 *
	 * Examples:
	 * 
	 * <ul>
	 * <li>new Text("hamburger").substring(4, 8) returns new Text("urge")</li>
	 * <li>new Text("smiles").substring(1, 5) returns new Text("mile").</li>
	 * </ul>
	 * 
	 * 
	 * @param beginIndex
	 *            the beginning index, inclusive.
	 * @param endIndex
	 *            the ending index, exclusive.
	 * @throws IndexOutOfBoundsException
	 *             if the beginIndex is negative, or endIndex is larger than the
	 *             length of this Text object, or beginIndex is larger than
	 *             endIndex.
	 * @return the specified subtext
	 * @see #subSequence(int, int)
	 * @see #substring(int)
	 * @see #subText(int)
	 * @see #subText(int, int)
	 */
	public Text substring(int beginIndex, int endIndex) {
		return new Text(val.substring(beginIndex, endIndex));
	}

	/**
	 * <p>
	 * Returns a text that is a subtext of this text. The subtext begins at the
	 * specified beginIndex and extends to the character at the end of the text.
	 * Thus, the length of the subtext is the length of the text minus beginIndex.
	 * </p>
	 * 
	 * 
	 * Examples:
	 * 
	 * <ul>
	 * <li>new Text("hamburger").substring(4) returns new Text("urger")</li>
	 * <li>new Text("smiles").substring(1) returns new Text("miles").</li>
	 * </ul>
	 *
	 * 
	 * @param beginIndex
	 *            the beginning index, inclusive.
	 * 
	 * @return the specified subtext
	 * @see #subSequence(int, int)
	 * @see #substring(int, int)
	 * @see #subText(int)
	 * @see #subText(int, int)
	 */
	public Text subText(int beginIndex) {
		return substring(beginIndex);
	}

	/**
	 * <p>
	 * Returns a text that is a subtext of this text. The subtext begins at the
	 * specified beginIndex and extends to the character at index endIndex - 1.
	 * Thus, the length of the subtext is endIndex-beginIndex.
	 * </p>
	 * 
	 * 
	 * Examples:
	 * 
	 * <ul>
	 * <li>new Text("hamburger").substring(4, 8) returns new Text("urge")</li>
	 * <li>new Text("smiles").substring(1, 5) returns new Text("mile").</li>
	 * </ul>
	 * 
	 * 
	 * @param beginIndex
	 *            the beginning index, inclusive.
	 * @param endIndex
	 *            the ending index, exclusive.
	 * @return the specified subtext
	 * @see #subSequence(int, int)
	 * @see #substring(int)
	 * @see #subText(int)
	 * @see #subText(int, int)
	 */
	public Text subText(int beginIndex, int endIndex) {
		return substring(beginIndex, endIndex);
	}

	/**
	 * A method to convert this text into binary string representation.
	 * 
	 * @return a new text in binary string representation.
	 */
	protected Text toBin() {
		Text text = new Text();
		for (char c : val.toCharArray()) {
			text = text.c(Long.toBinaryString(c), " ");
		}
		return text.removeLastChar();
	}

	/**
	 * A method to convert this text into binary string representation.
	 * 
	 * @return a new text in binary string representation.
	 */
	public Text toBinary() {
		if (this.getClass().equals(TextBinary.class))
			return clone();
		return toBin();

	}

	/**
	 * @return a text in camelTitleCase
	 */
	public Text toCamelTitleCase() {
		return toCamelCase().toUpperCaseFirst();
	}

	public char[] toCharArray() {
		return val.toCharArray();
	}

	/**
	 * Converts this text to a new character array.
	 * 
	 * @return a newly allocated character array whose length is the length of this
	 *         text and whose contents are initialized to contain the character
	 *         sequence represented by this text.
	 */
	public char[] toChars() {
		return val.toCharArray();
	}

	/**
	 * @return a constant-style text e.g: CONSTANT_TEXT
	 */
	public Text toConstantCase() {
		return replacePunctuations(new Text(" ")).toUnderscoreSeparated().toUpperCase();
	}

	/**
	 * Return this text with its words separated by dash
	 * 
	 * @return this text with its words separated by dash
	 */
	public Text toDashSeparated() {
		if (len >= 1)
			return separate("-").substring(0, len);
		return this;
	}

	/**
	 * A method to return <em>a.dotted.textual.data.</em>. Basically, all spaces in
	 * the text are replaced with a single dot marker.
	 * 
	 * @return A.dotted.textual.data.
	 * @see #dotted()
	 */
	public Text toDotSeparated() {
		return separate(".").substring(0, len);
	}

	/**
	 * A method to convert this text into hexadecimal string representation.
	 * 
	 * @return a new text in hexadecimal string representation.
	 */
	public Text toHex() {
		Text text = new Text();
		for (byte c : val.getBytes()) {
			text = text.append(Integer.toHexString(c));
		}
		return text;
	}

	/**
	 * A method to convert the text into <em>lower case.</em>. Basically, all the
	 * character of each word in the text are in lower case.
	 * 
	 * @return the text with all the characters in lower case
	 * @see #toSentenceCase()
	 * @see #toTitleCase()
	 * @see #toCamelCase()
	 * @see #toUpperCase()
	 * @see #toCamelTitleCase()
	 */
	public Text toLowerCase() {
		return new Text(val.toLowerCase());
	}

	public Text toLowerCase(java.util.Locale locale) {
		return new Text(val.toLowerCase(locale));

	}

	/**
	 * @return this text with the first character in lower case
	 */
	public Text toLowerFirstCase() {
		if (isEmpty())
			return clone();
		return subText(0, 1).toLowerCase().append(subText(1));
	}

	/**
	 * Returns this text converted to the Java-style method case
	 * 
	 * @return this text converted to methodCase
	 */
	public Text toMethodCase() {
		return toConstantCase().separate("_").toTitleCase().toCamelCase(); // ToDo
	}

	/**
	 * A method to convert this text into octal string representation.
	 * 
	 * @return a new text in octal string representation.
	 */
	public Text toOctal() {
		Text text = new Text();
		for (byte c : val.getBytes()) {
			text = text.append(Integer.toOctalString(c));
		}
		return text;
	}

	/**
	 * Returns text in random case
	 * 
	 * @return text in random case
	 */
	public Text toRandomCase() {
		int random = (int) (Math.random() * 7);
		switch (random) {
		case 0:
			return toSentenceCase();
		case 1:
			return toLowerCase();
		case 2:
			return toUpperCase();
		case 3:
			return toTitleCase();
		case 4:
			return toToggleCase();
		case 5:
			return toCamelCase();
		case 6:
			return toCamelTitleCase();
		case 7:
			return toDashSeparated();
		}
		return toSentenceCase();
	}

	/**
	 * A method to convert the text into <em>A sentence case.</em>. This means, the
	 * first character of the first word in the sentence text is an upper case
	 * letter with the subsequent characters all in lower case
	 * 
	 * @return The sentence case of the text.
	 * @see #toTitleCase()
	 * @see #toLowerCase()
	 * @see #toCamelCase()
	 * @see #toUpperCase()
	 * @see #toCamelTitleCase()
	 */
	public Text toSentenceCase() {
		if (val.length() >= 1)
			return new Text(val.substring(0, 1).toUpperCase() + val.substring(1));
		else
			return this;
	}

	@Override
	public String toString() {
		return val;
	}

	public Text toText() {
		return new Text(val);
	}

	/**
	 * A method to convert the text into <em>A Title Case.</em>. Basically, the
	 * first character of each word in the title text is an upper case letter with
	 * the subsequent characters all in lower case
	 * 
	 * @return The Title Case Of The Text
	 * @see #toSentenceCase()
	 * @see #toLowerCase()
	 * @see #toCamelCase()
	 * @see #toUpperCase()
	 * @see #toCamelTitleCase()
	 */
	public Text toTitleCase() {
		StringBuilder b = new StringBuilder("");
		if (val == null) {
			return this;
		}
		for (Text e : split("\\s+")) {
			if (e.length() > 1)
				if (e.startsWithPunctuationMark()) {
					int index = 2;
					if (e.length() <= 2)// TODO Refine
						index = 2;
					Text start = e.substring(0, 2).toUpperCase();
					b.append(start + e.substring(index).toLowerCase().toString() + " ");
				} else
					b.append(e.substring(0, 1).toUpperCase().toString() + e.substring(1).toLowerCase() + " ");
			else
				b.append(e.toUpperCase() + " ");
		}
		return new Text(b.toString().trim());
	}

	/**
	 * A method to convert the text into <em>toGGLe CasE.</em>. Basically, each
	 * lower case character of each word in the text is converted to an upper case
	 * value, and vice versa.
	 * 
	 * @return the text with all the characters in toggle case
	 * @see #toSentenceCase()
	 * @see #toTitleCase()
	 * @see #toCamelCase()
	 * @see #toUpperCase()
	 * @see #toCamelTitleCase()
	 */
	public Text toToggleCase() {
		StringBuilder b = new StringBuilder();
		for (char c : val.toCharArray()) {
			if (LETTERS_SMALL.contains("" + c)) {
				b.append(("" + c).toUpperCase());
			} else if (LETTERS_CAPS.contains("" + c)) {
				b.append(("" + c).toLowerCase());
			} else {
				b.append(c);
			}
		}
		return new Text(b.toString());
	}

	/**
	 * Returns an underscore_separated_case text
	 * 
	 * @return an underscore_separated_case text
	 */
	public Text toUnderscoreSeparated() {
		return separate("_").subText(0, len);
	}

	/**
	 * Returns an Underscore_Separated_Title_Case text
	 * 
	 * @return an Underscore_Separated_Title_Case text
	 */
	public Text toUnderscoreSeparatedTitleCase() {
		return toTitleCase().toUnderscoreSeparated().replaceLast("_", "");
	}

	/**
	 * A method to convert the text into <em>UPPER CASE.</em>. Basically, all the
	 * character of each word in the text are in UPPER CASE.
	 * 
	 * @return the text with all the characters in UPPER CASE
	 * @see #toSentenceCase()
	 * @see #toTitleCase()
	 * @see #toCamelCase()
	 * @see #toLowerCase()
	 * @see #toCamelTitleCase()
	 */
	public Text toUpperCase() {
		return new Text(val.toUpperCase());
	}

	public Text[] toWords() {
		return this.split(new Text("\\s+"));
	}

	/**
	 * Returns a text whose value is this text, with any leading and trailing white
	 * space removed, or a copy of this text if it has no leading or trailing white
	 * space.
	 * 
	 * @return A text object whose value is this text, with any leading and trailing
	 *         white space removed, or this a copy of this text object if it has no
	 *         leading or trailing white space.
	 */
	public Text trim() {
		return new Text(val.trim());
	}

	/**
	 * @param replacement
	 *            text to replace punctuation
	 * @return this text with all punctuation replace replaced with the given text
	 */
	public Text replacePunctuations(Text replacement) {
		return replaceAll(new Text("\\p{Punct}"), replacement);
	}

	/**
	 * @param replacement
	 *            text to replace punctuation
	 * @return this text with all punctuation replace replaced with the given text
	 */
	public Text replacePunctuations(String replacement) {
		return replaceAll(new Text("\\p{Punct}"), new Text(replacement));
	}

	/**
	 * @param val
	 *            the value to set
	 */
	private final void setText(String val) {
		this.val = val;
	}

	protected static float similarityIndex(Text a, Text b) { // TODO
		float f = a.replaceAll(new Text("[", b, "]"), new Text()).len / (a.len * 1.0f);

		return f;
	}

	public Text toVariableCase() {
		return toMethodCase();
	}

	public Text toCamelCase() {
		Text t = clone().replacePunctuations(" ");

		Text lower = t.removeUpperCase(new Text(" "));

		Text lowerFirst = t.removeLowerCase(new Text(" ")).toLowerFirstCase();

		Text r = new Text();
		int i = 0;
		for (char c : lower.toCharArray()) {
			if (c == ' ')
				r = r.append(lowerFirst.charAt(i));
			else {
				r = r.append(c);
			}
			i++;
		}
		TextBuilder tb = new TextBuilder();
		if (r.wordCount() == 1)
			tb.append(r);
		else {
			tb = new TextBuilder();
			int j = 0;
			for (Text word : r.toWords()) {
				if (j > 0)
					tb.append(word.toUpperCaseFirst());
				else
					tb.append(word);
				j++;
			}
		}
		return tb.toText().replacePunctuations("");

	}

	public Text toUpperCaseFirst() {

		if (len <= 1)
			return toUpperCase();
		return removeFirstChar().prepend(subText(0, 1).toUpperCase());
	}

	public int wordCount() {
		return toWords().length;
	}

	public Text removeLowerCase() {
		return replaceAll(new Text("[a-z]"), new Text(""));
	}

	public Text removeLowerCase(Text replacement) {
		return replaceAll(new Text("[a-z]"), replacement);
	}

	public Text removeUpperCase() {
		return replaceAll(new Text("[A-Z]"), new Text(""));
	}

	public Text removeUpperCase(Text replacement) {
		return replaceAll(new Text("[A-Z]"), replacement);
	}

	public Text toLowerCaseFirst() {
		if (len <= 1)
			return toLowerCase();
		return removeFirstChar().prepend(subText(0, 1).toLowerCase());
	}

	public boolean startsWithUpperCaseChar() {
		if (len > 0)
			return this.equals(this.toUpperCaseFirst());
		return false;
	}

	public boolean startsWithLowerCaseChar() {
		if (len > 0)
			return this.equals(this.toLowerCaseFirst());
		return false;
	}

	public static Text random(int length) {
		int charLength = ALPHANUMERICS.length();
		String text = "";
		try {
			if (length < 0)
				throw new Exception("length must be greater than or equal to zero");
			Random rand = new Random();
			for (int i = length; i > 0; i--) {
				text += ALPHANUMERICS.toCharArray()[rand.nextInt(charLength)];
			}

		} catch (Exception e) {

		}
		return new Text(text);
	}

	public static Text random(Text source, int length) {
		int charLength = source.length();
		String text = "";
		try {
			if (length < 0)
				throw new Exception("length must be greater than or equal to zero");
			Random rand = new Random();
			for (int i = length; i > 0; i--) {
				text += source.toCharArray()[rand.nextInt(charLength)];
			}

		} catch (Exception e) {

		}
		return new Text(text);
	}

	public Text randomize(int length) {
		return Text.random(this, length);
	}

	public static Text generatePassword(int $length) {
		Text t = new Text(ALPHANUMERICS, PATH_ILLEGALS, "!@#$/^&*()-'\":;,?+—=<>{{}}[[]]%~`|\\");
		return t.randomize($length);
	}

	public static void main(String[] args) {
		Text t = new Text("melchiz oyamo");
		System.out.println(Text.generatePassword(15));
		System.out.println(t.randomize(10));
		System.out.println(Text.random(new Text(Text.NUMERICS), 16).chunk(4, "-"));
	}

	/**
	 * @param limit
	 *            the length of a chunk
	 * @param string
	 *            the character string separating chunks
	 * @return chunked text
	 */
	public Text chunk(int limit, String separator) {
		String chunks = "";
		int count = 0;
		for (char c : toCharArray()) {

			if (count == limit) {
				chunks += separator;
				count = 0;
			}
			chunks += c;
			count++;

		}
		return new Text(chunks);
	}

}
