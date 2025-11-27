package com.example.cpre5300project.data

/**
 * Contains all the content for my home network security education app.
 *
 * This object holds a list of pages that users progress through sequentially
 * Each education page is followed by a test page on the same topic.
 */
object AppContent {
    /**
     * Ordered list of all pages in the app.
     * Users navigate through these pages sequentially from index 0 to the end.
     */
    val pages = listOf(
        // Page 1: Welcome Screen
        PageContent.Welcome(
            title = "Welcome to Secure Your SmartHome",
            content = """
                Home networks are a central part of modern life, and protecting them is essential.

                This app will guide you through the key steps needed to secure your router, manage your Wi-Fi settings, and reduce common security risks.

                You'll learn best practices and then apply them through short decision-based exercises.

                Tap Start to begin.
            """.trimIndent()
        ),

        // Page 2: Introduction
        PageContent.Introduction(
            content = """
                Your router controls how all of your devices connect to the internet.

                Misconfigured settings or outdated security options can make your network vulnerable to unauthorized access.

                This walkthrough will explain important security principles in simple terms. After each lesson, you'll answer a few questions or make decisions based on what you've learned [3]. If you select an unsafe option, you can review the material and try again.

                Let's begin with securing your router's basic settings.
            """.trimIndent()
        ),

        // Page 3a: Education — Router Credentials & SSID
        PageContent.Education(
            title = "Router Credentials & SSID",
            sections = listOf(
                EducationSection(
                    heading = "1. Changing the Router Login Username & Password",
                    content = """
                        Most routers come with a default administrator username and password. These default credentials are easy for attackers to guess because they are published online for nearly every router model [1].

                        Changing the admin login protects your router's configuration page from unauthorized access. Your new password should:
                        • Be at least 12 characters long
                        • Avoid personal information and common words
                        • Not be reused from other accounts
                    """.trimIndent()
                ),
                EducationSection(
                    heading = "2. Changing the Default SSID",
                    content = """
                        The SSID is the name of your Wi-Fi network. Leaving the default SSID or including personal details can expose unnecessary information [1].

                        Avoid:
                        • Your name, address, apartment number
                        • The router brand or model (could allow others to know vulnerabilities it has)
                        • Anything that identifies you or your family

                        A neutral name keeps your network private and avoids giving attackers useful hints.
                    """.trimIndent()
                )
            )
        ),

        // Page 3b: Test — Credentials & SSID
        PageContent.Test(
            title = "Test: Credentials & SSID",
            questions = listOf(
                Question(
                    questionText = "1. Choose a Strong Admin Password\n\nSelect the option that best follows strong password practices. Avoid short, predictable, or reused passwords.",
                    options = listOf(
                        AnswerOption("A", "Sunset123!", false),
                        AnswerOption("B", "GarrettHomeWiFi2025", false),
                        AnswerOption("C", "river-train-laptop-orange", true),
                        AnswerOption("D", "P@ssword!", false)
                    )
                ),
                Question(
                    questionText = "2. Pick an Acceptable SSID\n\nChoose the network name that does not reveal personal details or the router model.",
                    options = listOf(
                        AnswerOption("A", "SmithFamily_Unit12", false),
                        AnswerOption("B", "NETGEAR_AX6000", false),
                        AnswerOption("C", "HomeNetwork_5G", true),
                        AnswerOption("D", "1234 Oak Street WiFi", false)
                    )
                )
            )
        ),

        // Page 4a: Education — Wi-Fi Passphrase & Encryption
        PageContent.Education(
            title = "Wi-Fi Passphrase & Encryption",
            sections = listOf(
                EducationSection(
                    heading = "1. Wi-Fi Passphrase",
                    content = """
                        Your Wi-Fi password controls who can join your network. A weak password allows intruders onto your home Wi-Fi [1].

                        The Cybersecurity and Infrastructure Security Agency (CISA) recommends creating a passphrase using 5–7 unrelated words, totaling at least 16 characters [1].

                        This makes the password long, memorable, and hard to guess.

                        Do not reuse your Wi-Fi password for other logins.
                    """.trimIndent()
                ),
                EducationSection(
                    heading = "2. Wi-Fi Encryption",
                    content = """
                        Your router offers several encryption types. Only two provide strong protection today [1][4]:
                        • WPA3 Personal — preferred
                        • WPA2 AES/PSK — acceptable if WPA3 isn't available

                        Avoid older standards like WEP or WPA/TKIP. These can be cracked quickly with publicly available tools.
                    """.trimIndent()
                )
            )
        ),

        // Page 4b: Test — Wi-Fi Settings
        PageContent.Test(
            title = "Test: Wi-Fi Settings",
            questions = listOf(
                Question(
                    questionText = "1. Choose a Strong Wi-Fi Password\n\nSelect the passphrase that uses long, unrelated words and does not reuse personal information.",
                    options = listOf(
                        AnswerOption("A", "ISUcyberSecurity2024!", false),
                        AnswerOption("B", "BeachSunset!55", false),
                        AnswerOption("C", "coffee-lawn-bridge-signal-cloud", true),
                        AnswerOption("D", "GarrettsWiFi123", false)
                    )
                ),
                Question(
                    questionText = "2. Choose a Good Encryption Standard\n\nSelect WPA3 Personal, or WPA2 AES/PSK if WPA3 is not supported.",
                    options = listOf(
                        AnswerOption("A", "WEP", false),
                        AnswerOption("B", "WPA2-TKIP", false),
                        AnswerOption("C", "WPA3 Personal", true),
                        AnswerOption("D", "Open (No Password)", false)
                    )
                )
            )
        ),

        // Page 5a: Education — Remote Access, WPS, and UPnP
        PageContent.Education(
            title = "Remote Access, WPS, and UPnP",
            sections = listOf(
                EducationSection(
                    heading = "1. Disable Remote Management",
                    content = """
                        Remote management allows the router to be accessed from outside your home network [1].

                        Unless you specifically need this feature, keeping it enabled increases your risk of unauthorized access.

                        It is best to disable remote management.
                    """.trimIndent()
                ),
                EducationSection(
                    heading = "2. Disable WPS",
                    content = """
                        Wi-Fi Protected Setup (WPS) was designed to simplify device connection. Unfortunately, the PIN-based method can be brute-forced easily. This makes WPS a security risk on most home networks [1].

                        Disabling WPS is recommended.
                    """.trimIndent()
                ),
                EducationSection(
                    heading = "3. Disable UPnP",
                    content = """
                        Universal Plug and Play (UPnP) lets devices automatically open ports on your router. While convenient, it can also allow malware or unwanted applications to open ports without your knowledge [1].

                        For safety, UPnP should be disabled unless you have a specific need for it.
                    """.trimIndent()
                )
            )
        ),

        // Page 5b: Test — Disable Unsafe Features
        PageContent.Test(
            title = "Test: Disable Unsafe Features",
            questions = listOf(
                Question(
                    questionText = "Choose the settings that should be turned off:",
                    options = listOf(
                        AnswerOption("A", "Remote Management", true),
                        AnswerOption("B", "WPS (Wi-Fi Protected Setup)", true),
                        AnswerOption("C", "UPnP (Universal Plug and Play)", true),
                        AnswerOption("D", "WPA3 Personal", false),
                        AnswerOption("E", "Guest Network", false),
                        AnswerOption("F", "Firewall / SPI Firewall", false),
                        AnswerOption("G", "DHCP Server", false),
                        AnswerOption("H", "Wi-Fi Encryption (WPA2/WPA3)", false)
                    ),
                    isMultiSelect = true
                )
            )
        ),

        // Page 6a: Education — Physical Security & Guest Network Use
        PageContent.Education(
            title = "Physical Security & Guest Network Use",
            sections = listOf(
                EducationSection(
                    heading = "1. Store the Router in a Secure, Private Location",
                    content = """
                        A router should be placed somewhere that isn't easily accessible to guests or the public [1].

                        Someone with physical access could reset it, view the default password label, or connect unauthorized devices.

                        Keep it in a safe, indoor location where only household members can reach it.
                    """.trimIndent()
                ),
                EducationSection(
                    heading = "2. Use a Guest Network for IoT and Visitors",
                    content = """
                        Most routers support creating a separate guest network [1].

                        Use this network for:
                        • Smart home devices (Internet of Things)
                        • TVs
                        • Smart speakers
                        • Cameras
                        • Visitors' devices

                        Guest networks isolate low-trust devices and reduce the chance of an intruder accessing personal computers or smartphones.
                    """.trimIndent()
                )
            )
        ),

        // Page 6b: Test — Physical & Network Separation
        PageContent.Test(
            title = "Test: Physical & Network Separation",
            questions = listOf(
                Question(
                    questionText = "1. Choose Which Items Go on the Guest Network\n\nSort devices into either the main network (trusted/personal) or the guest network (IoT and visitors). Select all that should go on the GUEST network:",
                    options = listOf(
                        AnswerOption("A", "Smart Speakers", true),
                        AnswerOption("B", "Tablets", false),
                        AnswerOption("C", "Personal laptops", false),
                        AnswerOption("D", "A guest's laptop", true),
                        AnswerOption("E", "Work/school computers", false),
                        AnswerOption("F", "Security Cameras", true),
                        AnswerOption("G", "Personal smartphones", false),
                        AnswerOption("H", "Smart TVs", true)
                    ),
                    isMultiSelect = true
                ),
                Question(
                    questionText = "2. Choose the Best Place to Keep a Router\n\nSelect the most secure indoor location with limited public access.",
                    options = listOf(
                        AnswerOption("A", "On a windowsill in the living room, near the front door.", false),
                        AnswerOption("B", "On a high shelf in a central office room inside the home.", true),
                        AnswerOption("C", "On the balcony or patio for better signal outside.", false),
                        AnswerOption("D", "In an unlocked hallway cabinet accessible to anyone in the building.", false)
                    )
                )
            )
        ),

        // Page 7a: Education — Maintenance, Firmware, Firewall
        PageContent.Education(
            title = "Maintenance, Firmware, Firewall",
            sections = listOf(
                EducationSection(
                    heading = "1. Schedule Weekly Reboots",
                    content = """
                        Some routers perform better when rebooted periodically [2].

                        If your router supports scheduled reboots, selecting a weekly time can improve stability.
                    """.trimIndent()
                ),
                EducationSection(
                    heading = "2. Update Firmware",
                    content = """
                        Router firmware updates include important security patches and performance improvements. Not updating your router leaves you exposed to known vulnerabilities [1].

                        Always apply firmware updates when they are available.
                    """.trimIndent()
                ),
                EducationSection(
                    heading = "3. Enable Firewall Options",
                    content = """
                        Most routers include firewall protections such as [2]:
                        • Stateful Packet Inspection (SPI)
                        • Blocking inbound traffic
                        • Preventing unauthorized connections

                        These features help protect your home from external attacks and should remain enabled.
                    """.trimIndent()
                )
            )
        ),

        // Page 7b: Test — Maintenance Settings
        PageContent.Test(
            title = "Test: Maintenance Settings",
            questions = listOf(
                Question(
                    questionText = "Choose the options that improve network security:",
                    options = listOf(
                        AnswerOption("A", "Enabling firewall protections", true),
                        AnswerOption("B", "Leaving WPS enabled", false),
                        AnswerOption("C", "Applying the firmware update", true),
                        AnswerOption("D", "Using an easily guessable Wi-Fi password", false),
                        AnswerOption("E", "A consistent weekly reboot schedule", true),
                        AnswerOption("F", "Disabling WPA3 encryption", false),
                        AnswerOption("G", "Leaving UPnP enabled", false),
                        AnswerOption("H", "Using the default router password", false)
                    ),
                    isMultiSelect = true
                )
            )
        ),

        // Page 8a: Education — Choosing a Secure Router
        PageContent.Education(
            title = "Choosing a Secure Router",
            sections = listOf(
                EducationSection(
                    heading = "When shopping for a new router, look for:",
                    content = """
                        1. Wi-Fi CERTIFIED Logo
                        This indicates the device meets modern security and performance standards [4].

                        2. WPA3 Support
                        WPA3 is the current best-practice wireless security protocol [4].

                        3. Multiple SSIDs
                        A good router allows at least two networks:
                        • A primary network
                        • A guest network

                        4. Wi-Fi Standard
                        Look for Wi-Fi 6 or Wi-Fi 6E for up-to-date performance and security support.

                        A router with these features will provide a safer and more reliable network experience.
                    """.trimIndent()
                )
            )
        ),

        // Page 8b: Test — Choose a Good Router
        PageContent.Test(
            title = "Test: Choose a Good Router",
            questions = listOf(
                Question(
                    questionText = "From the options shown, select the routers that includes:\n• WPA3\n• Multiple SSIDs\n• Wi-Fi CERTIFIED\n• A modern Wi-Fi version",
                    options = listOf(
                        AnswerOption(
                            "A",
                            "NetWave AX6000\nWPA3 support\nMultiple SSIDs\nWi-Fi CERTIFIED\nWi-Fi 6",
                            true
                        ),
                        AnswerOption(
                            "B",
                            "SpeedLink 3000\nWPA2 only\nSingle SSID\nNot Wi-Fi CERTIFIED\nWi-Fi 5",
                            false
                        ),
                        AnswerOption(
                            "C",
                            "HomeSecure X1\nWPA3 support\nMultiple SSIDs\nWi-Fi CERTIFIED\nWi-Fi 6E",
                            true
                        ),
                        AnswerOption(
                            "D",
                            "RouterMax Basic\nWEP/WPA only\nSingle SSID\nNot Wi-Fi CERTIFIED\nWi-Fi 4",
                            false
                        )
                    ),
                    isMultiSelect = true
                )
            )
        ),

        // Final page: Completion
        PageContent.Completion(
            title = "Thank You for Learning!",
            content = """
                Congratulations on completing this home network security walkthrough!

                You've learned essential practices for securing your router and protecting your home network. By applying these principles, you're taking important steps to safeguard your devices and personal information.

                Remember:
                • Keep your router firmware updated
                • Use strong, unique passwords
                • Regularly review your security settings
                • Separate trusted devices from IoT devices

                Stay secure!
            """.trimIndent(),
            citationsPlaceholder = """
                References and Citations:

                Security Sources:

                [1] "Module 5: Securing Your Home Wi-Fi | CISA," Cybersecurity and Infrastructure Security Agency CISA, 2025. https://www.cisa.gov/audiences/high-risk-communities/projectupskill/module5 (accessed Oct. 13, 2025).

                [2] National Security Agency, "Best Practices for Securing Your Home Network," Feb. 2023. Available: https://media.defense.gov/2023/Feb/22/2003165170/-1/-1/0/CSI_BEST_PRACTICES_FOR_SECURING_YOUR_HOME_NETWORK.PDF

                [3] E. office, "Making technology work for adult learners: our 6 key research findings - European Association for the Education of Adults," European Association for the Education of Adults, Sep. 04, 2025. https://eaea.org/2025/09/04/making-technology-work-for-adult-learners-our-6-key-research-findings/ (accessed Oct. 13, 2025).

                [4] Wi-Fi Alliance, "WPA3 Deployment Options Highlights," Nov. 2024. Available: https://www.wi-fi.org/system/files/WPA3_Deployment_Options_Highlights_20241125.pdf
            """.trimIndent()
        )
    )
}
