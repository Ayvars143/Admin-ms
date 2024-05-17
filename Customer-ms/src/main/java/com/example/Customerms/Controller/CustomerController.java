package com.example.Customerms.Controller;

import com.example.Customerms.Entity.Customer;
import com.example.Customerms.Pojo.ResponseEntity;
import com.example.Customerms.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;

@RestController
@RequestMapping("customer-mapper")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody Customer customer){
        ResponseEntity response=new ResponseEntity();
        Customer cust=customerService.signup(customer);
        if(cust != null && cust.getCustomer_id() != null){
          response.setData(cust);
          response.setMessage("Customer signed up successfully...!!!");
          response.setSuccess(true);
        }else{
            response.setSuccess(false);
            response.setData(null);
            response.setMessage("Signup failed");
        }
          return response;
    }

    @PostMapping("/update/Customer/details/{id}")
    public ResponseEntity update(@PathVariable("id") Integer customerID,
                                 @RequestBody Customer customer) {
        ResponseEntity response = new ResponseEntity();
        Customer cust = customerService.updateCustomerDetails(customerID, customer);
        if (cust != null && cust.getCustomer_id() != null) {
            response.setData(cust);
            response.setMessage("Customer details updated successfully...!!!");
            response.setSuccess(true);
        } else {
            response.setSuccess(false);
            response.setData(cust);
            response.setMessage("update failed");
        }
        return response;
    }

    @PostMapping("/delete/customer/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer customerID,
            @RequestBody Customer customer){
        ResponseEntity response= new ResponseEntity();
        Customer cust=customerService.deleteCustomer(customerID,customer);
        if(cust !=null && !cust.getRecordDeleted()){
            response.setData(cust);
            response.setMessage("Customer deleted successfully...!!!");
            response.setSuccess(true);
        }else{
            response.setSuccess(false);
            response.setData(cust);
            response.setMessage("not deleted");
        }
        return response;
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody Customer customer){
        ResponseEntity response=new ResponseEntity();
        Customer cust=customerService.login(customer);
        if(cust !=null && !cust.getRecordDeleted()){
            response.setData(cust);
            response.setMessage("Customer logged in successfully...!!!");
            response.setSuccess(true);
        }else{
            response.setSuccess(false);
            response.setData(cust);
            response.setMessage("Invalid username or password");
        }
        return response;
    }

}
