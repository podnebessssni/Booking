package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Booking implements Comparable<Booking>{
    private int id;
    private int price;
    private String departAirport;
    private String arriveAirport;
    private int travelTime;

    
    public int compareTo(Booking o) {
        return price - o.price;
    }
}
