package com.example.cpre5300project.data

/**
 * Sealed class representing different types of page content in the app.
 * Each page type has its own data structure and will be rendered differently.
 */
sealed class PageContent {
    /**
     * Welcome screen - the first page users see when opening the app.
     *
     * @property title The welcome title/heading
     * @property content The welcome message body
     */
    data class Welcome(
        val title: String,
        val content: String
    ) : PageContent()

    /**
     * Introduction screen - explains the purpose and structure of the app.
     *
     * @property content The introduction text
     */
    data class Introduction(
        val content: String
    ) : PageContent()

    /**
     * Education screen - teaches users about a specific security topic.
     * Contains multiple sections, each with a heading and content.
     *
     * @property title The page title
     * @property sections List of education sections (each with heading and content)
     */
    data class Education(
        val title: String,
        val sections: List<EducationSection>
    ) : PageContent()

    /**
     * Test screen - quizzes users on what they learned in the previous education page.
     * Users must answer all questions correctly to proceed.
     *
     * @property title The test page title
     * @property questions List of questions to answer
     */
    data class Test(
        val title: String,
        val questions: List<Question>
    ) : PageContent()

    /**
     * Completion screen - final page thanking users and showing citations.
     *
     * @property title The completion title
     * @property content Thank you message and key takeaways
     * @property citationsPlaceholder References and citations section
     */
    data class Completion(
        val title: String,
        val content: String,
        val citationsPlaceholder: String
    ) : PageContent()
}

/**
 * Represents a section within an education page.
 *
 * @property heading The section heading/title
 * @property content The section body text
 */
data class EducationSection(
    val heading: String,
    val content: String
)
