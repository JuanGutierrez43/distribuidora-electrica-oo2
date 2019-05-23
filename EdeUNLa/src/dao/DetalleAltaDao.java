package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.DetalleAlta;

public class DetalleAltaDao {
	private static DetalleAltaDao instanciaDetalleAltaDao;
	protected static Session session;
	protected Transaction tx;
	
	public static DetalleAltaDao getInstance() {
		if (instanciaDetalleAltaDao == null){
			instanciaDetalleAltaDao= new DetalleAltaDao();
		}
		return instanciaDetalleAltaDao;
	}
	
	private void iniciaOperacion() throws HibernateException{
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	private void manejaExcepcion(HibernateException he) throws HibernateException{
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}
	
	public int agregar(DetalleAlta objeto){
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
	
	public void actualizar(DetalleAlta objeto) throws HibernateException{
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
	
	public void eliminar(DetalleAlta objeto) throws HibernateException{
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
	
	public DetalleAlta traerDetalleAlta(long idDetalleAlta) throws HibernateException{
		DetalleAlta objeto=null;
		try{
			iniciaOperacion();
			objeto=(DetalleAlta)session.get(DetalleAlta.class, idDetalleAlta);
		}finally{
			session.close();
		}
		return objeto;
	}
	
	@SuppressWarnings("unchecked")
	public List<DetalleAlta> traerDetalleAltas() throws HibernateException{
		List<DetalleAlta> lista=null;
		try{
			iniciaOperacion();
			lista=session.createQuery("from DetalleAlta d order by d.idDetalleAlta asc").list();
		}finally{
			session.close();
		}
		return lista;
	}
}