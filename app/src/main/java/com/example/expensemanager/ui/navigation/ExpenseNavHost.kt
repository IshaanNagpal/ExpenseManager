package com.example.expensemanager.ui.navigation

import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.expensemanager.R
import com.example.expensemanager.ui.home.HomeScreen
import com.example.expensemanager.ui.savings.SavingsScreen
import com.example.expensemanager.ui.setting.SettingsScreen
import com.example.expensemanager.ui.tabs.TabItem
import com.example.expensemanager.ui.transactions.TransactionsScreen

@Composable
fun ExpenseNavGraph(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = TabItem.Home.screenRoute) {
        composable(TabItem.Home.screenRoute) {
            HomeScreen(onClickItem = {})
        }

        composable(TabItem.Transactions.screenRoute) {
            TransactionsScreen()
        }

        composable(TabItem.Savings.screenRoute) {
            SavingsScreen()
        }

        composable(TabItem.Settings.screenRoute) {
            SettingsScreen()
        }
    }
}

@Composable
fun BottomNavigationComponent(navController: NavController) {
    val items = listOf(
        TabItem.Home,
        TabItem.Transactions,
        TabItem.Savings,
        TabItem.Settings,
    )
    BottomNavigation(
        backgroundColor = Color.White,
        contentColor = Color.Black
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        painterResource(id = item.icon),
                        modifier = Modifier.size(20.dp, 20.dp),
                        contentDescription = item.title
                    )
                },
                label = {
                    Text(
                        text = item.title,
                        fontSize = 9.sp
                    )
                },
                selectedContentColor = colorResource(id = R.color.primary_color),
                unselectedContentColor = colorResource(id = R.color.primary_color).copy(0.4f),
                alwaysShowLabel = true,
                selected = currentRoute == item.screenRoute,
                onClick = {
                    navController.navigate(item.screenRoute) {

                        navController.graph.startDestinationRoute?.let { screen_route ->
                            popUpTo(screen_route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}