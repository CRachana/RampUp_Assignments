
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
import com.hcl.model.CustomerFeedback;

public class FeedbackTestClass {

//import static org.testng.Assert.assertEquals;
	private SessionFactory factory = null;

	@BeforeClass
	public void setup() {
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
	}

	@Test
	public void saveCustomerFeedback() {
		CustomerFeedback cusfed = new CustomerFeedback(1, "damageinproducts", "hardware",
				"wants to exchange the product", "buy two days before");
		CustomerFeedback cusfed1 = new CustomerFeedback(2, "not working", "software", "wants to exchange the product",
				"buy two days before");

		Transaction transaction = null;

		try (Session session = factory.openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the vehicle objects
			session.save(cusfed);
			// session.save(veh1);
			session.save(cusfed1);

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	@Test(dependsOnMethods = "saveCustomerFeedback")
	public void readCustomerFeedback() {
		Transaction transaction = null;
		try (Session session = factory.openSession()) {

			List<CustomerFeedback> custfed = session.createQuery("from CustomerFeedback", CustomerFeedback.class)
					.list();
			custfed.forEach(c -> System.out.println(c.getCustomer_feedback_title()));
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
}
