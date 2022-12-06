package PWD.MNGR.COMMANDS;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import PWD.MNGR.MODELS.Password;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PasswordPersistenceTest {

	SessionFactory factory;

	@BeforeAll
	public void setup() {

		Configuration configuration = new Configuration().addAnnotatedClass(Password.class)
				.setProperty("hibernate.connection.driver_class", "org.sqlite.JDBC")
				.setProperty("hibernate.connection.url", "jdbc:sqlite:test.db")
				.setProperty("hibernate.dialect", "org.hibernate.dialect.SQLiteDialect")
				.setProperty("hibernate.show_sql", "true").setProperty("hibernate.hdm2ddl.auto", "create-drop");
		configuration.configure();

		factory = new Configuration().configure().buildSessionFactory();
	}

	@Test
	public void savePassword() {
		Password message = new Password("test", "xyz");
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(message);
		tx.commit();
		session.close();
	}

	@Test()
	public void readMessage() {
		Session session = factory.openSession();
		@SuppressWarnings("unchecked")
		List<Password> list = (List<Password>) session.createQuery("from Password").list();
		if (list.size() > 1) {
//        	asser
//            Assert.fail("Message configuration in error; table should contain only one."
//                    +" Set ddl to create-drop.");
		}
		if (list.size() == 0) {
//            Assert.fail("Read of initial message failed; check saveMessage() for errors."
//                    +" How did this test run?");
		}
		for (Password m : list) {
			System.out.println(m);
		}
		session.close();
	}

}
