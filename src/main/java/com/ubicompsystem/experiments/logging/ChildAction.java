package com.ubicompsystem.experiments.logging;

public class ChildAction extends BaseAction {

    @Override
    public void log( String message ){
        super.log( "Child " + message );
    }
}
