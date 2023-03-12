package com.example.hrkeurconversion;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class ConversionController {

    private final static Double ZERO_VALUE = 0D;
    private final static Double EURO_VALUE = 7.53450D;

    @FXML
    public TextField receiptAmountEURTextField;

    @FXML
    public TextField givenAmountTextField;

    @FXML
    public TextField returnAmountEURTextField;


    @FXML
    public EventHandler<KeyEvent> eventHandlerReceiptAmountTextField = new EventHandler<>() {
        @Override
        public void handle(KeyEvent event) {

            if (!receiptAmountEURTextField.getText().isBlank()) {
                calculateReturnAmount(receiptAmountEURTextField, givenAmountTextField);

                String receiptEURAmountString = receiptAmountEURTextField.getText();

                if (receiptAmountEURTextField.getText().contains(",")) {
                    receiptEURAmountString = receiptEURAmountString.replace(',', '.');
                }
            }
        }
    };

    @FXML
    public EventHandler<KeyEvent> eventHandlerGivenAmountTextField = new EventHandler<>() {
        @Override
        public void handle(KeyEvent event) {

            if (!givenAmountTextField.getText().isBlank()) {
                calculateReturnAmount(receiptAmountEURTextField, givenAmountTextField);
            }
        }
    };

    @FXML
    public void initialize() {
        receiptAmountEURTextField.setText("");  givenAmountTextField.setText("");

        // Event Listener initialization
        receiptAmountEURTextField.addEventHandler(KeyEvent.KEY_RELEASED, eventHandlerReceiptAmountTextField);
        givenAmountTextField.addEventHandler(KeyEvent.KEY_RELEASED, eventHandlerGivenAmountTextField);

        returnAmountEURTextField.setEditable(false);
        returnAmountEURTextField.setFocusTraversable(false);

        // Enter Button HotKey -> ENTER
        receiptAmountEURTextField.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                receiptAmountEURTextField.setFocusTraversable(false);
                givenAmountTextField.requestFocus();
            }
        });

        givenAmountTextField.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                givenAmountTextField.setFocusTraversable(false);
                receiptAmountEURTextField.requestFocus();
            }
        });
    }

    @FXML
    public void onResetButtonPress() {
        receiptAmountEURTextField.clear();
        givenAmountTextField.clear();
        returnAmountEURTextField.clear();

        receiptAmountEURTextField.requestFocus();
    }

    private void calculateReturnAmount(TextField receiptAmountTextField, TextField givenAmountTextField) {

        String receiptAmountString = receiptAmountTextField.getText();
        String givenAmountString = givenAmountTextField.getText();

        if (receiptAmountString.contains(",")) {
            receiptAmountString = receiptAmountString.replace(',', '.');
        }

        if (givenAmountString.contains(",")) {
            givenAmountString = givenAmountString.replace(',', '.');
        }

        double receiptAmount;
        double givenAmount;
        double returnAmount;

        if (!receiptAmountTextField.getText().isBlank()) {
            receiptAmount = Double.parseDouble(receiptAmountString);
        } else {
            receiptAmount = 0D;
        }

        if (!givenAmountTextField.getText().isBlank()) {
            givenAmount = Double.parseDouble(givenAmountString);
        } else {
            givenAmount = 0D;
        }

        if (receiptAmount > givenAmount) {
            returnAmountEURTextField.setText("-");
        } else {
            returnAmount = round(((givenAmount - receiptAmount)), 2);
            returnAmountEURTextField.setText(Double.toString(returnAmount));
        }
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}