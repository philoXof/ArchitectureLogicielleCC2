package org.esgi;

import org.esgi.application.UserService;
import org.esgi.domain.address.Address;
import org.esgi.domain.address.AddressBuilder;
import org.esgi.domain.user.User;
import org.esgi.domain.user.UserId;
import org.esgi.domain.user.UserRepository;
import org.esgi.infrastructure.InMemoryUserRepository;

public class Main
{
    public static void main( String[] args )
    {

        final AddressBuilder addressBuilder =
                AddressBuilder.create().withCountry("FRANCE");
        Address address1 = addressBuilder
                .withCity("PARIS")
                .withLine("ALLEE DES PINS")
                .withNumber("25")
                .build();

        Address address2 = addressBuilder
                .withCity("LYON")
                .withLine("AVENUE DU PAPE")
                .withNumber("42")
                .build();

        UserRepository userRepository = new InMemoryUserRepository();
        UserService userService = new UserService(userRepository);


        final UserId userId1 = userRepository.nextIdentity();
        final UserId userId2 = userRepository.nextIdentity();
        addUser(userService, userId1, address1);
        addUser(userService, userId2, address2);
    }

    private static void addUser(UserService userService, UserId userId, Address address){
        User user = User.of(userId,"JD","COUCOU",address);
        userService.create(user);
        System.out.println(user);
    }

}
