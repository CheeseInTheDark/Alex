package net.jmlproductions.alex.server;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Deserializer
{

    @SuppressWarnings("unchecked")
    public <T> T deserialize(byte[] data) throws ClassNotFoundException, IOException
    {
        try
        {
            return (T) new ObjectInputStream(new ByteArrayInputStream(data)).readObject();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

}
