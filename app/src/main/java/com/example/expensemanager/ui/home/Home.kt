package com.example.expensemanager.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun HomeScreen(
    onClickItem: (category: ExpenseCategory) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(all = 10.dp)
    ) {
        items(
            count = expenseCategoryList.size
        ) { index ->
            val expenseItem = expenseCategoryList[index] ?: return@items
            ExpenseItem(category = expenseItem) {
                onClickItem.invoke(expenseItem)
            }
        }
    }
}

@Composable
fun ExpenseItem(
    category: ExpenseCategory,
    nClickItem: (category: ExpenseCategory) -> Unit
) {
    Card(
        modifier = Modifier.padding(all = 5.dp)

    ) {
        Column(
            Modifier
                .padding(all = 15.dp)
        ) {
            Text(
                text = category.catName

            )
            Text(
                text = "${category.totalExpense} SGD ",

                )
        }
    }
}

