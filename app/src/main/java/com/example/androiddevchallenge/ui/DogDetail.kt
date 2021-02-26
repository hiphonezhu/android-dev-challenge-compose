package com.example.androiddevchallenge.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.Dog

/**
 * @author hyvenzhu
 * @version 2021-02-25
 */

@Composable
fun DogDetail(dog: Dog, onBack: () -> Unit) {
    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .background(Color.Blue),
        ) {
            Row(
                modifier = Modifier.fillMaxHeight().padding(start = 20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painterResource(id = R.drawable.back),
                    contentDescription = "返回",
                    Modifier.size(20.dp).clickable { onBack() },
                )
            }

            Text(
                text = dog.name,
                Modifier.align(Alignment.Center),
                color = Color.White
            )
        }

        Image(
            painterResource(id = dog.avatar),
            contentDescription = dog.name,
            Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )
        Text(text = dog.desc, modifier = Modifier.padding(10.dp))
    }
}