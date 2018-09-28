package com.soja.societysimulator.view;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Autowired;

@SpringUI
@Theme("valo")
public class DataInputUI extends UI {

    @Autowired
    private ChartPresenter chartPresenter;

    private VerticalLayout layout;

    @Override
    protected void init (VaadinRequest vaadinRequest) {
        setupLayout();
        addHeader();
        addForm();
        addChartPresenter();
        addClearButton();
    }


    private void setupLayout() {
        layout = new VerticalLayout();
        setContent(layout);
        layout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
    }


    private void addHeader() {
        Label header = new Label("Society Simulator");
        header.addStyleName(ValoTheme.THEME_NAME);
        layout.addComponent(header);
    }

    private void addForm() {
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.setSpacing(true);
        horizontalLayout.setWidth("80%");
        TextField textField = new TextField();
        Button button = new Button("Add");
        horizontalLayout.addComponents(textField, button);
        textField.setWidth("100%");
        horizontalLayout.setExpandRatio(textField, 1);
        layout.addComponent(horizontalLayout);
    }

    private void addClearButton() {
        Button clearData = new Button("Clear data");
        layout.addComponent(clearData);
    }


    private void addChartPresenter() {
        chartPresenter.setWidth("80%");
        layout.addComponent(chartPresenter);
    }



}
