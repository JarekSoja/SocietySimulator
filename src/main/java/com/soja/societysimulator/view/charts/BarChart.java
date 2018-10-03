package com.soja.societysimulator.view.charts;

import com.vaadin.server.StreamResource;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class BarChart implements StreamResource.StreamSource {

    private ByteArrayOutputStream imagebuffer = null;
    private CategoryDataset dataset;
    private BufferedImage image;

    public BarChart(CategoryDataset dataset) {
        this.dataset = dataset;
    }

    public InputStream getStream() {
        JFreeChart chart = ChartFactory.createBarChart(
                "Bar Chart Demo",
                "kategorie",
                "Wartości",
                dataset,
                PlotOrientation.VERTICAL,
                false,
                false,
                false);
        BufferedImage image = chart.createBufferedImage(300, 300);
        try {
            imagebuffer = new ByteArrayOutputStream();
            ImageIO.write(image, "png", imagebuffer);

            return new ByteArrayInputStream(imagebuffer.toByteArray());

        } catch (IOException e) {
            return null;
        }

    }
}