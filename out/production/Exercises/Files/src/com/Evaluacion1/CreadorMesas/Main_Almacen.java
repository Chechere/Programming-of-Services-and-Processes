package com.Evaluacion1.CreadorMesas;

public class Main_Almacen {

	public static void main(String[] args) {
		String[] types = {"tableros", "patas", "mesas"};
		int mesas = 4, tableros = 2, patas = 4;
		Almacen almacen = new Almacen(tableros, patas, mesas);
		Thread[] constructores = new Thread[3];
		
		
		for(int i = 0; i < 3; i++) {
			constructores[i] = new Thread(new Constructor(almacen, types[i]));
			constructores[i].start();
		}
		
		for(Thread constructor : constructores) {
			try {
				constructor.join();
			} catch (InterruptedException e) {				
			}
		}
		
		almacen.mostrarAlmacen();
	}

}
