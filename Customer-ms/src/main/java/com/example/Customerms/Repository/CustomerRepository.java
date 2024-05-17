package com.example.Customerms.Repository;

import com.example.Customerms.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
   @Query(value = "select * from customer where customer_user_name=:userName and customer_password=:password",nativeQuery = true)
    Customer findByUserNameNadPassword(String userName, String password);
}
