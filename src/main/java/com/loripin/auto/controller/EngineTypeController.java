package com.loripin.auto.controller;

import com.loripin.auto.model.EngineType;
import com.loripin.auto.service.EngineTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EngineTypeController {
    private final
    EngineTypeService engineTypeService;

    public EngineTypeController(EngineTypeService engineTypeService) {
        this.engineTypeService = engineTypeService;
    }

    @GetMapping("/engineTypeList")
    public String engineTypeList(Model model) {
        List<EngineType> engineTypes = engineTypeService.findAllByOrderByIdAsc();
        model.addAttribute("engineTypes", engineTypes);
        return "engineTypeList";
    }

    @GetMapping("/engineTypeCreate")
    public String engineTypeCreateForm(EngineType engineType) {
        return "engineTypeCreate";
    }

    @PostMapping("/engineTypeCreate")
    public String engineTypeCreate(EngineType engineType) {
        engineTypeService.save(engineType);
        return "redirect:/engineTypeList";
    }
}
