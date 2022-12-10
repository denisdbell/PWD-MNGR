package PWD.MNGR.DATABASE;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import PWD.MNGR.MODELS.Password;

public class DataBase {
	
	Configuration configuration;
	SessionFactory factory;
	
	public void setUpConnection() {
		Configuration configuration = new Configuration().addAnnotatedClass(Password.class).setProperty("connection.url", "jdbc:sqlite:/home/osboxes/Documents/PWD-MNGR/lib/src/main/resources/pwdmngr.db");
		configuration.configure();

		factory = new Configuration().configure().buildSessionFactory();
	}
	
	public void addPassword(String name, String value) {
		setUpConnection();

		Password password = new Password(name, value);
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(password);
		tx.commit();
		session.close();
	}

	
	public void listPasswords() {
		setUpConnection();

		Session session = factory.openSession();
		@SuppressWarnings("unchecked")
		List<Password> list = (List<Password>) session.createQuery("from Password").list();
			
		if(list.isEmpty()) {
			System.out.println("No passwords");
		}
		
		for (Password p : list) {
			System.out.println("<pid>: " + p.getId() + " <Name:>               " + p.getName() + "               <Password:>               " + p.getValue());
		}
		
		session.close();
	}
	
	public void deletePassword(Long id) {
		setUpConnection();

		Password password = new Password();
		password.setId(id);
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		Query query = session.createQuery("delete Password where id = :ID");
		query.setParameter("ID", id);
	
		int result = query.executeUpdate();
		
		tx.commit();
		session.close();
	}
	public void updatePassword(Long id, String name, String value) {
		setUpConnection();

		Password password = new Password();
		password.setId(id);
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		Query query = session.createQuery("Update Password p set p.value = :value, p.name = :name where id = :ID");
		query.setParameter("ID", id);
		query.setParameter("name", name);
		query.setParameter("value", value);
		
		int result = query.executeUpdate();
		
		tx.commit();
		session.close();
	}

	

}
