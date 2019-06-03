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

	public Factura generarFactura(Medidor medidor,int mes,int anio) {
		Factura f = new Factura(medidor.getCliente().itemCliente(), LocalDate.of(anio, mes, LocalDate.now().getDayOfMonth()), "Ninguna");
		Lectura lecturaNueva = LecturaABM.getInstance().traer(medidor, mes, anio);
		
		LocalDate date = LocalDate.of(anio, mes, 10);
		date = date.minusMonths(2);
		Lectura lecturaAnterior = LecturaABM.getInstance().traer(medidor, date.getMonthValue(), date.getYear());

		if (lecturaNueva instanceof BajaDemanda) {
			f.setLstItemBajaDemanda(lecturaNueva, (BajaDemanda)lecturaAnterior, TarifaABM.getInstance().traerXConsumo(((BajaDemanda)lecturaNueva).getConsumo((BajaDemanda)lecturaAnterior)).get(1));
		}else if (lecturaNueva instanceof AltaDemanda) {
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
