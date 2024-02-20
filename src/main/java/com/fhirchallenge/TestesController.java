package com.fhirchallenge;

import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class TestesController {
    private static final String template = "Hi, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/testes")
    public Testes testes(
            @RequestParam(value = "name", defaultValue = "World") String name) {
        return new Testes(counter.incrementAndGet(), String.format(template, name));
    }

    @RequestMapping(value = "/sum/{num1}/{num2}", method = RequestMethod.GET)
    public Double sum(@PathVariable(value = "num1") String num1, @PathVariable(value = "num2") String num2) {
        Double a = Double.parseDouble(num1) + Double.parseDouble(num2);
        return a;
    }
}
