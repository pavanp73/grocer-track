package com.pavan.track.apis.implementations;

import com.pavan.track.apis.interfaces.ChartResource;
import com.pavan.track.controllers.interfaces.ChartController;
import com.pavan.track.models.dto.DoughnutChartDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChartResourceImpl implements ChartResource {

    private final ChartController chartController;

    @Autowired
    public ChartResourceImpl(ChartController chartController) {
        this.chartController = chartController;
    }

    @Override
    public DoughnutChartDto getDataForDoughnutChart(String month) {
        return chartController.getDataForDoughnutChart(month);
    }
}
