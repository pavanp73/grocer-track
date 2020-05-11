package com.pavan.track.controllers.interfaces;

import com.pavan.track.models.dto.DoughnutChartDto;

public interface ChartController {

    DoughnutChartDto getDataForDoughnutChart(String month);
}
