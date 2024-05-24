:a
@echo on
REM Compilation
javac -d ../class --module-path ..\lib\javafx-sdk-22.0.1\lib --add-modules javafx.controls ../src/view/*.java ../src/controller/*.java ../src/model/data/*.java ../src/model/dao/*.java
@REM javac -d ../class --module-path javafx-sdk-22.0.1\lib --add-modules javafx.controls,javafx.base ../src/TimerApp.java ../src/timer/view/*.java ../src/timer/controller/*.java ../src/timer/model/*.java
@REM javac -d ../class `dir . -name *.java`
REM Execution

java --module-path "..\lib\mysql-connector-j-8.4.0\mysql-connector-j-8.4.0.jar;..\lib\javafx-sdk-22.0.1\lib" --add-modules javafx.controls view.App

@REM java --module-path javafx-sdk-22.0.1/lib --add-modules javafx.controls,javafx.base TimerApp 
@echo off
pause
CLS
GOTO :a