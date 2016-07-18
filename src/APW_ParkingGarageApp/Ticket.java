
package APW_ParkingGarageApp;




import java.time.LocalDateTime;


/**
 * Used to simulate a Parking Ticket
 * stores time parked and hours parking.
 * @author andre_000
 */
public class Ticket {
    private int custId;
    private LocalDateTime inTime;
  


    public Ticket() {
    }
    /**
     * getter for inTime
     * @return LocalDateTime
     */
    public final LocalDateTime getInTime() {
        return inTime;
    }
    /**
     * Setter for inTime
     * @param inTime LocalDateTime
     */
    public final void setInTime(LocalDateTime inTime) {
        if(inTime == null){
            throw new IllegalArgumentException("inTime cannot be set to Null.");
        }
        this.inTime = inTime;
    }
    /**
     * Getter for CustId
     * @return int
     */
    public final int getCustId() {
        return custId;
    }
    /**
     * Setter for custId
     * @param custId int
     */
    public final void setCustId(int custId) {
        if(custId <= 0){
             throw new IllegalArgumentException("custId must be greater than 0.");
        }
        
        this.custId = custId;
    }

}
