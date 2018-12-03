/**
 * 
 */
package com.technomicspro.textutils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A mutable sequence of text characters. This class is a wraper for the Java
 * language StringBuilder class, and is designed for use as a drop-in
 * replacement for StringBuffer in places where the string buffer was being used
 * by a single thread (as is generally the case). Java recommends the use of
 * TextBuilders in place of TextBuffers due to improved performance. The main
 * operations on a TextBuilder include append as well as insert methods, which
 * are overloaded so as to accept data of any type. Effectively, each of these
 * methods converts a given datum to a text and then appends or inserts its
 * characters to text builder. The append methods always add these text chars at
 * the end of the text builder; the insert methods add the text chars at a
 * specified point. This class defines additional variations of append and
 * insert methods useful for various text processing cases/implementations,
 * including appendLine(x), apppend(Object..o), among others.
 * 
 * <p>
 * For instance, let t b a text builder object whose current contents are
 * "start". In this case, the method call t.append("le") changes the contents of
 * the text builder to "startle", while t.insert(4, "le") alters the contents of
 * the text builder to become "starlet".
 * </p>
 * 
 * <p>
 * Generally, if tb is an instance of a TextBuilder, then tb.append(text) has a
 * similar effect to the method call tb.insert(sb.length(), text).
 * </p>
 * 
 * 
 * 
 * @author Melchiz Oyamo
 * @author <a href="http://www.technomicspro.com">Technomicspro Inc. </a>
 * @version 1.0
 * 
 *
 */
public class TextBuilder implements Iterable<Text> {
	private StringBuilder val;

	/**
	 * Constructs a text builder with no characters in it and an initial capacity of
	 * 16 characters.
	 */
	public TextBuilder() {
		val = new StringBuilder();
	}

	/**
	 * Constructs a text builder with no text characters in it and an initial
	 * capacity specified by the capacity argument.
	 * 
	 * @param capacity
	 *            the initial capacity.
	 * @throws NegativeArraySizeException
	 *             if the capacity argument is less than 0
	 */
	public TextBuilder(int capacity) {
		val = new StringBuilder(capacity);
	}

	/**
	 * Constructs a text builder that contains the same text characters as the
	 * specified StringBuilder. The initial capacity of the text builder is 16 plus
	 * the length of the StringBuilder argument.
	 * 
	 * @param sb
	 *            the string builder with sequence text to copy.
	 */
	public TextBuilder(StringBuilder sb) {
		val = new StringBuilder(sb);
	}

	/**
	 * Constructs a text builder that contains the same text characters as the
	 * specified TextBuilder. The initial capacity of the text builder is 16 plus
	 * the length of the TextBuilder argument.
	 * 
	 * @param tb
	 *            the text builder with sequence text to copy.
	 */
	public TextBuilder(TextBuilder tb) {
		val = new StringBuilder(tb.val);

	}

	/**
	 * A appends the value to the end of the text builder character sequence.
	 * 
	 * @param b
	 *            the value to append to the end of the text builder character
	 *            sequence.
	 * @return a new text builder with the value appended.
	 */
	public TextBuilder append(boolean b) {
		return new TextBuilder(val.append(b));
	}

	/**
	 * A appends the value to the end of the text builder character sequence.
	 * 
	 * @param c
	 *            the value to append to the end of the text builder character
	 *            sequence.
	 * @return a new text builder with the value appended.
	 */
	public TextBuilder append(char c) {
		return new TextBuilder(val.append(c));
	}

	/**
	 * A appends the value to the end of the text builder character sequence.
	 * 
	 * @param str
	 *            the value to append to the end of the text builder character
	 *            sequence.
	 * @return a new text builder with the value appended.
	 */
	public TextBuilder append(char[] str) {
		return new TextBuilder(val.append(str));
	}

	/**
	 * Appends the text representation of a sub-array of the char array argument to
	 * this sequence. Characters of the char array str, starting at index offset,
	 * are appended, in order, to the contents of this sequence. The length of this
	 * sequence increases by the value of len.
	 * 
	 * <p>
	 * The overall effect is exactly as if the arguments were converted to a text by
	 * the method {@link Text#valueOf(char[], int, int) }, and the characters of
	 * that string were then appended to this character sequence.
	 * </p>
	 * 
	 * @param str
	 *            the characters to be appended.
	 * @param offset
	 *            the index of the first char to append.
	 * @param len
	 *            the number of chars to append.
	 * @return a reference to this object.
	 * @throws IndexOutOfBoundsException
	 *             if offset &lt; 0 or len &lt; 0 or offset+len &gt; str.length
	 * 
	 */
	public TextBuilder append(char[] str, int offset, int len) {
		return new TextBuilder(val.append(str, offset, len));
	}

	/**
	 * Appends the specified character sequence to this TextBuilder.
	 * 
	 * @param cs
	 *            The character sequence to append. If cs is null, then the four
	 *            characters "null" are appended to this TextBuilder.
	 * @return A reference to this TextBuilder
	 * 
	 */
	public TextBuilder append(CharSequence cs) {
		return new TextBuilder(val.append(cs));
	}

