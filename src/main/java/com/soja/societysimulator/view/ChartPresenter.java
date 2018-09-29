package com.soja.societysimulator.view;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

@SpringComponent
@UIScope
public class ChartPresenter extends VerticalLayout {

    @Autowired
    CitizenRepository citizenRepository;

    @PostConstruct
    void init() {

    }
}
