package net.jmlproductions.alex.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Map;

public class Listener
{
    private Deserializer deserializer;
    
    private DatagramSocket socket;
    
    private Map<Class<?>, ? super AlexCommandExecutor<?>> executors;
    
    public Listener(DatagramSocket socket, Deserializer deserializer, Map<Class<?>, ? super AlexCommandExecutor<?>> handlers)
    {
        this.socket = socket;
        this.deserializer = deserializer;
        this.executors = handlers;
    }

    public void listen() throws ClassNotFoundException, IOException
    {
        DatagramPacket packet = new DatagramPacket(new byte[0], 0);
        try
        {
            socket.receive(packet);
        } catch (IOException e) {}
        
        AlexCommand command = deserializer.deserialize(packet.getData());
        Object arguments = deserializer.deserialize(command.getSerializedCommand());
        
        ((AlexCommandExecutor<?>) executors.get(command.getType())).executeUsing(arguments);
    }
}
