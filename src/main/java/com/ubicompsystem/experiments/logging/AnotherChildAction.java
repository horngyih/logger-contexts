package com.ubicompsystem.experiments.logging;

public class AnotherChildAction extends BaseAction {

    @Override
    public void log( String message ){
        super.log( "ANOTHER : " + message );
    }
}
