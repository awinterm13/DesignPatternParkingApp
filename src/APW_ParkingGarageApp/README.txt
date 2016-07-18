 Project Parking Garage Sim
Advanced Java
Second Upload
Andrew Wintermyer
*** Semester end version ***

Extra credit 

Strategy Patterns  + 30
-------------------------------------------
FeeStrategy
CustomerReceiptFormatStrategy
BusinessReportFormatStrategy
OutputStrategy
DateTimeUtilityStrategy
CustIdValidationStrategy
FileServiceTextFormatStrategy

total of 7.

-------------------------------------------

GUI for in and out terminals + 20

-------------------------------------------

Wednesday + 10

--------------------------------------------

** New to Second Upload! **
********************************************************************

I realized while rechecking over my work with the requirements sheet that I did not have a cust Id.
So I added that to the ticket, and added getters and setters to the ticket/car classes 
and included it in my customer receipt format classes.

I also realized that my two format strategies really could have been the same strategy if 
I would have named the method "format". I'm leaving them the way they are as 
it is not wrong but just less right. 

However to earn the points, I added a simple CustIdValidationStrategy. It only 
sets the limit of how many cars can be parked each day by limiting the maximum 
value of the custId. I realize now that I could have built a full validation Strategy and 
used it to validate everything but I think this serves the purpose of this assignment. 

I used a constant in this strategy for the Maximum value of custId. I understand that this 
increases the rigidity of the code but I wanted to add a 5th strategy to make up for the fact that 
my two format strategies really should be just one.    

 
*************************************************************************



OOAD:

We were to design a parking garage system per the instruction document. 
It must park and checkout 3 cars.

my conceptual solution:

Realizing that during the POS assignment we did not create an actual POS but more of a POS simulator
I decided to take that approach to this program. My program creates car objects and passes them through
each of the manager classes. In Terminal, Parking Lot, Out Terminal. Each car has a ticket object to store 
hours parked and a time. the In Terminal sets these values, and the out terminal reads them to calculate a fee.
This fee is then outputted to the console or JOptionpane.   


I identified the following nouns for my program.

Ticket
Car
In Terminal
Parking Lot
Out Terminal
Business Report
Customer Receipt
Fee
Printer - output ( console )
display - output ( JOptionpane )

I used a total of 4 strategies, each has two objects for demonstration.

FeeStrategy
CustomerReceiptFormatStrategy
BusinessReportFormatStrategy
OutputStrategy

I validated all methods that had parameters however my validation is not up to the 
new information and standards regarding exceptions that was presented last week.
I understand that for the final I will want to update that.





