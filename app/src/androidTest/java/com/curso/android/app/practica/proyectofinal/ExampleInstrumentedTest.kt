package com.curso.android.app.practica.proyectofinal

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class MainActivityInstrumentedTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun testUI() {
        // Simulate user input and button click
        composeTestRule.onNodeWithTag("editText1").performTextInput("hello")
        composeTestRule.onNodeWithTag("editText2").performTextInput("hello")
        composeTestRule.onNodeWithTag("compareButton").performClick()

        // Check the text displayed in TextView
        composeTestRule.onNodeWithTag("resultTextView")
            .assertTextEquals("Las cadenas son iguales")
    }
}

