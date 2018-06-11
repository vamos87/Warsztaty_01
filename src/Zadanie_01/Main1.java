package Zadanie_01;

import java.util.Random;
import java.util.Scanner;

public class Main1 {
	public static void main(String[] args) {
		Random rand = new Random();
		int x = rand.nextInt(100)+1;
		
		System.out.println("Zgadnij jaką liczbę pomyslałem od 1 do 100.");
		Scanner scan = new Scanner(System.in);
		
		int number = -1;
		int attempt = 0;
		while(number!=x) {
			while(!scan.hasNextInt()) {
				System.out.println("To nie jest liczba. Spróbuj jeszcze raz.");
				scan.next();
			}
			
			number = scan.nextInt();
			
			if(number<x) {
				System.out.println("Za mało!");
			} else if (number>x) {
				System.out.println("Za dużo!");
			}
			attempt = attempt +1;
		}
		scan.close();
		if(attempt != 1){
			System.out.println("Zgadłeś w "+attempt+" próbach!");
		} else {
			System.out.println("Zgadłeś już w pierwszej próbie! GRATULACJE!!!");
		}

	}
}
