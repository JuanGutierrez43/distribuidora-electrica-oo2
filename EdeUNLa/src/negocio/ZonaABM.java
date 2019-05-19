package negocio;

import java.util.List;

import dao.ZonaDao;
import datos.Zona;

public class ZonaABM {
private static ZonaABM instancia = null; // Patrón Singleton
	
	ZonaDao dao=ZonaDao.getInstance();

	protected ZonaABM() {
	}

	public static ZonaABM getInstance() {
		if (instancia == null)
			instancia = new ZonaABM();
		return instancia;
	}

	public Zona traer(long idZona) {
		return ZonaDao.getInstance().traerZona(idZona);
	}

	public List<Zona> traer() {
		return ZonaDao.getInstance().traerZonas();
	}
	
	public int agregarZona(String descripcion)throws Exception{
		Zona z=new Zona(descripcion);
		return dao.agregar(z);
	}
}