	/**
	 * Appends a subsequence of the specified CharSequence to this sequence.
	 * Characters of the argument s, starting at index start, are appended, in
	 * order, to the contents of this sequence up to the (exclusive) index end. The
	 * length of this sequence is increased by the value of end - start.
	 * 
	 * <p>
	 * Let n be the length of this character sequence just prior to execution of the
	 * append method. Then the character at index k in this character sequence
	 * becomes equal to the character at index k in this sequence, if k is less than
	 * n; otherwise, it is equal to the character at index k+start-n in the argument
	 * s.
	 * </p>
	 * 
	 * <p>
	 * If s is null, then this method appends characters as if the s parameter was a
	 * sequence containing the four characters "null". Specified by:append in
	 * interface Appendable
	 * 
	 * @param s
	 *            the sequence to append.
	 * @param start
	 *            the starting index of the subsequence to be appended.
	 * @param end
	 *            the end index of the subsequence to be appended.
	 * 
	 * @throws IndexOutOfBoundsException
	 *             if start is negative, or start is greater than end or end is
	 *             greater than s.length()
	 * 
	 * @return a reference to this object.
	 */

	public TextBuilder append(CharSequence s, int start, int end) {
		return new TextBuilder(val.append(s, start, end));
	}

	/**
	 * Appends the text representation of the double argument to this text sequence.
	 * The overall effect is similar to text conversion of the argument using the
	 * method call {@link Text#valueOf(double)}, and the chars of that text were
	 * then appended to this char sequence.
	 * 
	 * 
	 * @param d
	 *            the value to append to the end of the text builder character
	 *            sequence.
	 * @return a new text builder with the value appended.
	 */
	public TextBuilder append(double d) {
		return new TextBuilder(val.append(d));
	}

	/**
	 * Appends the text representation of the float argument to this text sequence.
	 * The overall effect is similar to text conversion of the argument using the
	 * method call {@link Text#valueOf(float)}, and the chars of that text were then
	 * appended to this char sequence.
	 * 
	 * 
	 * @param f
	 *            the value to append to the end of the text builder character
	 *            sequence.
	 * @return a new text builder with the value appended.
	 */
	public TextBuilder append(float f) {
		return new TextBuilder(val.append(f));
	}

	/**
	 * Appends the text representation of the int argument to this text sequence.
	 * The overall effect is similar to text conversion of the argument using the
	 * method call {@link Text#valueOf(int)}, and the chars of that text were then
	 * appended to this char sequence.
	 * 
	 * 
	 * @param i
	 *            the int value to append to the end of the text builder character
	 *            sequence.
	 * @return a new text builder with the value appended.
	 */
	public TextBuilder append(int i) {
		return new TextBuilder(val.append(i));
	}

	/**
	 * Appends the text representation of the long argument to this text sequence.
	 * The overall effect is similar to text conversion of the argument using the
	 * method call {@link Text#valueOf(long)}, and the chars of that text were then
	 * appended to this char sequence.
	 * 
	 * 
	 * @param l
	 *            the long value to append to the end of the text builder character
	 *            sequence.
	 * @return a new text builder with the value appended.
	 */
	public TextBuilder append(long l) {
		return new TextBuilder(val.append(l));
	}

	public void append(Object... objects) {
		for (Object object : objects) {
			val.append(object);
		}
	}

	/**
	 * Appends the text representation of the Object argument to this text sequence.
	 * The overall effect is similar to text conversion of the argument using the
	 * method call {@link Text#valueOf(Object)}, and the chars of that text were
	 * then appended to this char sequence.
	 * 
	 * 
	 * @param o
	 *            the object whose text value is to be appended to the end of the
	 *            text builder character sequence.
	 * @return a new text builder with the value appended.
	 */
	public TextBuilder append(Object o) {
		return new TextBuilder(val.append(o));
	}

	/**
	 * Appends the given text to this char sequence. The chars of the Text argument
	 * are appended, in order, increasing the length of this sequence by the length
	 * of the argument. If text is null, then the four characters "null" are
	 * appended.
	 * 
	 * <p>
	 * Let n be the length of this char sequence just prior to execution of the
	 * append method. In that case, the character at index k in the new char
	 * sequence is equivalent to the char at index k in the old char sequence, if k
	 * is less than n; else, it is equivalent to the char at index k-n in the
	 * argument text.
	 * </p>
	 * 
	 * @param text
	 *            - a text object.
	 * 
	 * @return a reference to this object.
	 * 
	 * 
	 */
	public TextBuilder append(Text text) {
		return new TextBuilder(val.append(text.toString()));
	}

	public TextBuilder append(TextBuffer tb) {
		return new TextBuilder(val.append(tb.toStringBuffer()));
	}

	public TextBuilder appendCodePoint(int codePoint) {
		return new TextBuilder(val.appendCodePoint(codePoint));
	}

	/**
	 * @param line
	 *            an object to be appended to the content of this text builder as a
	 *            line
	 */
	public void appendLine(Object line) {
		append(line, "\n");

	}

	public void appendLines(Object... lines) {
		for (Object line : lines) {
			appendLine(line);
		}
	}

