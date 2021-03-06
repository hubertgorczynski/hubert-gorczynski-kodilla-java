package com.kodilla.patterns.singleton;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class LoggerTestSuite {

    @BeforeClass
    public static void writtenToLogs() {
        Logger.getInstance().log("Simple test log");
    }

    @Test
    public void testGetLastLog() {
        //Given
        //When
        String lastLogName = Logger.getInstance().getLastLog();
        //Then
        Assert.assertEquals("Simple test log", lastLogName);
    }

    @Test
    public void testGetInstance() {
        //Given
        //When
        Logger instance1 = Logger.getInstance();
        instance1.log("log1");
        Logger instance2 = Logger.getInstance();
        instance2.log("log2");

        String lastLogOfInstance1 = instance1.getLastLog();
        String lastLogOfInstance2 = instance2.getLastLog();
        String lastLogName = Logger.getInstance().getLastLog();

        //Then
        Assert.assertEquals(instance1, instance2);
        Assert.assertEquals(lastLogOfInstance1, lastLogOfInstance2);
        Assert.assertEquals(lastLogName, "log2");
    }
}