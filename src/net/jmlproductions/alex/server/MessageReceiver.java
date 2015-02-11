package net.jmlproductions.alex.server;

public class MessageReceiver
{
    private Listener listener;
    private MessageDispatcher dispatcher;
    
	public MessageReceiver(Listener listener, MessageDispatcher dispatcher)
    {
        this.listener = listener;
        this.dispatcher = dispatcher;
    }

    public void listen()
	{
		Message message = listener.listen();
		dispatcher.send(message);
	}

}
