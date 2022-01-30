package com.bowen.zhang.spring_demo_i.data.repository;

import com.bowen.zhang.spring_demo_i.data.entity.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long> { //identify table and primary key



}
