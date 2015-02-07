package net.jmlproductions.alex.server;

import java.net.InetAddress;

public class Message
{
    private AlexUser recipient; 

    public Message(AlexUser recipient)
    {
        this.recipient = recipient;
    }

    public InetAddress translateDestination(AddressBook addressBook)
    {
        return addressBook.lookup(recipient);
    }

}
