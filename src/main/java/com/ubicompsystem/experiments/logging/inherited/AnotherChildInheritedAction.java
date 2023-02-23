package com.ubicompsystem.experiments.logging.inherited;

public class AnotherChildInheritedAction 
    extends InheritedBaseAction
{

    public void log( String message ){
        this.log.debug( "DEBUG Logging" );
        this.log.debug( "Logger Context : " + this.log.getName() );
        this.log.info( "Another Inherited Logger : " + message );
    }
}
