package negocio;

import java.util.List;

import dao.ItemFacturaDao;
import datos.Factura;
import datos.ItemFactura;
import datos.Lectura;
import datos.Tarifa;

public class ItemFacturaABM {
private static ItemFacturaABM instancia = null; // Patrón Singleton
	
	ItemFacturaDao dao=ItemFacturaDao.getInstance();

	protected ItemFacturaABM() {
	}

	public static ItemFacturaABM getInstance() {
		if (instancia == null)
			instancia = new ItemFacturaABM();
		return instancia;
	}

	public ItemFactura  traer(long idItemFactura) {
		return ItemFacturaDao.getInstance().traerItemFactura(idItemFactura);
	}

	public List<ItemFactura> traer() {
		return ItemFacturaDao.getInstance().traerItemFactura();
	}
	
//	public int agregarItemFactura(double precioUnitario, int cantidad, String unidad, Lectura lectura)throws Exception{
//		ItemFactura i=new ItemFactura(precioUnitario, cantidad, unidad, new Tarifa(), lectura, new Factura());
//		return dao.agregar(i);
//	}
	
	
	
}