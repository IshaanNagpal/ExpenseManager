package com.example.expensemanager.ui.tabs

import androidx.compose.runtime.Composable
import com.example.expensemanager.R
import com.example.expensemanager.ui.home.HomeScreen
import com.example.expensemanager.ui.savings.SavingsScreen
import com.example.expensemanager.ui.setting.SettingsScreen
import com.example.expensemanager.ui.transactions.TransactionsScreen

typealias ComposableFun = @Composable () -> Unit

sealed class TabItem(
    var icon: Int,
    var title: String,
    var screenRoute: String,
    var screen: ComposableFun
) {
    object Home : TabItem(R.drawable.ic_home, "Home", "home", { HomeScreen(onClickItem = {}) })
    object Transactions :
        TabItem(R.drawable.ic_transactions, "Transactions", "transaction", { TransactionsScreen() })

    object Savings : TabItem(R.drawable.ic_savings, "Savings", "savings", { SavingsScreen() })
    object Settings : TabItem(R.drawable.ic_setting, "Settings", "settings", { SettingsScreen() })
}
