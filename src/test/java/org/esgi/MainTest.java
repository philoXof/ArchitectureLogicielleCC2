package org.esgi;

import static org.junit.Assert.assertTrue;

import org.esgi.application.CreateTradesmanEvent;
import org.esgi.application.TradesmanAddCreditCard;
import org.esgi.application.TradesmanService;
import org.esgi.domain.Password;
import org.esgi.domain.address.Address;
import org.esgi.domain.address.AddressBuilder;
import org.esgi.domain.creditcard.CreditCard;
import org.esgi.domain.creditcard.CreditCardBuilder;
import org.esgi.domain.tradesman.Tradesman;
import org.esgi.domain.tradesman.TradesmanId;
import org.esgi.domain.tradesman.TradesmanRepository;
import org.esgi.infrastructure.InMemoryTradesmanRepository;
import org.esgi.kernel.ApplicationEvent;
import org.esgi.kernel.EventBus;
import org.esgi.kernel.SimpleEventBus;
import org.junit.Test;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class MainTest
{
    public static void main( String[] args ) throws ParseException {

        final TradesmanRepository tradesmanRepository = new InMemoryTradesmanRepository();

        /*
          event initialisation
         */
        EventBus<ApplicationEvent> eventBus = new SimpleEventBus<>();
        eventBus.register(CreateTradesmanEvent.class, List.of(new CreateTradesmanEventListener()));
        eventBus.register(TradesmanAddCreditCard.class,List.of(new TradesmanAddCreditCardListener()));
        final TradesmanService tradesmanService = new TradesmanService(tradesmanRepository, eventBus);

        /*
         * user id creation
         */
        final TradesmanId tradesmanId1 = tradesmanRepository.nextIdentity();
        final TradesmanId tradesmanId2 = tradesmanRepository.nextIdentity();

        /*
         * build Address
         */
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
        Address address3 = addressBuilder
                .withCity("MARSEILLE")
                .withLine("ROUTE DES VINS")
                .withNumber("42")
                .build();

        /*
         * build CreditCard
         */
        final CreditCardBuilder creditCardBuilder =
                CreditCardBuilder.create();
        CreditCard creditCard1 = creditCardBuilder
                .withCreditCardOwner("JEHANNO LUCAS")
                .withExpirationDate(stringToDate("05/23"))
                .withCryptogram("1746 2957 3257 2196")
                .withCardNumber("632")
                .build();
        CreditCard creditCard2 = creditCardBuilder
                .withCreditCardOwner("DUPONT MICHELLE")
                .withExpirationDate(stringToDate("12/22"))
                .withCryptogram("183")
                .withCardNumber("12731 6250 9175 1736")
                .build();
        CreditCard creditCard3 = creditCardBuilder
                .withCreditCardOwner("DANIEL JACQUELINE")
                .withExpirationDate(stringToDate("05/24"))
                .withCryptogram("352")
                .withCardNumber("2421 3245 1353 6353")
                .build();

        /*
         * add tradesmen
         */
        addTradesman(tradesmanService, tradesmanId1, address1, creditCard1, new Password("Coucou1$"));
        printTradesman(tradesmanRepository, tradesmanId1);

        addTradesman(tradesmanService, tradesmanId2, address2, creditCard2, new Password("Azerty12*%"));
        printTradesman(tradesmanRepository, tradesmanId2);

        /*
         * change address tradesmen
         */
        changeAddress(tradesmanService, tradesmanId2, address3);

        /*
         * change creditCard
         */
        changeCreditCard(tradesmanService, tradesmanId1, creditCard3);
        printTradesmen(tradesmanService);
    }

    /**
     *
     * @param date Date Format credit Card
     * @return Date complete to allow comparison between 2 Date
     * @throws ParseException exception
     */
    private static Date stringToDate(String date) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/yy");
        return simpleDateFormat.parse(date);
    }

    private static String dateToString(Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/yy");
        return simpleDateFormat.format(date);
    }

    private static void addTradesman(TradesmanService tradesmanService, TradesmanId tradesmanId, Address address, CreditCard creditCard, Password password){
        Tradesman tradesman = Tradesman.of(tradesmanId,"JD","COUCOU",address, creditCard, password);
        tradesmanService.create(tradesman);
    }

    private static void changeAddress(TradesmanService tradesmanService, TradesmanId id, Address address){
        tradesmanService.changeAddress(id, address);
    }

    private static void changeCreditCard(TradesmanService tradesmanService, TradesmanId tradesmanId, CreditCard creditCard){
        tradesmanService.changeCreditCard(tradesmanId,creditCard);
    }

    private static void printTradesmen(TradesmanService tradesmanService){
        System.out.println("Tradesmen List :");
        final List<Tradesman> tradesmen = tradesmanService.all();
        tradesmen.forEach(System.out::println);
    }

    private static void printTradesman(TradesmanRepository tradesmanRepository, TradesmanId id){
        System.out.println(tradesmanRepository.findById(id));
    }





    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
}
