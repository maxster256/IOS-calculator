package com.example.calc;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HelloController {

    String number_1="",number_2="",sign="";
    boolean clicked_sign=false,calculated=false;
    @FXML
    private Label welcomeText;
    @FXML
    protected void clicked(ActionEvent event) {
        if(clicked_sign) {clicked2(event);}
        else{
        Button clickedButton = (Button) event.getSource();
        number_1+=clickedButton.getText();
        welcomeText.setText(number_1);}
    }
    protected void clicked2(ActionEvent event) {
        if(calculated) {number_2=""; calculated=false;}
        Button clickedButton = (Button) event.getSource();
        number_2+=clickedButton.getText();
        welcomeText.setText(number_2);
    }
    @FXML
    protected void sign(ActionEvent event){
        clicked_sign=true;
        Button clickedButton = (Button) event.getSource();
        switch (clickedButton.getText()) {
            case "+" -> sign = "+";
            case "-" -> sign = "-";
            case "x" -> sign = "x";
            case ":" -> sign = ":";
            default -> System.out.println("oops! (1)");
        }
    }
    @FXML
    protected void can_calculate(){
        if(Double.parseDouble(number_2)==0 && sign==":") {welcomeText.setText("Blad dzielenia przez 0"); number_2="";}
        else {calculate();}
    }
    protected void calculate(){
        calculated=true;
        double num1=Double.parseDouble(number_1);
        double num2=Double.parseDouble(number_2);
        switch (sign) {
            case "+" -> num1 = num1 + num2;
            case "-" -> num1 = num1 - num2;
            case "x" -> num1 = num1 * num2;
            case ":" -> num1 = num1 / num2;
            default -> System.out.println("oops! (2)");
        }
        number_1=Double.toString(num1);
        welcomeText.setText(number_1);
    }
}