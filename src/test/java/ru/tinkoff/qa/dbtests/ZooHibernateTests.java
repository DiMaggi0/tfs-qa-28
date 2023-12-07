package ru.tinkoff.qa.dbtests;

import org.hibernate.Session;
import org.junit.jupiter.api.*;
import ru.tinkoff.qa.hibernate.BeforeCreator;
import ru.tinkoff.qa.hibernate.HibernateSessionFactoryCreator;
import ru.tinkoff.qa.hibernate.entities.Animal;
import ru.tinkoff.qa.hibernate.entities.Places;
import ru.tinkoff.qa.hibernate.entities.Workman;

import java.util.List;
import java.util.Set;

public class ZooHibernateTests {

    @BeforeAll
    static void init() {
        BeforeCreator.createData();
    }
    Session session;
    @BeforeEach
    void openSession(){
        session = HibernateSessionFactoryCreator.createSessionFactory().openSession();
    }
    @AfterEach
    void closeSession() {
        session.close();
    }

    /**
     * В таблице public.animal ровно 10 записей
     */
    @Test
    public void countRowAnimal() {
        long countRow = session.createQuery("from Animal").stream().count();
        Assertions.assertEquals(countRow, 10, "Verify table public.animal have 10 row");

    }

    /**
     * В таблицу public.animal нельзя добавить строку с индексом от 1 до 10 включительно
     */
    @Test
    public void insertIndexAnimal() {
        Animal animal = new Animal();
        int numberOfExceptions = 0;
        for (int i = 0; i < 11; i++) {
            try {
                session.beginTransaction();
                animal.setId(i);
                session.save(animal);
            } catch (Exception e) {
                numberOfExceptions++;
            }
        }
        Assertions.assertEquals(numberOfExceptions, 10, "Verify we can't add row with id between 1 and 10");
    }

    /**
     * В таблицу public.workman нельзя добавить строку с name = null
     */
    @Test
    public void insertNullToWorkman() {
        boolean insertNull = false;
        Workman workman = new Workman();
        try {
            session.beginTransaction();
            workman.setName(null);
            session.save(workman);

        } catch (Exception e) {
            insertNull = true;
        }
        Assertions.assertTrue(insertNull, "Verify we can't add row with name = null");
    }

    /**
     * Если в таблицу public.places добавить еще одну строку, то в ней будет 6 строк
     */
    @Test
    public void insertPlacesCountRow() {
        Places places = new Places();
        session.beginTransaction();
        places.setId(6);
        places.setPlace_num(1);
        places.setRow(3);
        places.setName("Tinkoff");
        session.save(places);
        Assertions.assertEquals(session.createQuery("from Places").stream().count(),
                6, "Verify after adding row table have 6 rows");


    }

    /**
     * В таблице public.zoo всего три записи с name 'Центральный', 'Северный', 'Западный'
     */
    @Test
    public void countRowZoo() {
        String[] names = {"\u0426\u0435\u043d\u0442\u0440\u0430\u043b\u044c\u043d\u044b\u0439","\u0421\u0435\u0432\u0435\u0440\u043d\u044b\u0439","\u0417\u0430\u043f\u0430\u0434\u043d\u044b\u0439"};
        StringBuilder query = new StringBuilder("select distinct name from Zoo where name in(");
        for (String name : names) {
            query.append("'").append(name).append("',");
        }
        query = new StringBuilder(query.substring(0, query.length() - 1) + ")");
        long resultRowCount = session.createQuery(query.toString()).getResultList().size();
        Assertions.assertEquals(resultRowCount, 3, "Verify table zoo only three rows with distinct names");

    }
}
