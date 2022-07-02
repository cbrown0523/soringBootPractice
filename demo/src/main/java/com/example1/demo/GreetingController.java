package com.example1.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

//jackson json  libray converts object to json
@RestController
public class GreetingController {
   //concurrency
    private final AtomicLong counter = new AtomicLong();
    @GetMapping("/")
    public String getHello(){
        return "hello";
    }

    @GetMapping("/sayHi")
    public Greeting sayHi(){
        return new Greeting(42, "Hello Pals");
    }
    @GetMapping("/greeting")
    //requet param ?q=
    //path variable {}/{}
    public Greeting greeting(@RequestParam(value="name" ,defaultValue ="world")String name){
        return new Greeting(counter.incrementAndGet(), String.format("hello %s" , name));
    }
    @GetMapping("/hello/{name}")
    public Greeting hello(@PathVariable String name){
        return new Greeting(counter.incrementAndGet(),"Hello path variable");
    }
}
