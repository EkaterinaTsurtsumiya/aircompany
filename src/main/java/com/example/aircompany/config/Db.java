//package com.example.aircompany.config;
//
//import com.example.aircompany.repository.*;
//import com.example.aircompany.structure.*;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//import java.time.LocalDateTime;
//import java.time.Month;
//import java.util.Arrays;
//import java.util.List;
//
//import static javafx.scene.input.KeyCode.T;
//
//@Component
//@RequiredArgsConstructor
//public class Db {
//
//    private final PassengerRepository passengerRepository;
//    private final PilotRepository pilotRepository;
//    private final CountryRepository countryRepository;
//    private final PlaneRepository planeRepository;
//    private final TicketRepository ticketRepository;
//    private final FlightRepository flightRepository;
//
//    @PostConstruct
//    private void AddToPass() {
//
//    }
//
//
//    @PostConstruct
//    private void AddToPilots() {
//        List<Pilot> pilots = Arrays.asList(
//                new Pilot("Андрей", "Иванов"),
//                new Pilot("Евгений", "Королев"),
//                new Pilot("Никита", "Соколов"),
//                new Pilot("Сергей", "Комаров")
//        );
//        pilotRepository.saveAll(pilots);
//    }
//
//    @PostConstruct
//    private void AddToCountries() {
//        List<Country> countries = Arrays.asList(
//                new Country("Греция"),
//                new Country("Чили"),
//                new Country("Венгрия"),
//                new Country("Чехия")
//        );
//        countryRepository.saveAll(countries);
//    }
//
//    @PostConstruct
//    private void AddToPlanes() {
//        List<Plane> planes = Arrays.asList(
//                new Plane("ТУ-134", 80),
//                new Plane("Sukhoi SuperJet-100", 98),
//                new Plane("Airbus A310", 183),
//                new Plane("Boeing-737", 117)
//        );
//        planeRepository.saveAll(planes);
//    }
//
//    @PostConstruct
//    private void AddToTickets() {
//        List<Passenger> passengers = Arrays.asList(
//                new Passenger("Кирилл", "Матвеев", "1108 544366", "k2001@yandex.ru", "+7(921)243-06-55"),
//                new Passenger("Алексей", "Петров", "1111 054233", "a_petrov@mail.ru", "+7(911)123-43-21"),
//                new Passenger("James", "Smith", "AB 433213", "jam-S@gmail.com", "+44(930)566-12-33")
//        );
//        passengerRepository.saveAll(passengers);
//        List<Ticket> tickets = Arrays.asList(
//                Ticket.builder().number("DF2378543").price(7832).typeOfClass("Эконом").passenger(passengerRepository.getOne(1)).build()
////                new Ticket("CR1234556", 5844, "Эконом"),
////                new Ticket("CL5489610", 54000, "Бизнес"),
////                new Ticket("VN7428901", 8400, "Эконом"),
////                new Ticket("GR0844671", 11600, "Эконом"),
////                new Ticket("CR1245689", 7300, "Эконом"),
////                new Ticket("CL5408665", 104000, "Бизнес"),
////                new Ticket("VN9356781", 6700, "Эконом")
//        );
//        ticketRepository.saveAll(tickets);
//    }
//
////    @PostConstruct
////    private void AddToFlight() {
////        List<Flight> flights = Arrays.asList(
////                new Flight("1235",  LocalDateTime.of(2021,Month.SEPTEMBER,21,13,50),
////                        LocalDateTime.of(2021,Month.SEPTEMBER,21, 16, 50) ),
////                new Flight("1244",  LocalDateTime.of(2021,Month.SEPTEMBER,30,9,44),
////                        LocalDateTime.of(2021, Month.OCTOBER,1, 19, 48) )
////        );
////        flightRepository.saveAll(flights);
////    }
//}
