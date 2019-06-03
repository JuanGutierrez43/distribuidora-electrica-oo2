package datos;

public abstract class Cliente {
	
	private long idCliente;
	private String direccion;
	private String email;
	private long telefonoFijo;
	private long telefonoMovil;
	
	public Cliente() {
		
	}
	
	public Cliente(String direccion, String email, long telefonoFijo, long telefonoMovil) {
		super();
		this.direccion = direccion;
		this.email = email;
		this.telefonoFijo = telefonoFijo;
		this.telefonoMovil = telefonoMovil;
	}

	public long getIdCliente() {
		return idCliente;
	}

	protected void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getTelefonoFijo() {
		return telefonoFijo;
	}

	public void setTelefonoFijo(long telefonoFijo) {
		this.telefonoFijo = telefonoFijo;
	}

	public long getTelefonoMovil() {
		return telefonoMovil;
	}

	public void setTelefonoMovil(long telefonoMovil) {
		this.telefonoMovil = telefonoMovil;
	}

	// método para atributo: detalle, de itemFactura
	public String itemCliente() {
		return "Cliente [idCliente=" + idCliente + ", direccion=" + direccion + ", telefonoFijo="
				+ telefonoFijo + ", telefonoMovil=" + telefonoMovil + "]";
	}
	
	public abstract String datosCliente();
	
	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", direccion=" + direccion + ", email=" + email + ", telefonoFijo="
				+ telefonoFijo + ", telefonoMovil=" + telefonoMovil + "]";
	}
	
}