package com.bridgelabz.oops.oopbannerapp;

import java.util.HashMap;

public class OopsBannerApp {
	public static void main(String[] args) {
		System.out.println("oops");

		System.out.println("=====================================");

		System.out.println("   ***   " + "   ***   " + " ****** " + " *****");

		System.out.println(" **   ** " + " **   ** " + " **   ** " + "**    ");

		System.out.println(" **   ** " + " **   ** " + " **   ** " + "**    ");

		System.out.println(" **   ** " + " **   ** " + " ****** " + " *****");

		System.out.println(" **   ** " + " **   ** " + " **      " + "    **");

		System.out.println(" **   ** " + " **   ** " + " **      " + "    **");

		System.out.println("   ***   " + "   ***   " + " **      " + " *****");

		System.out.println("=========================================================");

		System.out.println(String.join("", "   ***   ", "   ***   ", " ****** ", " *****"));

		System.out.println(String.join("", " **   ** ", " **   ** ", " **   ** ", "**    "));

		System.out.println(String.join("", " **   ** ", " **   ** ", " **   ** ", "**    "));

		System.out.println(String.join("", " **   ** ", " **   ** ", " ****** ", " *****"));

		System.out.println(String.join("", " **   ** ", " **   ** ", " **      ", "    **"));

		System.out.println(String.join("", " **   ** ", " **   ** ", " **      ", "    **"));

		System.out.println(String.join("", "   ***   ", "   ***   ", " **      ", " *****"));

		System.out.println("==========================================");

		String[] lines = {

				String.join("", "   ***   ", "   ***   ", " ****** ", " *****  "),

				String.join("", " **   ** ", " **   ** ", " **   ** ", "**     "),

				String.join("", " **   ** ", " **   ** ", " **   ** ", "**     "),

				String.join("", " **   ** ", " **   ** ", " ****** ", " *****  "),

				String.join("", " **   ** ", " **   ** ", " **      ", "    ** "),

				String.join("", " **   ** ", " **   ** ", " **      ", "    ** "),

				String.join("", "   ***   ", "   ***   ", " **      ", "*****  ") };

		for (String line : lines) {
			System.out.println(line);
		}
		System.out.println("=======================================");

		String[] oPattern = getOPattern();
		String[] pPattern = getPPattern();
		String[] sPattern = getSPattern();

		for (int i = 0; i < oPattern.length; i++) {
			System.out.println(oPattern[i] + "  " + oPattern[i] + "  " + pPattern[i] + "  " + sPattern[i]);
		}
		System.out.println("==================================");
		CharacterPatternMap[] charMaps = createCharacterPatternMaps();

		printMessage("OOPS", charMaps);
		System.out.println("========================================");
		HashMap<Character, String[]> charMap = createCharacterMap();
		String message = "OOPS";
		displayBanner(message, charMap);
	}

	public static String[] getOPattern() {
		return new String[] { " *** ", "** **", "** **", "** **", " *** " };
	}

	public static String[] getPPattern() {
		return new String[] { "**** ", "** **", "**** ", "**   ", "**   " };
	}

	public static String[] getSPattern() {
		return new String[] { " ****", "**   ", " *** ", "   **", "**** " };
	}

	static class CharacterPatternMap {

		private final Character character;

		private final String[] pattern;

		public CharacterPatternMap(Character character, String[] pattern) {
			this.character = character;
			this.pattern = pattern;
		}

		public Character getCharacter() {
			return character;
		}

		public String[] getPattern() {
			return pattern;
		}
	}

	public static CharacterPatternMap[] createCharacterPatternMaps() {
		return new CharacterPatternMap[] {

				new CharacterPatternMap('O', new String[] { " *** ", "** **", "** **", "** **", " *** " }),

				new CharacterPatternMap('P', new String[] { "**** ", "** **", "**** ", "**   ", "**   " }),

				new CharacterPatternMap('S', new String[] { " ****", "**   ", " *** ", "   **", "**** " }) };
	}

	public static String[] getCharacterPattern(char ch, CharacterPatternMap[] charMaps) {
		for (CharacterPatternMap map : charMaps) {
			if (map.getCharacter() == ch) {
				return map.getPattern();
			}
		}
		return new String[] { "     ", "     ", "     ", "     ", "     " };
	}

	public static void printMessage(String message, CharacterPatternMap[] charMaps) {

		int patternHeight = charMaps[0].getPattern().length;

		for (int i = 0; i < patternHeight; i++) {
			for (int j = 0; j < message.length(); j++) {
				String[] pattern = getCharacterPattern(message.charAt(j), charMaps);
				System.out.print(pattern[i] + "  ");
			}
			System.out.println();
		}
	}

	public static HashMap<Character, String[]> createCharacterMap() {
		HashMap<Character, String[]> charMap = new HashMap<>();
		charMap.put('O', new String[] { "   ***    ", " **   **  ", "**     ** ", "**     ** ", "**     ** ",
				"**     ** ", "**     ** ", " **   **  ", "   ***    " });
		charMap.put('P', new String[] { "******    ", "**    **  ", "**     ** ", "**    **  ", "******    ",
				"**        ", "**        ", "**        ", "**        " });
		charMap.put('S', new String[] { "    ***** ", "  **      ", "**        ", "  **      ", "    ***   ",
				"      **  ", "        ** ", "      **   ", " *****     " });
		return charMap;
	}

	public static void displayBanner(String message, HashMap<Character, String[]> charMap) {
		int patternHeight = charMap.get('O').length;
		char[] chars = message.toCharArray();

		for (int line = 0; line < patternHeight; line++) {
			for (char ch : chars) {
				String[] pattern = charMap.get(ch);
				System.out.print(pattern[line]);
			}
			System.out.println();
		}
	}
}
