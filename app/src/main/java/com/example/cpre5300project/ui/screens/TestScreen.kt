package com.example.cpre5300project.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.cpre5300project.data.AnswerOption
import com.example.cpre5300project.data.PageContent
import com.example.cpre5300project.data.Question

/**
 * Displays a test/quiz screen where users answer questions about what they learned.
 *
 * Features:
 * - Supports both single-select (radio) and multi-select (checkbox) questions
 * - Users must answer all questions before submitting
 * - Shows visual feedback (green/red) for correct/incorrect answers
 * - Users can only proceed after answering all questions correctly
 * - Allows users to change answers and resubmit if any are incorrect
 *
 * @param content The test page content (title and questions)
 * @param onNext Callback invoked when all questions are answered correctly and user taps "Continue"
 */
@Composable
fun TestScreen(
    content: PageContent.Test,
    onNext: () -> Unit
) {
    // State: tracks selected answer for each question
    // Each index corresponds to a question, with a set of selected options
    var selectedAnswers by remember { mutableStateOf(List(content.questions.size) { emptySet<String>() }) }
    // State: whether to show answer feedback (true after submitting)
    var showResults by remember { mutableStateOf(false) }
    // State: whether all questions were answered correctly
    var allCorrect by remember { mutableStateOf(false) }

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

            content.questions.forEachIndexed { index, question ->
                QuestionItem(
                    question = question,
                    selectedOptions = selectedAnswers[index],
                    showResult = showResults,
                    onSelectionChange = { optionId ->
                        selectedAnswers = selectedAnswers.toMutableList().apply {
                            this[index] = if (question.isMultiSelect) {
                                if (selectedAnswers[index].contains(optionId)) {
                                    selectedAnswers[index] - optionId
                                } else {
                                    selectedAnswers[index] + optionId
                                }
                            } else {
                                setOf(optionId)
                            }
                        }
                        // Reset results when user changes answer
                        showResults = false
                        allCorrect = false
                    }
                )

                if (index < content.questions.size - 1) {
                    HorizontalDivider(modifier = Modifier.padding(vertical = 24.dp))
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (allCorrect) {
            Button(
                onClick = onNext,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            ) {
                Text(
                    text = "Continue",
                    style = MaterialTheme.typography.titleMedium
                )
            }
        } else {
            Button(
                onClick = {
                    showResults = true
                    allCorrect = content.questions.indices.all { index ->
                        isAnswerCorrect(content.questions[index], selectedAnswers[index])
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                enabled = selectedAnswers.all { it.isNotEmpty() }
            ) {
                Text(
                    text = "Submit Answers",
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }
    }
}

/**
 * Displays a single question with its answer options.
 *
 * @param question The question to display
 * @param selectedOptions Set of currently selected option IDs
 * @param showResult Whether to show answer feedback (correct/incorrect)
 * @param onSelectionChange Callback when an option is selected/deselected
 */
@Composable
fun QuestionItem(
    question: Question,
    selectedOptions: Set<String>,
    showResult: Boolean,
    onSelectionChange: (String) -> Unit
) {
    Column {
        Text(
            text = question.questionText,
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(bottom = 12.dp)
        )

        question.options.forEach { option ->
            val isSelected = selectedOptions.contains(option.id)

            // Show correctness if results are shown and this option was selected
            val showCorrectness = if (showResult && isSelected) {
                option.isCorrect
            } else if (showResult && !isSelected && option.isCorrect) {
                // Also show correct answers that weren't selected
                true
            } else {
                null
            }

            AnswerOptionItem(
                option = option,
                isSelected = isSelected,
                isCorrect = showCorrectness,
                onClick = { onSelectionChange(option.id) },
                isMultiSelect = question.isMultiSelect,
                showResult = showResult
            )

            Spacer(modifier = Modifier.height(8.dp))
        }

        if (showResult) {
            val isCorrect = isAnswerCorrect(question, selectedOptions)
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp),
                colors = CardDefaults.cardColors(
                    containerColor = if (isCorrect) {
                        Color(0xFFE8F5E9)
                    } else {
                        Color(0xFFFFEBEE)
                    }
                )
            ) {
                Text(
                    text = if (isCorrect) "✓ Correct!" else "✗ Incorrect - Please review and try again",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.SemiBold,
                    color = if (isCorrect) Color(0xFF2E7D32) else Color(0xFFC62828),
                    modifier = Modifier.padding(12.dp)
                )
            }
        }
    }
}

/**
 * Displays a single answer option as a clickable card.
 *
 * States:
 * - Default: Outlined card with option text
 * - Selected: Highlighted background
 * - Correct (after submit): Green border and background
 * - Incorrect (after submit): Red border and background
 *
 * @param option The answer option to display
 * @param isSelected Whether this option is currently selected
 * @param isCorrect Whether this option is correct (null if not showing results)
 * @param onClick Callback when the option is clicked
 * @param isMultiSelect Whether this is a multi-select question (checkbox vs radio button)
 * @param showResult Whether to show answer feedback
 */
@Composable
fun AnswerOptionItem(
    option: AnswerOption,
    isSelected: Boolean,
    isCorrect: Boolean?,
    onClick: () -> Unit,
    isMultiSelect: Boolean,
    showResult: Boolean = false
) {
    val borderColor = when {
        isCorrect == true -> Color(0xFF4CAF50)
        isCorrect == false -> Color(0xFFF44336)
        isSelected -> MaterialTheme.colorScheme.primary
        else -> MaterialTheme.colorScheme.outline
    }

    val backgroundColor = when {
        isCorrect == true -> Color(0xFFE8F5E9)
        isCorrect == false -> Color(0xFFFFEBEE)
        isSelected -> MaterialTheme.colorScheme.primaryContainer
        else -> MaterialTheme.colorScheme.surface
    }

    OutlinedCard(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
        border = BorderStroke(2.dp, borderColor),
        colors = CardDefaults.outlinedCardColors(
            containerColor = backgroundColor
        )
    ) {
        Row(
            modifier = Modifier.padding(16.dp)
        ) {
            if (isMultiSelect) {
                Checkbox(
                    checked = isSelected,
                    onCheckedChange = { onClick() }
                )
            } else {
                RadioButton(
                    selected = isSelected,
                    onClick = onClick
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            Text(
                text = option.text,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

/**
 * Checks if the selected options for a question are correct.
 *
 * @param question The question to check
 * @param selectedOptions The set of selected option IDs
 * @return true if the answer is completely correct, false otherwise
 */
fun isAnswerCorrect(question: Question, selectedOptions: Set<String>): Boolean {
    val correctOptions = question.options.filter { it.isCorrect }.map { it.id }.toSet()
    return selectedOptions == correctOptions
}
