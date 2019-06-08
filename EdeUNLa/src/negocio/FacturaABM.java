package negocio;

import java.time.LocalDate;
import java.util.List;

import dao.FacturaDao;
import datos.AltaDemanda;
import datos.BajaDemanda;
import datos.Factura;
import datos.Lectura;
import datos.Medidor;

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
		
		if (lstLectura.size() == 1) { // Si es la primera lectura entonces creo otra para que no se caiga el código  
			lstLectura.add(0,new BajaDemanda(lstLectura.get(0).getFecha(), lstLectura.get(0).getInspector(),lstLectura.get(0).getMedidor(), 0));
		}
		
		if (lstLectura.get(1) instanceof BajaDemanda) {
			f.setLstItemBajaDemanda(
					lstLectura.get(1), 
					(BajaDemanda) lstLectura.get(0),
					TarifaABM.getInstance().traerXConsumo(((BajaDemanda) lstLectura.get(1)).getConsumo((BajaDemanda) lstLectura.get(0))).get(1)
			);
		} else if (lstLectura.get(1) instanceof AltaDemanda) {
			// próximo hacer
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
