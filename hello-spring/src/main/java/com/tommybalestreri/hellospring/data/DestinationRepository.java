package com.tommybalestreri.hellospring.data;

import com.tommybalestreri.hellospring.models.Destination;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface DestinationRepository extends CrudRepository<Destination, Integer> {
}
