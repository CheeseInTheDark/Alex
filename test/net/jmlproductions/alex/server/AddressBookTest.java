package net.jmlproductions.alex.server;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


public class AddressBookTest
{
    private AddressBook underTest;
    
    @Mock
    private AlexUser user;
    
    @Mock
    private AlexUser anotherUser;
    
    @Mock
    private AddressWithPort expectedAddress;
    
    @Mock
    private AddressWithPort anotherAddress;
    
    @Before
    public void setup()
    {
        MockitoAnnotations.initMocks(this);
        
        underTest = new AddressBook();
        
        underTest.add(user, expectedAddress);
        underTest.add(anotherUser, anotherAddress);
    }
    
    @Test
    public void shouldRetrieveAddress()
    {
        AddressWithPort address = underTest.lookup(user);
        
        assertThat(address, is(expectedAddress));
    }
    
    @Test
    public void shouldRetrieveADifferentAddress()
    {
        AddressWithPort address = underTest.lookup(anotherUser);
        
        assertThat(address, is(anotherAddress));
    }
}
