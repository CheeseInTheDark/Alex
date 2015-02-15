package net.jmlproductions.alex.server;

import static com.google.common.collect.Maps.newHashMap;

import java.net.InetAddress;
import java.util.Map;

public class AddressBook
{
    private Map<AlexUser, InetAddress> addressMap;
    
    public AddressBook()
    {
        addressMap = newHashMap();
    }
    
    public InetAddress lookup(AlexUser recipient)
    {
        return addressMap.get(recipient);
    }

    public void add(AlexUser user, InetAddress address)
    {
        addressMap.put(user, address);
    }
}
