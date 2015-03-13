package net.jmlproductions.alex.server;

import static com.google.common.collect.Maps.newHashMap;

import java.util.Map;

public class AddressBook
{
    private Map<AlexUser, AddressWithPort> addressMap;
    
    public AddressBook()
    {
        addressMap = newHashMap();
    }
    
    public AddressWithPort lookup(AlexUser recipient)
    {
        return addressMap.get(recipient);
    }

    public void add(AlexUser user, AddressWithPort address)
    {
        addressMap.put(user, address);
    }
}
