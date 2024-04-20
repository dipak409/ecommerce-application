package com.ekart.loginmodule.repository;

import com.ekart.loginmodule.eo.Login;
import com.ekart.loginmodule.eo.SignUp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LoginRepository extends JpaRepository<Login,Integer> {
    public Login findByuserName(String userName);
    public Login findByuserNameAndPassword(String userName,String password);
}
