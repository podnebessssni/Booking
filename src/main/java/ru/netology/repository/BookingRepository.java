package ru.netology.repository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ru.netology.domain.Booking;

@AllArgsConstructor
@NoArgsConstructor
public class BookingRepository {
    private Booking[] items = new Booking[0];

    public void save(Booking item) {
        int length = items.length + 1;
        Booking[] tmp = new Booking[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }
    public Booking[] showAll() {
        return items;
    }

    public void removeById(int id) {
        int length = items.length - 1;
        Booking[] tmp = new Booking[length];
        int index = 0;
        for (Booking item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }


}
