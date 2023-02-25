package kodlama.io.rentacar;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RentACarApplication {

    public static void main(String[] args) {
        SpringApplication.run(RentACarApplication.class, args);
    }
//Asagida program baslatildiginda direk otomatik olusturulacak modelmapper olusturulur bekler
    @Bean
public ModelMapper getModelMapper(){
        return  new ModelMapper();
}
}
