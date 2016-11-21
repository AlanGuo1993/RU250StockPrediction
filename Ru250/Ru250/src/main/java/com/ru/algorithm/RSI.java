package com.ru.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GA on 4/28/16.
 *
 * 计算方法
 * N日RS=[A÷(A+B)]×100%
 * 公式中，A——N日内收盘涨幅之和
 * B——N日内收盘跌幅之和(取正值)
 * N日RSI=100-100/(1+RS)
 * 从计算公式上看，我们可以看到，RSI的计算非常简单，实际理解为：在某一阶段价格上涨所产生的波动占整个波动的百分比。
 *
 * 取值的大小
 * RSI的变动范围在0—100之间，强弱指标值一般分布在20—80。(如下图所示)
 * RSI值市场特征投资操作
 * 80—100极强卖出
 * 50—80强买入
 * 20—50弱观望
 * 0—20极弱买入
 * 这里的“极强”、“强”、“弱”和“极弱”只是一个相对的分析概念，是一个相对的区域。
 * 有的投资者也可把它们取值为30、70或15、85，根据个人的喜好吧，没有绝对性。
 */
public class RSI
{

    public List<Double> price;
    public int numberOfDays;
    public int N = 12;
    public double A;
    public double B;
    public double RS;
    public double RSI;

    // return strategy: -1 sell out   0 hold   1 buy in
    public int strategy(List<Double> price)
    {
        this.price = price;
        numberOfDays = price.size();
        for(int i = 0; i<N; i++)
        {
            double difference = price.get(numberOfDays-1 - i) - price.get(numberOfDays-1 - i - 1);
            if(difference > 0)
                A += difference;
            if(difference < 0)
                B += difference;
        }
        RS = A / (A + B) ;
        RSI = (double)100 - (double)100/(1+RS);

        if(RSI <20 || ((RSI > 50)&&(RSI < 80)))
        {
            return 1;
        }
        else if(RSI>=20 && RSI<=50)
        {
            return 0;
        }
        else
            return -1;

    }
}
