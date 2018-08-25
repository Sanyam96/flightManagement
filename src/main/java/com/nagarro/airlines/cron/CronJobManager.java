package com.nagarro.airlines.cron;


import com.nagarro.airlines.App;
import com.nagarro.airlines.io.Input;
import com.nagarro.airlines.io.Output;
import com.nagarro.airlines.models.FlightInfo;
import com.nagarro.airlines.models.OutputData;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * @author Sanyam Goel created on 26/8/18
 */
public class CronJobManager implements Job {

    Output output = new Output();

    @Override
    public void execute(JobExecutionContext jobExecutionContext) {

        System.out.println("Updated Results at.."+new Date());
//        OutputData outputData = new OutputData();
//        outputData.getFlights();
        System.out.println("-----------------------------------");
        output.displayFlightDetails(App.flightResults);
    }
}
