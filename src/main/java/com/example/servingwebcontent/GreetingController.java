package com.example.servingwebcontent;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes("valueSession2")
public class GreetingController {

    private int value=42;
    @ModelAttribute("value")
    public int getValue()
    {
        return value;
    }

    private int valueSession2 = 44;

    @ModelAttribute("valueSession2")
    public int getValueSession2()
    {
        return valueSession2;
    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model, HttpSession session) {
        model.addAttribute("name", name);
        session.setAttribute("valueSession", 43);
        return "greeting";
    }

    @GetMapping("/testParam/{id}")
    public String testParam(@PathVariable int id, Model model) {
        model.addAttribute("id", id);
        return "param";
    }

    @RequestMapping("/endsession")
    public String endSession(SessionStatus status){
        status.setComplete();
        return "redirect:/greeting";
    }

}