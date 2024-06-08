import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class QuizGame extends JFrame {
    private JPanel questionPanel;
    private JLabel questionLabel;
    private JRadioButton[] options;
    private ButtonGroup optionsGroup;
    private JButton nextButton;
    private int currentQuestionIndex;
    private int score;

    private ArrayList<String> questions = new ArrayList<>();
    private ArrayList<ArrayList<String>> optionsList = new ArrayList<>();
    private ArrayList<Integer> answers = new ArrayList<>();

    public QuizGame() {
        setTitle("Quiz Game");
        setSize(400, 300);
        setLayout(new BorderLayout());
        
        questionPanel = new JPanel();
        questionPanel.setLayout(new BoxLayout(questionPanel, BoxLayout.Y_AXIS));
        questionLabel = new JLabel("Question");
        questionPanel.add(questionLabel);

        options = new JRadioButton[4];
        optionsGroup = new ButtonGroup();
        for (int i = 0; i < options.length; i++) {
            options[i] = new JRadioButton();
            optionsGroup.add(options[i]);
            questionPanel.add(options[i]);
        }

        nextButton = new JButton("Next");
        nextButton.addActionListener(new NextButtonListener());

        add(questionPanel, BorderLayout.CENTER);
        add(nextButton, BorderLayout.SOUTH);

        loadQuestions();
        currentQuestionIndex = 0;
        score = 1;  // Initial score
        loadQuestion();
    }

    private void loadQuestions() {
        questions.add("What is the capital of France?");
        ArrayList<String> options1 = new ArrayList<>();
        options1.add("Paris");
        options1.add("London");
        options1.add("Rome");
        options1.add("Berlin");
        optionsList.add(options1);
        answers.add(0);

        questions.add("What is 2 + 2?");
        ArrayList<String> options2 = new ArrayList<>();
        options2.add("3");
        options2.add("4");
        options2.add("5");
        options2.add("6");
        optionsList.add(options2);
        answers.add(1);

        questions.add("What is the capital of Japan?");
        ArrayList<String> options3 = new ArrayList<>();
        options3.add("Tokyo");
        options3.add("Beijing");
        options3.add("Seoul");
        options3.add("Bangkok");
        optionsList.add(options3);
        answers.add(0);

        questions.add("What is the largest planet in our solar system?");
        ArrayList<String> options4 = new ArrayList<>();
        options4.add("Earth");
        options4.add("Jupiter");
        options4.add("Saturn");
        options4.add("Mars");
        optionsList.add(options4);
        answers.add(1);

        questions.add("Who wrote 'Hamlet'?");
        ArrayList<String> options5 = new ArrayList<>();
        options5.add("Charles Dickens");
        options5.add("J.K. Rowling");
        options5.add("William Shakespeare");
        options5.add("Jane Austen");
        optionsList.add(options5);
        answers.add(2);

        questions.add("What is the chemical symbol for water?");
        ArrayList<String> options6 = new ArrayList<>();
        options6.add("H2O");
        options6.add("O2");
        options6.add("CO2");
        options6.add("HO2");
        optionsList.add(options6);
        answers.add(0);

        questions.add("Who is known as the 'Father of Computers'?");
        ArrayList<String> options7 = new ArrayList<>();
        options7.add("Albert Einstein");
        options7.add("Isaac Newton");
        options7.add("Charles Babbage");
        options7.add("Nikola Tesla");
        optionsList.add(options7);
        answers.add(2);

        questions.add("What is the tallest mountain in the world?");
        ArrayList<String> options8 = new ArrayList<>();
        options8.add("K2");
        options8.add("Kangchenjunga");
        options8.add("Mount Everest");
        options8.add("Lhotse");
        optionsList.add(options8);
        answers.add(2);

        questions.add("What is the hardest natural substance on Earth?");
        ArrayList<String> options9 = new ArrayList<>();
        options9.add("Gold");
        options9.add("Iron");
        options9.add("Diamond");
        options9.add("Platinum");
        optionsList.add(options9);
        answers.add(2);

        questions.add("Who painted the Mona Lisa?");
        ArrayList<String> options10 = new ArrayList<>();
        options10.add("Vincent van Gogh");
        options10.add("Pablo Picasso");
        options10.add("Leonardo da Vinci");
        options10.add("Claude Monet");
        optionsList.add(options10);
        answers.add(2);
    }

    private void loadQuestion() {
        if (currentQuestionIndex < questions.size()) {
            questionLabel.setText(questions.get(currentQuestionIndex));
            ArrayList<String> currentOptions = optionsList.get(currentQuestionIndex);
            for (int i = 0; i < options.length; i++) {
                options[i].setText(currentOptions.get(i));
            }
            optionsGroup.clearSelection();
        } else {
            endQuiz();
        }
    }

    private void endQuiz() {
        JOptionPane.showMessageDialog(this, "Congratulations! You won " + score + " points.");
        System.exit(0);
    }

    private class NextButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int selectedAnswer = -1;
            for (int i = 0; i < options.length; i++) {
                if (options[i].isSelected()) {
                    selectedAnswer = i;
                    break;
                }
            }

            if (selectedAnswer == answers.get(currentQuestionIndex)) {
                score *= 2;  // Double the score for each correct answer
                currentQuestionIndex++;
                loadQuestion();
            } else {
                endQuiz();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            QuizGame frame = new QuizGame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
