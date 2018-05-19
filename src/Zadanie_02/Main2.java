package Zadanie_02;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;

public class Main2 {
	public static void main(String[] args) {
		System.out.println("Podaj typowaną liczbę");
		Scanner scan = new Scanner(System.in);
		int[] tab = new int[6];
		
		for(int i=0; i<6; i++) {
			if(i!=0) {
				System.out.println("Podaj kolejną liczbę");
			}
			while(tab[i]==0) {
				try {
					int numb = Integer.parseInt(scan.next());
					while(isNumberInTab(tab,numb) || (numb<1 || numb>49)) {
						if (numb<1 || numb>49) {
							System.out.println("Ta liczba nie jest z zakresu od 1 do 49. Podaj inną liczbę.");
						}	else if (isNumberInTab(tab,numb)) {
							System.out.println("Tę liczbę już podałeś wcześniej. Podaj inną liczbę.");
						}
						numb = Integer.parseInt(scan.next());
					}
					tab[i] = numb;
				} catch (InputMismatchException | NumberFormatException e) {
					System.out.println("Podaj liczbę całkowitą.");
				}
			}
		}
		
		scan.close();	
		Arrays.sort(tab);
		System.out.println("Twoje liczby to:");
		System.out.println(Arrays.toString(tab));
		System.out.println("Wylosowane liczby są następujące:");
		Integer[] random = random();
		System.out.println(Arrays.toString(random));
		System.out.println(win(tab, random));
		
	}
	
	static boolean isNumberInTab(int[] tab, int number) {
		boolean isInTab = false;
		for(int i=0; i<tab.length; i++) {
			if(number==tab[i]) {
				isInTab = true;
			}
		}
		return isInTab;
	}
	
	static Integer[] random() {
		Integer[] numbs = new Integer[49];
		for(int i=0; i<49; i++) {
			numbs[i] = i+1;
		}
		Collections.shuffle(Arrays.asList(numbs));
		Integer[] onlySix = Arrays.copyOf(numbs, 6);
		Arrays.sort(onlySix);
		return onlySix;
	}
	
	static String win(int[] tab, Integer[] random) {
		int check = 0;
		for(int i=0; i<6; i++) {
			for(int j=0; j<6; j++) {
				if(tab[i]==random[j]) {
					check = check + 1;
				}
			}
		}
		
		String str;
		switch(check) {
		case 3: str = "Trafiłeś trójkę";
			break;
		case 4: str = "Trafiłeś czwórkę";
			break;
		case 5: str = "Trafiłeś piątkę";
			break;
		case 6: str = "Trafiłeś szóstkę. GRATULACJE!";
			break;
		default: str = "Spróbuj jeszcze raz, może następnym razem się uda.";
			break;
		}
		
		return str;
	}
}

