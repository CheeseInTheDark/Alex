package net.jmlproductions.alex.server;

import static net.jmlproductions.testing.answers.PacketAnswer.setReceivedPacketTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;


public class ListenerTest
{

    private Listener underTest;
    
    @Mock
    private Message expectedMessage;
    
    @Mock
    private Deserializer<Message> deserializer;
    
    @Mock
    private DatagramSocket socket;
    
    private byte[] data = new byte[0];
    
    private DatagramPacket packet = new DatagramPacket(data, 0, null, 0);
    
    @Before
    public void setup() throws IOException, ClassNotFoundException
    {
        initMocks(this);
        
        underTest = new Listener(socket, deserializer);
        
        doAnswer(setReceivedPacketTo(packet)).when(socket).receive(any(DatagramPacket.class));
        when(deserializer.deserialize(data)).thenReturn(expectedMessage);
    }
    
    @Test
    public void shouldReturnObjectInMessage() throws ClassNotFoundException, IOException
    {
        Message message = underTest.listen();
        
        assertThat(message, is(expectedMessage));
    }
}
