package com.tommybalestreri.hellospring.data;

import com.tommybalestreri.hellospring.models.Destination;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DestinationRepository extends CrudRepository<Destination, Integer> {
}
