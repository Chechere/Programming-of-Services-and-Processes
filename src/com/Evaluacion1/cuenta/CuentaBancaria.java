package com.Evaluacion1.cuenta;

public class CuentaBancaria {
	int saldo;
	boolean retirando = false;
	
	public CuentaBancaria(int saldoInicial) {
		this.saldo = saldoInicial;
	}
	
	public synchronized int retirarDinero(int esperado) throws InterruptedException {
		int dinero = 0;
		
		while(retirando) {
			wait();
		}		
		
		if(saldo >= 0) {			
			retirando = true;
			if(esperado <= saldo) {
				dinero = esperado;
			} else { 
				dinero = saldo;
			}
			
			Thread.sleep(500);		
			saldo -= dinero;		
		}
		
		retirando = false;
		notify();
		return dinero;
	}	
	
	public void showMoney() {
		System.out.println("En la cuenta quedan " + saldo + "€.");
	}
}
