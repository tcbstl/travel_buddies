package com.tommybalestreri.hellospring.data;

import com.tommybalestreri.hellospring.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

//    User findById(Integer id);
    User findByUsername(String username);

}
