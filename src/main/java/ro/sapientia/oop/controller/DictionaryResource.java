package ro.sapientia.oop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import ro.sapientia.oop.service.DictionaryService;

@RestController
@RequestMapping("api/v1/dictionary")
public class DictionaryResource {
    @Autowired
    private DictionaryService service;

    public DictionaryResource() {}

    @GetMapping
    public String word(@RequestParam("word") String word){
        if (service.findWord(word)){
            return "The word " + word + " EXISTS";
        }
        else{
            return "The word " + word + " DOES NOT EXIST";
        }
    }
    @GetMapping("/hello")
    public String hello() {
        return "Hello!";
    }
}
