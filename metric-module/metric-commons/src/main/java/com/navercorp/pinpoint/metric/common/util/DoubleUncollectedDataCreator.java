/*
 *
 *  * Copyright 2024 NAVER Corp.
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  * http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 *
 */

package com.navercorp.pinpoint.metric.common.util;

import com.navercorp.pinpoint.metric.common.model.chart.AvgMinMaxMetricPoint;
import com.navercorp.pinpoint.metric.common.model.chart.AvgMinMetricPoint;
import com.navercorp.pinpoint.metric.common.model.chart.MinMaxMetricPoint;
import com.navercorp.pinpoint.metric.common.model.chart.SystemMetricPoint;

/**
 * @author minwoo.jung
 */
public class DoubleUncollectedDataCreator implements UncollectedDataCreator<Double> {
    public static final Double UNCOLLECTED_VALUE = -1D;
    public static final UncollectedDataCreator<Double> UNCOLLECTED_DATA_CREATOR = new DoubleUncollectedDataCreator();

    @Override
    public SystemMetricPoint<Double> createUnCollectedPoint(long xVal) {
        return new SystemMetricPoint<>(xVal, UNCOLLECTED_VALUE);
    }

    @Override
    public AvgMinMaxMetricPoint<Double> createUnCollectedAvgMinMaxMetricPoint(long xVal) {
        return new AvgMinMaxMetricPoint<>(xVal, UNCOLLECTED_VALUE, UNCOLLECTED_VALUE, UNCOLLECTED_VALUE);
    }

    @Override
    public MinMaxMetricPoint<Double> createUnCollectedMinMaxMetricPoint(long xVal) {
        return new MinMaxMetricPoint<>(xVal,UNCOLLECTED_VALUE, UNCOLLECTED_VALUE);
    }

    @Override
    public AvgMinMetricPoint<Double> createUnCollectedAvgMinMetricPoint(long xVal) {
        return new AvgMinMetricPoint<>(xVal, UNCOLLECTED_VALUE, UNCOLLECTED_VALUE);
    }
}
