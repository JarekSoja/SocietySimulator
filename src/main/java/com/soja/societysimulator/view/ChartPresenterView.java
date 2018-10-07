package com.soja.societysimulator.view;

import com.soja.societysimulator.view.charts.BarChart;

import com.vaadin.annotations.Theme;
import com.vaadin.navigator.View;
import com.vaadin.server.StreamResource;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.VerticalLayout;


@SpringComponent
@SpringView
@Theme("valo")
public class ChartPresenterView extends VerticalLayout implements View  {

    private VerticalLayout layout;
    private BarChart dataSource;
    private Embedded imageBar;

    public ChartPresenterView() {
        this.layout = new VerticalLayout();

        setSizeFull();
        layout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);

        makeBar();
    }

    private StreamResource createStreamResource(StreamResource.StreamSource imageSource) {
        return new StreamResource(imageSource, "mychart.png");
    }

    private void makeBar() {
        StreamResource.StreamSource bar = new BarChart();
        StreamResource barImageResource = createStreamResource(bar);
        if (imageBar != null) {
            layout.removeComponent(imageBar);
        }
        imageBar = new Embedded("Bar Image", barImageResource);
        layout.addComponent(imageBar);
    }
}
