package com.app.rc.getting_started_with_jpa_relationships;

import com.app.rc.getting_started_with_jpa_relationships.config.ClientSupport;
import com.app.rc.getting_started_with_jpa_relationships.data.dao.BooksDAO;
import com.app.rc.getting_started_with_jpa_relationships.shared.dto.BooksDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

/**
 * @author iHSPA
 */
@SpringBootApplication
public class GettingStartedWithJpaRelationshipsApplication implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger(GettingStartedWithJpaRelationshipsApplication.class);
    private static final String DIV_SINGLE = "-----------------------------------------------------------------";

    @Autowired
    private BooksDAO booksDAO;

    ClientSupport cs = new ClientSupport();

    public static void main(String[] args) {
        SpringApplication.run(GettingStartedWithJpaRelationshipsApplication.class, args);
    }

    /**
     * Callback used to run the bean.
     *
     * @param args incoming main method arguments
     * @throws Exception on error
     */
    @Override
    public void run(String... args) {
        /*
        booksRepository.save(new BooksEntity(1, "Getting Started", "Programming", "Software", true,
                (new Date(System.currentTimeMillis())), (new Date(System.currentTimeMillis()))));
        booksRepository.save(new BooksEntity(2, "Hands On With", "Programming", "Software", true,
                (new Date(System.currentTimeMillis())), (new Date(System.currentTimeMillis()))));
        booksRepository.save(new BooksEntity(3, "Face To Face With", "Programming", "Software", true,
                (new Date(System.currentTimeMillis())), (new Date(System.currentTimeMillis()))));
        */

        this.getAllBooksData();
        this.getBookById(33);
        this.getBookById(34);
    }

    /**
     * Test stub for getting all books data
     */
    public void getAllBooksData() {
        LOG.info("Display BOOKS data");
        LOG.info(DIV_SINGLE);
        final List<BooksDTO> response = booksDAO.getAllBooksData();
        response.stream().forEach(S -> LOG.info(S.toString()));
    }

    /**
     * Get Book object based on passed ID
     *
     * @param id Valid ID to find Book Record with
     */
    public void getBookById(int id) {
        LOG.info("Display BOOKS data by ID");
        LOG.info(DIV_SINGLE);
        LOG.info(booksDAO.findBookById(id).toString());
    }
}
