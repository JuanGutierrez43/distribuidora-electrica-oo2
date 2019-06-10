package negocio;

import java.time.LocalDate;
import java.util.List;

import dao.FacturaDao;
import datos.AltaDemanda;
import datos.BajaDemanda;
import datos.Factura;
import datos.Lectura;
import datos.Medidor;

import java.util.Collections;


public class FacturaABM {
	
	private static FacturaABM instancia = null; // Patrón Singleton

	FacturaDao dao = FacturaDao.getInstance();

	protected FacturaABM() {
	}

	public static FacturaABM getInstance() {
		if (instancia == null)
			instancia = new FacturaABM();
		return instancia;
	}

	public Factura traer(long idFactura) {
		return FacturaDao.getInstance().traerFactura(idFactura);
	}

	public List<Factura> traer() {
		return FacturaDao.getInstance().traerFactura();
	}

	public Factura generarFactura(Medidor medidor,int mes,int anio) throws Exception {
		Factura f = new Factura(medidor.getCliente().itemCliente(), LocalDate.of(anio, mes, LocalDate.now().getDayOfMonth()), "Ninguna");
		List<Lectura> lstLectura = LecturaABM.getInstance().traer(medidor, LocalDate.of(anio, mes, 10), LocalDate.of(anio, mes, 10).minusMonths(2));

		if (lstLectura.size() == 1 && Collections.max(lstLectura) instanceof BajaDemanda) { // Si es la primera lectura entonces creo otra para que no se caiga el sistema
			lstLectura.add(0,new BajaDemanda(Collections.max(lstLectura).getFecha().minusMonths(2), Collections.max(lstLectura).getInspector(), Collections.max(lstLectura).getMedidor(), 0));
		}else if (lstLectura.size() == 1 && Collections.max(lstLectura) instanceof AltaDemanda) {
			lstLectura.add(0,new AltaDemanda(Collections.max(lstLectura).getFecha().minusMonths(2), Collections.max(lstLectura).getInspector(), Collections.max(lstLectura).getMedidor(), 0, 0, 0));
		}
		if (Collections.max(lstLectura) instanceof BajaDemanda) {
			
			f.agregarItemBajaDemanda(
					(BajaDemanda) Collections.max(lstLectura), 
					(BajaDemanda) Collections.min(lstLectura),
					TarifaABM.getInstance().traerXConsumo(((BajaDemanda) Collections.max(lstLectura)).calcularConsumo((BajaDemanda) Collections.min(lstLectura))).get(1)
			);
			
		} else if (Collections.max(lstLectura) instanceof AltaDemanda) {
			
			f.agregarItemAltaDemanda(
					(AltaDemanda) Collections.max(lstLectura), 
					(AltaDemanda) Collections.min(lstLectura),
					TarifaABM.getInstance().traerXConsumoAltaDemanda(((AltaDemanda) Collections.max(lstLectura)).calcularConsumoHorasValle((AltaDemanda) Collections.min(lstLectura)), medidor.getPotencia()),
					TarifaABM.getInstance().traerXConsumoAltaDemanda(((AltaDemanda) Collections.max(lstLectura)).calcularConsumoHorasPico((AltaDemanda) Collections.min(lstLectura)), medidor.getPotencia()),
					TarifaABM.getInstance().traerXConsumoAltaDemanda(((AltaDemanda) Collections.max(lstLectura)).calcularConsumoHorasResto((AltaDemanda) Collections.min(lstLectura)), medidor.getPotencia())
			);
			
		}
		return f;
	}
	
	public int alta(Factura factura) {
		return dao.agregar(factura);
	}

	
//	public Pago pagarFactura(Factura factura,LocalDate fPago,double interes) {
//		
//	}
	
//	public Factura traer(int mes, int anio) {
//		return FacturaDao.getInstance().traerFactura(mes, anio);
//	}
	
}
