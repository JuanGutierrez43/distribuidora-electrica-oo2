package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Cliente;
import datos.Zona;

public class ZonaDao {
	private static ZonaDao instanciaZonaDao;
	protected static Session session;
	protected Transaction tx;
	
	public static ZonaDao getInstance() {
		if (instanciaZonaDao == null){
			instanciaZonaDao = new ZonaDao();
		}
		return instanciaZonaDao ;
	}
	
	private void iniciaOperacion() throws HibernateException{
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	private void manejaExcepcion(HibernateException he) throws HibernateException{
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}
	
	public int agregar(Zona objeto){
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
	
	public void actualizar(Zona objeto) throws HibernateException{
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
	
	public void eliminar(Zona objeto) throws HibernateException{
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
	
	public Zona traerZona(long idZona) throws HibernateException{
		Zona objeto=null;
		try{
			iniciaOperacion();
			objeto=(Zona)session.get(Zona.class, idZona);
		}finally{
			session.close();
		}
		return objeto;
	}
	
	@SuppressWarnings("unchecked")
	public List<Zona> traerZonas() throws HibernateException{
		List<Zona> lista=null;
		try{
			iniciaOperacion();
			lista=session.createQuery("from Zona z order by z.descripcion asc").list();
		}finally{
			session.close();
		}
		return lista;
	}
}