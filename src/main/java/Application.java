import chernovol.jpa.config.ApplicationConfiguration;
import chernovol.jpa.dmo.CreditCard;
import chernovol.jpa.dmo.User;
import chernovol.jpa.service.CreditCardService;
import chernovol.jpa.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

        UserService userService = context.getBean(UserService.class);

        CreditCard creditCard1 =
                new CreditCard(1111_2222_5555_0001L);

        CreditCardService creditCardService = context.getBean(CreditCardService.class);
        creditCardService.add(creditCard1);
        User user1 = new User("Andrii", creditCard1);

        userService.add(user1);
    }
}
