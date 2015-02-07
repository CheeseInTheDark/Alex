package net.jmlproductions.alex.server;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.net.InetAddress;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;


public class MessageDispatcherTest
{
    private MessageDispatcher underTest;
    
    @Mock
    private Sender sender;
    
    @Mock
    private Message message;
    
    @Mock
    private AddressBook addressBook;
    
    @Mock
    private InetAddress address;
    
    @Before
    public void setup()
    {
        initMocks(this);
        
        when(message.translateDestination(addressBook)).thenReturn(address);

        underTest = new MessageDispatcher(sender, addressBook);
    }
    
    @Test
    public void shouldDispatchMessage()
    {
        underTest.send(message);
        
        verify(sender).send(message, address);
    }
}
