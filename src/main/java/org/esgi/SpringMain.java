package org.esgi;

import static org.junit.Assert.assertTrue;

import org.esgi.use_case.contractor.application.ContractorService;
import org.esgi.use_case.contractor.application.CreateContractorEvent;
import org.esgi.use_case.contractor.domain.Contractor;
import org.esgi.use_case.contractor.domain.ContractorId;
import org.esgi.use_case.contractor.domain.ContractorRepository;
import org.esgi.use_case.contractor.infrastructure.InMemoryContractorRepository;
import org.esgi.use_case.project.application.CreateProjectEvent;
import org.esgi.use_case.project.application.ProjectService;
import org.esgi.use_case.project.domain.Project;
import org.esgi.use_case.project.domain.ProjectId;
import org.esgi.use_case.project.domain.ProjectRepository;
import org.esgi.use_case.tradesman.application.CreateTradesmanEvent;
import org.esgi.use_case.tradesman.application.TradesmanService;
import org.esgi.domain.Email;
import org.esgi.domain.Password;
import org.esgi.domain.address.Address;
import org.esgi.domain.address.AddressBuilder;
import org.esgi.domain.creditcard.CreditCard;
import org.esgi.domain.creditcard.CreditCardBuilder;
import org.esgi.use_case.tradesman.domain.Tradesman;
import org.esgi.use_case.tradesman.domain.TradesmanId;
import org.esgi.use_case.tradesman.domain.TradesmanRepository;
import org.esgi.use_case.tradesman.infrastructure.InMemoryTradesmanRepository;
import org.esgi.kernel.ApplicationEvent;
import org.esgi.kernel.EventBus;
import org.esgi.kernel.SimpleEventBus;
import org.esgi.use_case.project.infrastructure.InMemoryProjectRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class SpringMain
{
    public static void main( String[] args ) throws ParseException {
        //final ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringMain.class, args);

        final TradesmanRepository tradesmanRepository = new InMemoryTradesmanRepository();
        final ContractorRepository contractorRepository = new InMemoryContractorRepository();
        final ProjectRepository projectRepository = new InMemoryProjectRepository();

        /*
          event initialisation
         */
        EventBus<ApplicationEvent> eventBus = new SimpleEventBus<>();
        eventBus.register(CreateTradesmanEvent.class, List.of(new CreateTradesmanEventListener()));
        eventBus.register(TradesmanAddCreditCard.class,List.of(new TradesmanAddCreditCardListener()));
        final TradesmanService tradesmanService = new TradesmanService(tradesmanRepository, eventBus);
        final ContractorService contractorService = new ContractorService(contractorRepository, eventBus);
        final ProjectService projectService = new ProjectService(projectRepository,eventBus);

        /*
         * tradesman id creation
         */
        final TradesmanId tradesmanId1 = tradesmanRepository.nextIdentity();
        final TradesmanId tradesmanId2 = tradesmanRepository.nextIdentity();

        /*
         * contractor Id creation
         */
        final ContractorId contractorId1 = contractorRepository.nextIdentity();

        /*
        project Id
         */
        final ProjectId projectId1 = projectRepository.nextIdentity();

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
        addTradesman(tradesmanService, tradesmanId1, address1, creditCard1, new Password("Coucou1$"), new Email("coucou@mail.com"), "je suis compétant", 10.0, "certificat");
        printTradesman(tradesmanRepository, tradesmanId1);

        /*
        add contractor
         */
        addContractor(contractorService,contractorId1, new Password("azertDS23$"), new Email("dokdksd@dkklslkd.com"), creditCard3);
        addProjectToContractor(contractorService, contractorId1, projectId1);

        addTradesman(tradesmanService, tradesmanId2, address2, creditCard2, new Password("Azerty12*%"), new Email("michelle@toto.fr"), "je suis pas compétant", 12,"lalala", "orly");
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
 * todo:
 *      - vérifier qu'un email contractor est unique dans les contractor / idem pour tradesman
 *      - vérifié q'uun projet est dans un seul contractor
 *      - vérifier contractor inscription / tradesman via eventlistener
 *      - payement
 */
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

    private static void addTradesman(TradesmanService tradesmanService, TradesmanId tradesmanId, Address address, CreditCard creditCard, Password password, Email email, String skills, double dailyRate, String qualificationCertificate){
        Tradesman tradesman = Tradesman.of(tradesmanId,"JD","COUCOU",address, creditCard, password, email, skills, dailyRate, qualificationCertificate);
        tradesmanService.create(tradesman);
    }

    private static void addContractor(ContractorService contractorService ,ContractorId id, Password password, Email email, CreditCard creditCard) {
        Contractor contractor = Contractor.of(id,"dada","dodo", password, email, creditCard);
        contractorService.create(contractor);
    }

    private static void createProject(ProjectService projectService, ProjectId id, String name, String description, List<String> jobs, List<String> skills, String location, double dailyRate, double duration){
        Project project = Project.of(id, name, description, jobs, skills, location, dailyRate,duration);
        projectService.create(project);
    }

    private static void addProjectToContractor(ContractorService contractorService, ContractorId id, ProjectId projectId){
        contractorService.addProject(id,projectId);
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
}
