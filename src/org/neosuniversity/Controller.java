package org.neosuniversity;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import org.neosuniversity.math.MathUtils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Controller {

    @FXML
    private TextField txtGradosCelsius;

    @FXML
    private TextField txtGradosFahrenheit;


    @FXML
    public void convertirAction(ActionEvent evt) {
        LocalDate localDate = LocalDate.now();
        System.out.println("LocalDate = " + localDate);

        Date date1 = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        System.out.println("Date      = " + date1);



        System.out.println("Celsius: " + txtGradosCelsius.getText());

       String strCelsius = txtGradosCelsius.getText();

       try {
           Double celsius = Double.parseDouble(strCelsius);
           Double fahrenheit = MathUtils.convierteCelsiusaFarenheit(celsius);
           this.txtGradosFahrenheit.setText(String.valueOf(fahrenheit));


       } catch (NumberFormatException e) {
           Alert alert = new Alert(Alert.AlertType.ERROR);
           alert.setTitle("Error");
           alert.setHeaderText("Error");
           alert.setContentText("Ingrese solo numeros");
           alert.show();
       }


    }
}
