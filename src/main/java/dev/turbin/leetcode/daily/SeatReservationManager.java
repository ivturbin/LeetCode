package dev.turbin.leetcode.daily;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Design a system that manages the reservation state of n seats that are numbered from 1 to n.
 * Implement the SeatManager class:
 * SeatManager(int n) Initializes a SeatManager object that will manage n seats numbered from 1 to n. All seats are initially available.
 * int reserve() Fetches the smallest-numbered unreserved seat, reserves it, and returns its number.
 * void unreserve(int seatNumber) Unreserves the seat with the given seatNumber.
 */

@SpringBootTest
public class SeatReservationManager {


    @Test
    void test1() {
        SeatManager seatManager = new SeatManager(3); // Initializes a SeatManager with 5 seats.
        seatManager.reserve();
        seatManager.reserve();
        seatManager.unreserve(1);
        seatManager.unreserve(2);
        seatManager.reserve();
        seatManager.unreserve(1);
        seatManager.reserve();
        seatManager.unreserve(1);
    }

    public class SeatManager {

        private final boolean[] seats;
        private int i = 0;
        public SeatManager(int n) {
            this.seats = new boolean[n];
        }

        public int reserve() {
            for (; i < seats.length; i++) {
                if (!seats[i]) {
                    seats[i] = true;
                    i++;
                    return i;
                }
            }
            return 0;
        }

        public void unreserve(int seatNumber) {
            if (seatNumber - 1 < i) {
                i = seatNumber - 1;
            }
            seats[seatNumber - 1] = false;
        }
    }
}
