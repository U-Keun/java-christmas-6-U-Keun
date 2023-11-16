package christmas;

import christmas.controller.Controller;

public class Application {
    public static void main(String[] args) {
        Controller reservationController = Controller.generateReservationController();
        reservationController.start();
    }
}
