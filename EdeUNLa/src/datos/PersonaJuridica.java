package datos;

public class PersonaJuridica extends Cliente {
	
	private String cuit;
	private String razonSocial;
	
	public PersonaJuridica(String direccion, String email, long telefonoFijo, long telefonoMovil,
			String cuit, String razonSocial) {
		super(direccion, email, telefonoFijo, telefonoMovil);
		this.cuit = cuit;
		this.razonSocial = razonSocial;
	}

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	@Override
	public String toString() {
		return "PersonaJuridica [cuit=" + cuit + ", razonSocial=" + razonSocial + "]";
	}
	
	
	
}
