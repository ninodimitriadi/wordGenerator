package com.example.wordgeneration;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private ChoiceBox <String> choice;
    @FXML
    private Spinner <Integer> sentence;
    @FXML
    private Spinner <Integer> words_min;
    @FXML
    private Spinner <Integer> words_max;
    @FXML
    private Spinner <Integer> char_min;
    @FXML
    private Spinner <Integer> char_max;
    @FXML
    private Button button;
    @FXML
    private Label text;
    @FXML
    public TextArea final_text;

    private String[] lang = {"Georgian", "English"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choice.getItems().addAll(lang);
        SpinnerValueFactory<Integer> ValueFactory1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100);
        SpinnerValueFactory<Integer> ValueFactory2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100);
        SpinnerValueFactory<Integer> ValueFactory3 = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100);
        SpinnerValueFactory<Integer> ValueFactory4 = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100);
        SpinnerValueFactory<Integer> ValueFactory5 = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100);
        ValueFactory1.setValue(1);
        ValueFactory2.setValue(1);
        ValueFactory3.setValue(1);
        ValueFactory4.setValue(1);
        ValueFactory5.setValue(1);
        words_min.setValueFactory(ValueFactory1);
        words_max.setValueFactory(ValueFactory2);
        char_min.setValueFactory(ValueFactory3);
        char_max.setValueFactory(ValueFactory4);
        sentence.setValueFactory(ValueFactory5);
    }

    @FXML
    protected void onButtonClick() {
        int word = new Random().nextInt(words_max.getValue() + 1 - words_min.getValue()) + words_min.getValue();
        int character = new Random().nextInt(char_max.getValue() + 1 - char_min.getValue()) + char_min.getValue();
        String lang = choice.getValue();
        String sent = Integer.toString(sentence.getValue());
        text.setText(lang + ", " + sent + " - sentence, " +
                word + " - word, " + character + " - character, ");


        String[] alphabet_en = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        String[] alphabet_ge = {"ა", "ბ", "გ", "დ", "ე", "ვ", "ზ", "თ", "ი", "კ", "ლ", "მ", "ნ", "ო", "პ", "ჟ", "რ", "ს", "ტ", "უ", "ფ", "ქ", "ღ", "ყ", "შ", "ჩ", "ც", "ძ", "წ", "ჭ", "ხ", "ჯ", "ჰ"};
        String sityva = "";
        String winadadeba = "";
        String text = "";
        if (lang == "English"){
            for (int i=0; i<sentence.getValue(); i++){
                for (int x= words_min.getValue(); x<word; x++){
                    for (int y=char_min.getValue(); y<character; y++){
                        sityva = sityva + alphabet_en[new Random().nextInt(alphabet_en.length)];
                    }
                    winadadeba = winadadeba + sityva + " ";
                }
                text = text + winadadeba + ". ";
            }
            final_text.setText(text);
        }
        else {
            for (int i=0; i<sentence.getValue(); i++){
                for (int x= words_min.getValue(); x<word; x++){
                    for (int y=char_min.getValue(); y<character; y++){
                        sityva = sityva + alphabet_ge[new Random().nextInt(alphabet_ge.length)];
                    }
                    winadadeba = winadadeba + sityva + " ";
                }
                text = text + winadadeba + ". ";
            }
            final_text.setText(text);
        }
    }
}