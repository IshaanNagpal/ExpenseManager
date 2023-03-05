package com.example.expensemanager

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TabHost.TabContentFactory
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Colors
import androidx.compose.material.TopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.expensemanager.ui.navigation.BottomNavigationComponent
import com.example.expensemanager.ui.navigation.ExpenseNavGraph
import com.example.expensemanager.ui.tabs.TabItem
import com.example.expensemanager.ui.tabs.Tabs
import com.example.expensemanager.ui.tabs.TabsContent
import com.example.expensemanager.ui.theme.ExpenseManagerTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExpenseManagerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

/*@OptIn(ExperimentalPagerApi::class, ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val tabs = listOf(
        TabItem.Home,
        TabItem.Transactions,
        TabItem.Savings,
        TabItem.Settings
    )
    val pagerState =  rememberPagerState()
    val navController = rememberNavController()
    Scaffold(
        topBar = { TopBar() },
        bottomBar = { BottomNavigationComponent(navController = navController)}
    ) { padding ->
        ExpenseNavGraph(navController)
        Column(modifier = Modifier.padding(padding)) {
            // Tabs(tabs = tabs, pagerState = pagerState )
            TabsContent(tabs = tabs, pagerState = pagerState)

        }
    }
}*/

@Composable
fun TopBar() {
    TopAppBar(
        title = { Text(text = stringResource(R.string.app_name), fontSize = 18.sp) },
        backgroundColor = Color.White,
        contentColor = Color.Black
    )
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ExpenseManagerTheme {
        Greeting("Android")
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    androidx.compose.material.Scaffold(
        topBar = { TopBar() },
        bottomBar = { BottomNavigationComponent(navController = navController) },
        content = { paddingValues ->
            Box(
                modifier =
                Modifier.padding(paddingValues)
            ) {
                ExpenseNavGraph(navController = navController)
            }
        },
        backgroundColor = Color.White

    )
}