package io.d4rkr0n1n.sample;

import java.sql.Timestamp;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class SampleController {

    private final SampleRepository sampleRepository;

    public SampleController(SampleRepository sampleRepository) {
        this.sampleRepository = sampleRepository;
    }

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello There";
    }

    @GetMapping("/get")
    public String get() {
        return sampleRepository.findAll().toString();
    }

    @PostMapping("/post")
    public String post() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Notes notes = new Notes(UUID.randomUUID(), "Note_"+timestamp);
        sampleRepository.save(notes);
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
