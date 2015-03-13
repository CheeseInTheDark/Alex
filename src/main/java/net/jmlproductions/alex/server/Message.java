package net.jmlproductions.alex.server;


public class Message
{
    private AlexUser recipient; 

    public Message(AlexUser recipient)
    {
        this.recipient = recipient;
    }

    public AddressWithPort translateDestination(AddressBook addressBook)
    {
        return addressBook.lookup(recipient);
    }

}
