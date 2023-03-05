package com.example.expensemanager.ui.home

data class ExpenseCategory(
    val id: Int,
    val catName: String,
    var totalExpense: Double
)

val expenseCategoryList = listOf<ExpenseCategory>(
    ExpenseCategory(1, "Food", 0.0),
    ExpenseCategory(2, "Transportation", 0.0),
    ExpenseCategory(3, "Housing & Utilities", 0.0),
    ExpenseCategory(4, "Personal Care", 0.0),
    ExpenseCategory(5, "Shopping", 0.0),
    ExpenseCategory(6, "Health Care", 0.0),
    ExpenseCategory(7, "MemberShip", 0.0),
    ExpenseCategory(8, "Givings", 0.0),
    ExpenseCategory(9, "Salary", 0.0),
    ExpenseCategory(10, "Investment", 0.0)

)