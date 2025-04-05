package com.grp7.project.controller;

import com.grp7.project.service.FeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FeePageController {

    @Autowired
    private FeeService feeService;

    @GetMapping("/fees/list")
    public String showFeeList(Model model) {
        model.addAttribute("fees", feeService.getAllFees());
        return "feeList";
    }
}