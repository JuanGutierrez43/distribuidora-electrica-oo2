package negocio;

import java.util.List;

import dao.DetalleAltaDao;
import datos.DetalleAlta;
import datos.TarifaAlta;

public class DetalleAltaABM {
	private static DetalleAltaABM instancia = null; // Patrón Singleton
	
	DetalleAltaDao dao=DetalleAltaDao.getInstance();

	protected DetalleAltaABM() {
	}

	public static DetalleAltaABM getInstance() {
		if (instancia == null)
			instancia = new DetalleAltaABM();
		return instancia;
	}

	public DetalleAlta traer(long idDetalleAlta) {
		return DetalleAltaDao.getInstance().traerDetalleAlta(idDetalleAlta);
	}

	public List<DetalleAlta> traer() {
		return DetalleAltaDao.getInstance().traerDetalleAltas();
	}
	
	public int agregarDetalleAlta(TarifaAlta tarifaAlta, String detalleConcepto, String unidad, boolean superarLimite, double valor)throws Exception{
		DetalleAlta d=new DetalleAlta(tarifaAlta, detalleConcepto, unidad, superarLimite, valor);
		return dao.agregar(d);
	}
}