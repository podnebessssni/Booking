package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Booking;
import ru.netology.domain.TicketByTravelTimeAscComparator;
import ru.netology.repository.BookingRepository;

import static org.junit.jupiter.api.Assertions.*;

class BookingManagerTest {

    private BookingRepository repository = new BookingRepository();
    private BookingManager manager = new BookingManager(repository);

    private Booking ticket1 = new Booking(1, 300, "VIE", "MSQ", 120);
    private Booking ticket2 = new Booking(2, 250, "SVO", "AYT", 90);
    private Booking ticket3 = new Booking(3, 500, "IST", "BCN", 180);
    private Booking ticket4 = new Booking(4, 300, "SVO", "AYT", 100);
    private Booking ticket5 = new Booking(5, 1200, "JFK", "LHR", 420);
    private Booking ticket6 = new Booking(6, 705, "LHR", "DME", 210);
    private Booking ticket7 = new Booking(7, 155, "SVO", "AYT", 70);

    @BeforeEach
    void setUp(){
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
    }

    @Test
    void shouldShowExistTickets(){

        Booking[] expected = {ticket7, ticket2, ticket4};
        Booking[] actual = manager.findAll("SVO", "AYT", new TicketByTravelTimeAscComparator());

        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldShowNonExistTickets(){

        Booking[] expected = {};
        Booking[] actual = manager.findAll("IST", "DME", new TicketByTravelTimeAscComparator());

        assertArrayEquals(expected, actual);

    }

}