package com.gluonhq.hello;

import com.gluonhq.attach.display.DisplayService;
import com.gluonhq.attach.util.Platform;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.mvc.View;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Dimension2D;
import javafx.scene.Scene;
import java.io.IOException;

public class HelloGluon extends MobileApplication {

    private static final String RESTLIST_VIEW = "RestObjectView";
    private AppBar appBar;
    @Override
    public void init() {
        addViewFactory(HOME_VIEW, () -> {
            try {
                View view =FXMLLoader.load(HelloGluon.class.getResource("views/home.fxml"));
                return view;
            } catch (IOException e) {
                return null;
            }
        });
    }

    @Override
    public void postInit(Scene scene) {
        appBar = MobileApplication.getInstance().getAppBar();
        appBar.setVisible(false);
        scene.getStylesheets().add(HelloGluon.class.getResource("styles.css").toExternalForm());
        if (Platform.isDesktop()) {
            Dimension2D dimension2D = DisplayService.create()
                    .map(DisplayService::getDefaultDimensions)
                    .orElse(new Dimension2D(450, 900));
            scene.getWindow().setWidth(dimension2D.getWidth());
            scene.getWindow().setHeight(dimension2D.getHeight());
        }
    }

    public static void main(String[] args) {
        launch();
    }

}