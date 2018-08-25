package com.nagarro.airlines;

import com.nagarro.airlines.cron.CronJobManager;
import com.nagarro.airlines.io.Input;
import com.nagarro.airlines.io.Output;
import com.nagarro.airlines.models.FlightInfo;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Main class file
 */
public class App {

    public static HashMap<String, ArrayList<FlightInfo>> flightResults = new HashMap<>();

    /**
     * Main function to starter code
     *
     * @param args
     */
    public static void main(String[] args) {

        Input input = new Input();
        Output output = new Output();
        input.takeInput(flightResults);

        try {
            JobDetail job1 = JobBuilder.newJob(CronJobManager.class).withIdentity("job1", "group1").build();
            Trigger trigger1 = TriggerBuilder.newTrigger()
                    .withIdentity("cronTrigger1", "group1")
                    .withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?"))
                    .build();
            Scheduler scheduler1 = new StdSchedulerFactory().getScheduler();
            scheduler1.start();
            scheduler1.scheduleJob(job1, trigger1);
            Thread.sleep(100000);
            output.displayFlightDetails(flightResults);
            scheduler1.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
