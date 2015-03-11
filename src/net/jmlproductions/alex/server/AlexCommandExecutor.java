package net.jmlproductions.alex.server;

public abstract class AlexCommandExecutor<T>
{
    @SuppressWarnings("unchecked")
    public void executeUsing(Object testArguments)
    {
        executeUsingConvertedArguments((T) testArguments);
    }

    protected abstract void executeUsingConvertedArguments(T arguments);
}
