package springproject.bookingdemo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/bookings")
public class BookingController {
    private List<HotelBooking> bookinglist;

    public BookingController(){
        bookinglist = new ArrayList<>();

        bookinglist.add(new HotelBooking("Akwa Palace", 200.50, 3));
        bookinglist.add(new HotelBooking("Djeuga Palace", 300.00, 7));
        bookinglist.add(new HotelBooking("Serena Hotel", 150, 7));
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<HotelBooking> getAll(){
        return bookinglist;
    }

    @RequestMapping(value = "/affordable/{price}", method = RequestMethod.GET)
    public List<HotelBooking> getAffordable(@PathVariable double price){
        return bookinglist.stream().filter(x -> x.getPricePerNight() <= price)
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public List<HotelBooking> create(@RequestBody HotelBooking hotelBooking){

        bookinglist.add(hotelBooking);

        return bookinglist;
    }


}
