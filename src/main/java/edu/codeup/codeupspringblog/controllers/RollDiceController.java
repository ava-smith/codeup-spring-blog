package edu.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class RollDiceController {
    private int counter = 0;

    @GetMapping("/roll-dice")
    public String rollDiceView() {
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{num}")
    public String userGuess(@PathVariable int num, Model model) {
        int randomNumber1 = (int) (Math.floor(Math.random() * 6) + 1);
        int randomNumber2 = (int) (Math.floor(Math.random() * 6) + 1);
        int randomNumber3 = (int) (Math.floor(Math.random() * 6) + 1);
        int randomNumber4 = (int) (Math.floor(Math.random() * 6) + 1);
        int randomNumber5 = (int) (Math.floor(Math.random() * 6) + 1);
        int randomNumber6 = (int) (Math.floor(Math.random() * 6) + 1);
        List<Integer> randomNumbers = new ArrayList<>();
        randomNumbers.add(randomNumber1);
        randomNumbers.add(randomNumber2);
        randomNumbers.add(randomNumber3);
        randomNumbers.add(randomNumber4);
        randomNumbers.add(randomNumber5);
        randomNumbers.add(randomNumber6);

        for(int i = 0; i < randomNumbers.size(); i++) {
            if(randomNumbers.get(i) == num) {
                counter++;
            }
        }

        model.addAttribute("num", num);
        model.addAttribute("randomNumbers", randomNumbers);
        model.addAttribute("counter", counter);
        return "roll-dice";
    }
}