	public void appendSpaced(Object... objects) {
		for (Object object : objects) {
			append(object, " ");
		}
		val.trimToSize();
	}

	public int capacity() {
		return val.capacity();
	}

	public char charAt(int index) {
		return val.charAt(index);
	}

	public java.util.stream.IntStream chars() {
		return val.chars();
	}

	public int codePointAt(int index) {
		return val.codePointAt(index);
	}

	public int codePointBefore(int index) {
		return val.codePointBefore(index);
	}

	public int codePointCount(int arg0, int arg1) {
		return val.codePointCount(arg0, arg1);
	}

	public java.util.stream.IntStream codePoints() {
		return val.codePoints();
	}

	public TextBuilder delete(int beginIndex, int endIndex) {
		return new TextBuilder(val.delete(beginIndex, endIndex));
	}

	public TextBuilder deleteCharAt(int index) {
		return new TextBuilder(val.deleteCharAt(index));
	}

	public void ensureCapacity(int size) {
		val.ensureCapacity(size);
	}

	@Override
	public boolean equals(Object o) {
		return val.equals(o);
	}

	public void getChars(int arg0, int arg1, char[] arg2, int arg3) {
		val.getChars(arg0, arg1, arg2, arg3);
	}

	@Override
	public int hashCode() {
		return val.hashCode();
	}

	public int indexOf(Text text) {
		return val.indexOf(text.toString());
	}

	public int indexOf(Text text, int fromIndex) {
		return (val.indexOf(text.toString(), fromIndex));
	}

	public TextBuilder insert(int offset, boolean b) {
		return new TextBuilder(val.insert(offset, b));
	}

	public TextBuilder insert(int offset, char c) {
		return new TextBuilder(val.insert(offset, c));
	}

	public TextBuilder insert(int offset, char[] str) {
		return new TextBuilder(val.insert(offset, str));
	}

	public TextBuilder insert(int index, char[] str, int offset, int len) {
		return new TextBuilder(val.insert(index, str, offset, len));
	}

	public TextBuilder insert(int dstOffset, CharSequence s) {
		return new TextBuilder(val.insert(dstOffset, s));
	}

	public TextBuilder insert(int dstOffset, CharSequence s, int start, int end) {
		return new TextBuilder(val.insert(dstOffset, s, start, end));
	}

	public TextBuilder insert(int offset, double d) {
		return new TextBuilder(val.insert(offset, d));
	}

	public TextBuilder insert(int offset, float f) {
		return new TextBuilder(val.insert(offset, f));
	}

	public TextBuilder insert(int offset, int i) {
		return new TextBuilder(val.insert(offset, i));
	}

	public TextBuilder insert(int offset, long l) {
		return new TextBuilder(val.insert(offset, l));
	}

	public TextBuilder insert(int offset, Object obj) {
		return new TextBuilder(val.insert(offset, obj));
	}

	public TextBuilder insert(int offset, Text text) {
		return new TextBuilder(val.insert(offset, text));
	}

	/**
	 * 
	 * @see java.lang.Iterable#iterator()
	 */
	@Override
	public Iterator<Text> iterator() {
		List<Text> texts = new ArrayList<>();
		for (Text text : toText().toWords()) {
			texts.add(text);
		}
		return texts.iterator();
	}

	public int lastIndexOf(Text text) {
		return val.lastIndexOf(text.toString());
	}

	public int lastIndexOf(Text text, int fromIndex) {
		return val.lastIndexOf(text.toString(), fromIndex);
	}

	public int length() {
		return val.length();
	}

	public int offsetByCodePoints(int arg0, int arg1) {
		return val.offsetByCodePoints(arg0, arg1);
	}

	public TextBuilder replace(int from, int to, Text text) {
		return new TextBuilder(val.replace(from, to, text.toString()));
	}

	public TextBuilder reverse() {
		return new TextBuilder(val.reverse());
	}

	public void setCharAt(int index, char c) {
		val.setCharAt(index, c);
	}

	public void setLength(int l) {
		val.setLength(l);
	}

	public CharSequence subSequence(int beginIndex, int endIndex) {
		return val.subSequence(beginIndex, endIndex);
	}

	public Text substring(int beginIndex) {
		return new Text(val.substring(beginIndex));
	}

	public Text substring(int beginIndex, int endIndex) {
		return new Text(val.substring(beginIndex, endIndex));
	}

	/**
	 * Returns a string representing the data in this sequence. Allocates a new
	 * String object and initializes its contents to the character sequence
	 * currently represented by this object. This String is then returned.
	 * Subsequent changes to this char sequence have no effect on the contents of
	 * the string object.
	 * 
	 * @return a string representation of the data in this text builder sequence
	 */
	@Override
	public String toString() {
		return val.toString();
	}

	/**
	 * Returns a Text object representing the data in this sequence. Creates a new
	 * Text object and initializes its contents to the character sequence currently
	 * represented by this object. This Text is then returned. Subsequent changes to
	 * this char sequence have no effect on the contents of the Text object.
	 * 
	 * @return a text representation of the data in this text builder sequence
	 */
	public Text toText() {
		return new Text(val);
	}

	public void trimToSize() {
		val.trimToSize();
	}

}
