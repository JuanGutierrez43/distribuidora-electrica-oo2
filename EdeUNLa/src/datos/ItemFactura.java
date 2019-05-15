package datos;

public class ItemFactura {

	private int idItemFactura;
	private String detalle;
	private double precioUnitario;
	private int cantidad;
	private String unidad;
	private int nroMedidor;
	private Tarifa tarifa;
	private Lectura lectura;

	public ItemFactura() {
	}

	public ItemFactura(String detalle, double precioUnitario, int cantidad, String unidad, int nroMedidor,
			Tarifa tarifa, Lectura lectura) {
		super();
		this.detalle = detalle;
		this.precioUnitario = precioUnitario;
		this.cantidad = cantidad;
		this.unidad = unidad;
		this.nroMedidor = nroMedidor;
		this.tarifa = tarifa;
		this.lectura = lectura;
	}

	public int getIdItemFactura() {
		return idItemFactura;
	}

	protected void setIdItemFactura(int idItemFactura) {
		this.idItemFactura = idItemFactura;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getUnidad() {
		return unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	public int getNroMedidor() {
		return nroMedidor;
	}

	public void setNroMedidor(int nroMedidor) {
		this.nroMedidor = nroMedidor;
	}

	public Tarifa getTarifa() {
		return tarifa;
	}

	public void setTarifa(Tarifa tarifa) {
		this.tarifa = tarifa;
	}

	public Lectura getLectura() {
		return lectura;
	}

	public void setLectura(Lectura lectura) {
		this.lectura = lectura;
	}

	// métodos
	public double calcularSubTotal() {
		return 0;
	}

	@Override
	public String toString() {
		return "ItemFactura [idItemFactura=" + idItemFactura + ", detalle=" + detalle + ", precioUnitario="
				+ precioUnitario + ", cantidad=" + cantidad + ", unidad=" + unidad + ", nroMedidor=" + nroMedidor
				+ ", tarifa=" + tarifa + ", lectura=" + lectura + "]";
	}

}
