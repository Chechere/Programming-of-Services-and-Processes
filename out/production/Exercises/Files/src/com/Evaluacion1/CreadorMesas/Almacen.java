package com.Evaluacion1.CreadorMesas;

public class Almacen {
	public final int MAX_TABLEROS;
	public final int MAX_PATAS;
	public final int MAX_MESAS;
	
	private int tableros = 0;
	private int patas = 0;
	private int mesas = 0;
	
	public Almacen(int MAX_TABLEROS, int MAX_PATAS, int MAX_MESAS) {
		this.MAX_TABLEROS = MAX_TABLEROS;
		this.MAX_PATAS = MAX_PATAS;
		this.MAX_MESAS = MAX_MESAS;		
	}	
	
	public synchronized void addPata() throws InterruptedException {
		if(patas == MAX_PATAS) {
			System.out.println("No puedo crear una pata.");
			
			while(patas == MAX_PATAS) {				
				wait();			
			}
		}
		
		patas++;
		System.out.println("Creo una pata. Ahora hay " + patas + " de " + MAX_PATAS);		
		notifyAll();
		
	}
	
	public synchronized void addTablero() throws InterruptedException {		
		if(tableros == MAX_TABLEROS) {
			System.out.println("No puedo crear un tablero.");

			while(tableros == MAX_TABLEROS) {			
				wait();			
			}
		}
				
		tableros++;
		System.out.println("Creo un tablero. Ahora hay " + tableros + " de " + MAX_TABLEROS);		
		notifyAll();
		
	}
	
	public synchronized void addMesa() throws InterruptedException {
		if(tableros < 1 || patas < 4) {
			System.out.println("No puedo crear una mesa.");
			
			while(tableros < 1 || patas < 4) {			
				wait();							
			}
		}
		
		tableros--;
		patas -= 4;
		mesas++;
		System.out.println("Creo una mesa. Ahora hay " + mesas + " de " + MAX_MESAS);		
		notifyAll();
		
	}
	
	public synchronized boolean mesasLimit() {
		return mesas == MAX_MESAS;
	}
	
	public void mostrarAlmacen() {
		System.out.println("Hay en el almacen " + mesas + " mesas.");
		System.out.println("Hay en el almacen " + tableros + " tableros.");
		System.out.println("Hay en el almacen " + patas + " patas.");

	}
}
