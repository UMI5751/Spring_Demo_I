package com.bowen.zhang.spring_demo_i.data.repository;

import com.bowen.zhang.spring_demo_i.data.entity.Guest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends CrudRepository<Guest, Long> {
}
