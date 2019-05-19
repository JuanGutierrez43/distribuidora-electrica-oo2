package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Inspector;

public class InspectorDao {
	private static InspectorDao instanciaInspectorDao;
	protected static Session session;
	protected Transaction tx;
	
	public static InspectorDao getInstance() {
		if (instanciaInspectorDao == null){
			instanciaInspectorDao = new InspectorDao();
		}
		return instanciaInspectorDao;
	}
	
	private void iniciaOperacion() throws HibernateException{
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	private void manejaExcepcion(HibernateException he) throws HibernateException{
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}
	
	public int agregar(Inspector objeto){
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
	
	public void actualizar(Inspector objeto) throws HibernateException{
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
	
	public void eliminar(Inspector objeto) throws HibernateException{
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
	
	public Inspector traerInspector(long idInspector) throws HibernateException{
		Inspector objeto=null;
		try{
			iniciaOperacion();
			objeto=(Inspector)session.get(Inspector.class, idInspector);
		}finally{
			session.close();
		}
		return objeto;
	}
	
	@SuppressWarnings("unchecked")
	public List<Inspector> traerInspectores() throws HibernateException{
		List<Inspector> lista=null;
		try{
			iniciaOperacion();
			lista=session.createQuery("from Inspector i order by i.idInspector asc").list();
		}finally{
			session.close();
		}
		return lista;
	}
}