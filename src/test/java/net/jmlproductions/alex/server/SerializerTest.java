package net.jmlproductions.alex.server;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;

import org.junit.Test;


public class SerializerTest
{
    private Serializer underTest = new Serializer();
    
    private TestSerializableObject toSerialize = new TestSerializableObject("DERP");
    
    private byte[] expectedData = new byte[] {-84, -19, 0, 5, 115, 114, 0, 53, 110, 
            101, 116, 46, 106, 109, 108, 112, 114, 111, 100, 117, 99, 116, 105, 111,
            110, 115, 46, 97, 108, 101, 120, 46, 115, 101, 114, 118, 101, 114, 46, 
            84, 101, 115, 116, 83, 101, 114, 105, 97, 108, 105, 122, 97, 98, 108, 
            101, 79, 98, 106, 101, 99, 116, 0, 0, 0, 0, 0, 0, 0, 1, 2, 0, 1, 76, 
            0, 4, 100, 97, 116, 97, 116, 0, 18, 76, 106, 97, 118, 97, 47, 108, 97,
            110, 103, 47, 79, 98, 106, 101, 99, 116, 59, 120, 112, 116, 0, 4, 68, 69, 82, 80};
    
    @Test
    public void shouldSerializeObject() throws IOException
    {
        byte[] result = underTest.serialize(toSerialize);
        
        assertThat(result, equalTo(expectedData));
    }
}
