package com.muhammadfaizfauzan.tugascashier

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.muhammadfaizfauzan.tugascashier.ui.theme.SimpleCashierAppTheme
import androidx.lifecycle.viewmodel.compose.viewModel
import com.muhammadfaizfauzan.tugascashier.ui.screen.CashierScreen
import com.muhammadfaizfauzan.tugascashier.viewmodel.CashierViewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val cashierViewModel: CashierViewModel = viewModel()
            val uiState = cashierViewModel.uiState
            CashierScreen(
                uiState = uiState,
                onAddProduct = cashierViewModel::addToCart,
                onDecreaseItem = cashierViewModel::decreaseItem,
                onCheckout = cashierViewModel::checkout,
                onResetTransaction = cashierViewModel::resetTransaction
            )
        }
    }
}