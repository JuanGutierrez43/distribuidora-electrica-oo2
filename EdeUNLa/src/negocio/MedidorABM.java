package negocio;

import java.util.List;

import dao.MedidorDao;
import datos.Cliente;
import datos.Medidor;
import datos.Zona;


public class MedidorABM {
private static MedidorABM instancia = null; // Patrón Singleton
	
	MedidorDao dao=MedidorDao.getInstance();

	protected MedidorABM() {
	}

	public static MedidorABM getInstance() {
		if (instancia == null)
			instancia = new MedidorABM();
		return instancia;
	}

	public Medidor traer(long idMedidor) {
		return MedidorDao.getInstance().traerMedidor(idMedidor);
	}

	public List<Medidor> traer() {
		return MedidorDao.getInstance().traerMedidores();
	}
	
	public int agregarMedidor(Cliente cliente, int nroSerie, String domicilioMedidor, Zona zona)throws Exception{
		Medidor m=new Medidor(cliente, nroSerie, domicilioMedidor, zona);
		return dao.agregar(m);
	}
	
	public int agregarMedidor(Cliente cliente, int nroSerie, String domicilioMedidor, String potencia, Zona zona)throws Exception{
		Medidor m=new Medidor(cliente, nroSerie, domicilioMedidor, potencia, zona);
		return dao.agregar(m);
	}
}