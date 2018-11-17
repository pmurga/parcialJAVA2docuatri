package parcialJAVA2doCuatrimestre2018;

public class Cancion extends ContenidoMultimedia {
	
	public Cancion(String titulo , String descripcion , String url) {
		
		this.setTitulo(titulo);
		this.setDescripcion(descripcion);
		this.setUrl(url);
	}

	//genero un constructor donde no obligo al usuario a ingresar una descripcion
	//sin embargo, le agrego una descripción genérica para evitar tener que tratar
	//excepciones de null pointer para el objeto String titulo de la clase Contenido
	//en caso de que en ningun momento sea inicializado/modificado
	public Cancion(String titulo, String url) {
		
		this.setTitulo(titulo);
		this.setDescripcion("Sin Descripción");
		this.setUrl(url);
	}

}
