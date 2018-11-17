package parcialJAVA2doCuatrimestre2018;

import java.util.ArrayList;
import java.util.HashMap;

public class Bag implements Observer , Sujeto , Hitable{

	private String nombre;
	
	ArrayList<User> colaboradores;
	ArrayList<Bag> lista_referencias;
	ArrayList<Contenido> contenidos;
	ArrayList<Hit> hit_requests;
	private Hit latestHit;

	HashMap<Hit, ArrayList<Contenido>> historial;
	
	
	Bag(String nombre){
		this.nombre = nombre;	
	}

	public Hit getLatestHit() {
		return latestHit;
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public boolean isColaborador(User u) {
		
		for (User colaborador:colaboradores) {
			
			//comparo la identidad de los objetos de tipo usuario directamente para encontrar coincidencia
			if (colaborador.equals(u)) { return true; }
		}
		return false;
		
	}

	//el usuario deber autenticarse para poder acceder hacer cambios (pasar una referencia de si mismo)
	public void agregarContenido (Contenido c, User u) throws notAllowedException{
		
		if (isColaborador(u)) {
			contenidos.add(c);
		}else {
			throw new notAllowedException("El usuario no tiene los permisos correctos para esta accion");
		}
		
	}
	
	//el usuario deber autenticarse para poder acceder hacer cambios (pasar una referencia de si mismo)
	public void quitarContenido (Contenido c, User u) throws notAllowedException , notExistingContentException{
		
		if (isColaborador(u)) {
			
			if (contenidos.contains(c)){
				contenidos.remove(c);
			}else {
				throw new notExistingContentException("El contenido no existe en esta lista");
			}
			
		}else {
			throw new notAllowedException("El usuario no tiene los permisos correctos para esta accion");
		}
		
	}
	
	@Override
	public void update() {
		
		ArrayList<Contenido> resultados = historial.get(latestHit);
				
		for (Contenido resultado:resultados) {
			System.out.println(resultado.getTitulo());
		}
		
		//evito null pointer exception si la lista de ref. esta vacia
		if (!lista_referencias.isEmpty()){
			notifyObservers();
		}
		
	}

	@Override
	public void attach(Observer obs) {

		if (obs instanceof Bag) {
			lista_referencias.add((Bag)obs);
		}
		
	}

	@Override
	public void dettach(Observer obs) {

		if (obs instanceof Bag) {
			
			//chequeo si lo contiene para evitar tener que manejar la BagNotFoundException
			if (lista_referencias.contains((Bag)obs)) {
				lista_referencias.remove(obs);
			}
		}
		
	}

	//solicitar a los bags de la lista de referencia que enlisten sus contenidos tambien
	@Override
	public void notifyObservers() {

		for(Observer bag : lista_referencias) {
			bag.update();
		}
		
	}
	//punto 2b
	public void addColaborador(User user) throws ColaboradorExistsException {
		
		if (!colaboradores.contains(user)){
			colaboradores.add(user);
		}else {
			throw new ColaboradorExistsException("El colaborador ya existe en el Bag");
		}
	
	}
	//punto 2b
	public void quitarColaborador(User user) throws ColaboradorNotFoundException {
		
		if (colaboradores.contains(user)){
			int i = colaboradores.indexOf(user);
			colaboradores.remove(i);
		}else {
			throw new ColaboradorNotFoundException("El colaborador no existe en el Bag");
		}
	
	}

	@Override
	public void rollback(Hit hit) {

		if (historial.containsKey(hit)) {
			contenidos = historial.get(hit);
		}
		
	}

	@Override
	public void push(Hit hit) {
		
		if (hit.getHit_status() == "APROBADO" ) {
			
			ArrayList<Contenido>contenido_nuevo = new ArrayList<Contenido>();
			for (Contenido contenido : contenidos) {
				contenido_nuevo.add(contenido);
			}
			
			//chequeo si aun está en la lista de hit pendientes para evitar manejo de exception
			if (hit_requests.contains(hit)) {
				hit_requests.remove(hit);
			}
			
			historial.put(hit, contenido_nuevo);
			this.latestHit = hit;
		}
		
	}

	@Override
	public void approve(Hit hit) {
		
		if (hit_requests.contains(hit)) {
			hit.aprobar();
		}
		
	}
	
	//punto 2g 
	public void getChanges(Hit hit) {
		
		if (historial.containsKey(hit)) {
			ArrayList<Contenido> resultados = historial.get(hit);
			
			//se muestra el titulo de cada contenido a modo informativo
			for ( Contenido resultado : resultados) {
			
				System.out.println(resultado.getTitulo());
			
			}

		}
		
	}
	
	public void addHit(Hit hit, User user) {
		
		if (isColaborador(user)) {
			
			if (!this.hit_requests.contains(hit)) {
				hit_requests.add(hit);
			}
			
		}
			
		
	}

}
