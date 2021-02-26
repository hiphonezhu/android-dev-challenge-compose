package com.example.androiddevchallenge.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.Dog

/**
 * @author hyvenzhu
 * @version 2021-02-25
 */
@Composable
fun DogList(dogList: List<Dog>, onClick: (Dog) -> Unit) {
    val columnCount = 2
    val dogSize = dogList.size
    val rowCount = dogSize / columnCount + if (dogSize % columnCount == 0) 0 else 1
    Column() {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(Color.Blue),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "2020年热门宠物狗排名",
                color = Color.White
            )
        }

        LazyColumn(
            Modifier
                .fillMaxSize()
                .padding(top = 10.dp)
        ) {
            val array = arrayOfNulls<Int>(rowCount)
            itemsIndexed(array) { index, item ->
                val fromIndex = index * columnCount
                val endIndex =
                    if (fromIndex + columnCount > dogSize) dogSize else fromIndex + columnCount
                val rowList = dogList.subList(index * columnCount, endIndex)
                Row(Modifier.fillMaxWidth()) {
                    for (columnIndex in rowList.indices) {
                        val dog = rowList[columnIndex]
                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .clickable {
                                    onClick(dog)
                                },
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painterResource(id = dog.avatar),
                                contentDescription = dog.name,
                                Modifier.size(150.dp),
                                contentScale = ContentScale.Crop
                            )
                            Spacer(modifier = Modifier.size(5.dp))
                            Text(text = dog.name)
                        }
                    }

                    for (placeHolder in rowList.size until 2) {
                        Box(modifier = Modifier.weight(1f))
                    }
                }
                Spacer(modifier = Modifier.size(20.dp))
            }
        }
    }
}