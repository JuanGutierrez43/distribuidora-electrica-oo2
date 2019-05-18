package datos;

import java.time.LocalDate;
import java.util.Set;

public class Factura {
	private int idFactura;
	private String datosCliente;
	private LocalDate fecha;
	private String observaciones;
	private Set<ItemFactura> lstItem;

	public Factura() {
	}

	public Factura(String datosCliente, LocalDate fecha, String observaciones, Set<ItemFactura> lstItem) {
		super();
		this.datosCliente = datosCliente;
		this.fecha = fecha;
		this.observaciones = observaciones;
		this.lstItem = lstItem;
	}

	public int getIdFactura() {
		return idFactura;
	}

	protected void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}

	public String getDatosCliente() {
		return datosCliente;
	}

	public void setDatosCliente(String datosCliente) {
		this.datosCliente = datosCliente;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Set<ItemFactura> getLstItem() {
		return lstItem;
	}

	public void setLstItem(Set<ItemFactura> lstItem) {
		this.lstItem = lstItem;
	}

	// Métodos
	
	public double calcularTotal() {
		return 0;
	}
	
	public LocalDate calcularFVto() {
		return null;
	}

	@Override
	public String toString() {
		return "Factura [idFactura=" + idFactura + ", datosCliente=" + datosCliente + ", fecha=" + fecha
				+ ", observaciones=" + observaciones + ", lstItem=" + lstItem + "]";
	}
	
}
