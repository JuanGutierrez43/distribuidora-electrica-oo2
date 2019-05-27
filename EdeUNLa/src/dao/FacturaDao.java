package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Factura;

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
		}finally{
			session.close();
		}
		return lista;
	}
}
