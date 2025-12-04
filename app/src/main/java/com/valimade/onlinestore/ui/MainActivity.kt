package com.valimade.onlinestore.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.valimade.onlinestore.App
import com.valimade.onlinestore.ui.sccreen.ProductsScreen
import com.valimade.onlinestore.ui.theme.OnlineStoreTheme
import com.valimade.onlinestore.ui.viewmodel.ProductsViewModel
import com.valimade.onlinestore.ui.viewmodel.ProductsViewModelFactory
import javax.inject.Inject

class MainActivity : ComponentActivity() {
    @Inject
    lateinit var viewModelFactory: ProductsViewModelFactory

    private val viewModel: ProductsViewModel by viewModels {
        viewModelFactory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        App.Companion.appComponent.inject(this)
        setContent {
            OnlineStoreTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ProductsScreen(
                        modifier = Modifier.padding(innerPadding),
                        viewModel = viewModel,
                    )
                }
            }
        }
    }
}
