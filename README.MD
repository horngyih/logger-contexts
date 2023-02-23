# Logging Contexts

This is a small toy project to illustrate configuration of Logging Categories.

The project contains two _family_ of **Action** classes:
- one of which creates a Logger based on a _hardcoded_ target class,
- another creates a Logger using the _this_ keyword.

**BaseAction** - creates Logger using the _this_ keyword
```Java
  Logger log = new Logger(this.getClass());
```

**InheritedBaseAction** - creates Logger usin the _hardcoded_ target class
```Java
  Logger log = new Logger(InheritedBaseAction.class);
```

A simple test runs logging on the two _families_ of **Action** classes and demonstrates
how each _family_ logger construction causes category targeting to be a problem.

Since the **InheritedBaseAction** class constructs the Logger with the _hardcoded_ target class,
the Logger created are pegged to the target class name as the Log Category _com.ubicompsystem.experiments.logging.inherited.InheritedBaseAction_
and further targeting the child classes as a category would not work since the Logger goes not further down the heirarchy.

The **BaseAction** class constructs the Logger with `this.getClass()`,
the Logger constructed therefore is pegged to the inheriting child class name as the Log Category
this allows properly to target the respective child classes Log Category.
