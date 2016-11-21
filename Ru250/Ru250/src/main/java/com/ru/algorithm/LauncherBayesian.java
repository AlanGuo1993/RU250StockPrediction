package com.ru.algorithm;

import java.util.ArrayList;
import java.util.List;

public class LauncherBayesian
{

    public double predict(List<Double> price)
    {
        CurveFitting curveFitting = new CurveFitting(price);
        return curveFitting.predict();
    }
}
