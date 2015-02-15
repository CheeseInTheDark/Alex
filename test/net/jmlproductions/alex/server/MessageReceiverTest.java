package net.jmlproductions.alex.server;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

public class MessageReceiverTest
{
	private MessageReceiver underTest;

    @Mock
    private Listener listener;
    
    @Mock
    private Message message;
    
    @Mock
    private MessageDispatcher dispatcher;
    
	@Before
	public void setup() throws ClassNotFoundException, IOException
	{
	    initMocks(this);

	    underTest = new MessageReceiver(listener, dispatcher);
	    
	    when(listener.listen()).thenReturn(message);
	}
	
	@Test
	public void shouldSendMessageToHandler() throws ClassNotFoundException, IOException
	{
		underTest.listen();
		
		verify(dispatcher).send(message);
	}
}
