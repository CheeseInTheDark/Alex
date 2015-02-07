package net.jmlproductions.alex.server;

public class MessageReceiver
{
    private Listener listener;
    private MessageDispatcher queue;
    
	public MessageReceiver(Listener listener, MessageDispatcher queue)
    {
        this.listener = listener;
        this.queue = queue;
    }

    public void listen()
	{
		Message message = listener.listen();
		queue.send(message);
	}

}
