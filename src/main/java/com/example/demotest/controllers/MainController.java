package com.example.demotest.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/calc")
    public String calc(@RequestParam(name = "perv", required = false,defaultValue = "0") double perv,
                       @RequestParam(name = "vtor", required = false,defaultValue = "0") double vtor,
                       @RequestParam(name = "math", required = false) String math, Model model)
    {
        System.out.print(math);
        double res = switch (math){
            case "+" -> perv + vtor;
            case "-" ->  perv - vtor;
            case "*"-> perv * vtor;
            case "/"-> perv / vtor;
            default -> 0;
        };
        model.addAttribute("res",res);

        return "res";

    }
    @PostMapping("/calc")
    public String postcalc(@RequestParam(name = "perv", required = false,defaultValue = "0") double perv,
                       @RequestParam(name = "vtor", required = false,defaultValue = "0") double vtor,
                       @RequestParam(name = "math", required = false) String math,
                       Model model)
    {

        double res = switch (math){
            case "+" -> perv + vtor;
            case "-" ->  perv - vtor;
            case "*"-> perv * vtor;
            case "/"-> perv / vtor;
            default -> 0;
        };
        model.addAttribute("res",res);

        return "res";

    }

}
