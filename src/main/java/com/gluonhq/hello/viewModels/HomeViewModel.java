package com.gluonhq.hello.viewModels;

import com.gluonhq.hello.model.Contact;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


/** Represents the model of the Home view.
 *
 */
public class HomeViewModel {

    /** Represents the people on your phone contact list witch uses the app
     *
     */
    public static ObservableList contactsList = FXCollections.observableArrayList(
            new Contact("Jim","jim12","123123123","Too sweet","https://cdn.pixabay.com/photo/2017/06/10/16/33/double-exposure-2390185_960_720.jpg"),
            new Contact("Mario","mar1131","124323","Hi!","https://cdn.pixabay.com/photo/2017/06/10/16/33/double-exposure-2390185_960_720.jpg"),
            new Contact("Pepe Cansado","pcX","123234234","Cool bro","https://cdn.pixabay.com/photo/2017/06/10/16/33/double-exposure-2390185_960_720.jpg"),
            new Contact("Judas","RealJudas","123166643","Fuck the system","https://cdn.pixabay.com/photo/2017/06/10/16/33/double-exposure-2390185_960_720.jpg"),
            new Contact("Gluon Boy","gluonSupport","123123123","JavaFX is so cool","https://cdn.pixabay.com/photo/2017/06/10/16/33/double-exposure-2390185_960_720.jpg"),
            new Contact("Alexander","s1mple","12312313","It's Na'Vi era","https://cdn.pixabay.com/photo/2017/06/10/16/33/double-exposure-2390185_960_720.jpg")
    );


    public HomeViewModel(){

    }

}
