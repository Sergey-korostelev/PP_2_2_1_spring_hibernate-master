package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        User userEgor = new User("Egor", "Kirkorov", "Egorka@mail.ru");
        Car fastCar = new Car("Camry", 9);
        userEgor.setUserCar(fastCar);

        User userMiha = new User("Miha", "Ivanov", "Mihka@mail.ru");
        Car slowCar = new Car("Niva", 2);
        userMiha.setUserCar(slowCar);

        UserService userService = context.getBean(UserService.class);
        User user = userService.getUserByCar("Niva", 2);
        System.out.println(user.toString());

//        userService.add(userEgor);
//        userService.add(userMiha);

//        userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
//        userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
//        userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
//        userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

//        List<User> users = userService.listUsers();
//        for (User user : users) {
//            System.out.println("Id = " + user.getId());
//            System.out.println("First Name = " + user.getFirstName());
//            System.out.println("Last Name = " + user.getLastName());
//            System.out.println("Email = " + user.getEmail());
//            if (user.getUserCar() != null) {
//                System.out.println(user.getUserCar().toString());
//            }
//            System.out.println();
//        }

        context.close();
    }
}
