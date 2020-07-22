package ru.netology.domain;

import java.util.Comparator;

public class TicketByPriceAscComparator implements Comparator<Booking> {

    @Override
    public int compare(Booking o1, Booking o2) {
        return o1.getTravelTime() - o2.getTravelTime();
    }
}
