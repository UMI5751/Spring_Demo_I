package com.bowen.zhang.spring_demo_i;

import com.bowen.zhang.spring_demo_i.data.entity.Room;
import com.bowen.zhang.spring_demo_i.data.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SpringDemoIApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDemoIApplication.class, args);
    }

    @RestController
    @RequestMapping("/rooms")
    public class RoomController {
        @Autowired
        private RoomRepository roomRepository;

        @RequestMapping
        public Iterable<Room> getRooms() {
            return roomRepository.findAll();
        }
    }

}
