package tp1.ejercicio3;

public class Profesor extends Persona{

	private String catedra;
	private String facultad;
	
	public Profesor(String nombre, String apellido, String email, String catedra, String facultad) {
		super(nombre, apellido, email);
		this.setCatedra(catedra);
		this.setFacultad(facultad);
	}
	
	public String getCatedra() {
		return catedra;
	}
	public void setCatedra(String catedra) {
		this.catedra = catedra;
	}
	public String getFacultad() {
		return facultad;
	}
	public void setFacultad(String facultad) {
		this.facultad = facultad;
	}
	
	public String tusDatos() {
		String datos = "Profesor " + super.tusDatos() + " | Facultad: " + this.getFacultad() + " | Catedra: " + this.getCatedra() + ".";
		return datos;
	}
	
}
