package com.tommybalestreri.hellospring.data;

import com.tommybalestreri.hellospring.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);

}
