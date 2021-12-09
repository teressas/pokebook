package com.teressas.pokebook.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.teressas.pokebook.models.Expense;
import com.teressas.pokebook.services.ExpenseService;

@Controller
@RequestMapping("/expenses")
public class HomeController {

	@Autowired
	ExpenseService expenseService;

	// Find all
	@GetMapping("")
	public String dashboard(Model model, @ModelAttribute("newExpense") Expense newExpense) {
		List<Expense> expenses = expenseService.allExpenses();
		model.addAttribute("expenses", expenses);

		return "index.jsp";
	}

	// Create
	@GetMapping("/create")
	public String createForm(@ModelAttribute("newExpense") Expense newExpense) {
		return "index.jsp";
	}

	// Process Create Form
	@PostMapping("/create")
	public String processCreateForm(Model model, @Valid @ModelAttribute("newExpense") Expense newExpense,
			BindingResult result) {
		if (result.hasErrors()) {
			List<Expense> expenses = expenseService.allExpenses();
			model.addAttribute("expenses", expenses);
			return "index.jsp";
		} else {
			expenseService.addExpense(newExpense);
			return "redirect:/";
		}
	}
	
//	@GetMapping("/{id}")
//	public String getOneExpense(@PathVariable("id")Long id, Model model) {
//		Expense expense = expenseService.findOneExpense(id);
//		model.addAttribute("expense", expense);
//		return "editForm.jsp";
//	}
//	
	//Edit
	@GetMapping("/edit/{id}")
	public String editForm(@PathVariable("id") Long id, Model model) {
		Expense expense = expenseService.findOneExpense(id);
		model.addAttribute("expense", expense);
		return "editForm.jsp";
	}

	@PutMapping("/edit/{id}")
	public String processEditForm(@Valid @ModelAttribute("expense") Expense expense,
			BindingResult result, @PathVariable("id") Long id) {
		if(result.hasErrors()) {
			return "editForm.jsp";
		} else {
			expenseService.editExpense(expense);
			return "redirect:/expenses/edit/{id}";
		}
	}
}
