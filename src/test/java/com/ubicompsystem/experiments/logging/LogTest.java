package com.ubicompsystem.experiments.logging;

import org.junit.Test;

import com.ubicompsystem.experiments.logging.inherited.*;

public class LogTest {

    Logger log = new Logger(this.getClass());

    @Test
    public void defaultTest(){
        log.info( "===== START Logging with BaseAction where Logger is constructed with this.getClass() =====" );
        String message = "Hello World";

        ChildAction childAction = new ChildAction();
        childAction.log( message );

        AnotherChildAction anotherChildAction = new AnotherChildAction();
        anotherChildAction.log( message );
        log.info( "===== END Logging with BaseAction where Logger is constructed with this.getClass() =====" );
        log.info("");
    }

    @Test
    public void inheritedLoggerTest(){
        log.info( "===== START Logging with InheritedBaseAction where Logger is constructed with explicit InheritedBaseAction.class =====" );
        String message = "Another Hello World";

        ChildInheritedAction inheritedChildAction = new ChildInheritedAction();
        inheritedChildAction.log( message );

        AnotherChildInheritedAction anotherChildInheritedAction = new AnotherChildInheritedAction();
        anotherChildInheritedAction.log( message );
        log.info( "===== END Logging with InheritedBaseAction where Logger is constructed with explicit InheritedBaseAction.class =====" );
        log.info("");
    }
}
