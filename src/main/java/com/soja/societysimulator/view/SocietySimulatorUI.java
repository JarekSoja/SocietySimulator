package com.soja.societysimulator.view;

import com.soja.societysimulator.model.SocietyModel;
import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Autowired;

@SpringUI
@Theme("valo")
public class SocietySimulatorUI extends UI implements View {

    private final SocietyModel societyModel;

    private Navigator navigator;

    private VerticalLayout layout;

    @Autowired
    public SocietySimulatorUI(SocietyModel societyModel) {
        this.societyModel = societyModel;
        this.navigator = new Navigator(this, this);
    }

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        getPage().setTitle("Society simulator ver. 0.1");
        navigator.addView("result", new ChartPresenterView());
        setupLayout();
        addHeader();
        addForm();
      //  addChartPresenter();
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

        TextField citizenNumberField = new TextField();
        TextField initialCashField = new TextField();
        TextField numberOfYearsField = new TextField();
        TextField cashCahngeByYearField = new TextField();

        Button addButton = new Button("Add");
        Button runButton = new Button("Run calculations");

        horizontalLayout.addComponents(citizenNumberField, initialCashField, numberOfYearsField, cashCahngeByYearField,
                addButton, runButton);

        citizenNumberField.setWidth("20%");
        initialCashField.setWidth("20%");
        numberOfYearsField.setWidth("20%");
        cashCahngeByYearField.setWidth("20%");
        citizenNumberField.setValue("Pop");
        initialCashField.setValue("cash");
        numberOfYearsField.setValue("years");
        cashCahngeByYearField.setValue("chas V");

        addButton.addClickListener((event) -> {
            this.societyModel.setPopulation(Integer.parseInt(citizenNumberField.getValue()));
            this.societyModel.setCashChangeByYear(Integer.parseInt(cashCahngeByYearField.getValue()));
            this.societyModel.setStartingCash(Integer.parseInt(initialCashField.getValue()));
            this.societyModel.setYearsToOperate(Integer.parseInt(numberOfYearsField.getValue()));
        });

        runButton.addClickListener((event) -> {
            TemporalExecutor executor = new TemporalExecutor(this.societyModel);
            executor.execute();
            navigator.navigateTo("result");
        });


        layout.addComponent(horizontalLayout);
    }
}
