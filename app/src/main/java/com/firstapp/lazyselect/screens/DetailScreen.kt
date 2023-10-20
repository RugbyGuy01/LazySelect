package com.firstapp.lazyselect.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.format.TextStyle

@Composable
fun DatailScreen(
    modifier: Modifier = Modifier,
    names: Array<String>,
    ingredients: Array<String>,
    itemIndex: Int?
) {
    Column(
        modifier
            .fillMaxSize()
            .padding(25.dp),
        verticalArrangement = Arrangement.spacedBy(25.dp)
    ) {
        Text(
            "${names[itemIndex!!]}",
            modifier.padding(12.dp),
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            "${ingredients[itemIndex!!]}", modifier.padding(10.dp), fontSize = 30.sp,
            style = androidx.compose.ui.text.TextStyle(lineHeight = 40.sp)
        )
    }
}
