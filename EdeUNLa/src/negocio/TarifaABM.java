package negocio;

import java.util.List;

import dao.TarifaDao;
import datos.Tarifa;
import datos.TarifaAlta;
import datos.TarifaBaja;

public class TarifaABM {
private static TarifaABM instancia = null; // Patrón Singleton
	
	TarifaDao dao=TarifaDao.getInstance();

	protected TarifaABM() {
	}

	public static TarifaABM getInstance() {
		if (instancia == null)
			instancia = new TarifaABM();
		return instancia;
	}

	public Tarifa traer(long idTarifa) {
		return TarifaDao.getInstance().traerTarifa(idTarifa);
	}

	public List<Tarifa> traer() {
		return TarifaDao.getInstance().traerTarifas();
	}
	
	public int agregarTarifaBaja(String servicio)throws Exception{
		Tarifa t=new TarifaBaja(servicio);
		return dao.agregar(t);
	}
	
	public int agregarTarifaAlta(String servicio, String tensionContratada, int limite)throws Exception{
		Tarifa t=new TarifaAlta(servicio, tensionContratada, limite);
		return dao.agregar(t);
	}
}