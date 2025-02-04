package DESIGNPATTERNS.chainOfResponsibility;

public class Test {

    public static void main(String args[]){
        Logger logger = new InfoLevelLogger(LogLevel.INFO,
                new DebugLevelLogger(LogLevel.DEBUG,
                        new ErrorLevelLogger(LogLevel.ERROR, null)));
        logger.log("Yayy", LogLevel.DEBUG);
    }
}


abstract class Logger{
    Logger nextLogProcessor;
    LogLevel logLevel;
    abstract void log(String content, LogLevel level);
}

enum LogLevel{
    INFO,
    DEBUG,
    ERROR
}

class InfoLevelLogger extends Logger{
    InfoLevelLogger(LogLevel level, Logger nextLogProcessor){
        this.logLevel = level;
        this.nextLogProcessor = nextLogProcessor;
    }
    public void log(String content, LogLevel level){
        if(level==this.logLevel){
            System.out.println("Log level INFO: "+ this.logLevel + " : "+ content);
        }else {
            nextLogProcessor.log(content, level);
        }
    }
}

class DebugLevelLogger extends Logger{
    DebugLevelLogger(LogLevel level, Logger nextLogProcessor){
        this.logLevel = level;
        this.nextLogProcessor = nextLogProcessor;
    }
    public void log(String content, LogLevel level){
        if(level==this.logLevel){
            System.out.println("Log level DEBUG: "+ this.logLevel + " : "+ content);
        }else {
            nextLogProcessor.log(content, level);
        }
    }
}

class ErrorLevelLogger extends Logger{
    ErrorLevelLogger(LogLevel level, Logger nextLogProcessor){
        this.logLevel = level;
        this.nextLogProcessor = nextLogProcessor;
    }
    public void log(String content, LogLevel level){
        if(level==this.logLevel){
            System.out.println("Log level ERROR: "+ this.logLevel + " : "+ content);
        }else {
            nextLogProcessor.log(content, level);
        }
    }
}