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

	public void agregarItemBajaDemanda(BajaDemanda lecturaNueva, BajaDemanda lecturaAnterior, Tarifa tarifa) {
		double precioUnitario = 0, precioUnitario2 = 0;
		int cantidad = ((BajaDemanda) lecturaNueva).calcularConsumo(lecturaAnterior), cantidad2 = 1;
		String unidad = null, unidad2 = null;
		for (DetalleBaja db : ((TarifaBaja) tarifa).getLstDetalle()) {
			if (!db.getDetalleConcepto().equals("Cargo Fijo")) {
				unidad = db.getUnidad();
				precioUnitario = db.getValor();
			} else {
				unidad2 = db.getUnidad();
				precioUnitario2 = db.getValor();
			}
		}
		
		ItemFactura itemFactura = new ItemFactura(precioUnitario, cantidad, unidad, tarifa, lecturaNueva, this);
		ItemFactura itemFactura2 = new ItemFactura(precioUnitario2, cantidad2, unidad2, tarifa, lecturaNueva, this);
		
		this.lstItem.add(itemFactura);
		this.lstItem.add(itemFactura2);
		
	}
	
	public void agregarItemAltaDemanda(AltaDemanda lecturaNueva, AltaDemanda lecturaAnterior, Tarifa tarifa1,Tarifa tarifa2,Tarifa tarifa3) {
		
		double precioUnitario = 0;
		String unidad = null;
		int cantidad = 1;
		
		int cantidadVAlle = ((AltaDemanda) lecturaNueva).calcularConsumoHorasValle(lecturaAnterior);
		double precioUnitarioValle = 0;
		int cantidadPico = ((AltaDemanda) lecturaNueva).calcularConsumoHorasPico(lecturaAnterior);
		double precioUnitarioPico = 0;
		int cantidadResto = ((AltaDemanda) lecturaNueva).calcularConsumoHorasResto(lecturaAnterior);
		double precioUnitarioResto = 0;
				
		String unidadPico = null;
		String unidadValle = null;
		String unidadResto = null;
		
		for (DetalleAlta detalleAlta : ((TarifaAlta) tarifa1).getLstDetalle()) {
			if (detalleAlta.getDetalleConcepto().equals("Cargo fijo") ) {
				unidad = detalleAlta.getUnidad();
				precioUnitario = detalleAlta.getValor();
			}else if (detalleAlta.getDetalleConcepto().equals("Cargo variable valle") ) {
				unidadPico = detalleAlta.getUnidad();
				precioUnitarioValle = detalleAlta.getValor();
			} else if (detalleAlta.getDetalleConcepto().equals("Cargo variable pico") ) {
				unidadValle = detalleAlta.getUnidad();
				precioUnitarioPico = detalleAlta.getValor();
			} else if (detalleAlta.getDetalleConcepto().equals("Cargo variable resto") ) {
				unidadResto = detalleAlta.getUnidad();
				precioUnitarioResto = detalleAlta.getValor();
			}
		}
		// de alguna manera me tiene que dar 4 items bien echos
		ItemFactura itemFactura11 = new ItemFactura(precioUnitario, cantidad, unidad, tarifa1, lecturaNueva, this);
		
		ItemFactura itemFactura12 = new ItemFactura(precioUnitarioValle, cantidadVAlle, unidadPico, tarifa1, lecturaNueva, this);
		ItemFactura itemFactura22 = new ItemFactura(precioUnitarioPico, cantidadPico, unidadValle, tarifa2, lecturaNueva, this);
		ItemFactura itemFactura32 = new ItemFactura(precioUnitarioResto, cantidadResto, unidadResto, tarifa3, lecturaNueva, this);

		this.lstItem.add(itemFactura11);
		this.lstItem.add(itemFactura12);
		this.lstItem.add(itemFactura22);
		this.lstItem.add(itemFactura32);
	}
	
	@Override
	public String toString() {
		return "Factura [idFactura=" + idFactura + ", datosCliente=" + datosCliente + ", fecha=" + fecha
				+ ", observaciones=" + observaciones + "\n Items=" + this.lstItem + "]";
	}

}
