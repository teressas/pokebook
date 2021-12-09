package com.teressas.pokebook.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teressas.pokebook.models.Expense;
import com.teressas.pokebook.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	
	@Autowired
	ExpenseRepository expenseRepo;
	
	// returns all items
	public List<Expense> allExpenses() {
		return expenseRepo.findAll();
			 
	}
	
	//create an item
	public Expense addExpense(Expense expense) {
		return expenseRepo.save(expense);
	}
	
	// find one item
	public Expense findOneExpense(Long id) {
		Optional<Expense> optionalExpense = expenseRepo.findById(id);
		if(optionalExpense.isPresent()) {
			return optionalExpense.get();
		} else {
			return null;
		}
 	}
	
	// update an item
	public Expense editExpense(Expense expense) {
		return expenseRepo.save(expense);
	}
	
	public void deleteExpense(Long id) {
		expenseRepo.deleteById(id);
	}
	
}
