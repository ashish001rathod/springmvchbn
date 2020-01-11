package mvchbn;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDao {
	@Autowired
	SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	public void addCustomer(Customer cust){
		Session session =sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(cust);
		tx.commit();
		session.close();
	}
	public List<Customer> getCustomers(){
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<Customer> customerList = session.createQuery("from Customer").list();
		return customerList;
	}
	public void updateCustomer(Customer cust){
		Session session =sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(cust);
		tx.commit();
		session.close();
	}
	public Customer getCustomer(int code) {
		Session session =sessionFactory.openSession();
		Customer cust = (Customer) session.get(Customer.class, code);
		return cust;
	}
	public void deleteCustomer(Customer cust){
		Session session=sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(cust);
		tx.commit();
		session.close();
	}
}