package net.jmlproductions.alex.server;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class Serializer
{
    public <T extends Serializable> byte[] serialize(T serializable)
    {
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        ObjectOutputStream outputStream;
        try
        {
            outputStream = new ObjectOutputStream(byteStream);
            outputStream.writeObject(serializable);
            
            return byteStream.toByteArray();
        }
        catch (IOException e) {}
        
        return null;
    }

}
