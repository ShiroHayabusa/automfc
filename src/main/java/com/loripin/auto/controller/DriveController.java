package com.loripin.auto.controller;

import com.loripin.auto.model.Drive;
import com.loripin.auto.service.DriveService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class DriveController {
    private final
    DriveService driveService;

    public DriveController(DriveService driveService) {
        this.driveService = driveService;
    }

    @GetMapping("/driveList")
    public String driveList(Model model) {
        List<Drive> drives = driveService.findAllByOrderByIdAsc();
        model.addAttribute("drives", drives);
        return "driveList";
    }

    @GetMapping("/driveCreate")
    public String driveCreateForm(Drive drive) {
        return "driveCreate";
    }

    @PostMapping("/driveCreate")
    public String driveCreate(Drive drive) {
        driveService.save(drive);
        return "redirect:/driveList";
    }
}
