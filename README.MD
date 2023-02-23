# Logging Contexts

This is a small toy project to illustrate configuration of Logging Categories.

The project contains two _family_ of **Action** classes:

- **BaseAction** - creates Logger using the _this_ keyword
```Java
  Logger log = new Logger(this.getClass());
```

- **InheritedBaseAction** - creates Logger using the _hardcoded_ target class
```Java
  Logger log = new Logger(InheritedBaseAction.class);
```

A simple test runs logging on the two _families_ of **Action** classes and demonstrates
how each _family_ logger construction causes category targeting to be a problem.

- **BaseAction**: The **BaseAction** class constructs the Logger with `this.getClass()`,
the Logger constructed therefore is pegged to the inheriting child class name as the Log Category
this allows properly to target the respective child classes Log Category.

- **InheritedBaseAction**: Since the **InheritedBaseAction** class constructs the Logger with _hardcoded_ `InheritedBaseAction.class`,
the Logger created are pegged to the target class name as the Log Category _com.ubicompsystem.experiments.logging.inherited.InheritedBaseAction_
and further targeting the child classes as a category would not work since the Logger goes not further down the heirarchy.

Test is configured to log using both _family_ of Action classes and attempts to target ONE of the child classes to log in `DEBUG` level.
```xml
    <category name="com.ubicompsystem.experiments.logging.inherited.ChildInheritedAction">
        <level value="DEBUG"/>
    </category>

    <category name="com.ubicompsystem.experiments.logging.ChildAction">
        <level value="DEBUG"/>
    </category>
```
[log4j.xml](https://github.com/horngyih/logger-contexts/blob/main/src/test/resources/log4j.xml)

## Test Targeting Child Class

Result shows that the result is not as expected:-
```log
INFO  ===== START Logging with BaseAction where Logger is constructed with this.getClass() =====  (LogTest.java:13)
DEBUG Logging Category: com.ubicompsystem.experiments.logging.ChildAction  (BaseAction.java:7)
INFO  Child Hello World  (BaseAction.java:8)
INFO  ANOTHER : Hello World  (BaseAction.java:8)
INFO  ===== END Logging with BaseAction where Logger is constructed with this.getClass() =====  (LogTest.java:21)
INFO    (LogTest.java:22)
INFO  ===== START Logging with InheritedBaseAction where Logger is constructed with explicit InheritedBaseAction.class =====  (LogTest.java:27)
INFO  Inherited Logger : Another Hello World  (ChildInheritedAction.java:10)
INFO  Another Inherited Logger : Another Hello World  (AnotherChildInheritedAction.java:10)
INFO  ===== END Logging with InheritedBaseAction where Logger is constructed with explicit InheritedBaseAction.class =====  (LogTest.java:35)
INFO    (LogTest.java:36)
```
where the _Inherited_ **ChildInheritedAction** is NOT targeted.

## Display Logger Category

Modifying the `log4j.xml` `root` log level to `DEBUG` will reveal the _logging context_ for each of the `Logger`s.

```
INFO  ===== START Logging with BaseAction where Logger is constructed with this.getClass() =====  (LogTest.java:13)
DEBUG Logging Category: com.ubicompsystem.experiments.logging.ChildAction  (BaseAction.java:7)
INFO  Child Hello World  (BaseAction.java:8)
DEBUG Logging Category: com.ubicompsystem.experiments.logging.AnotherChildAction  (BaseAction.java:7)
INFO  ANOTHER : Hello World  (BaseAction.java:8)
INFO  ===== END Logging with BaseAction where Logger is constructed with this.getClass() =====  (LogTest.java:21)
INFO    (LogTest.java:22)
INFO  ===== START Logging with InheritedBaseAction where Logger is constructed with explicit InheritedBaseAction.class =====  (LogTest.java:27)
DEBUG DEBUG Logging  (ChildInheritedAction.java:8)
DEBUG Logger Context : com.ubicompsystem.experiments.logging.inherited.InheritedBaseAction  (ChildInheritedAction.java:9)
INFO  Inherited Logger : Another Hello World  (ChildInheritedAction.java:10)
DEBUG DEBUG Logging  (AnotherChildInheritedAction.java:8)
DEBUG Logger Context : com.ubicompsystem.experiments.logging.inherited.InheritedBaseAction  (AnotherChildInheritedAction.java:9)
INFO  Another Inherited Logger : Another Hello World  (AnotherChildInheritedAction.java:10)
INFO  ===== END Logging with InheritedBaseAction where Logger is constructed with explicit InheritedBaseAction.class =====  (LogTest.java:35)
INFO    (LogTest.java:36)
```

From the output it is shown that the _Inherited_ family logs with `com.ubicompsystem.experiments.logging.inherited.InheritedBaseAction` category,
whereas the _this.getClass()_ family logs with the respective child Action classname.
