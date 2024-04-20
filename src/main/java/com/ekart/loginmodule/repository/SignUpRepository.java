package com.ekart.loginmodule.repository;

import com.ekart.loginmodule.eo.SignUp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SignUpRepository extends JpaRepository<SignUp,Integer> {

}
