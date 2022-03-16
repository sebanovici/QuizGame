import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Quiz implements ActionListener {

    String[] questions = {

            "What you do to improve coding skills?",
            "What programming language do you study?",
            "How many application do you build?",
            "Who is credited with creating Java"
    };
    String [][] options = {

            {"Coding","Playing videogames","Watching movies","Procrastinate on your goals"},
            {"Java","C++","JavaScript" , "Python"},
            {"none","not enough","too many","i don't have time for this"},
            {"Steve Jobs","Bill Gates","Dalai Lama","James Gosling"}
    };
    char [] answers = {

            'A',
            'A',
            'B',
            'D'
    };
    char guess;
    char answer;
    int index;
    int correct_guesses = 0;
    int total_questions = questions.length;
    int result;
    int seconds = 10;

    JFrame frame = new JFrame();
    JTextField textField = new JTextField();
    JTextArea textArea = new JTextArea();
    JButton buttonA = new JButton();
    JButton buttonB = new JButton();
    JButton buttonC = new JButton();
    JButton buttonD = new JButton();
    JLabel answer_labelA = new JLabel();
    JLabel answer_labelB = new JLabel();
    JLabel answer_labelC = new JLabel();
    JLabel answer_labelD = new JLabel();
    JLabel time_label = new JLabel();
    JLabel seconds_left = new JLabel();
    JTextField numbers_right = new JTextField();
    JTextField percentage = new JTextField();


    Timer timer = new Timer(1000, new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e){
            seconds--;
            seconds_left.setText(String.valueOf(seconds));
            if (seconds<=0){
                displayAnswer();
            }

        }
    });

    public Quiz(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650,650);
        frame.getContentPane().setBackground(new Color(50,50,60));
        frame.setLayout(null);
        frame.setResizable(true);

        textField.setBounds(0,0,650,60);
        textField.setBackground(new Color(20,20,30));
        textField.setForeground(new Color(25,255,9));
        textField.setFont(new Font("Ink Free",Font.ITALIC,30));
        textField.setBorder(BorderFactory.createBevelBorder(1));
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setEditable(false);
        textField.setText("QUIZ Game");

        textArea.setBounds(0,50,650,50);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBackground(new Color(60,20,30));
        textArea.setForeground(new Color(25,255,9));
        textArea.setFont(new Font("MV Boli",Font.ITALIC,25));
        textArea.setBorder(BorderFactory.createBevelBorder(1));
        textArea.setEditable(false);
        textArea.setText("Display questions");

        buttonA.setBounds(0,100,100,100);
        buttonA.setFont(new Font("MV Boli", Font.ITALIC,35));
        buttonA.setFocusable(false);
        buttonA.addActionListener(this);
        buttonA.setText("A");

        buttonB.setBounds(0,200,100,100);
        buttonB.setFont(new Font("MV Boli", Font.ITALIC,35));
        buttonB.setFocusable(false);
        buttonB.addActionListener(this);
        buttonB.setText("B");

        buttonC.setBounds(0,300,100,100);
        buttonC.setFont(new Font("MV Boli", Font.ITALIC,35));
        buttonC.setFocusable(false);
        buttonC.addActionListener(this);
        buttonC.setText("C");

        buttonD.setBounds(0,400,100,100);
        buttonD.setFont(new Font("MV Boli", Font.ITALIC,35));
        buttonD.setFocusable(false);
        buttonD.addActionListener(this);
        buttonD.setText("D");

        answer_labelA.setBounds(125,100,500,100);
        answer_labelA.setBackground(new Color(50,50,50));
        answer_labelA.setForeground(new Color(25,255,9));
        answer_labelA.setFont(new Font("MV Boli",Font.BOLD,35));

        answer_labelB.setBounds(125,200,500,100);
        answer_labelB.setBackground(new Color(50,50,50));
        answer_labelB.setForeground(new Color(25,255,9));
        answer_labelB.setFont(new Font("MV Boli",Font.BOLD,35));

        answer_labelC.setBounds(125,300,500,100);
        answer_labelC.setBackground(new Color(50,50,50));
        answer_labelC.setForeground(new Color(25,255,9));
        answer_labelC.setFont(new Font("MV Boli",Font.BOLD,35));

        answer_labelD.setBounds(125,400,500,100);
        answer_labelD.setBackground(new Color(50,50,50));
        answer_labelD.setForeground(new Color(25,255,9));
        answer_labelD.setFont(new Font("MV Boli",Font.BOLD,35));

        seconds_left.setBounds(535,510,100,100);
        seconds_left.setBackground(new Color(25,25,25));
        seconds_left.setForeground(new Color(255,0,50));
        seconds_left.setFont(new Font("MV Boli",Font.BOLD,65));
        seconds_left.setBorder(BorderFactory.createBevelBorder(2));
        seconds_left.setOpaque(true);
        seconds_left.setHorizontalAlignment(JTextField.CENTER);
        seconds_left.setText(String.valueOf(seconds));

        time_label.setBounds(535,475,100,25);
        time_label.setBackground(new Color(50,50,50));
        time_label.setForeground(new Color(255,255,9));
        time_label.setFont(new Font("MV Boli",Font.PLAIN,25));
        time_label.setHorizontalAlignment(JTextField.CENTER);
        time_label.setText("Timer: ");

        numbers_right.setBounds(225,225,200,100);
        numbers_right.setBackground(new Color(25,120,25));
        numbers_right.setForeground(new Color(25,255,9));
        numbers_right.setFont(new Font("MV Boli",Font.BOLD,50));
        numbers_right.setBorder(BorderFactory.createBevelBorder(2));
        numbers_right.setHorizontalAlignment(JTextField.CENTER);
        numbers_right.setEditable(false);

        percentage.setBounds(225,325,200,100);
        percentage.setBackground(new Color(25,70,25));
        percentage.setForeground(new Color(25,255,9));
        percentage.setFont(new Font("MV Boli",Font.BOLD,50));
        percentage.setBorder(BorderFactory.createBevelBorder(1));
        percentage.setHorizontalAlignment(JTextField.CENTER);
        percentage.setEditable(false);



        frame.add(time_label);
        frame.add(seconds_left);
        frame.add(answer_labelA);
        frame.add(answer_labelB);
        frame.add(answer_labelC);
        frame.add(answer_labelD);
        frame.add(buttonA);
        frame.add(buttonB);
        frame.add(buttonC);
        frame.add(buttonD);
        frame.add(textArea);
        frame.add(textField);
        frame.setVisible(true);

        nextQuestion();
    }
    public void nextQuestion(){
        if (index>=total_questions){
            results();
        }
        else {
            textField.setText("Question " + (index +1));
            textArea.setText(questions[index]);
            answer_labelA.setText(options[index][0]);
            answer_labelB.setText(options[index][1]);
            answer_labelC.setText(options[index][2]);
            answer_labelD.setText(options[index][3]);
            timer.start();

        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        if (e.getSource()==buttonA){
            answer = 'A';
            if (answer == answers[index]){
                correct_guesses++;
            }
        }
        if (e.getSource()==buttonB){
            answer = 'B';
            if (answer == answers[index]){
                correct_guesses++;
            }
        }
        if (e.getSource()==buttonC){
            answer = 'C';
            if (answer == answers[index]){
                correct_guesses++;
            }
        }
        if (e.getSource()==buttonD){
            answer = 'D';
            if (answer == answers[index]){
                correct_guesses++;
            }
        }
        displayAnswer();
    }

    public void displayAnswer(){
        timer.stop();
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        if (answers[index] !='A')
            answer_labelA.setForeground(new Color(250,0,9));
        if (answers[index] !='B')
            answer_labelB.setForeground(new Color(250,0,9));
        if (answers[index] !='C')
            answer_labelC.setForeground(new Color(250,0,9));
        if (answers[index] !='D')
            answer_labelD.setForeground(new Color(250,0,9));

        Timer pause = new Timer(2000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e){

                answer_labelA.setForeground(new Color(25,255,0));
                answer_labelB.setForeground(new Color(25,255,0));
                answer_labelC.setForeground(new Color(25,255,0));
                answer_labelD.setForeground(new Color(25,255,0));

                answer = ' ';
                seconds = 10;
                seconds_left.setText(String.valueOf(seconds));
                buttonA.setEnabled(true);
                buttonB.setEnabled(true);
                buttonC.setEnabled(true);
                buttonD.setEnabled(true);
                index++;
                nextQuestion();
            }
        });
        pause.setRepeats(false);
        pause.start();

    }
    public void results(){

        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        result = (int)((correct_guesses/(double)total_questions) * 100);

        textField.setText("RESULTS");
        textArea.setText("");
        answer_labelA.setText("");
        answer_labelB.setText("");
        answer_labelC.setText("");
        answer_labelD.setText("");

        numbers_right.setText("(" +correct_guesses+"/" +total_questions + ")");
        percentage.setText(result+ " %");

        frame.add(percentage);
        frame.add(numbers_right);
    }
}
