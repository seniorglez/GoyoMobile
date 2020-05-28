package com.gluonhq.hello.services;


import javafx.concurrent.Service;
import javafx.concurrent.Task;



public class QuoteService extends Service<String> {

    private String restURL = "https://api.chucknorris.io/jokes/random";
    @Override
    protected Task<String> createTask() {
        QuoteTask qt = new QuoteTask();
        qt.setRestURL(restURL);
        return  qt;
    }


}
