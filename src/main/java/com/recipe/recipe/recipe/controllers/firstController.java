package com.recipe.recipe.recipe.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class firstController {
    @GetMapping
    public String helloWorld() {
        return "Приложение запущено";
    }

    @GetMapping("/info")
    public String name() {
        String name = "Jack";
        String project = "MavenTest";
        String date = "23.01.2023";
        String description = "doesn't matter";
        return "Имя: " + name
                + ", Имя проекта: " + project
                + ", Дата создания: " + date
                + ", Описание проекта: "
                + description;
    }
}


