package negocio;

import java.util.List;

import dao.ClienteDao;
import datos.Cliente;
import datos.PersonaFisica;
import datos.PersonaJuridica;

public class ClienteABM {
	private static ClienteABM instancia = null; // Patrón Singleton
	
	ClienteDao dao=ClienteDao.getInstance();

	protected ClienteABM() {
	}

	public static ClienteABM getInstance() {
		if (instancia == null)
			instancia = new ClienteABM();
		return instancia;
	}

	public Cliente traer(long idCliente) {
		return ClienteDao.getInstance().traerCliente(idCliente);
	}

	public List<Cliente> traer() {
		return ClienteDao.getInstance().traerClientes();
	}
	
	public int agregarPersonaFisica(String direccion, String email, long telefonoFijo, long telefonoMovil, long dni, 
			String nombre, String apellido)throws Exception{
		Cliente c=new PersonaFisica(direccion, email, telefonoFijo, telefonoMovil, dni, nombre, apellido);
		System.out.println(c);
		return dao.agregar(c);
	}
	
	public int agregarPersonaJuridica(String direccion, String email, long telefonoFijo, long telefonoMovil, String cuit, 
			String razonSocial)throws Exception{
		Cliente c=new PersonaJuridica(direccion, email, telefonoFijo, telefonoMovil, cuit, razonSocial);
		return dao.agregar(c);
	}
}