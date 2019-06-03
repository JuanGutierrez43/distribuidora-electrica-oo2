package negocio;

import java.util.ArrayList;
import java.util.List;

import dao.TarifaDao;
import datos.AltaDemanda;
import datos.BajaDemanda;
import datos.DetalleAlta;
import datos.DetalleBaja;
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

	public List<Tarifa> traer(BajaDemanda lectura) {
		List<Tarifa> lsTarifa = TarifaDao.getInstance().traerTarifas();
		List<Tarifa> lsTarifaAux = new ArrayList<Tarifa>();;
		
		for (Tarifa t : lsTarifa) {
			if (t instanceof TarifaBaja) {
				
				for (DetalleBaja detalle : ((TarifaBaja) t).getLstDetalle()) {
					if(lectura.getConsumo() >= detalle.getDesde() && lectura.getConsumo() <= detalle.getHasta()) {
						lsTarifaAux.add(t);
					}
				}
				
			}
		}
		
		return lsTarifaAux;
	}
	
	public List<Tarifa> traer(AltaDemanda lectura) { //sin hacer
		List<Tarifa> lsTarifa = TarifaDao.getInstance().traerTarifas();
		List<Tarifa> lsTarifaAux = new ArrayList<Tarifa>();;
		
		for (Tarifa t : lsTarifa) {
			if (t instanceof TarifaAlta) {
				
//				for (DetalleAlta detalle : ((TarifaAlta) t).getLstDetalle()) {
//					if (lectura.getConsumo() >= detalle.getDesde() && lectura.getConsumo() <= detalle.getHasta()) {
//						lsTarifaAux.add(t);
//					}
//				}
				
			}
		}
		
		return lsTarifaAux;
	}
	
	public List<Tarifa> traerXConsumo(int consumo) {
		List<Tarifa> lsTarifa = TarifaDao.getInstance().traerTarifas();
		List<Tarifa> lsTarifaAux = new ArrayList<Tarifa>();;
		
		for (Tarifa t : lsTarifa) {
			if (t instanceof TarifaBaja) {
				
				for (DetalleBaja detalle : ((TarifaBaja) t).getLstDetalle()) {
					if(consumo >= detalle.getDesde() && consumo <= detalle.getHasta()) {
						lsTarifaAux.add(t);
					}
				}
				
			}
		}
		
		return lsTarifaAux;
	}
}