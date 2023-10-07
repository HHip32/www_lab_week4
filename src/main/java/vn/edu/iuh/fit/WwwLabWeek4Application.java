package vn.edu.iuh.fit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import vn.edu.iuh.fit.daos.Address_DAO;
import vn.edu.iuh.fit.daos.Candidate_DAO;
import vn.edu.iuh.fit.models.Address;
import vn.edu.iuh.fit.models.Candidate;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class WwwLabWeek4Application {
    @Autowired
    private Candidate_DAO candidate_dao;

    public static void main(String[] args) {
        SpringApplication.run(WwwLabWeek4Application.class, args);
    }

    @Bean
    public CommandLineRunner ex1(){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                Address address = new Address("2536442d-8a32-4acf-9dfc-7a4e25edb333"
                        ,"Quang Trung","SG", 1, "11","5345643");
                Candidate candidate = new Candidate(1, LocalDateTime.now()
                        ,"hoaihiep@gmail.com","Phan Nguyen Hoai Hiep","0999999999",address);
                candidate_dao.insert(candidate);
            }
        };
    }

}
