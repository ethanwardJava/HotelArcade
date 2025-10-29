package com.arcade.hotelarcade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class HotelArcadeApplication {

    public static void main(String[] args) {
        SpringApplication.run(HotelArcadeApplication.class, args);
    }

}
