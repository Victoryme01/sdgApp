package bbc.sdg.sdgapp;

public class QuestionLibrary {

    private String mQuestions[] = {
            "which number comes in the following series ? 10 50 250 1250__?__",
            "Free is to imprison as Forgive is to_____?",
            "My Mother is Sister of your Brother,what relation m i to you?",
            "Spot out the stranger in the following?"
    };

    private String mChoices[][] = {
            {"1350", "6250", "6500", "1550"},
            {"Accuse", "Accept", "Condemn", "Punish"},
            {"Uncle", "Brother", "Cousin", "Nephew"},
            {"Atheist", "Godly", "Holy", "Pious"}

    };
    private String mCorrectAnswers[] = {
            "6250",
            "Punish",
            "Cousin",
            "Atheist"
    };

    public String getQuestion(int a) {
        String question = mQuestions[a];
        return question;
    }

    public String getChoice1(int a) {
        String choice0 = mChoices[a][0];
        return choice0;
    }

    public String getChoice2(int a) {
        String choice1 = mChoices[a][1];
        return choice1;
    }

    public String getChoice3(int a) {
        String choice2 = mChoices[a][2];
        return choice2;
    }

    public String getChoice4(int a) {
        String choice3 = mChoices[a][3];
        return choice3;
    }

    public String getCorrectAnswer(int a) {
        String answer = mCorrectAnswers[a];
        return answer;
    }
}