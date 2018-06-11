package Zadanie_03;

import java.util.Scanner;

public class Main3 {

	public static void main(String[] args) {
		System.out.println("Pomyśl liczbę od 0 do 1000, a ja ją zgadnę w max. 10 próbach. Po każdej mojej próbie napisz za mało, za dużo, albo zgadłeś. OK?");
		int min = 0;
		int max = 1000;
		Scanner scan = new Scanner(System.in);
		scan.nextLine();
		int attempt = 1;
		String answer = "";
		
		while(!answer.toUpperCase().equals("ZGADŁEŚ")) {
			int guess = ((max-min)/2)+min;
			System.out.println("Próba nr"+attempt+". Zgaduję: "+guess);
					
			answer = scan.nextLine();
		
			if(answer.toUpperCase().equals("ZGADŁEŚ")) {
				System.out.println("Wygrałem! Tak jak mówiłem zgadłem Twoją liczbę w 10 próbach.");
			} else if (answer.toUpperCase().equals("ZA DUŻO")) {
				max = guess;
			} else if (answer.toUpperCase().equals("ZA MAŁO")) {
				min = guess;
			} else {
				System.out.println("Nie oszukuj! Po każdej mojej próbie napisz za mało, za dużo, albo zgadłeś.");
			}
			attempt = attempt +1;
		}
		scan.close();
		
	}

}
