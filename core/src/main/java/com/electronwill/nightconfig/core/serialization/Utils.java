package com.electronwill.nightconfig.core.serialization;

/**
 * Serialization utilities.
 *
 * @author TheElectronWill
 */
public final class Utils {
	private static final char[] EMPTY_CHAR_ARRAY = new char[0];

	private Utils() {}//Utility class can't be constructed

	/**
	 * Checks if an array contains the specified element.
	 *
	 * @param array   the array
	 * @param element the element to search
	 * @return true if the array contains the element, false if it doesn't
	 */
	public static boolean arrayContains(char[] array, char element) {
		for (char c : array) {
			if (c == element)
				return true;
		}
		return false;
	}

	/**
	 * Returns the index, within the specified array, of the first occurrence of the specified character.
	 * Returns -1 if the array doesn't contains the character.
	 *
	 * @param array   the array
	 * @param element the element to search
	 * @return the index of the first occurence of c, or -1 if not found.
	 */
	public static int arrayIndexOf(char[] array, char element) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == element)
				return i;
		}
		return -1;
	}

	/**
	 * Parses a CharsWrapper that represents a long value in the specified base.
	 *
	 * @param chars the CharsWrapper representing a long
	 * @param base  the base of the number
	 * @return the long value represented by the CharsWrapper
	 */
	public static long parseLong(CharsWrapper chars, int base) {
		return parseLong(chars.getChars(), base);
	}

	/**
	 * Parses an array of chars that represents a long value in the specified base.
	 *
	 * @param chars the CharsWrapper representing a long
	 * @param base  the base of the number
	 * @return the long value represented by the CharsWrapper
	 */
	public static long parseLong(char[] chars, int base) {
		//Optimized lightweight parsing
		boolean negative = (chars[0] == '-');
		long value = 0, coefficient = 1;
		for (int i = 0; i < chars.length; i++) {
			int digitValue = Character.digit(chars[i], base);
			value += digitValue * coefficient;
			coefficient *= base;
		}
		return negative ? -value : value;
	}

	/**
	 * Parses a CharsWrapper that represents an int value in the specified base.
	 *
	 * @param chars the CharsWrapper representing an int
	 * @param base  the base of the number
	 * @return the int value represented by the CharsWrapper
	 */
	public static int parseInt(CharsWrapper chars, int base) {
		return parseInt(chars.getChars(), base);
	}

	/**
	 * Parses an array of chars that represents an int value in the specified base.
	 *
	 * @param chars the CharsWrapper representing an int
	 * @param base  the base of the number
	 * @return the int value represented by the CharsWrapper
	 */
	public static int parseInt(char[] chars, int base) {
		//Optimized lightweight parsing
		boolean negative = (chars[0] == '-');
		int value = 0, coefficient = 1;
		for (int i = 0; i < chars.length; i++) {
			int digitValue = Character.digit(chars[i], base);
			value += digitValue * coefficient;
			coefficient *= base;
		}
		return negative ? -value : value;
	}

	/**
	 * Parses a CharsWrapper that represents a double value.
	 *
	 * @param chars the CharsWrapper representing a double
	 * @return the double value represented by the CharsWrapper
	 */
	public static double parseDouble(CharsWrapper chars) {
		return Double.parseDouble(chars.toString());
	}

	/**
	 * Returns an empty char array.
	 *
	 * @return an ampty char array
	 */
	public static char[] noChars() {
		return EMPTY_CHAR_ARRAY;
	}
}
