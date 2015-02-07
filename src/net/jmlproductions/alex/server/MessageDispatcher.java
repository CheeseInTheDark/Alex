package net.jmlproductions.alex.server;

import java.net.InetAddress;

public class MessageDispatcher
{
    private Sender sender;
    private AddressBook addressBook;
    
    public MessageDispatcher(Sender sender, AddressBook addressBook)
    {
        this.sender = sender;
        this.addressBook = addressBook;
    }

    public void send(Message message)
    {
        InetAddress destination = message.translateDestination(addressBook);
        
        sender.send(message, destination);
    }

}
