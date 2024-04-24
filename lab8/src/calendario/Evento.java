package calendario;

public class Evento {
	private String descripcion;
	private String date;
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Evento(String descripcion, String date) {
		super();
		this.descripcion = descripcion;
		this.date = date;
	}
	
}
