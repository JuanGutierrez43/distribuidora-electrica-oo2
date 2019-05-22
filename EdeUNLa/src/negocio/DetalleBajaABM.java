package negocio;

import java.util.List;

import dao.DetalleBajaDao;
import datos.DetalleBaja;
import datos.TarifaBaja;

public class DetalleBajaABM {
private static DetalleBajaABM instancia = null; // Patrón Singleton
	
	DetalleBajaDao dao=DetalleBajaDao.getInstance();

	protected DetalleBajaABM() {
	}

	public static DetalleBajaABM getInstance() {
		if (instancia == null)
			instancia = new DetalleBajaABM();
		return instancia;
	}

	public DetalleBaja traer(long idDetalleBaja) {
		return DetalleBajaDao.getInstance().traerDetalleBaja(idDetalleBaja);
	}

	public List<DetalleBaja> traer() {
		return DetalleBajaDao.getInstance().traerDetalleBajas();
	}
	
	public int agregarDetalleBaja(TarifaBaja tarifaBaja, String detalleConcepto, String unidad, int desde, int hasta, double valor)throws Exception{
		DetalleBaja d=new DetalleBaja(tarifaBaja, detalleConcepto, unidad, desde, hasta, valor);
		return dao.agregar(d);
	}
}