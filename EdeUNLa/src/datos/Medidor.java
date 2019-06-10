package datos;

public class Medidor {
	private long idMedidor;
	private Cliente cliente;
	private int nroSerie;
	private String domicilioMedidor;
	private String potencia;
	private boolean esBaja;
	private Zona zona;

	public Medidor() {

	}

	public Medidor(Cliente cliente, int nroSerie, String domicilioMedidor, Zona zona) {
		this.cliente = cliente;
		this.nroSerie = nroSerie;
		this.domicilioMedidor = domicilioMedidor;
		this.esBaja = false;
		this.potencia = "BT";
		this.zona = zona;

	}

	public Medidor(Cliente cliente, int nroSerie, String domicilioMedidor, String potencia, Zona zona) {
		this.cliente = cliente;
		this.nroSerie = nroSerie;
		this.domicilioMedidor = domicilioMedidor;
		this.esBaja = false;
		this.potencia = potencia;
		this.zona = zona;

	}

	public long getIdMedidor() {
		return idMedidor;
	}

	protected void setIdMedidor(long idMedidor) {
		this.idMedidor = idMedidor;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public int getNroSerie() {
		return nroSerie;
	}

	public void setNroSerie(int nroSerie) {
		this.nroSerie = nroSerie;
	}

	public String getDomicilioMedidor() {
		return domicilioMedidor;
	}

	public void setDomicilioMedidor(String domicilioMedidor) {
		this.domicilioMedidor = domicilioMedidor;
	}

	public boolean isEsBaja() {
		return esBaja;
	}

	public void setEsBaja(boolean esBaja) {
		this.esBaja = esBaja;
	}

	public Zona getZona() {
		return zona;
	}

	public void setZona(Zona zona) {
		this.zona = zona;
	}

	public String getPotencia() {
		return potencia;
	}

	public void setPotencia(String potencia) {
		this.potencia = potencia;
	}

	@Override
	public String toString() {
		return "Medidor [idMedidor=" + idMedidor + ", cliente=" + cliente + ", nroSerie=" + nroSerie
				+ ", domicilioMedidor=" + domicilioMedidor + ", esBaja=" + esBaja + ", zona=" + zona
				+ ", potencia contratada: " + getPotencia() + "]";
	}

}