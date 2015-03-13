package net.jmlproductions.alex.server;

import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;


public class AlexCommandExecutorTest
{
    private Object testArguments = new TestCommandArguments();
    
    @Spy
    AlexCommandExecutor<TestCommandArguments> underTest = new TestAlexCommandExecutor();
    
    @Before
    public void setup()
    {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void shouldConvertObject()
    {
        underTest.executeUsing(testArguments);
        
        verify(underTest).executeUsingConvertedArguments((TestCommandArguments) testArguments);
    }
}
