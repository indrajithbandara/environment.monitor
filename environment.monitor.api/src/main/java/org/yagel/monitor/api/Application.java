package org.yagel.monitor.api;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.yagel.monitor.ScheduleRunner;
import org.yagel.monitor.ScheduleRunnerImpl;

@SpringBootApplication(scanBasePackages = "org.yagel.monitor")
public class Application {

  public static void main(String[] args) {


    SpringApplication.run(Application.class, args);

  }

  @Bean
  public CommandLineRunner schedulingRunner() {
    return new CommandLineRunner() {
      public void run(String... args) throws Exception {
        ScheduleRunner scheduleRunner = ScheduleRunnerImpl.newInstance(ClassLoader.getSystemClassLoader());
        scheduleRunner.runTasks();
      }
    };

  }


}
