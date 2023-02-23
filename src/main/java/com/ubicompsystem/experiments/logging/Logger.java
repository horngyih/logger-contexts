package com.ubicompsystem.experiments.logging;

import java.util.Locale;

import org.slf4j.LoggerFactory;
import org.slf4j.cal10n.LocLogger;

import ch.qos.cal10n.MessageConveyor;

public class Logger extends LocLogger {
	
	public Logger() {
		super(LoggerFactory.getLogger(Logger.class), new MessageConveyor(Locale.US));
	}
	
	public Logger(Class<?> clazz) {
		super(LoggerFactory.getLogger(clazz), new MessageConveyor(Locale.US));
	}
	
	public Logger(Locale locale, Class<?> clazz) {
		super(LoggerFactory.getLogger(clazz), new MessageConveyor(locale));
	}

    @Override
    public String getName(){
        return super.getName();
    }
}
