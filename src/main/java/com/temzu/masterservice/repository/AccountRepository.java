package com.temzu.masterservice.repository;

import com.temzu.masterservice.model.entity.Account;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {

  Optional<Account> findByPhone(String phone);

  boolean existsByPhoneAndPassword(String phone, String password);

  boolean existsByPhone(String phone);
}
