package datos;

public class Medidor {
	private long idMedidor;
	private Cliente cliente;
	private int nroSerie;
	private String domicilioMedidor;
	private boolean esBaja;
	
	public Medidor(Cliente cliente, int nroSerie, String domicilioMedidor, boolean esBaja) {
		this.cliente = cliente;
		this.nroSerie = nroSerie;
		this.domicilioMedidor = domicilioMedidor;
		this.esBaja = esBaja;
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

	@Override
	public String toString() {
		return "Medidor [idMedidor=" + idMedidor + ", cliente=" + cliente + ", nroSerie=" + nroSerie
				+ ", domicilioMedidor=" + domicilioMedidor + ", esBaja=" + esBaja + "]";
	}
}