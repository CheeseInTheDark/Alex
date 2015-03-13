package net.jmlproductions.alex.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ClientSelfAddressRequestHandler
{

    private DatagramSocket socket;
    private Serializer serializer;
    
    public ClientSelfAddressRequestHandler(DatagramSocket socket, Serializer serializer)
    {
        this.socket = socket;
        this.serializer = serializer;
    }

    public void listen()
    {
        DatagramPacket packet = new DatagramPacket(new byte[0], 0);
        
        try
        {
            socket.receive(packet);
            
            AddressWithPort clientAddress = new AddressWithPort(packet.getAddress(), packet.getPort());
            
            packet.setData(serializer.serialize(clientAddress));
            packet.setAddress(packet.getAddress());
            packet.setPort(packet.getPort());
            
            socket.send(packet);
        }
        catch (IOException e) {}
    }

}
