package com.tugas.deploy.controller;

import com.tugas.deploy.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class UserController {

    // List temporary untuk simpan data mahasiswa (tidak ke database)
    private static List<User> listMahasiswa = new ArrayList<>();

    // Ganti dengan NIM asli kamu
    private final String MY_NIM = "20230140111";

    @GetMapping("/")
    public String index() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        if ("admin".equals(username) && MY_NIM.equals(password)) {
            return "redirect:/home";
        }
        model.addAttribute("error", "Username atau Password Salah!");
        return "login";
    }

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("dataMhs", listMahasiswa);
        model.addAttribute("myNim", MY_NIM); // Untuk identitas di footer/header
        return "home";
    }

    @GetMapping("/form")
    public String showForm() {
        return "form";
    }

    @PostMapping("/save")
    public String save(@RequestParam String nama, @RequestParam String nim, @RequestParam String jenisKelamin) {
        listMahasiswa.add(new User( UUID.randomUUID().toString(),nama, nim, jenisKelamin));
        return "redirect:/home";
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/";
    }
}