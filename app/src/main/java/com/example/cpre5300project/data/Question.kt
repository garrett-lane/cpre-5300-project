package com.example.cpre5300project.data

/**
 * Represents a question in a test/quiz page.
 *
 * @property questionText The text of the question to display to the user
 * @property options List of answer options for this question
 * @property isMultiSelect Whether this question allows multiple answers to be selected (checkbox)
 *                         or only one answer (radio button). Defaults to false (single select).
 */
data class Question(
    val questionText: String,
    val options: List<AnswerOption>,
    val isMultiSelect: Boolean = false
)

/**
 * Represents a single answer option for a question.
 *
 * @property id Unique identifier for this option (e.g., "A", "B", "C", "D")
 * @property text The display text for this answer option
 * @property isCorrect Whether this option is a correct answer
 */
data class AnswerOption(
    val id: String,
    val text: String,
    val isCorrect: Boolean
)
