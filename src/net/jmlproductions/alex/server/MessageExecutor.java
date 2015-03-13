package net.jmlproductions.alex.server;


public class MessageExecutor extends AlexCommandExecutor<Message>
{
    private Sender sender;
    private AddressBook addressBook;
    
    public MessageExecutor(Sender sender, AddressBook addressBook)
    {
        this.sender = sender;
        this.addressBook = addressBook;
    }

    @Override
    public void executeUsingConvertedArguments(Message message)
    {
        AddressWithPort destination = message.translateDestination(addressBook);
        
        sender.send(message, destination);
    }

}
