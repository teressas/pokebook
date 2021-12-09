package com.teressas.pokebook.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.teressas.pokebook.models.Expense;

@Repository
public interface ExpenseRepository extends CrudRepository<Expense, Long> {
	
	List<Expense> findAll();

}
