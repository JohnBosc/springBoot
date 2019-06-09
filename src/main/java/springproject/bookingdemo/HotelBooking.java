package springproject.bookingdemo;

public class HotelBooking {
    private String hotelName;
    private double pricePerNight;
    private int nbOfNights;

    public HotelBooking(){}

    public HotelBooking(String hotelName, double pricePerNight, int nbOfNights){

        this.hotelName = hotelName;
        this.pricePerNight = pricePerNight;
        this.nbOfNights = nbOfNights;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public String getHotelName() {
        return hotelName;
    }

    public int getNbOfNights() {
        return nbOfNights;
    }

    public double getTotalPrice(){
        return pricePerNight * nbOfNights;
    }
}
