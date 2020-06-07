package com.greenlearner.etagfilterdemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author - GreenLearner(https://www.youtube.com/c/greenlearner)
 */

@Controller
public class EtagDemoController {

    @GetMapping("/hello/{name}")
    ModelAndView hello(@PathVariable String name){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("name", name);
        return modelAndView;
    }
}
