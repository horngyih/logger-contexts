package com.ubicompsystem.experiments.logging.inherited;

public class ChildInheritedAction 
    extends InheritedBaseAction
{

    public void log( String message ){
        this.log.debug( "DEBUG Logging" );
        this.log.debug( "Logger Context : " + this.log.getName() );
        this.log.info( "Inherited Logger : " + message );
    }
}
