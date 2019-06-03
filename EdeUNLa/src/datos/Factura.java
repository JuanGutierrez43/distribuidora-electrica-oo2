package datos;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Factura {
	private long idFactura;
	private String datosCliente;
	private LocalDate fecha;
	private String observaciones;
	private Set<ItemFactura> lstItem;

	public Factura() {
	}

	public Factura(String datosCliente, LocalDate fecha, String observaciones) {
		super();
		this.datosCliente = datosCliente;
		this.fecha = fecha;
		this.observaciones = observaciones;
		this.lstItem = new HashSet<ItemFactura>();
	}

	public long getIdFactura() {
		return idFactura;
	}

	protected void setIdFactura(long idFactura) {
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

	public double calcularTotal() {
		double Total = 0;
		for (ItemFactura itemFactura : getLstItem()) {
			Total += itemFactura.calcularSubTotal();
		}
		return Total;
	}

	public LocalDate calcularFVto() {
		return null;
	}

	public void setLstItemBajaDemanda(Lectura lecturaNueva, BajaDemanda lecturaAnterior, Tarifa tarifa) {

		double precioUnitario = 0;
		int cantidad = ((BajaDemanda)lecturaNueva).getConsumo(lecturaAnterior);
		String unidad = null;

		for (DetalleBaja db : ((TarifaBaja) tarifa).getLstDetalle()) {
			if (db.getDetalleConcepto().equalsIgnoreCase("Cargo Fijo")) {
				unidad = db.getUnidad();
			} else {
				precioUnitario = db.getValor();
			}

		}

		ItemFactura itemFactura = new ItemFactura(precioUnitario, cantidad, unidad, tarifa, lecturaNueva, this);
		// itemFactura
//		System.out.println("Cant: " + cantidad);
//		System.out.println("Detalle: fecha " + lecturaNueva.getFecha() + ", Localizado en: "
//				+ lecturaNueva.getMedidor().getDomicilioMedidor());
//		System.out.println("Total: " + total);
//		System.out.println("precioUnitario: " + precioUnitario);
//		System.out.println("cantidad: " + cantidad);
//		System.out.println("unidad: " + unidad);
//		System.out.println("nroMedidor: " + lecturaNueva.getMedidor().getNroSerie());
//		System.out.println("Tarifa -> " + tarifa);
//		System.out.println("Lectura -> " + lecturaNueva);
		this.lstItem.add(itemFactura);

	}

	@Override
	public String toString() {
		return "Factura [idFactura=" + idFactura + ", datosCliente=" + datosCliente + ", fecha=" + fecha
				+ ", observaciones=" + observaciones + ", lstItem=" + lstItem + "]";
	}

}
