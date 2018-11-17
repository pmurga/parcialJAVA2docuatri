package parcialJAVA2doCuatrimestre2018;


//clase contenido multimedia engloba los atributos comunes de cualquier contenido multimedia
//sin importar su tipo --> a nivel implementación ahorro implementar los mismos métodos para las
//clases imagen, video , cancion, etc.

//clase abstracta ya que quiero establecerla genéricamente y que directamente sea instanciado
//el tipo de contenido multimedia específico que herede sus métodos y atributos
public abstract class ContenidoMultimedia extends Contenido{
	
	private String descripcion;
	private String url;
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
	
	
}
