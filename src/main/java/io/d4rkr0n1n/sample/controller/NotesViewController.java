package io.d4rkr0n1n.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NotesViewController {
  @GetMapping("/")

    public String home(Model model) {
        model.addAttribute("message", "Notes WebApp");
        return "index";
    }
}
