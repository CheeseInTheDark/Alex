package net.jmlproductions.alex.server;

import static net.jmlproductions.testing.answers.PacketAnswer.setReceivedPacketTo;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;


public class ListenerTest
{
    private Listener underTest;
    
    @Mock
    private AlexCommand command;
    
    private byte[] serializedCommand = new byte[0];
    
    private Class<TestCommandArguments> commandType = TestCommandArguments.class;
    
    @Mock
    private Deserializer deserializer;
    
    @Mock
    private DatagramSocket socket;
    
    @Mock
    private Map<Class<?>, ? super AlexCommandExecutor<?>> executors;
    
    @Mock
    private TestAlexCommandExecutor executor;
    
    private byte[] data = new byte[1];
    
    private DatagramPacket packet = new DatagramPacket(data, 0, null, 0);

    @Mock
    private TestCommandArguments contents;
    
    @Before
    public void setup() throws IOException, ClassNotFoundException
    {
        initMocks(this);
        
        underTest = new Listener(socket, deserializer, executors);
        
        doAnswer(setReceivedPacketTo(packet)).when(socket).receive(any(DatagramPacket.class));
        when(deserializer.deserialize(data)).thenReturn(command);
        doReturn(commandType).when(command).getType();
        doReturn(serializedCommand).when(command).getSerializedCommand();
        when(deserializer.deserialize(serializedCommand)).thenReturn(contents);
        when(executors.get(commandType)).thenReturn(executor);
    }
    
    @Test
    public void shouldPassMessageToRespectiveHandler() throws ClassNotFoundException, IOException
    {
        underTest.listen();
        
        verify(executor).executeUsing(contents);
    }
}
