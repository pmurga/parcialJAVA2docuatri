package parcialJAVA2doCuatrimestre2018;

//hereda directamente de Contenido ya que no requiere compartir atributos con el resto
// de los contenidos multimedia más que el título
public class Texto extends Contenido{

	private String contenido;

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	
	public Texto(String titulo , String contenido) {
		
		this.setTitulo(titulo);
		this.contenido = contenido;
		
	}
	
	
}
