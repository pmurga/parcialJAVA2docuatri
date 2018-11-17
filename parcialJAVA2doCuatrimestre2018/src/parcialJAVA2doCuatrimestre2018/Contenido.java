package parcialJAVA2doCuatrimestre2018;

//clase abstracta ya que no requiero instanciar nunca un objeto genérico de tipo contenido multimedia
//simplemente lo abstraigo para poder compartir el atributo común "titulo"
public abstract class Contenido{
	
	private String titulo;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
}
