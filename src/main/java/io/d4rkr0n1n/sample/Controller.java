package io.d4rkr0n1n.sample;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class Controller {

  @GetMapping("/hello")
  public String helloWorld() {
      return "Hello There";
  }

  @GetMapping("/get")
  public String get() {
      return "get";
  }

  @PostMapping("/post")
  public String post() {
      return "post";
  }

  @PutMapping("/put")
  public String put() {
      return "put";
  }

  @DeleteMapping("/delete")
  public String delete() {
      return "delete";
  }
  
}
