package com.example.cpre5300project.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.cpre5300project.data.EducationSection
import com.example.cpre5300project.data.PageContent

/**
 * Displays an education screen teaching users about a security topic.
 *
 * @param content The education page content (title and sections)
 * @param onNext Callback invoked when the user taps "Continue to Test"
 */
@Composable
fun EducationScreen(
    content: PageContent.Education,
    onNext: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                text = content.title,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            content.sections.forEach { section ->
                EducationSectionItem(section = section)
                Spacer(modifier = Modifier.height(16.dp))
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = onNext,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
        ) {
            Text(
                text = "Continue to Test",
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}

/**
 * Displays a single section within an education page.
 *
 * @param section The education section to display
 */
@Composable
fun EducationSectionItem(section: EducationSection) {
    Column {
        Text(
            text = section.heading,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Text(
            text = section.content,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}
