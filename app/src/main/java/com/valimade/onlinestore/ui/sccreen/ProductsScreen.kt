package com.valimade.onlinestore.ui.sccreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.valimade.onlinestore.ui.components.ProductsGrid
import com.valimade.onlinestore.ui.viewmodel.ProductsViewModel

@Composable
fun ProductsScreen(
    modifier: Modifier,
    viewModel: ProductsViewModel
) {
    val state by viewModel.state.collectAsState()
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        when {
            state.isLoading -> {
                CircularProgressIndicator()
            }

            state.error != null -> {
                Text(
                    text = "Ошибка: ${state.error}",
                    color = Color.Red,
                    modifier = Modifier.padding(16.dp)
                )
            }

            else -> {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(
                        text = "Список товаров",
                        fontSize = 20.sp,
                        modifier = Modifier.padding(16.dp)
                    )
                    Button(
                        onClick = {viewModel.reloadFromServer()}
                    ) {
                        Text(text = "Обновить список")
                    }
                    ProductsGrid(state.products)
                }
            }
        }
    }
}
