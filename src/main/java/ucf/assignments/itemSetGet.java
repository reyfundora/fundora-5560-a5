package ucf.assignments;

import javafx.beans.property.SimpleStringProperty;

public class itemSetGet {
    private SimpleStringProperty value, serial, name;

    public itemSetGet(String value, String serial, String name) {
        this.value = new SimpleStringProperty(value);
        this.serial = new SimpleStringProperty(serial);
        this.name = new SimpleStringProperty(name);
    }

    // Set and Get for Value
    public String getValue() {
        return value.get();
    }
    public SimpleStringProperty valueProperty() {
        return value;
    }
    public void setValue(String value) {
        this.value.set(value);
    }

    // Set and Get for Serial
    public String getSerial() {
        return serial.get();
    }
    public SimpleStringProperty serialProperty() {
        return serial;
    }
    public void setSerial(String serial) {
        this.serial.set(serial);
    }

    // Set and Get for Name
    public String getName() {
        return name.get();
    }
    public SimpleStringProperty nameProperty() {
        return name;
    }
    public void setName(String name) {
        this.name.set(name);
    }
}
