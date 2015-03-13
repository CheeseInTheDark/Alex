package net.jmlproductions.alex.server;

import java.io.Serializable;
import java.net.InetAddress;

public class AddressWithPort implements Serializable
{
    private static final long serialVersionUID = -8015342628615044777L;
    private InetAddress address;
    private int port;

    public AddressWithPort(InetAddress address, int port)
    {
        this.address = address;
        this.port = port;
    }

    public int getPort()
    {
        return port;
    }

    public InetAddress getAddress()
    {
        return address;
    }
}
