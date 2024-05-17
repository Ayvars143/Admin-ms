package com.example.Customerms.Service;

import com.example.Customerms.Entity.Customer;
import com.example.Customerms.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepo;

    @Override
    public Customer signup(Customer customer) {
        Customer cust=new Customer();
        if(customer != null & customer.getCustomerUserName() != null && customer.getCustomerPassword() != null){
            cust=customerRepo.save(customer);
        }
        return cust;
    }

    @Override
    public Customer updateCustomerDetails(Integer customerID, Customer customer) {
       Customer cust=new Customer();
        if(customerID != null && customer != null){
           Optional<Customer> existingCustomer=customerRepo.findById(customerID);
           if(existingCustomer.isPresent() && !existingCustomer.get().getRecordDeleted()){
               cust=existingCustomer.get();
               cust.setCustomer_email(customer.getCustomer_email());
               cust.setCustomer_mobile(customer.getCustomer_mobile());
               cust.setCustomerPassword(customer.getCustomerPassword());
               cust.setCustomerAddress(customer.getCustomerAddress());
               cust.setCustomerUserName(customer.getCustomerUserName());
               cust.setRecordDeleted(customer.getRecordDeleted());

               cust=customerRepo.save(cust);
           }
        }
        return cust;
    }

    @Override
    public Customer deleteCustomer(Integer customerID, Customer customer) {
        Customer cust=new Customer();
        if(customerID != null && customer != null){
            Optional<Customer> existingCustomer=customerRepo.findById(customerID);
            if(existingCustomer.isPresent() && !existingCustomer.get().getRecordDeleted()){
                cust=existingCustomer.get();
                cust.setRecordDeleted(true);
                cust=customerRepo.save(cust);
            }
        }
        return cust;
    }

    @Override
    public Customer login(Customer customer) {
        Customer cust=new Customer();
        if(customer.getCustomerUserName() != null && customer.getCustomerPassword() !=null){
            cust=customerRepo.findByUserNameNadPassword(customer.getCustomerUserName(),customer.getCustomerPassword());
            if(cust != null && customer.getCustomerPassword().equalsIgnoreCase(cust.getCustomerPassword()) && customer.getCustomerUserName().equalsIgnoreCase(cust.getCustomerUserName()) && !cust.getRecordDeleted()){
                return cust;
            }else{
                cust=null;
            }
        }
        return cust;
    }
}
