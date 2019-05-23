package datos;

public class DetalleAlta {
	
	private long idDetalleAlta;
	private TarifaAlta tarifaAlta;
	private String detalleConcepto;
	private String unidad;
	private boolean superarLimite;
	private double valor;

	public DetalleAlta() {
	}

	public DetalleAlta(TarifaAlta tarifaAlta, String detalleConcepto, String unidad, boolean superarLimite, double valor) {
		super();
		this.tarifaAlta = tarifaAlta;
		this.detalleConcepto = detalleConcepto;
		this.unidad = unidad;
		this.superarLimite = superarLimite;
		this.valor = valor;
	}
	
	public long getIdDetalleAlta() {
		return idDetalleAlta;
	}

	protected void setIdDetalleAlta(long idDetalleAlta) {
		this.idDetalleAlta = idDetalleAlta;
	}

	public TarifaAlta getTarifaAlta() {
		return tarifaAlta;
	}

	public void setTarifaAlta(TarifaAlta tarifaAlta) {
		this.tarifaAlta = tarifaAlta;
	}

	public String getDetalleConcepto() {
		return detalleConcepto;
	}

	public void setDetalleConcepto(String detalleConcepto) {
		this.detalleConcepto = detalleConcepto;
	}

	public String getUnidad() {
		return unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	public boolean isSuperarLimite() {
		return superarLimite;
	}

	public void setSuperarLimite(boolean superarLimite) {
		this.superarLimite = superarLimite;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "DetalleAlta [idDetalleAlta=" + idDetalleAlta + ", tarifaAlta=" + tarifaAlta + ", detalleConcepto="
				+ detalleConcepto + ", unidad=" + unidad + ", superarLimite=" + superarLimite + ", valor=" + valor
				+ "]";
	}
}