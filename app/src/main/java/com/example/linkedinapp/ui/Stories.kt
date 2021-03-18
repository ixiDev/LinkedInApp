package com.example.linkedinapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.linkedinapp.R
import com.google.accompanist.coil.CoilImage
import com.google.accompanist.imageloading.ImageLoadState
import com.google.accompanist.imageloading.MaterialLoadingImage


data class Story(
    var userName: String,
    var image: String,
)

@Composable
fun StoriesListView(list: List<Story>) {
    LazyRow(
        Modifier.fillMaxWidth()
    ) {

        item {
            AddStoryView(modifier = Modifier.clickable {
                // add story
            })
        }
        items(list) { story ->
            StoryItemView(story = story, Modifier.clickable {
                // view user stories
            })
        }
    }
}

@Composable
fun AddStoryView(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(4.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box {
            Image(
                painter = painterResource(id = R.drawable.user_pic),
                contentDescription = null,
                modifier = Modifier
                    .clip(CircleShape)
                    .size(60.dp),
                contentScale = ContentScale.Crop
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_add),
                contentDescription = null,
                tint = Color(0xFF1079F0),
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .clip(CircleShape)
                    .background(Color.White)

            )
        }

        Text(
            text = "Your Story",
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun StoryItemView(story: Story, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(4.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CoilImage(
            data = story.image,
            modifier = Modifier
                // .clip(CircleShape)
                .size(60.dp)
        )
        { imageState ->
            if (imageState is ImageLoadState.Success) {
                MaterialLoadingImage(
                    result = imageState,
                    contentDescription = null,
                    fadeInEnabled = true,
                    // fadeInDurationMs = 600,
                    modifier = Modifier
                        .border(2.dp, color = Color.Blue, shape = CircleShape)
                        .clip(shape = CircleShape)
                )

            }
        }

        Text(
            text = story.userName,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold
        )
    }
}