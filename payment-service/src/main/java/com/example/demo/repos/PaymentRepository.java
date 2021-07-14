package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Payment;
import java.util.*;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
   
	public List<Payment> findByDescription(String qryString);
    public List<Payment> findByAmountGreaterThan(double  qryAmount);
 
    @Query(value="update payments set amount =:newAmount where txnId=:id",nativeQuery = true)
    @Modifying
    @Transactional
    public int updateAmount(@Param("newAmount") double amtToUpdate, @Param("id") int id);
}
