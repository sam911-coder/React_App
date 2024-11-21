package in.sam.service;

import in.sam.dao.CustomerDao;
import in.sam.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;


@Service
public class CustomerService {

	@Autowired
	private CustomerDao dao;

	public List<Customer> loadAllCustomers() throws InterruptedException {
		long start = System.currentTimeMillis();
		List<Customer> customers = dao.getCustomers();
		long end = System.currentTimeMillis();
		System.out.println("Time :: " + (end - start));
		return customers;
	}

	public Flux<Customer> loadAllCustomersStream() throws InterruptedException {
		long start = System.currentTimeMillis();
		Flux<Customer> customers = dao.getCustomersFlux();
		long end = System.currentTimeMillis();
		System.out.println("Time :: " + (end - start));
		return customers;
	}
}
