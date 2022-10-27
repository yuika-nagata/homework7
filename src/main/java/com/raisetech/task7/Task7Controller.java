package com.raisetech.task7;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
public class Task7Controller {

    @GetMapping("/name")
    public ResponseEntity<Map<String,String>> getUser(@RequestParam(value = "name",defaultValue = "name")String name,@RequestParam(value = "birthday",defaultValue = "0000")String birthday){

        return ResponseEntity.ok(Map.of("message",name+" "+birthday));
    }

    @PostMapping("/names")
    public ResponseEntity<String> create(@RequestBody CreateForm form){
        URI url= UriComponentsBuilder.fromUriString("http://localhost:8080")
                .path("/name/id")
                .build()
                .toUri();
        return ResponseEntity.created(url).body("name successfully created");
    }

    @PatchMapping("/names/{id}")
    public ResponseEntity<Map<String,String>> update(@PathVariable("id") int id,@RequestBody UpdateForm from){
        return ResponseEntity.ok(Map.of("message","name successfully updated"));
    }

    @DeleteMapping("/names/{id}")
    public ResponseEntity<Map<String,String>> delete(@PathVariable("id") int id) {
        return ResponseEntity.ok(Map.of("message", "name successfully delete"));
    }
}
