package com.lsk.springfree;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.Plot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/charts")
public class MyPieChart {
	
	@RequestMapping(value = "/piechart", method = RequestMethod.GET)
	public void drawPieChart(HttpServletResponse response){
		response.setContentType("image/png");
		PieDataset pdSet = createDataSet();
		JFreeChart chart = createChart(pdSet, "ฮอร์โมน แฟนคลับ (Test JFreeChart API version 1.0.15)");
		
		try{
			ChartUtilities.writeChartAsPNG(response.getOutputStream(), chart, 800, 800);
			response.getOutputStream().close();
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
	}
	
	private PieDataset createDataSet(){
		DefaultPieDataset dpd = new DefaultPieDataset();
		dpd.setValue("วิน", 8);
		dpd.setValue("ขวัญ", 38);
		dpd.setValue("ต้า", 13);
		dpd.setValue("อ้อยใจ", 80);
		dpd.setValue("ไผ่", 32);
		dpd.setValue("สไปรท์", 50);
		dpd.setValue("สมพงษ์", 184);
		dpd.setValue("เต้ย", 22);
		return dpd;
	}
	
	private JFreeChart createChart(PieDataset dataset, String title){
		JFreeChart chart = null;
		
		boolean legend = true;
		boolean tooltips = true;
		boolean urls = false;
		

		chart = ChartFactory.createPieChart(title, dataset, legend, tooltips, urls);
		Plot plot = chart.getPlot();
		plot.setBackgroundAlpha(0.2f);
		plot.setOutlineVisible(false);
		return chart;
	}

}
