------------------------------------ Development Exercise ---------------------------------------------

Please create a web application for the Shopping Basket that will use MySQL as the database.

It should implement the following features:

1. Create a basket for the customer
2. Add and remove items inside the basket
3. A list of all the items of a basket
4. Get the total price on all the baskets of the customer

-------------------------------------------------------------------------------------------------------------------
Assumptions & Limitations

1. 1 basket per customer
2. No changing of customer
3. Hard coded data for database, plugged in when started

Notes:

1. I used crudrepository and hibernate jpa to be database agnostic. this Should run on mysql, just change the application.properties entries.
2. Shopping Basket is stored in session
3. Since I was instructed to use only 4-5 hours and for simplicity, I used simple JSP and no javascript.

For improvements:

1. Unit Testing
2. Use Javascript Front End (i.e. ajax, jquery, react)
3. Add Login/Logout, Product Management, Customer Management
4. Add Checkout
5. Add Logging


To run:

In Eclipse/STS: run as Spring Boot
In mvn console: mvn spring-boot:run