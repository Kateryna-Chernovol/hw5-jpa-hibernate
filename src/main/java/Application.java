import chernovol.jpa.config.ApplicationConfiguration;
import chernovol.jpa.dmo.Cart;
import chernovol.jpa.dmo.CreditCard;
import chernovol.jpa.dmo.User;
import chernovol.jpa.service.CategoryService;
import chernovol.jpa.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

        UserService userService  = context.getBean(UserService.class);
        CategoryService categoryService = context.getBean(CategoryService.class);

        CreditCard creditCard1 =
                new CreditCard(1111_2222_5555_0001L,1000);

        User user1 = new User("Andrii",creditCard1);
        Cart cart1 = new Cart();

        userService.add(user1);


//        public User(String nickname, CreditCard creditCard) {
//            this.nickname = nickname;
//            this.creditCard = creditCard;
//        }
    }
}
