
module com.mycompany.dbooks {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.persistence;
    requires java.sql;
    requires org.hibernate.orm.core;
    requires java.base;


    opens com.mycompany.dbooks to javafx.fxml;
    opens com.mycompany.dbooks.db;
    exports com.mycompany.dbooks;
}
