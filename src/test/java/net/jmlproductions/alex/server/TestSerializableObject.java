package net.jmlproductions.alex.server;

import java.io.Serializable;

public class TestSerializableObject implements Serializable 
{
    private static final long serialVersionUID = 1L;

    private Object data;

    public TestSerializableObject(Object data)
    {
        this.data = data;
    }

    public Object getData()
    {
        return data;
    }
}