//package PWD.MNGR.COMMANDS;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//import java.util.List;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.hibernate.cfg.Configuration;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestInstance;
//
//import PWD.MNGR.MODELS.Password;
//
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//public class PasswordPersistenceTest {
//
//	SessionFactory factory;
//
//	@BeforeAll
//	public void setup() {
//
//		Configuration configuration = new Configuration().addAnnotatedClass(Password.class);
//		configuration.configure();
//
//		factory = new Configuration().configure().buildSessionFactory();
//	}
//
//	@Test
//	public void savePassword() {
//		Password password = new Password("test", "xyz");
//		Session session = factory.openSession();
//		Transaction tx = session.beginTransaction();
//		session.persist(password);
//	
//	    List<Password> list = (List<Password>) session.createQuery("from Password").list();
//		
//		assertEquals(list.size() > 1, true);		
//	
//		for (Password m : list) {
//			System.out.println(m);
//		}
//		
//		tx.commit();
//		session.close();
//	}
//
//	//@Test()
//	public void readMessage() {
//		Session session = factory.openSession();
//		@SuppressWarnings("unchecked")
//		List<Password> list = (List<Password>) session.createQuery("from Password").list();
//		
//		assertEquals(list.size() > 1, true);
//		
//	
//		for (Password m : list) {
//			System.out.println(m);
//		}
//		session.close();
//	}
//
//}
