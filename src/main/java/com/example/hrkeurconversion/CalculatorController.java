package com.example.hrkeurconversion;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalculatorController {

    @FXML
    TextField oneCentField;

    @FXML
    TextField twoCentField;

    @FXML
    TextField fiveCentField;

    @FXML
    TextField tenCentField;

    @FXML
    TextField twentyCentField;

    @FXML
    TextField fiftyCentField;

    @FXML
    TextField oneEuroField;

    @FXML
    TextField twoEuroField;

    @FXML
    TextField fiveEuroField;

    @FXML
    TextField tenEuroField;

    @FXML
    TextField twentyEuroField;

    @FXML
    TextField fiftyEuroField;

    @FXML
    TextField resultField;

    @FXML
    public EventHandler<KeyEvent> eventHandlerSumAmountTextField = new EventHandler<>() {
        @Override
        public void handle(KeyEvent event) {

            if (!oneCentField.getText().isBlank() || !twoCentField.getText().isBlank() ||
                    !fiveCentField.getText().isBlank() || !tenCentField.getText().isBlank() ||
                    !twentyCentField.getText().isBlank() || !fiftyCentField.getText().isBlank() ||
                    !oneEuroField.getText().isBlank() || !twoEuroField.getText().isBlank() ||
                    !fiveEuroField.getText().isBlank() || tenEuroField.getText().isBlank() ||
                    !twentyEuroField.getText().isBlank() || !fiftyEuroField.getText().isBlank()){
                calculateAmount(oneCentField, twoCentField, fiveCentField, tenCentField, twentyCentField, fiftyCentField,
                        oneEuroField, twoEuroField, fiveEuroField, tenEuroField, twentyEuroField, fiftyEuroField);
            }
        }
    };

    @FXML
    private void initialize() {

        oneCentField.setText("0"); twoCentField.setText("0"); fiveCentField.setText("0"); tenCentField.setText("0");
        twentyCentField.setText("0"); fiftyCentField.setText("0"); oneEuroField.setText("0"); twoEuroField.setText("0");
        fiveEuroField.setText("0"); tenEuroField.setText("0"); twentyEuroField.setText("0"); fiftyEuroField.setText("0");

        // Event Listener initialization
        oneCentField.addEventHandler(KeyEvent.KEY_RELEASED, eventHandlerSumAmountTextField);
        twoCentField.addEventHandler(KeyEvent.KEY_RELEASED, eventHandlerSumAmountTextField);
        fiveCentField.addEventHandler(KeyEvent.KEY_RELEASED, eventHandlerSumAmountTextField);
        tenCentField.addEventHandler(KeyEvent.KEY_RELEASED, eventHandlerSumAmountTextField);
        twentyCentField.addEventHandler(KeyEvent.KEY_RELEASED, eventHandlerSumAmountTextField);
        fiftyCentField.addEventHandler(KeyEvent.KEY_RELEASED, eventHandlerSumAmountTextField);
        oneEuroField.addEventHandler(KeyEvent.KEY_RELEASED, eventHandlerSumAmountTextField);
        twoEuroField.addEventHandler(KeyEvent.KEY_RELEASED, eventHandlerSumAmountTextField);
        fiveEuroField.addEventHandler(KeyEvent.KEY_RELEASED, eventHandlerSumAmountTextField);
        tenEuroField.addEventHandler(KeyEvent.KEY_RELEASED, eventHandlerSumAmountTextField);
        twentyEuroField.addEventHandler(KeyEvent.KEY_RELEASED, eventHandlerSumAmountTextField);
        fiftyEuroField.addEventHandler(KeyEvent.KEY_RELEASED, eventHandlerSumAmountTextField);

        resultField.setEditable(false);
        resultField.setFocusTraversable(false);

        // Enter Button HotKey -> ENTER
        oneCentField.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                oneCentField.setFocusTraversable(false);
                twoCentField.requestFocus();
            }
        });

        twoCentField.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                twoCentField.setFocusTraversable(false);
                fiveCentField.requestFocus();
            }
        });

        fiveCentField.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                fiveCentField.setFocusTraversable(false);
                tenCentField.requestFocus();
            }
        });

        tenCentField.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                tenCentField.setFocusTraversable(false);
                twentyCentField.requestFocus();
            }
        });

        twentyCentField.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                twentyCentField.setFocusTraversable(false);
                fiftyCentField.requestFocus();
            }
        });

        fiftyCentField.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                fiftyCentField.setFocusTraversable(false);
                oneEuroField.requestFocus();
            }
        });

        oneEuroField.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                oneEuroField.setFocusTraversable(false);
                twoEuroField.requestFocus();
            }
        });

        twoEuroField.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                twoEuroField.setFocusTraversable(false);
                fiveEuroField.requestFocus();
            }
        });

        fiveEuroField.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                fiveEuroField.setFocusTraversable(false);
                tenEuroField.requestFocus();
            }
        });

        tenEuroField.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                tenEuroField.setFocusTraversable(false);
                twentyEuroField.requestFocus();
            }
        });

        twentyEuroField.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                twentyEuroField.setFocusTraversable(false);
                fiftyEuroField.requestFocus();
            }
        });

        fiftyEuroField.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                fiftyEuroField.setFocusTraversable(false);
                oneCentField.requestFocus();
            }
        });
    }

    @FXML
    public void onResetButtonPress() {
        oneCentField.setText("0"); twoCentField.setText("0"); fiveCentField.setText("0"); tenCentField.setText("0");
        twentyCentField.setText("0"); fiftyCentField.setText("0"); oneEuroField.setText("0"); twoEuroField.setText("0");
        fiveEuroField.setText("0"); tenEuroField.setText("0"); twentyEuroField.setText("0"); fiftyEuroField.setText("0");
        resultField.setText("0");

        oneCentField.requestFocus();
    }

    private void calculateAmount(TextField oneCentField, TextField twoCentField, TextField fiveCentField,
                                 TextField tenCentField, TextField twentyCentField, TextField fiftyCentField,
                                 TextField oneEuroField, TextField twoEuroField, TextField fiveEuroField,
                                 TextField tenEuroField, TextField twentyEuroField, TextField fiftyEuroField) {

        double sumAmount = 0D;

        if (oneCentField.getText().isBlank()) {
            oneCentField.setText("0");
        }
        if (twoCentField.getText().isBlank()) {
            twoCentField.setText("0");
        }
        if (fiveCentField.getText().isBlank()) {
            fiveCentField.setText("0");
        }
        if (tenCentField.getText().isBlank()) {
            tenCentField.setText("0");
        }
        if (twentyCentField.getText().isBlank()) {
            twentyCentField.setText("0");
        }
        if (fiftyCentField.getText().isBlank()) {
            fiftyCentField.setText("0");
        }
        if (oneEuroField.getText().isBlank()) {
            oneEuroField.setText("0");
        }
        if (twoEuroField.getText().isBlank()) {
            twoEuroField.setText("0");
        }
        if (fiveEuroField.getText().isBlank()) {
            fiveEuroField.setText("0");
        }
        if (tenEuroField.getText().isBlank()) {
            tenEuroField.setText("0");
        }
        if (twentyEuroField.getText().isBlank()) {
            twentyEuroField.setText("0");
        }
        if (fiftyEuroField.getText().isBlank()) {
            fiftyEuroField.setText("0");
        }

        double oneCentAmount = Double.parseDouble(oneCentField.getText()) / 100;
        double twoCentAmount = (2 * Double.parseDouble(twoCentField.getText())) / 100;
        double fiveCentAmount = (5 * Double.parseDouble(fiveCentField.getText())) / 100;
        double tenCentAmount = (10 * Double.parseDouble(tenCentField.getText())) / 100;
        double twentyCentAmount = (20 * Double.parseDouble(twentyCentField.getText())) / 100;
        double fiftyCentAmount = (50 * Double.parseDouble(fiftyCentField.getText())) / 100;
        double oneEuroAmount = Double.parseDouble(oneEuroField.getText());
        double twoEuroAmount = (2 * Double.parseDouble(twoEuroField.getText()));
        double fiveEuroAmount = (5 * Double.parseDouble(fiveEuroField.getText()));
        double tenEuroAmount = (10 * Double.parseDouble(tenEuroField.getText()));
        double twentyEuroAmount = (20 * Double.parseDouble(twentyEuroField.getText()));
        double fiftyEuroAmount = (50 * Double.parseDouble(fiftyEuroField.getText()));

        sumAmount += oneCentAmount += twoCentAmount += fiveCentAmount += tenCentAmount += twentyCentAmount +=
                fiftyCentAmount += oneEuroAmount += twoEuroAmount += fiveEuroAmount += tenEuroAmount +=
                        twentyEuroAmount += fiftyEuroAmount;


        resultField.setText(Double.toString(round(sumAmount, 2)));
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

}
