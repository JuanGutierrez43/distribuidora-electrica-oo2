package negocio;

import java.time.LocalDate;
import java.util.List;

import dao.FacturaDao;
import datos.Factura;

public class FacturaABM {
	
	Factura f = new Factura();
	
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

	public int agregar(String datosCliente, LocalDate fecha, String observaciones) throws Exception {
		Factura f = new Factura(datosCliente, fecha, observaciones);
		System.out.println(f);
		return dao.agregar(f);
	}
	
	
}
