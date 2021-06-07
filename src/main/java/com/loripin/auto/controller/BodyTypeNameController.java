package com.loripin.auto.controller;

import com.loripin.auto.model.BodyTypeName;
import com.loripin.auto.service.BodyTypeNameService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BodyTypeNameController {
    private final
    BodyTypeNameService bodyTypeNameService;

    public BodyTypeNameController(BodyTypeNameService bodyTypeNameService) {
        this.bodyTypeNameService = bodyTypeNameService;
    }

    @GetMapping("/bodyTypeNameList")
    public String bodyTypeNameList(Model model) {
        List<BodyTypeName> bodyTypeNames = bodyTypeNameService.findAllByOrderByNameAsc();
        model.addAttribute("bodyTypeNames", bodyTypeNames);
        return "bodyTypeNameList";
    }

    @GetMapping("/bodyTypeNameCreate")
    public String bodyTypeNameCreateForm(BodyTypeName bodyTypeName) {
        return "bodyTypeNameCreate";
    }

    @PostMapping("/bodyTypeNameCreate")
    public String bodyTypeNameCreate(BodyTypeName bodyTypeName) {
        bodyTypeNameService.save(bodyTypeName);
        return "redirect:/bodyTypeNameList";
    }
}
