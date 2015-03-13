package net.jmlproductions.alex.server;

import static org.mockito.Mockito.verify;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class RegistrationExecutorTest
{
    private AlexCommandExecutor<Registration> underTest;
    
    @Mock
    private AddressBook addressBook;
    
    private Registration registration;
    
    @Mock
    private AlexUser user;
    
    @Mock
    private AddressWithPort address;
    
    @Before
    public void setup() throws IOException
    {
        MockitoAnnotations.initMocks(this);
        
        registration = new Registration(user, address);
        
        underTest = new RegistrationExecutor(addressBook);
    }
    
    @Test
    public void shouldAddEntryToAddressBook()
    {
        underTest.executeUsingConvertedArguments(registration);
        
        verify(addressBook).add(user, address);
    }
}
