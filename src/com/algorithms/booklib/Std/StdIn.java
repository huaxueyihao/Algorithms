package com.algorithms.booklib.Std;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Pattern;

public final class StdIn {

	// 使用UTF-8编码
	// assume Unicode UTF-8 encoding
	private static final String CHARSET_NAME = "UTF-8";

	// 使用语言 = English country = US 用作统一输出
	// assume language = English, country = US for consistency with System.out.
	private static final Locale LOCALE = Locale.US;

	// the default token separator; we maintain the invariant that this value
	// is held by the scanner's delimiter between calls
	private static final Pattern WHITESPACE_PATTERN = Pattern.compile("\\p{javaWhitespace}+");

	// makes whitespace significant
	private static final Pattern EMPTY_PATTERN = Pattern.compile("");

	// used to read the entire input
	private static final Pattern EVERYTHING_PATTERN = Pattern.compile("\\A");

	private static Scanner scanner;

	// it doesn't make sense to instantiate this class
	private StdIn() {
	}

	public static boolean isEmpty() {
		return !scanner.hasNext();
	}

	public static boolean hasNextLine() {
		return scanner.hasNextLine();
	}

	public static boolean hasNextChar() {
		scanner.useDelimiter(EMPTY_PATTERN);
		boolean result = scanner.hasNext();
		scanner.useDelimiter(WHITESPACE_PATTERN);
		return result;
	}

	public static String readLine() {
		String line;
		try {
			line = scanner.nextLine();
		} catch (NoSuchElementException e) {
			line = null;
		}
		return line;
	}

	public static char readChar() {
		try {
			scanner.useDelimiter(EMPTY_PATTERN);
			String ch = scanner.next();
			assert ch.length() == 1 : "Internal (Std) In.readChar() error!" + " Please contact the authors";
			scanner.useDelimiter(WHITESPACE_PATTERN);
			return ch.charAt(0);
		} catch (NoSuchElementException e) {
			throw new NoSuchElementException(
					"attempts to read a 'char' value from standard input, but there are no more token available");
		}
	}

	public static String readAll() {
		if (!scanner.hasNextLine())
			return "";
		String result = scanner.useDelimiter(EVERYTHING_PATTERN).next();
		scanner.useDelimiter(WHITESPACE_PATTERN);
		return result;
	}

	public static String readString() {
		try {
			return scanner.next();
		} catch (NoSuchElementException e) {
			throw new NoSuchElementException(
					"attempts to read a 'String' value from standard input, but there are no more token available");
		}
	}

	public static int readInt() {
		try {
			return scanner.nextInt();
		} catch (InputMismatchException e) {
			throw new InputMismatchException(
					"attempts to read a 'int' value from standard input, but there are no more token available");
		} catch (NoSuchElementException e) {
			throw new NoSuchElementException(
					"attempts to read a 'int' value from standard input, but there are no more token available");
		}
	}

	public static double readDouble() {
		try {
			return scanner.nextDouble();
		} catch (InputMismatchException e) {
			throw new InputMismatchException(
					"attempts to read a 'double' value from standard input, but there are no more token available");
		} catch (NoSuchElementException e) {
			throw new NoSuchElementException(
					"attempts to read a 'double' value from standard input, but there are no more token available");
		}
	}

	public static float readFloat() {
		try {
			return scanner.nextFloat();
		} catch (InputMismatchException e) {
			throw new InputMismatchException(
					"attempts to read a 'float' value from standard input, but there are no more token available");
		} catch (NoSuchElementException e) {
			throw new NoSuchElementException(
					"attempts to read a 'float' value from standard input, but there are no more token available");
		}
	}

	public static long readLong() {
		try {
			return scanner.nextLong();
		} catch (InputMismatchException e) {
			throw new InputMismatchException(
					"attempts to read a 'long' value from standard input, but there are no more token available");
		} catch (NoSuchElementException e) {
			throw new NoSuchElementException(
					"attempts to read a 'long' value from standard input, but there are no more token available");
		}
	}

	public static short readShort() {
		try {
			return scanner.nextShort();
		} catch (InputMismatchException e) {
			throw new InputMismatchException(
					"attempts to read a 'short' value from standard input, but there are no more token available");
		} catch (NoSuchElementException e) {
			throw new NoSuchElementException(
					"attempts to read a 'short' value from standard input, but there are no more token available");
		}
	}

	public static byte readByte() {
		try {
			return scanner.nextByte();
		} catch (InputMismatchException e) {
			throw new InputMismatchException(
					"attempts to read a 'byte' value from standard input, but there are no more token available");
		} catch (NoSuchElementException e) {
			throw new NoSuchElementException(
					"attempts to read a 'byte' value from standard input, but there are no more token available");
		}
	}

	public static boolean readBoolean() {
		try {
			String token = readString();
			if ("true".equalsIgnoreCase(token))
				return true;
			if ("false".equalsIgnoreCase(token))
				return false;
			if ("1".equalsIgnoreCase(token))
				return true;
			if ("0".equalsIgnoreCase(token))
				return false;
			throw new InputMismatchException(
					"attempts to read a 'boolean' value from standard input, but there are no more token available");
		} catch (NoSuchElementException e) {
			throw new NoSuchElementException(
					"attempts to read a 'boolean' value from standard input, but there are no more token available");
		}
	}

	public static String[] readAllStrings() {
		String[] tokens = WHITESPACE_PATTERN.split(readAll());
		if (tokens.length == 0 || tokens[0].length() > 0)
			return tokens;
		String[] decapitokens = new String[tokens.length - 1];
		for (int i = 0; i < tokens.length - 1; i++) {
			decapitokens[i] = tokens[i];
		}
		return decapitokens;
	}

	public static String[] readAllLines() {
		List<String> lines = new ArrayList<String>();
		while(hasNextLine()) {
			lines.add(readLine());
		}
		return lines.toArray(new String[lines.size()]);
		
	}

	public static int[] readAllInts() {
		String[] fields = readAllStrings();
		int[] vals = new int[fields.length];
		for (int i = 0; i < vals.length; i++) 
			vals[i] = Integer.parseInt(fields[i]);
		return vals;
	}
	
	public static long[] readAllLongs() {
		String[] fields = readAllStrings();
		long[] vals = new long[fields.length];
		for (int i = 0; i < vals.length; i++) 
			vals[i] = Long.parseLong(fields[i]);
		return vals;
	}
	
	
	public static double[] readAllDoubles() {
		String[] fields = readAllStrings();
		double[] vals = new double[fields.length];
		for (int i = 0; i < vals.length; i++) 
			vals[i] = Double.parseDouble(fields[i]);
		return vals;
	}
	
	static {
		resync();
	}

	private static void resync() {
		setScanner(new Scanner(new java.io.BufferedInputStream(System.in),CHARSET_NAME));
	}

	private static void setScanner(Scanner scanner) {
		StdIn.scanner = scanner;
		StdIn.scanner.useLocale(LOCALE);
	}
	
	@Deprecated
	public static int[] readInts() {
		return readAllInts();
	}
	
	@Deprecated
	public static double[] readDoubles() {
		return readAllDoubles();
	}
	
	@Deprecated
	public static String[] readStrings() {
		return readAllStrings();
	}
	
	public static void main(String[] args) {
		
		String[] s = StdIn.readAllStrings();
		StdOut.println(s);
		
	}
	

	
	
}
