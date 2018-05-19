package Zadanie_03;

import java.util.Scanner;

public class Main3 {

	public static void main(String[] args) {
		System.out.println("Pomyśl liczbę od 0 do 1000, a ja ją zgadnę w max. 10 próbach");
		int min = 0;
		int max = 1000;
		Scanner scan = new Scanner(System.in);
		String answer = "";
		
		while(!answer.toUpperCase().equals("ZGADŁEŚ")) {
			int guess = ((max-min)/2)+min;
			System.out.println("Zgaduję: "+guess);
					
			answer = scan.nextLine();
		
			if(answer.toUpperCase().equals("ZGADŁEŚ")) {
				System.out.println("Wygrałem!");
			} else if (answer.toUpperCase().equals("ZA DUŻO")) {
				max = guess;
			} else if (answer.toUpperCase().equals("ZA MAŁO")) {
				min = guess;
			} else {
				System.out.println("Nie oszukuj!");
			}
		}
		scan.close();
		
	}

}
