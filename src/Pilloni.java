import java.util.Scanner;


public class Pilloni
{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		Scanner input = new Scanner(System.in);
		ContoCorrente contoGioc= new ContoCorrente(1000);
		ContoCorrente contoCas= new ContoCorrente(100000);
		double somma;
		int n, cont= 0, cont2= 0, temp= 0;
		do {
			cont= 0;
			cont2= 0;
			do {
				System.out.print("\nInserisci la somma che vuoi giocare: ");
				somma= in.nextDouble();
				if(somma<=contoGioc.saldo && somma <= contoCas.saldo/5) {
					cont=1;
				}else {
					System.out.println("La cifra inserita non rispetta le nostre condizioni!");
					continue;
				}
			}while(cont==0);
			do {
				System.out.print("\nInserisci un numero 1 a 6: ");
				n= in.nextInt();
				if(n>=1 && n<=6)
					cont2= 1;
				else {
					System.out.println("Il numero inserito deve essere fra 1 a 6!");
					continue;
				}
			}while(cont2 == 0);
			contoCas.calcoloVinc(n, somma, contoGioc);
			String risp;
			if(contoGioc.saldo==0)
				break;
			else {
				System.out.println("Vuoi continuare a giocare: ");
				risp= input.nextLine();
				risp= risp.toLowerCase();
				if(risp.equals("si"))
					continue;
				else {
					temp=1;
					System.out.println("Uscita dal gioco... \n\nIl tuo saldo iniziale era di 1000 euro \nIl tuo saldo attuale è di " + contoGioc.saldo + " euro");
					if(contoGioc.saldo < 1000)
						System.out.println("\nSei in perdita di " + (1000 - contoGioc.saldo) + " euro");
					else if(contoGioc.saldo == 1000)
						System.out.println("\nSei in pari");
					else
						System.out.println("\nSei in vincita di " + (contoGioc.saldo - 1000) + " euro");
				}
			}
		}while(temp==0);
	}
}