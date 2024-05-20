//package com.example.demospring;
//
//import com.example.demospring.entity.User;
//import com.example.demospring.repository.UserRepository;
//import com.example.demospring.specification.SearchCriteria;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = { PersistenceJPAConfig.class })
//@Transactional
//@TransactionConfiguration
//public class JPASpecificationIntegrationTest {
//
//    @Autowired
//    private UserRepository repository;
//
//    private User userJohn;
//    private User userTom;
//
//    @Before
//    public void init() {
//        userJohn = new User();
//        userJohn.setUserName("John");
//        userJohn.setEmail("john@doe.com");
//        userJohn.setPhoneNumber("22");
//        repository.save(userJohn);
//
//        userTom = new User();
//        userTom.setUserName("Tom");
//        userTom.setEmail("Tom@doe.com");
//        userTom.setPhoneNumber("22");
//        repository.save(userTom);
//    }
//
//    @Test
//    public void givenLast_whenGettingListOfUsers_thenCorrect() {
//        UserSpecification spec =
//                new UserSpecification(new SearchCriteria("lastName", ":", "doe"));
//
//        List<User> results = repository.findAll(spec);
//
//        assertThat(userJohn, isIn(results));
//        assertThat(userTom, isIn(results));
//    }
//}