package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Medidor;

public class MedidorDao {
	private static MedidorDao instanciaClienteDao;
	protected static Session session;
	protected Transaction tx;
	
	public static MedidorDao getInstance() {
		if (instanciaClienteDao == null){
			instanciaClienteDao = new MedidorDao();
		}
		return instanciaClienteDao ;
	}
	
	private void iniciaOperacion() throws HibernateException{
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	private void manejaExcepcion(HibernateException he) throws HibernateException{
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}
	
	public int agregar(Medidor objeto){
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
	
	public void actualizar(Medidor objeto) throws HibernateException{
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
	
	public void eliminar(Medidor objeto) throws HibernateException{
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
	
	public Medidor traerMedidor(long idMedidor) throws HibernateException{
		Medidor objeto=null;
		try{
			iniciaOperacion();
			objeto=(Medidor)session.get(Medidor.class, idMedidor);
			Hibernate.initialize(objeto.getCliente());
			Hibernate.initialize(objeto.getZona());
			
		}finally{
			session.close();
		}
		return objeto;
	}
	
	@SuppressWarnings("unchecked")
	public List<Medidor> traerMedidores() throws HibernateException{
		List<Medidor> lista=null;
		try{
			iniciaOperacion();
			lista=session.createQuery("from Medidor m order by m.idMedidor asc").list();
		}finally{
			session.close();
		}
		return lista;
	}
}