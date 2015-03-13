package net.jmlproductions.alex.server;

import static net.jmlproductions.testing.answers.PacketAnswer.setReceivedPacketTo;
import static net.jmlproductions.testing.matchers.PacketDataMatcher.packetWithData;
import static net.jmlproductions.testing.matchers.PacketDestinationMatcher.packetWithDestination;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isA;
import static org.hamcrest.beans.HasPropertyWithValue.hasProperty;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.argThat;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.Serializable;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ClientSelfAddressRequestHandlerTest
{
    private ClientSelfAddressRequestHandler underTest;
    
    @Mock
    private DatagramSocket socket;

    @Mock
    private InetAddress senderAddress;
    
    @Mock
    private Serializer serializer;
    
    private byte[] expectedData = new byte[0];
    
    private int senderPort = 1232;
    
    private DatagramPacket packet;
    
    @Before
    public void setup()
    {
        MockitoAnnotations.initMocks(this);
        
        packet = new DatagramPacket(new byte[0], 0, senderAddress, senderPort);
        underTest = new ClientSelfAddressRequestHandler(socket, serializer);
        
        when(serializer.serialize(argThat(serializableObjectWithAddressAndPort(senderAddress, senderPort)))).thenReturn(expectedData);
    }
    
    private Matcher<Serializable> serializableObjectWithAddressAndPort(InetAddress senderAddress, int senderPort)
    {
        return allOf(isA(Serializable.class), hasProperty("address", is(senderAddress)), hasProperty("port", is(senderPort)));
    }

    @Test
    public void shouldReturnSendersAddressAsSeenByTheServer() throws IOException
    {
        doAnswer(setReceivedPacketTo(packet)).when(socket).receive(any(DatagramPacket.class));
        
        underTest.listen();
        
        verify(socket).send(argThat(packetWithDestinationAndData(expectedData, senderAddress, senderPort)));
    }
    
    private Matcher<DatagramPacket> packetWithDestinationAndData(byte[] data, InetAddress address, int port)
    {
        return allOf(packetWithDestination(senderAddress, senderPort), packetWithData(data));
    }
}
