package tr.com.mindworks.controllers.security;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.BarChartSeries;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import tr.com.mindworks.annotations.SpringFlowScoped;
import tr.com.mindworks.controllers.BaseController;

@Component("mainPageController")
@SpringFlowScoped
@ViewScoped
public class MainPageController extends BaseController {

	private CartesianChartModel combinedModel;
	 
    @PostConstruct
    public void init() {
        createCombinedModel();
    }
 
    public CartesianChartModel getCombinedModel() {
        return combinedModel;
    }
     
    private void createCombinedModel() {
        combinedModel = new BarChartModel();
 
        BarChartSeries boys = new BarChartSeries();
        boys.setLabel("Satış Adet");
 
        boys.set("Ocak", 6);
        boys.set("Şubat", 5);
        boys.set("Mart", 1);
        boys.set("Nisan", 7);
        boys.set("Mayıs", 1);
 
        LineChartSeries girls = new LineChartSeries();
        girls.setLabel("Üretim Tamamlama");
 
        girls.set("Ocak", 2);
        girls.set("Şubat", 3);
        girls.set("Mart", 6);
        girls.set("Nisan", 7);
        girls.set("Mayıs", 6);
 
        combinedModel.addSeries(boys);
        combinedModel.addSeries(girls);
         
        combinedModel.setTitle("Satış / Üretim Grafiği");
        combinedModel.setLegendPosition("ne");
        combinedModel.setMouseoverHighlight(false);
        combinedModel.setShowDatatip(false);
        combinedModel.setShowPointLabels(true);
        Axis yAxis = combinedModel.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(10);
    }
}
