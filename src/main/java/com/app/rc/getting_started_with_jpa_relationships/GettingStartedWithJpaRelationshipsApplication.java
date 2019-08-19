package com.app.rc.getting_started_with_jpa_relationships;

import com.app.rc.getting_started_with_jpa_relationships.config.ClientSupport;
import com.app.rc.getting_started_with_jpa_relationships.data.dao.BooksDAOImpl;
import com.app.rc.getting_started_with_jpa_relationships.data.entity.BooksEntity;
import com.app.rc.getting_started_with_jpa_relationships.data.repository.BooksRepository;
import com.app.rc.getting_started_with_jpa_relationships.shared.dto.BooksDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.List;

/**
 * @author iHSPA
 */
@SpringBootApplication
public class GettingStartedWithJpaRelationshipsApplication implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger(GettingStartedWithJpaRelationshipsApplication.class);
    private static final String DIV_SINGLE = "-----------------------------------------------------------------";

    private static boolean toCreate = false;


    @Autowired
    private BooksDAOImpl booksDAOImpl;

    @Autowired
    private BooksRepository booksRepository;

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

        if (toCreate) {
            // Comment-out of ddl-update type is not create-drop type //
            booksRepository.save(new BooksEntity(1, "Getting Started", "Programming", "Software", true,
                    (new Date(System.currentTimeMillis())), (new Date(System.currentTimeMillis()))));
            booksRepository.save(new BooksEntity(2, "Hands On With", "Programming", "Software", true,
                    (new Date(System.currentTimeMillis())), (new Date(System.currentTimeMillis()))));
            booksRepository.save(new BooksEntity(3, "Face To Face With", "Programming", "Software", true,
                    (new Date(System.currentTimeMillis())), (new Date(System.currentTimeMillis()))));
        }
        this.getAllBooksData();
        LOG.info("Last ID Used -> {}", booksDAOImpl.findLastId());
    }

    /**
     * Get all Book data
     */
    public void getAllBooksData() {
        LOG.info("Display BOOKS data");
        LOG.info(DIV_SINGLE);
        final List<BooksDTO> response = booksDAOImpl.getAllBooksData();
        response.stream().forEach(S -> LOG.info(S.toString()));
    }
}
