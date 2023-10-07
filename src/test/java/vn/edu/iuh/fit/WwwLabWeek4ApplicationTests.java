package vn.edu.iuh.fit;

import jakarta.annotation.PostConstruct;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vn.edu.iuh.fit.daos.Address_DAO;
import vn.edu.iuh.fit.daos.Candidate_DAO;
import vn.edu.iuh.fit.models.Address;
import vn.edu.iuh.fit.models.Candidate;

import java.time.LocalDateTime;
import java.util.UUID;

@SpringBootTest
class WwwLabWeek4ApplicationTests {

    @Autowired
    private Address_DAO addressDao;
//    @PostConstruct
    void insert() {
        Address address = new Address("2536442d-8a32-4acf-9dfc-7a4e25edb333","Quang Trung","SG", 1, "11","5345643");
        addressDao.insert(address);
    }

    @Test
    void getById() {
        Address address = addressDao.getById("2536442d-8a32-4acf-9dfc-7a4e25edb333");
        Assertions.assertEquals(address.getStreet(),"NVQ");
    }

    @Test
    void getALL() {
    }
}
