package com.fiskrindy.saveTravels.Services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.fiskrindy.saveTravels.Models.Expense;
import com.fiskrindy.saveTravels.Repositories.ExpenseRepository;

@Service
public class ExpenseService {
	private final ExpenseRepository expenseRepo;
	
	public ExpenseService(ExpenseRepository expenseRepo) {
		this.expenseRepo = expenseRepo;
	}
	
	public List<Expense> allExpenses(){
		return expenseRepo.findAll();
	}
	
	public Expense create(Expense expense) {
		return expenseRepo.save(expense);
	}
	
	public Expense find(Long id) {
		Optional<Expense> optionalExpense = expenseRepo.findById(id);
		if(optionalExpense.isPresent()) {
			return optionalExpense.get();
		}
		else {
			return null;
		}
	}
	
	public Expense update(Expense expense) {
		return expenseRepo.save(expense);
	}
	
	public void delete(Expense expense) {
		expenseRepo.delete(expense);
	}
}
