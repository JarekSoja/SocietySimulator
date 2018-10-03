package com.soja.societysimulator.view;

import com.soja.societysimulator.view.charts.VerticalBarChartDataSource;
import com.soja.societysimulator.view.charts.BarChart;


import com.soja.societysimulator.view.charts.VerticalChart;
import com.vaadin.annotations.Theme;
import com.vaadin.server.StreamResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Button;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SpringUI
@Theme("valo")
@SpringComponent
@UIScope
public class ChartPresenter extends UI {

    private VerticalLayout layout;
    private VerticalBarChartDataSource dataSource;
    private Button generate;
    private Embedded imageBar;

    @Override
    protected void init(VaadinRequest request) {
        layout = new VerticalLayout();
        dataSource = new VerticalChart();
        layout.addComponent(imageBar);
        generate = new Button("Generuj");
        generate.addListener((event) -> {
            makeBar();
        });
        layout.addComponent(generate);
    }

    private StreamResource createStreamResource(StreamResource.StreamSource imageSource) {
        return new StreamResource(imageSource, "mychart.png");
    }

    private void makeBar() {
        StreamResource.StreamSource bar = new BarChart(dataSource.getCategoryDataset());
        StreamResource barImageResource = createStreamResource(bar);
        if (imageBar != null) {
            layout.removeComponent(imageBar);
        }
        imageBar = new Embedded("Bar Image", barImageResource);
        layout.addComponent(imageBar);
    }
}
