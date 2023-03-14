package com.example.thymeleafdemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.DateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.format.TextStyle;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("greetings")
public class HelloController {

  @GetMapping("hello")
  public String sayHello(Model model) {
    model.addAttribute("message", "world");
    LocalDate today = LocalDate.now();
    String formattedDate = today.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM));
    model.addAttribute("today", formattedDate);
    return "greeting";
  }

  @GetMapping("weekday")
  public String getWeekday(Model model) {
    LocalDate today = LocalDate.now();
    model.addAttribute("day", formatWeekday(today));
    return "weekday";
  }

  private String formatWeekday(LocalDate date) {
    Locale danish = new Locale("da", "DK");
    DayOfWeek dayOfWeek = date.getDayOfWeek();
    String str = dayOfWeek.getDisplayName(TextStyle.FULL, danish);
    return str.substring(0, 1).toUpperCase() + str.substring(1);
  }

  @GetMapping("friday")
  public String isFriday(Model model) {
    LocalDate today = LocalDate.now();
    model.addAttribute("day", today.getDayOfWeek().toString());
    return "isFriday";
  }

  @GetMapping("items")
  public String items(Model model) {
    List items = Arrays.asList("ananas", "banan", "kiwi", "mango", "pære");
    model.addAttribute("items", items);
    return "items";
  }
}
