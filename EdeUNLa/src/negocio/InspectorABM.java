package negocio;

import java.util.List;

import dao.InspectorDao;
import datos.Inspector;

public class InspectorABM {
private static InspectorABM instancia = null; // Patrón Singleton
	
	InspectorDao dao=InspectorDao.getInstance();

	protected InspectorABM() {
	}

	public static InspectorABM getInstance() {
		if (instancia == null)
			instancia = new InspectorABM();
		return instancia;
	}

	public Inspector traer(long idInspector) {
		return InspectorDao.getInstance().traerInspector(idInspector);
	}

	public List<Inspector> traer() {
		return InspectorDao.getInstance().traerInspectores();
	}
	
	public int agregarInspector(String nombre, String apellido, long dni, long telefonoMovil)throws Exception{
		Inspector i=new Inspector(nombre, apellido, dni, telefonoMovil);
		return dao.agregar(i);
	}
}