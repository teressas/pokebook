package com.teressas.pokebook.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.teressas.pokebook.models.Expense;
import com.teressas.pokebook.services.ExpenseService;

@Controller
public class HomeController {
	
	@Autowired
	ExpenseService expenseService;
	
	// Find all
	
	@GetMapping("/")
	public String dashboard(Model model, @ModelAttribute("newExpense") Expense newExpense) {
		List<Expense> expenses = expenseService.allExpenses();
		model.addAttribute("expenses", expenses);
		
		return "index.jsp";
	}
	
	@GetMapping("/create")
	public String createForm(@ModelAttribute("newExpense") Expense newExpense) {
		return "index.jsp";
	}
	
	@PostMapping("/create")
	public String processCreateForm(Model model, @Valid @ModelAttribute("newExpense") Expense newExpense,
			BindingResult result) {
		if(result.hasErrors()) {
			List<Expense> expenses = expenseService.allExpenses();
			model.addAttribute("expenses", expenses);
			return "index.jsp";
		} else {
			expenseService.addExpense(newExpense);
			return "redirect:/";
		}
		
	}
	
}
