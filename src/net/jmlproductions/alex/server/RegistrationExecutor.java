package net.jmlproductions.alex.server;

public class RegistrationExecutor extends AlexCommandExecutor<Registration>
{
        private AddressBook addressBook;

        public RegistrationExecutor(AddressBook addressBook)
        {
            this.addressBook = addressBook;
        }
        
        @Override
        protected void executeUsingConvertedArguments(Registration arguments)
        {
            addressBook.add(arguments.getUser(), arguments.getAddress());
        }
}
