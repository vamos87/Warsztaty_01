package Zadanie_01;

import java.util.Random;
import java.util.Scanner;

public class Main1 {
	public static void main(String[] args) {
		Random rand = new Random();
		int x = rand.nextInt(100)+1;
		
		System.out.println("Zgadnij liczbę");
		Scanner scan = new Scanner(System.in);
		
		int number = -1;
		while(number!=x) {
			while(!scan.hasNextInt()) {
				System.out.println("To nie jest liczba");
				scan.next();
			}
			
			number = scan.nextInt();
			
			if(number<x) {
				System.out.println("Za mało!");
			} else if (number>x) {
				System.out.println("Za dużo!");
			} 
		}
		scan.close();
		System.out.println("Zgadłeś!");
	}
}
