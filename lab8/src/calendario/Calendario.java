package calendario;

import java.util.ArrayList;
import java.util.HashMap;

public class Calendario {
	private HashMap<String, Evento> eventos;
	
	public HashMap<String, Evento> getEventos() {
		return eventos;
	}

	public void setEventos(HashMap<String, Evento> eventos) {
		this.eventos = eventos;
	}

	public Calendario() {
		this.eventos = new HashMap<String, Evento>();
		this.cargarEventos();
	}
	
	private void cargarEventos() {
		ArrayList<String> textos = ArchivoPlano.cargar("eventos.csv");
		for(String textoEvento : textos) {
			String datos[] = textoEvento.split(";");
			Evento evento = new Evento(datos[1], datos[0]);
			this.eventos.put(datos[0], evento);
		}
	}
}

