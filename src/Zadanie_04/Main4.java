package Zadanie_04;

import java.util.Random;
import java.util.Scanner;

public class Main4 {

	public static void main(String[] args) {
	    try {
            System.out.println("Wprowadź kod rzutu kostkami do gry planszowej. \nNp. dla polecenia \"Rzuć dwiema kostkami dziesięciościennymi, a do wyniku dodaj 20\" wpisz: 2D10+20.");
            Scanner scan = new Scanner(System.in);
            String codeDice = scan.nextLine();
            scan.close();
            System.out.println(dice(codeDice));
        } catch (NumberFormatException e){
            System.out.println("Nieprawidłowy format kodu rzutu.");
        }
    }
	
	static int dice(String codeDice) throws NumberFormatException {
		int dIndex = codeDice.indexOf('D');
		int throwsDice = 1;
                try {
                    throwsDice = Integer.parseInt(codeDice.substring(0, dIndex));
                } catch (StringIndexOutOfBoundsException e){
                    //e.printStackTrace();
                } catch (NumberFormatException e){
                    //e.printStackTrace();
                }

		int signIndex;
		
		if(codeDice.contains("+")) {
			signIndex = codeDice.indexOf('+');
		} else if (codeDice.contains("-")) {
			signIndex = codeDice.indexOf('-');
		} else {
			signIndex = 0;
		}

		int typeDice;
		int modyfDice;
		if(signIndex == 0){
            typeDice = Integer.parseInt(codeDice.substring(dIndex+1));
            modyfDice = 0;
        } else {
            typeDice = Integer.parseInt(codeDice.substring(dIndex+1,signIndex));
            modyfDice = Integer.parseInt(codeDice.substring(signIndex+1));
        }

        boolean approvedTypeDice = false;
		int[] dices = {3,4,6,8,10,12,20,100};
        for(int i : dices){
            if(i==typeDice){
                approvedTypeDice = true;
            }
        }

        Random rand = new Random();
        int sum = 0;
        if(approvedTypeDice == false){
            System.out.println("Nieprawidłowy typ kostki. Do grier używamy jedynie kości typu D3, D4, D6, D8, D10, D12, D20 oraz D100.");
            modyfDice = 0;
        } else {
            for(int i=0; i<throwsDice; i++){
                sum = sum + rand.nextInt(typeDice)+1;
            }
        }
        System.out.println("Wynik rzutu:");
        return sum + modyfDice;
	}
}
