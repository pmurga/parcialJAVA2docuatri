package parcialJAVA2doCuatrimestre2018;

import java.util.ArrayList;

public class User implements Sujeto{
	
	private ArrayList<Observer> bags = new ArrayList<>();
	
	public User() {
		
	}
	
	public void attach(Observer obs) {
		
		//evito duplicados sin tener que manejar exceptions
		if (!bags.contains(obs)) {
			bags.add(obs);
		}
	}

	
	public void dettach(Observer obs) {
		
		//evito manejo de excepciones notFound
		if(bags.contains(obs)){
			bags.remove(obs);
		}
	}

	//obtener listado del contenido (punto 2a)
	public void notifyObservers() {
		
		for(Observer bag : bags) {
			bag.update();
		}
	}
	
	public void crearBag (String nombre) {
		
		Bag bag = new Bag(nombre);
		attach(bag);
		
	}
	
	//punto (2b)
	public void addColaborador(User user, Bag bag) throws BagNotFoundException , ColaboradorExistsException {
	
		if (bags.contains(bag)) {
			bag.addColaborador(user);
		}else {
			throw new BagNotFoundException("El usuario no posee ese Bag");
		}
	}
	//punto (2b)
	public void quitarColaborador(User user, Bag bag) throws BagNotFoundException , ColaboradorNotFoundException {
		
		if (bags.contains(bag)) {
			bag.quitarColaborador(user);
		}else {
			throw new BagNotFoundException("El usuario no posee ese Bag");
		}
	}
	
	// los hit se crean "locales" para el user y solo se ven del lado del bag cuando se commitean
	public void commitToBag(String descripcion, Bag bag) {
		
		Hit hit = new Hit(descripcion);
		bag.addHit(hit, this);
		

	}

	
}
