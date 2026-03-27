package tp1.ejercicio3;

public class Test {

	public static void main(String[] args) {
		
		Estudiante[] estudiantes = {new Estudiante("Tomas", "Cielli Moro", "tomas@gmail.com", "1", "C 73"), 
									new Estudiante("Juan", "Gomez", "juan@gmail.com", "2", "C 74")};
		
		Profesor[] profesores = {new Profesor ("Pedro", "Cielli", "pedro@gmai.com", "Civil", "UTN"),
								 new Profesor ("Maria", "Moro", "maria@gmai.com", "Hidraulica", "Ingenieria"),
								 new Profesor ("Pablo", "Perez", "pablo@gmai.com", "AyED", "Informatica")};
		
		System.out.println("------ Estudiantes ------");
		for (Estudiante est : estudiantes) {
			System.out.println(est.tusDatos());
			System.out.println("");
		}
		System.out.println("");
		
		System.out.println("------ Profesores ------");
		for (Profesor prof : profesores) {
			System.out.println(prof.tusDatos());
			System.out.println("");
		}
	}

}
