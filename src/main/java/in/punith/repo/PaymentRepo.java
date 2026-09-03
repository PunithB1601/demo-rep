package in.punith.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.punith.entity.Payment;
@Repository
public interface PaymentRepo extends JpaRepository<Payment, Integer>{

}
