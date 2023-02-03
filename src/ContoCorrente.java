
public class ContoCorrente {
	double saldo;
	ContoCorrente(double saldo){
		this.saldo= saldo;
	}
	
	void calcoloVinc(int n, double somma, ContoCorrente gioco) {
		int dado= (int)(Math.random()*6)+1;
		System.out.println("Il dado ha estratto il numero: " + dado);
		if(n == dado) {
			gioco.saldo += somma*5;
			saldo -= somma*5;
			System.out.println("Hai visto!");
		}else {
			saldo += somma;
			gioco.saldo -= somma;
			System.out.println("Il banco vince, hai perso!");
		}
		System.out.println("Saldo rimanente: " + gioco.saldo);
	}
}


