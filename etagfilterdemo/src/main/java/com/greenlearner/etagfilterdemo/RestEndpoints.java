package com.greenlearner.etagfilterdemo;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author - GreenLearner(https://www.youtube.com/c/greenlearner)
 */

@RestController
public class RestEndpoints {

    @GetMapping("/rest/{name}")
    String hi(@PathVariable String name, HttpServletRequest request) {
        System.out.println("etag -- " + request.getHeader(HttpHeaders.ETAG));
        System.out.println("if-none-mathc -- " + request.getHeader(HttpHeaders.IF_NONE_MATCH));
        return "hello" + name;
    }
    @GetMapping("/rest12/{name}")
    String hi12(@PathVariable String name) {
        return "hello123" + name;
    }

    @GetMapping("/custom/{name}")
    ResponseEntity<String> customHandler(@PathVariable String name) {

        return ResponseEntity.ok()
                .eTag(name)
                .body("hello " + name);
    }
}
