package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Lectura;

public class LecturaDao {
	private static LecturaDao instanciaLecturaDao;
	protected static Session session;
	protected Transaction tx;
	
	public static LecturaDao getInstance() {
		if (instanciaLecturaDao == null){
			instanciaLecturaDao = new LecturaDao();
		}
		return instanciaLecturaDao;
	}
	
	private void iniciaOperacion() throws HibernateException{
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	private void manejaExcepcion(HibernateException he) throws HibernateException{
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}
	
	public int agregar(Lectura objeto){
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
	
	public void actualizar(Lectura objeto) throws HibernateException{
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
	
	public void eliminar(Lectura objeto) throws HibernateException{
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
	
	public Lectura traerLectura(long idLectura) throws HibernateException{
		Lectura objeto=null;
		try{
			iniciaOperacion();
			objeto=(Lectura)session.get(Lectura.class, idLectura);
		}finally{
			session.close();
		}
		return objeto;
	}
	
	@SuppressWarnings("unchecked")
	public List<Lectura> traerLecturas() throws HibernateException{
		List<Lectura> lista=null;
		try{
			iniciaOperacion();
			lista=session.createQuery("from Lectura l order by m.idLectura asc").list();
		}finally{
			session.close();
		}
		return lista;
	}
}