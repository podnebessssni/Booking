package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.netology.domain.Booking;
import ru.netology.repository.BookingRepository;

import java.util.Arrays;

@AllArgsConstructor
@Data
public class BookingManager {
    private BookingRepository repository;


    public void add(Booking item) {
        repository.save(item);
    }

    public Booking[] findAll(String from, String to) {
        Booking[] result = new Booking[0];
        for (Booking booking : repository.showAll()) {
            if (booking.getDepartAirport().equals(from) && booking.getArriveAirport().equals(to)) {
                Booking[] tmp = new Booking[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = booking;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }
}
