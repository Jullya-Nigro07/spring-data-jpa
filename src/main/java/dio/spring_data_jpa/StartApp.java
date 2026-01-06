package dio.spring_data_jpa;


import dio.spring_data_jpa.model.User;
import dio.spring_data_jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StartApp implements CommandLineRunner {

    @Autowired
    private UserRepository repository;

    @Override
    public void run(String... args) throws Exception{

        List<User> users = repository.filtrarPorNome("Jullya");
        List<User> users1 = repository.findByNameContaining("Fernando");
        User users3 = repository.findByUsername("sml2");

        for (User u : users){
            System.out.println(u);
        }

        for (User u : users1){
            System.out.println(u);
        }

        System.out.println(users3);
    }

    private void insertUsers(){
        User user = new User();
        user.setName("Peter");
        user.setUsername("ptrr40");
        user.setPassword("teste234");

        repository.save(user);

        for(User u: repository.findAll()){
            System.out.println(u);
        }
    }
}
