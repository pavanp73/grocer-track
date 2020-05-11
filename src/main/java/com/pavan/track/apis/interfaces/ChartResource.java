package com.pavan.track.apis.interfaces;

import com.pavan.track.models.dto.DoughnutChartDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("chart")
public interface ChartResource {

    @GetMapping
    @Operation(summary = "Fetch data for Doughnut chart")
    DoughnutChartDto getDataForDoughnutChart(
            @RequestParam(value = "month", required = false) String month);

}
