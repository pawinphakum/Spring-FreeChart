package com.lsk.springfree;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.googlecode.charts4j.Color;
import com.googlecode.charts4j.GCharts;
import com.googlecode.charts4j.PieChart;
import com.googlecode.charts4j.Slice;

@Controller
@RequestMapping("/charts")
public class GooglePieChart {
	
	@RequestMapping(value = "/googlepiechart", method = RequestMethod.GET)
	public String chart(ModelMap model){
		Slice s1 = Slice.newSlice(15, Color.ALICEBLUE, "สมพงษ์", "สมพงษ์");
		Slice s2 = Slice.newSlice(35, Color.BLANCHEDALMOND, "เต้ย", "เต้ย");
		Slice s3 = Slice.newSlice(65, Color.CORNFLOWERBLUE, "ไผ่", "ไผ่");
		Slice s4 = Slice.newSlice(95, Color.FUCHSIA, "ขวัญ", "ขวัญ");
		
		PieChart pChart = GCharts.newPieChart(s1, s2, s3, s4);
		pChart.setTitle("ฮอร์โมน แฟนคลับ Google Pie Chart 1.3 (ModelMap)", Color.MEDIUMBLUE, 20);
		pChart.setSize(800, 375);
		pChart.setThreeD(true);
		
		model.put("pieUrl", pChart.toURLString());
		
		return "GooglePieChart";
	}

}
