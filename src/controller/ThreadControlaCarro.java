package controller;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class ThreadControlaCarro extends Thread{
	
	private int id;
	private Semaphore semaforo;
	private String sentido [] = {"cima", "baixo", "direita", "esquerda"};
	
	public ThreadControlaCarro(int id, Semaphore semaforo){
		this.id = id;
		this.semaforo = semaforo;
	}
	
	@Override
	public void run(){
		try{
			semaforo.acquire();
			Deslocamento();
		}
		catch (InterruptedException e){
			e.printStackTrace();
		}
		finally{
			semaforo.release();
		}
	}

	private void Deslocamento(){
		String destino;
		
		if(condicaoCruzamento(id)){
			destino = sentido[id+1];
		}
		else{			
			destino = sentido[id-1];
		}
		System.out.println("O Carro " + id + " está na rua a " + sentido[id] + " indo para rua a " + destino);
		dormir(3000);
		System.out.println("O Carro " + id + " atravessou o cruzamento");
		dormir(1000);
	}

	private void dormir(int tempo){
		try{
			sleep(tempo);
		}catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}

	private boolean condicaoCruzamento(int x)
	{
		if (x % 2 == 0){
			return true;
		}
		return false;
	}
}
