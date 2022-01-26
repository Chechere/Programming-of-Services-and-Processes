package com.Evaluacion1.cuenta;

public class Main_Cuenta {

	public static void main(String[] args) throws InterruptedException {
		CuentaBancaria cuenta = new CuentaBancaria(100);		
		Thread[] personas = new Thread[10];
		
		for(int i = 0; i < personas.length; i++) {
			Thread persona = new Thread(new Persona(cuenta, 40, i+1));
			personas[i] = persona;
			personas[i].start();
		}
		
		for(Thread persona : personas) {
			persona.join();
		}
		
		cuenta.showMoney();
	}

}
