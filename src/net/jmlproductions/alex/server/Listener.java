package net.jmlproductions.alex.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Listener
{
    private Deserializer deserializer;
    
    private DatagramSocket socket;
    
    public Listener(DatagramSocket socket, Deserializer deserializer)
    {
        this.socket = socket;
        this.deserializer = deserializer;
    }

    public Message listen()
    {
        DatagramPacket packet = new DatagramPacket(new byte[0], 0);
        try
        {
            socket.receive(packet);
        } catch (IOException e) {}
        return deserializer.deserialize(packet.getData());
    }

}
