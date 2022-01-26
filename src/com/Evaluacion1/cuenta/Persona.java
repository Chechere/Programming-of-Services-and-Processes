package com.Evaluacion1.cuenta;

public class Persona implements Runnable {
	String name = "Persona ";
	CuentaBancaria cuenta;
	int dineroSacar;
	int dineroSacado = 0;
	
	public Persona(CuentaBancaria cuenta, int dineroSacar, int name) {
		this.cuenta = cuenta;
		this.dineroSacar = dineroSacar;
		this.name += name;
	}
	
	@Override
	public void run() {
		int dinero = 1;
		while(dineroSacado < dineroSacar && dinero != 0) {
			try {
				dinero = cuenta.retirarDinero(10);
				dineroSacado += dinero;
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
		}
		
		if(dineroSacado == 0) {
			System.out.println(name + ": No habia mas dinero para sacar.");
		} else if(dineroSacado == dineroSacar) {
			System.out.println(name + ": He sacado " + dineroSacado + "€.");
		} else {
			System.out.println(name + ": He sacado " + dineroSacado + "€, y esperaba sacar " + dineroSacar + "€.");
		}
	}

}
