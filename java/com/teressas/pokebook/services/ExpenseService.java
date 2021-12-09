package com.teressas.pokebook.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teressas.pokebook.models.Expense;
import com.teressas.pokebook.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	
	@Autowired
	ExpenseRepository expenseRepo;
	
	// returns all books
	public List<Expense> allExpenses() {
		return expenseRepo.findAll();
			 
	}
	
	//create a expense
	public Expense addExpense(Expense expense) {
		return expenseRepo.save(expense);
	}
	
}
