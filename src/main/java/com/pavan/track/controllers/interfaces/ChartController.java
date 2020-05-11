package com.pavan.track.controllers.interfaces;

import com.pavan.track.models.dto.DoughnutChartDto;

import java.util.List;

public interface ChartController {

    DoughnutChartDto getDataForDoughnutChart(String month);
}
