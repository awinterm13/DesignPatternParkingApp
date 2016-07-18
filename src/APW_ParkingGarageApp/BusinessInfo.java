/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package APW_ParkingGarageApp;

/**
 * The BusinessInfo class is used to store Information regarding the business.
 * One should be created per client. 
 * I decided to not make this a strategy because you probably would not want to include more 
 * then one of these classes in the clients system. The setters are included incase the system 
 * gets sold to new owners.  
 * @author andre_000
 */
public class BusinessInfo {

    private String name = "Best Value Parking Garage";
    private int lotSize = 20;
    
    
    
    /**
     * a getter for the size of the Lot. 
     * @return lotSize
     */
    public final int getLotSize() {
        return lotSize;
    }
    
    /**
     * setter for lotSize takes an int.
     * @param lotSize 
     */
    public final void setLotSize(int lotSize) {
        if(lotSize == 0){
            throw new IllegalArgumentException();
        }
        this.lotSize = lotSize;
    }

    
    /**
     * Getter for name property.
     * @return 
     */
    public final String getName() {
        return name;
    }
    
    /**
     * setter for name property. Takes a string.
     * @param name 
     */
    public final void setName(String name) {
        if(name == null || name == null){
            throw new IllegalArgumentException("Name is Null.");
        }
        this.name = name;
    }

}
