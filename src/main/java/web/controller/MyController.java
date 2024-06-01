package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.models.User;
import web.services.UserService;

import java.util.List;

@Controller
public class MyController {
    @Autowired
    private UserService userService;

//    @GetMapping("/")
//    public String showAllUsers(Model model) {
//        List<User> allUsers = userService.getAllUsers();
//        model.addAttribute("allUsers", allUsers);
//
//        return "index";
//    }
    @GetMapping("/")
    public String showAllUsers(Model model) {
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("allUsers", allUsers);
        model.addAttribute("user", new User()); // добавление нового объекта user в модель

        return "index"; // название вашего Thymeleaf шаблона (без .html)
    }

    @PostMapping("/addNewUser")
    public String addNewUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

//    @PostMapping("/addNewUser")
//    public String addNewUser(Model model) {
//        User user = new User();
//        model.addAttribute("user", user);
//
//        return "redirect:/";
//    }

//    @PostMapping("/saveUser")
//    public String saveUser(@ModelAttribute("user") User user) {
//        userService.saveUser(user);
//
//        return "index";
//    }

    @PostMapping("/updateUser")
    public String updateUser(@RequestParam("userId") int id, Model model) {
        User user = userService.getUser(id);
        model.addAttribute("user", user);

        return "index";
    }

    @PostMapping("/deleteUser")
    public String deleteUser(@RequestParam("userId") int id) {
        userService.deleteUser(id);

        return "index";
    }
}
