package Tarea1;

import java.util.StringTokenizer;

public class BrailleSystem {
	public static String translateBrailletoDecimal(String input) {
		/*
		En el StringTokenizer se le agrega null debido a que en el programa se suman las variables
		a la línea recibida por parámetro y como la variable está vacia se le suma el null al comienzo
		*/
		StringTokenizer stk = new StringTokenizer(input, " null");
		String braille, traduccion = "";
		//Si la línea tiene más elementos se continuara la iteración
		while (stk.hasMoreElements()) {
			braille = stk.nextToken();
			if (braille.equals("*.....")) {
				traduccion += "1";
			} else if (braille.equals("*.*...")) {
				traduccion += "2";
			} else if (braille.equals("**....")) {
				traduccion += "3";
			} else if (braille.equals("**.*..")) {
				traduccion += "4";
			} else if (braille.equals("*..*..")) {
				traduccion += "5";
			} else if (braille.equals("***...")) {
				traduccion += "6";
			} else if (braille.equals("****..")) {
				traduccion += "7";
			} else if (braille.equals("*.**..")) {
				traduccion += "8";
			} else if (braille.equals(".**...")) {
				traduccion += "9";
			} else if (braille.equals(".***..")) {
				traduccion += "0";;
			}
		}
		return traduccion;
	}

	public static String translateDecimaltoBraille(String input, int cant) {
		int num;
		String traduccion = "";
		for (int i = 0; i < cant; i++) {
			//Se va de char en char comparando, transformando el char a String y luego el String a entero
			num = Integer.parseInt(String.valueOf((input.charAt(i))));
			if (num == 1) {
				traduccion += ("*. .. ..") + " ";
			} else if (num == 2) {
				traduccion += ("*. *. ..") + " ";
			} else if (num == 3) {
				traduccion += ("** .. ..") + " ";
			} else if (num == 4) {
				traduccion += ("** .* ..") + " ";
			} else if (num == 5) {
				traduccion += ("*. .* ..") + " ";
			} else if (num == 6) {
				traduccion += ("** *. ..") + " ";
			} else if (num == 7) {
				traduccion += ("** ** ..") + " ";
			} else if (num == 8) {
				traduccion += ("*. ** ..") + " ";
			} else if (num == 9) {
				traduccion += (".* *. ..") + " ";
			} else if (num == 0) {
				traduccion += (".* ** ..") + " ";
			}
		}
		return traduccion;
	}	
}
