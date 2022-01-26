package com.Evaluacion1.CreadorMesas;

public class Constructor implements Runnable {
	Almacen almacen;
	String type;
	
	public Constructor(Almacen almacen, String type) {
		this.almacen = almacen;
		this.type = type;
	}
	
	@Override
	public void run() {		
		while(!almacen.mesasLimit()) {
			try {
				Thread.sleep((int)(Math.random() * 1000));
				
				switch(type) {
					case "tableros":
						almacen.addTablero();
					break;
					case "patas":
						almacen.addPata();
					break;
					case "mesas":
						almacen.addMesa();
					break;
				}				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("He terminado de construir mis " + type);
	}
	
}
