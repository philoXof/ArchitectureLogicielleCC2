package org.esgi;

import org.esgi.application.TradesmanService;
import org.esgi.domain.address.Address;
import org.esgi.domain.address.AddressBuilder;
import org.esgi.domain.tradesman.Tradesman;
import org.esgi.domain.tradesman.TradesmanId;
import org.esgi.domain.tradesman.TradesmanRepository;
import org.esgi.infrastructure.InMemoryTradesmanRepository;

import java.util.List;

public class Main
{
    public static void main( String[] args )
    {
        final TradesmanRepository tradesmanRepository = new InMemoryTradesmanRepository();
        final TradesmanService tradesmanService = new TradesmanService(tradesmanRepository);
        final TradesmanId tradesmanId1 = tradesmanRepository.nextIdentity();
        final TradesmanId tradesmanId2 = tradesmanRepository.nextIdentity();

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

        addTradesman(tradesmanService, tradesmanId1, address1);
        printTradesman(tradesmanRepository, tradesmanId1);

        addTradesman(tradesmanService, tradesmanId2, address2);
        printTradesman(tradesmanRepository, tradesmanId2);

        changeAddress(tradesmanService, tradesmanId1, address2);
        changeAddress(tradesmanService, tradesmanId2, address1);

        printTradesmen(tradesmanService);
    }

    private static void addTradesman(TradesmanService tradesmanService, TradesmanId tradesmanId, Address address){
        Tradesman tradesman = Tradesman.of(tradesmanId,"JD","COUCOU",address);
        tradesmanService.create(tradesman);
    }

    private static void changeAddress(TradesmanService tradesmanService, TradesmanId id, Address address){
        tradesmanService.changeAddress(id, address);
    }

    private static void printTradesmen(TradesmanService tradesmanService){
        System.out.println("User List :");
        final List<Tradesman> tradesmen = tradesmanService.all();
        tradesmen.forEach(System.out::println);
    }

    private static void printTradesman(TradesmanRepository tradesmanRepository, TradesmanId id){
        System.out.println(tradesmanRepository.findById(id));
    }

}
