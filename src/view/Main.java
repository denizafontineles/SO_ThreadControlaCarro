package view;
import controller.ThreadControlaCarro;

	import java.util.concurrent.Semaphore;

	public class Main {

		public static void main(String[] args) {
			
			int permissoes = 1;
			Semaphore semaforo = new Semaphore(permissoes);

			for (int id = 0; id < 4; id++)
			{
				ThreadControlaCarro threadControlaCarro = new ThreadControlaCarro(id, semaforo);
				threadControlaCarro.start();				
			}

		}
}
