package com.fiskrindy.saveTravels.Repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.fiskrindy.saveTravels.Models.Expense;

@Repository
public interface ExpenseRepository extends CrudRepository<Expense, Long> {
	List<Expense> findAll();
}
