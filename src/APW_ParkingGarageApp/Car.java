
package APW_ParkingGarageApp;

import java.time.LocalDateTime;

/**
 * This class is used to simulate a Car object.
 * @author andre_000
 */
public class Car {

    private Ticket ticket = new Ticket();

    public Car() {
    }

    /**
     * getter for Ticket object.
     * @return Ticket
     */
    public final Ticket getTicket() {
        return ticket;
    }
    
    /**
     * setter for Ticket takes a localDateTime as inTime
     * @param inTime LocalDateDate
     */
    public final void setTicket(LocalDateTime inTime) {
        ticket.setInTime(inTime);
    }

    /**
     * getter for inTime property
     * @return LocalDateTime
     */
    public final LocalDateTime getInTime() {
        return ticket.getInTime();
    }
    
    /**
     * Setter for custID property
     * @param custId int
     */
    public final void setCustId(int custId){
        ticket.setCustId(custId);
    }
    
    /**
     * Getter for custID property
     * @return int
     */
    public final int getCustId(){
        return ticket.getCustId();
    }
  
    
   
    /**
     * Override of toString returns a String of the custId property
     * @return String
     */
    @Override
    public final String toString() {
        return String.valueOf(ticket.getCustId());
    }
    
    
    
}
