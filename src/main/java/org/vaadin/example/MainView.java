package org.vaadin.example;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route
public class MainView extends VerticalLayout {

    public MainView() {
        DatePicker datePicker = new DatePicker();
        datePicker.addOpenedChangeListener(event ->
                System.out.println(event.isOpened() ? "datepicker was opened" : "datepicker was closed"));

        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.setItems("Windows", "MacOS", "Linux");
        comboBox.getElement().addPropertyChangeListener("opened", event -> {
            System.out.println((boolean) event.getValue() ? "combobox was opened" : "combobox was closed");
        });

        add(datePicker, comboBox);
    }
}
