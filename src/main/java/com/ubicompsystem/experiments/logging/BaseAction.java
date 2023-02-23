package com.ubicompsystem.experiments.logging;

public abstract class BaseAction {
    Logger log = new Logger(this.getClass());

    public void log( String message ){
        this.log.debug( "Logging Category: " + this.log.getName() );
        this.log.info( message );
    }
}
