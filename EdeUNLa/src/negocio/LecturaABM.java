package negocio;

import java.time.LocalDate;
import java.util.List;

import dao.LecturaDao;
import datos.AltaDemanda;
import datos.BajaDemanda;
import datos.Inspector;
import datos.Lectura;
import datos.Medidor;

public class LecturaABM {
private static LecturaABM instancia = null; // Patrón Singleton
	
	LecturaDao dao=LecturaDao.getInstance();

	protected LecturaABM() {
	}

	public static LecturaABM getInstance() {
		if (instancia == null)
			instancia = new LecturaABM();
		return instancia;
	}

	public Lectura traer(long idCliente) {
		return LecturaDao.getInstance().traerLectura(idCliente);
	}

	public List<Lectura> traer() {
		return LecturaDao.getInstance().traerLecturas();
	}
	
	public int agregarLecturaAltaDemanda(LocalDate fecha, Inspector inspector, Medidor medidor, int consumoHorasValle, int consumoHoraPico, 
			int consumoHorasResto)throws Exception{
		Lectura l=new AltaDemanda(fecha, inspector, medidor, consumoHorasValle, consumoHoraPico, consumoHorasResto);
		return dao.agregar(l);
	}
	
	public int agregarLecturaBajaDemanda(LocalDate fecha, Inspector inspector, Medidor medidor, int consumo)throws Exception{
		Lectura l=new BajaDemanda(fecha, inspector, medidor, consumo);
		return dao.agregar(l);
	}
}