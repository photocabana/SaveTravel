package com.fiskrindy.saveTravels.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fiskrindy.saveTravels.Models.Expense;
import com.fiskrindy.saveTravels.Services.ExpenseService;

import jakarta.validation.Valid;

@Controller
public class MainController {
	@Autowired
	ExpenseService expenseService;
	
	@GetMapping("/")
	public String dashboard() {
		return "redirect:/expenses";
	}
	
	@GetMapping("/expenses")
	public String index(@ModelAttribute("expense") Expense expense, Model model) {
		List<Expense> expenses = expenseService.allExpenses();
		model.addAttribute("expenses", expenses);
		return "index.jsp";
	}
	
	@PostMapping("/expenses")
	public String index(@Valid @ModelAttribute("expense") Expense expense, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Expense> expenses = expenseService.allExpenses();
			model.addAttribute("expenses", expenses);
			return "index.jsp";
		}
		else {
			expenseService.create(expense);
			return "redirect:/expenses";
		}
	}
	
	@GetMapping("/expenses/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {	
		model.addAttribute("expense", expenseService.find(id));
		return "edit.jsp";
	}
	
	@PostMapping("/expenses/edit/{id}")
	public String edit(@Valid @ModelAttribute("expense") Expense expense, BindingResult result, 
			@PathVariable("id") Long id, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("expense", expenseService.find(id));
			return "redirect:/edit/{id}";
		}
		else {
			expenseService.update(expense);
			return "redirect:/expenses";
		}
	}
	
	@GetMapping("/expenses/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		model.addAttribute("expense", expenseService.find(id));
		return "show.jsp";
	}
	
	@RequestMapping("/expenses/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		Expense expense = expenseService.find(id);
		expenseService.delete(expense);
		return "redirect:/expenses";
	}
}
