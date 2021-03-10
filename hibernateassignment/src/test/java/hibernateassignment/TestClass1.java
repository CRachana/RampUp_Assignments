package hibernateassignment;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.hcl.model.Customer;
import hibernateassignment.FeedbackTestClass;;

public class TestClass1 {

//import static org.testng.Assert.assertEquals;
	private SessionFactory factory = null;

	@BeforeClass
	public void setup() {
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
	}

	@Test
	public void saveCustomer() {
		Customer cus = new Customer(13, "rachana", "7010488765", "rachana@gmail.com", "rachana#312", "rachana@651",
				"raja street,karuppur,salem-636013");
		Customer cus1 = new Customer(14, "priya", "987670108", "priya@gmail.com", "priya@19", "priya@10",
				"veera street,alagapuram,madurai-634501");
		Transaction transaction = null;

		try (Session session = factory.openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the vehicle objects
			session.save(cus);
			// session.save(veh1);
			session.save(cus1);

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	@Test(dependsOnMethods = "saveCustomer")
	public void readCustomer() {
		Transaction transaction = null;
		try (Session session = factory.openSession()) {

			List<Customer> cust = session.createQuery("from Customer", Customer.class).list();
			cust.forEach(c -> System.out.println(c.getCustomer_name()));
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
}
