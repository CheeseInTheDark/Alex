package net.jmlproductions.alex.server;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;


public class MessageTest
{
    private Message underTest;
    
    @Mock
    private AlexUser recipient;
    
    @Mock
    private AddressBook addressBook;
    
    @Mock
    private AddressWithPort expectedAddress;
    
    @Before
    public void setup()
    {
        initMocks(this);

        underTest = new Message(recipient);

        when(addressBook.lookup(recipient)).thenReturn(expectedAddress);
    }
    
    @Test
    public void shouldTranslateAddress()
    {
        AddressWithPort address = underTest.translateDestination(addressBook);
        
        assertThat(address, is(expectedAddress));
    }
}
