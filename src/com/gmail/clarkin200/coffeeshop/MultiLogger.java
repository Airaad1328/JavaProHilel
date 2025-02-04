package com.gmail.clarkin200.coffeeshop;

import ch.qos.logback.classic.*;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.util.StatusPrinter;
import org.slf4j.LoggerFactory;

import java.net.URL;

public class MultiLogger {
    public static Logger loadLogger(String configFile) {
        try {
            LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
            context.reset();

            JoranConfigurator configurator = new JoranConfigurator();
            configurator.setContext(context);
            URL configURL = MultiLogger.class.getClassLoader().getResource(configFile);
            if (configURL == null) {
                throw new RuntimeException("Configuration file not found " + configFile);
            }
            configurator.doConfigure(configURL);
            StatusPrinter.printInCaseOfErrorsOrWarnings(context);

            return (Logger) LoggerFactory.getLogger(MultiLogger.class);
        } catch (Exception e) {
            throw new RuntimeException("Fail to load configuration Logback: " + configFile, e);
        }
    }
}
