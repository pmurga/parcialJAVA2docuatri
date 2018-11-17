package parcialJAVA2doCuatrimestre2018;

public class Hit {
		
	private String descripcion;
	
	private enum Estado {PENDIENTE, RECHAZADO, APROBADO};
	private Estado hit_status;
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	//se requiere al usuario ingresar una descripcion para poder generar un hit
	public Hit(String descripcion){
		this.descripcion = descripcion;
		this.hit_status = Estado.PENDIENTE; //el estado siempre se inicializara en pendiente
	}
	public void aprobar() {
		this.hit_status = Estado.APROBADO;
	}
	public void rechazar() {
		this.hit_status = Estado.RECHAZADO;
	}
	public String getHit_status() {
		return hit_status.name();
	}
	
	

}
