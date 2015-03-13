package net.jmlproductions.alex.server;

public class Registration
{
    private AlexUser user;
    private AddressWithPort address;

    public Registration(AlexUser user, AddressWithPort address)
    {
        this.user = user;
        this.address = address;
    }

    public AlexUser getUser()
    {
        return user;
    }

    public AddressWithPort getAddress()
    {
        return address;
    }
}
