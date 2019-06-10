package dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Factura;
import datos.ItemFactura;

public class FacturaDao {
	private static FacturaDao instanciaFacturaDao;
	protected static Session session;
	protected Transaction tx;
	
	public static FacturaDao getInstance() {
		if (instanciaFacturaDao == null){
			instanciaFacturaDao = new FacturaDao();
		}
		return instanciaFacturaDao;
	}
	
	private void iniciaOperacion() throws HibernateException{
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	private void manejaExcepcion(HibernateException he) throws HibernateException{
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}
	
	public int agregar(Factura objeto){
		int id=0;
		try{
			iniciaOperacion();
			id=Integer.parseInt(session.save(objeto).toString());
			tx.commit();
		}catch(HibernateException he){
			manejaExcepcion(he);
			throw he;
		}finally{
			session.close();
		}
		return id;
	}
	
	public void actualizar(Factura objeto) throws HibernateException{
		try{
			iniciaOperacion();
			session.update(objeto);
			tx.commit();
		}catch(HibernateException he){
			manejaExcepcion(he);
			throw he;
		}finally{
			session.close();
		}
	}
	
	public void eliminar(Factura objeto) throws HibernateException{
		try{
			iniciaOperacion();
			session.delete(objeto);
			tx.commit();
		}catch(HibernateException he){
			manejaExcepcion(he);
			throw he;
		}finally{
			session.close();
		}
	}
	
	public Factura traerFactura(long idFactura) throws HibernateException{
		Factura objeto=null;
		try{
			iniciaOperacion();
			objeto=(Factura)session.get(Factura.class, idFactura);
			Hibernate.initialize(objeto.getLstItem());
			Set<ItemFactura> lstItem = objeto.getLstItem();
			for (ItemFactura itemFactura : lstItem) {
				Hibernate.initialize(itemFactura.getLectura());
				Hibernate.initialize(itemFactura.getLectura().getInspector());
				Hibernate.initialize(itemFactura.getLectura().getMedidor());
			}
		}finally{
			session.close();
		}
		return objeto;
	}
	
	@SuppressWarnings("unchecked")
	public List<Factura> traerFactura() throws HibernateException{
		List<Factura> lista=null;
		try{
			iniciaOperacion();
			lista=session.createQuery("from Factura f order by f.idFactura asc").list();
			for (Factura factura : lista) {
				Hibernate.initialize(factura.getLstItem());
				Set<ItemFactura> lstItem = factura.getLstItem();
				for (ItemFactura itemFactura : lstItem) {
					Hibernate.initialize(itemFactura.getLectura());
					Hibernate.initialize(itemFactura.getLectura().getInspector());
					Hibernate.initialize(itemFactura.getLectura().getMedidor());
				}
			}
		}finally{
			session.close();
		}
		return lista;
	}


//	public Factura traerFactura(int mes, int anio) {
//		Factura objeto=null;
//		try{
//			iniciaOperacion();
//			objeto=(Factura)session.get(Factura.class, idFactura);
//			
//			
//		}finally{
//			session.close();
//		}
//		return objeto;
//	}
}
