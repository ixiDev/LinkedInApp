package com.example.linkedinapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.linkedinapp.ui.*
import com.example.linkedinapp.ui.theme.LinkedInAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LinkedInAppTheme {
                LinkedInMain()
            }
        }
    }
}


@Composable
fun LinkedInMain() {
    Scaffold(
        topBar = { LinkedInToolBar() },
        bottomBar = { LinkedInBottomBar() }
    ) {
        Column(Modifier.fillMaxSize()) {
            val stories = loadStories()
            StoriesListView(list = stories)
        }
    }
}

private fun loadStories(): List<Story> {
    return listOf(
        Story(
            "User 1",
            "https://media-exp1.licdn.com/dms/image/C4E35AQEg2Nc8zAkPIQ/profile-framedphoto-shrink_100_100/0/1615913961023?e=1616115600&v=beta&t=KFcvpSJ3H1IYUaut8dpp6JAi8CI-KbJrXoR722jEIm0"
        ),
        Story(
            "User 2",
            "https://media-exp1.licdn.com/dms/image/C4E03AQFxQ1YdKArQ8Q/profile-displayphoto-shrink_100_100/0/1614723380076?e=1621468800&v=beta&t=Ot52K-s8Nk2Kgj_cJLCzt7lLdVD51G4H7ZIJco6wvmU"
        ),
        Story(
            "User 3",
            "https://media-exp1.licdn.com/dms/image/C4D03AQHqe_JFyId--A/profile-displayphoto-shrink_100_100/0/1604915760468?e=1621468800&v=beta&t=VnJDI0RvHXfrK6bi3oyZtSPKNvNWkqdZDiSwN23_-yY"
        ),
        Story(
            "User 4",
            "https://media-exp1.licdn.com/dms/image/C4D03AQFr4mWqAOtUtg/profile-displayphoto-shrink_100_100/0/1615629923088?e=1621468800&v=beta&t=YrwJVUWGGv7LqAFqh_VcX3fESf42ef-hMBiCK9JsDnY"
        ),
        Story(
            "User 5",
            "https://media-exp1.licdn.com/dms/image/C4D03AQEayrMUbxD_zA/profile-displayphoto-shrink_100_100/0/1589416332840?e=1621468800&v=beta&t=Oe6StYST3oYUeafD-6WJd_YHNSBiBGelTuvsp5sMtKY"
        ),
        Story(
            "User 6",
            "https://media-exp1.licdn.com/dms/image/C4E03AQHt09d7wOKqCQ/profile-displayphoto-shrink_100_100/0/1611966644166?e=1621468800&v=beta&t=8QaUS1MIWKmq7dNlMulYcQe1Y1Mvygi_SCzKsWPL9Gg"
        ),
    )
}
