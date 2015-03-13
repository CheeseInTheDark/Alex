package net.jmlproductions.alex.server;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.junit.Before;
import org.junit.Test;


public class DeserializerTest implements Serializable
{
 
    private static final long serialVersionUID = 5216855927541856766L;
    
    private String someData = "DERP";
    
    private byte[] bytes;
    
    @Before
    public void setup() throws IOException
    {
        TestSerializableObject serializable = new TestSerializableObject(someData);
        
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        ObjectOutputStream outputStream = new ObjectOutputStream(byteStream);
        
        outputStream.writeObject(serializable);
        
        bytes = byteStream.toByteArray();
    }
    
    @Test
    public void shouldDeserializeObject() throws IOException, ClassNotFoundException
    {
        Deserializer underTest = new Deserializer();
        
        TestSerializableObject result = underTest.deserialize(bytes);
        
        assertThat(result.getData(), is(someData));
    }
}
