package pl.robert.phonebook.phonebook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.robert.phonebook.phonebook.models.forms.PhoneBookForm;
import pl.robert.phonebook.phonebook.models.services.AuthService;

@Controller
public class AuthController {

    final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("phoneBookForm", new PhoneBookForm());
        return "index";
    }

    @PostMapping("/index")
    public String index(@ModelAttribute("phoneBookForm") PhoneBookForm phoneBookForm, Model model) {
        if (!authService.tryToAddNumber(phoneBookForm)) {
            model.addAttribute("info", "Numer Zajęty");
            return "index";
        }
        return "redirect:/index";
    }
}
