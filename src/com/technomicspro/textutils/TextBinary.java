package com.technomicspro.textutils;

public class TextBinary extends Text {
	public static final Text SPACE = new Text(" ").toBinary();

	public TextBinary(Text text) {
		super(text.toBinary());
	}

	/**
	 * Constructs an instance of TextBinary with the required arguments
	 * 
	 * @param text
	 *            string value
	 */
	public TextBinary(String text) {
		this(new Text(text));
	}

	/**
	 * @see com.technomicspro.textutils.Text#toWords()
	 */
	@Override
	public Text[] toWords() {
		return replaceAll(SPACE.c("{3}"), new Text(" ")).toWords();
	}

	@Override
	public Text toBinary() {
		return clone();
	}

	public Text toTextString() { // TODO

		char[] chars = removeSpaces().toCharArray();
		char[] transcoded = new char[(chars.length / 9) + 1];

		// for each char (plus one for spacing)
		for (int i = 0; i < chars.length; i += 9) {
			int idx = 0;
			int sum = 0;
			for (int j = 7; j >= 0; j--) {
				System.out.println(i + j);
				if (chars[j + i] == '1') {
					sum += 1 << idx;
				}
				idx++;
			}
			transcoded[i / 9] = (char) sum;

		}

		return Text.valueOf(transcoded);
	}

}