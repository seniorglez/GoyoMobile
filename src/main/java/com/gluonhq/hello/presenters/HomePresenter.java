package com.gluonhq.hello.presenters;

import com.gluonhq.charm.glisten.control.CharmListCell;
import com.gluonhq.charm.glisten.control.CharmListView;
import com.gluonhq.charm.glisten.control.ListTile;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.hello.model.Contact;
import com.gluonhq.hello.services.QuoteService;
import com.gluonhq.hello.viewModels.HomeViewModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;



import java.net.URL;
import java.util.ResourceBundle;

public class HomePresenter implements Initializable {

    @FXML
    public View home;

    private CharmListView<Contact,String> charmListViewContacts = new CharmListView(HomeViewModel.contactsList);
    private VBox chuckPane;
    private VBox homePanel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    initializeCharmListViewContacts();
    initializeWelcome();
    initializeChuck();

    }


    private void initializeChuck() {
        Label quoteLabel = new Label("PRESS THE BUTTON FOR A FACT");
        QuoteService service = new QuoteService();
        ImageView imageGoyo = new ImageView("https://img2.freepng.es/20180324/dgw/kisspng-chuck-norris-facts-united-states-total-gym-kicksta-chuck-norris-5ab679c0977203.4622969215219081606203.jpg");
        imageGoyo.setFitHeight(200);
        imageGoyo.setPreserveRatio(true);
        Button button = new Button("New Quote");
        quoteLabel.textProperty().bind(service.valueProperty());
        service.start();
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(!service.isRunning()){
                    service.restart(); // I need to call restart method because javaFX can only start a Service in the
                    // READY state. When the program reach this line service is in state SUCCEEDED
                } else {
                    System.out.println("Service already running");
                }
            }
        });
        chuckPane = new VBox(30, imageGoyo,quoteLabel,button);
        chuckPane.setAlignment(Pos.CENTER);
    }

    private void initializeWelcome() {
        Label welcome = new Label("Welcome to GoyoMobile");
        ImageView imageGoyo = new ImageView("https://gregoriofer.com/wp-content/uploads/2015/11/logo.jpg");
        imageGoyo.setFitHeight(200);
        imageGoyo.setPreserveRatio(true);

        homePanel = new VBox(30, imageGoyo, welcome);
        homePanel.setAlignment(Pos.CENTER);
        home.setCenter(homePanel);
    }

    private void initializeCharmListViewContacts() {
        charmListViewContacts.setCellFactory(p -> new CharmListCell<>() {
            @Override
            public void updateItem(Contact item, boolean empty) {
                super.updateItem(item, empty);

                if(item != null && !empty) {
                    ListTile tile = new ListTile();
                    tile.textProperty().addAll(item.getName(),"@" + item.getAlias());
                    setText(null);
                    setGraphic(tile);
                } else {
                    setText(null);
                    setGraphic(null);
                }
            }
        });
    }

    @FXML
    public void onClickContactButton() {
        System.out.println("Loading contacts...");
        home.setCenter(charmListViewContacts);
    }

    @FXML
    public void onClickCallsButton() {
        System.out.println("Loading chuck");
        home.setCenter(chuckPane);
    }

    @FXML
    public void onClickChatsButton() {
        System.out.println("Calculator pane");
        home.setCenter(homePanel);
    }

}
