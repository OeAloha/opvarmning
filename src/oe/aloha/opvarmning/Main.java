package oe.aloha.opvarmning;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int tall = 0;
		System.out.print("Hej med dig!\nIndtast et tal: ");
		for (int gange = 1; true; gange++) {
			String input = scanner.nextLine();
			if (input.toLowerCase().equals("q")) {
				System.out.println("Farvel!");
				scanner.close();
				break;
			}
			if (!input.matches("[0-9]+")) {
				System.out.print("Det var ikke et tal. Prøv igen: ");
				gange--;
				continue;
			}
			tall += Integer.parseInt(input);
			System.out.print("Gennemsnittet af de indtastede tal er " + (tall / gange) + ".\nIndtast endnu et tal: ");
		}
	}
}