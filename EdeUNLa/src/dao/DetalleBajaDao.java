package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.DetalleBaja;

public class DetalleBajaDao {
	private static DetalleBajaDao instanciaDetalleBajaDao;
	protected static Session session;
	protected Transaction tx;
	
	public static DetalleBajaDao getInstance() {
		if (instanciaDetalleBajaDao == null){
			instanciaDetalleBajaDao = new DetalleBajaDao();
		}
		return instanciaDetalleBajaDao;
	}
	
	private void iniciaOperacion() throws HibernateException{
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	private void manejaExcepcion(HibernateException he) throws HibernateException{
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}
	
	public int agregar(DetalleBaja objeto){
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
	
	public void actualizar(DetalleBaja objeto) throws HibernateException{
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
	
	public void eliminar(DetalleBaja objeto) throws HibernateException{
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
	
	public DetalleBaja traerDetalleBaja(long idDetalleBaja) throws HibernateException{
		DetalleBaja objeto=null;
		try{
			iniciaOperacion();
			objeto=(DetalleBaja)session.get(DetalleBaja.class, idDetalleBaja);
		}finally{
			session.close();
		}
		return objeto;
	}
	
	@SuppressWarnings("unchecked")
	public List<DetalleBaja> traerDetalleBajas() throws HibernateException{
		List<DetalleBaja> lista=null;
		try{
			iniciaOperacion();
			lista=session.createQuery("from DetalleBaja d order by d.idDetalleBaja asc").list();
		}finally{
			session.close();
		}
		return lista;
	}
}