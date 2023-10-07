package com.example.quizthink

object TechAndGadgetQuestionsSource {
    var techGadgetQuesList = mutableListOf<TechAndGadgetQuesFormat>(
        TechAndGadgetQuesFormat(
            "What does the term \"IoT\" stand for in the context of technology and gadgets?",
            listOf("A: Internet of Text", "B: Internet of Televisions", "C: Internet of Things", "D: Internet of Tablets"),
            2
        ),TechAndGadgetQuesFormat(
            "Which company is known for its line of smartphones with the \"iPhone\" brand?",
            listOf("A: Samsung", "B: Google", "C: Apple", "D: Microsoft"),
            2
        ),TechAndGadgetQuesFormat(
            "What does VR stand for in the context of technology and gadgets?",
            listOf("A: Virtual Reality", "B: Video Recorder", "C: Voice Recognition", "D: Visual Rendering"),
            0
        ),TechAndGadgetQuesFormat(
            "Which gadget is designed specifically for reading digital books and documents, typically using E-ink technology for a paper-like display?",
            listOf("A: Tablet", "B: Laptop", "C: Smartphone", "D: E-reader"),
            3
        ),
    )
}

object CodingQuestionSource{
    var codingQuesList = mutableListOf<CodingQuesFormat>(
        CodingQuesFormat(
            "Which of the following is true about Kotlin?",
            listOf("A: It is a statically-typed language", "B: It is a purely functional programming language",
                "C: It is a superset of Java", "D: It is only used for server-side programming"),
            0
        ),
        CodingQuesFormat(
            "What is Kotlin primarily used for?",
            listOf("A:  Web development", "B: Mobile app development", "C: Game development", "D: Data analysis"),
            1
        ),
        CodingQuesFormat(
            "In Kotlin, what keyword is used to declare a variable that can be modified after it is initialized?",
            listOf("A: val", "B: const", "C: var", "D: let"),
            2
        ),
        CodingQuesFormat(
            "Which of the following is NOT a feature of Kotlin?",
            listOf("A: Null safety", "B: Extension functions", "C: Checked exceptions", "D: Smart casts"),
            2
        ),
        CodingQuesFormat(
            "What is the Kotlin standard library function used to iterate through a collection and apply a given lambda expression to each element?",
            listOf("A: map", "B: filter", "C: forEach", "D: reduce"),
            2
        ),

    )
}

object SocietyQuesSource{
    var societyQuesList = mutableListOf <SocietyQuesFormat>(
        SocietyQuesFormat(
            "মাস্টারছিপ কোথায় ব্যবহার হয়?",
            listOf("A: সড়কে", "B: সামুদ্রে", "C: আকাশে", "D: বসার ঘরে"),
            3
        ),SocietyQuesFormat(
            "বাংলাদেশের রাষ্ট্রীয় পতাকার রঙ কি?",
            listOf("A: লাল ও সাদা", "B: সবুজ ও সাদা", "C: লাল, সবুজ", "D: সবুজ, লাল, ও বাদামি"),
            2
        ),SocietyQuesFormat(
            "বাংলা বর্ণমালায় কতটি স্বরবর্ণ আছে?",
            listOf("A: 9", "B: 10", "C: 11", "D: 12"),
            2
        ),SocietyQuesFormat(
            "বিশ্বের সবচেয়ে বড় নদী কোনটি?",
            listOf("A: নীল", "B: আমাজন", "C: গঙ্গা", "D: মিসিসিপি"),
            0
        ),SocietyQuesFormat(
            "রবীন্দ্রনাথ ঠাকুরের কোন কাব্য রচনা নীতিনাট্যের সৃজনক কাব্য হিসেবে প্রশংসিত হয়?",
            listOf("A: গীতাঞ্জলি", "B: মুকুট", "C: বাল্মীকি প্রতিক্রান্ত", "D: ছিলপুড়"),
            2
        ),SocietyQuesFormat(
            "বাংলাদেশের কোন পর্বতমালা সর্বোচ্চ পর্বত পিক দিয়ে অভিযানিত?",
            listOf("A: চিত্রদুর্গ পর্বতমালা", "B: তাজিংডং", "C: কেওক্রাডং পর্বতমালা", "D: সুন্দরবন পর্বতমালা"),
            1
        ),
    )
}