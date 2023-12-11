package org.sample.bdd.tdd.setupfixture.teardown;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;


@RunWith(JUnit4.class)
public class BeforeAndAfterAnnotationsUnitTest {
   static Logger LOG=Logger.getLogger("BeforeAndAfterAnnotationsUnitTest");

    private List<String> list;


    @Before
    public void init() {
        LOG.info("startup");
        list = new ArrayList<>(Arrays.asList("test1", "test2"));
    }

    @After
    public void teardown() {
       LOG.info("teardown");
        list.clear();
    }


    @Test
    public void whenCheckingListSize_thenSizeEqualsToInit() {
        LOG.info("executing test");
        assertEquals(2, list.size());

        list.add("another test");
    }

    @Test
    public void whenCheckingListSizeAgain_thenSizeEqualsToInit() {
       LOG.info("executing another test");
        assertEquals(2, list.size());
        list.add("yet another test");
    }





    //before and after  test in junit 4

//    @BeforeClass
//    public static void setup() {
//        LOG.info("startup - creating DB connection");
//    }
//
//    @AfterClass
//    public static void tearDown() {
//        LOG.info("closing DB connection");
//    }
//
//    @Test
//    public void simpleTest() {
//        LOG.info("simple test");
//    }
//
//    @Test
//    public void anotherSimpleTest() {
//        LOG.info("another simple test");
//    }





    //before and after ech test in junit 5

//    @BeforeEach
//    void init() {
//        LOG.info("startup");
//        list = new ArrayList<>(Arrays.asList("test1", "test2"));
//    }
//
//    @AfterEach
//    void teardown() {
//        LOG.info("teardown");
//        list.clear();
//    }



    //before  and after all test in junit 5

//    @BeforeAll
//    static void setup() {
//        LOG.info("startup - creating DB connection");
//    }
//


//    @AfterAll
//    static void tearDown() {
//        LOG.info("closing DB connection");
//    }

}
