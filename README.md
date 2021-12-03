# BankAPI
## 1. Why are we doing this?
The goal of this project is to transform in a working application all the main concepts covered during the Software Development Bootcamp with the QA Ltd Academy. More specifically, the following points have been involved:
- Agile(SCRUM) & Project Management(Git, Jira);
- Databases & Cloud Fundamentals (H2, MySQL);
- Programming Fundamentals (Java);
- API Development (Spring Boot);
- Automated Testing (JUnit);
#### About the BankAPI
This API is a prototype of an application that has a bank institution as a final user. Through this API customers details can be stored inside a database and the main CRUD operations can be applied in order to manipulate those data. Few custom requests can be applied, such as searching customers based on their id or visualize all the customers with a balance over or lower than 10,000.  
Customers details are always displayed in a restricted mode since password and username will be hidden. This is just an example of how the final user can customise the application in order to protect customers details and their privacy.
## 2. How I expected the challange to go.
Due to the quality and the depth of the training received throughout the bootcamp, I was quite confident that the final result would have been of good quality. I was well informed and everything was explained in details on how to develop and complete the project: this helped me to face this challange in a more relaxed way. 
## 3. What went well? What didn't go as planned?
The API development was completed one day before the deadline. I was able to complete some strech goals such as the use of DTOs and to achieve test coverage of more than 80%.  
Nevertheless, I must highlight my inability to achieve all the features I had in mind for this application: having a job that keeps me awake all night heavily affects my ability to stay focused and being productive at daytime, forcing me to take extra breaks and limiting the time for implementing new ideas.
## 4. Possible improvements for future revisions of the project.
The following improvement could be added to the project:
- Adding custom Exception that handles the case of customers that do not exist when searching for a specific id.
- Creating extra tables in the database for each branch that a bank has, and saving new customers in the right branch/table.
- Adding some restrictions when creating a customer profile, checking for example if an account number already exists or if an email is already used by another customer.
## 5. Screenshots about Postman requests and the output from the API.
#### Please navigate to the documentation/screenshots folder of this project for more screenshots.
Postman get all customers DTO request and API response
![Postman screenshot](https://github.com/artufabio/BankAPI/blob/main/Documentation/Screenshots/get%20all%20dto%20postman.png)
Postman create customer request and API response
![Postman screenshot](https://github.com/artufabio/BankAPI/blob/main/Documentation/Screenshots/Create_customer_postman.png)
Postman get customers DTO by Id request and API response
![Postman screenshot](https://github.com/artufabio/BankAPI/blob/main/Documentation/Screenshots/get%20customer%20dto%20by%20id%20postman.png)
Postman delete customer request and API response
![Postman screenshot](https://github.com/artufabio/BankAPI/blob/main/Documentation/Screenshots/delete%20customer.png)
Postman update customer request and API response
![Postman screenshot](https://github.com/artufabio/BankAPI/blob/main/Documentation/Screenshots/update%20customer%20postman.png)
Postman get all customers DTO with a balance over 10,000 request and API response
![Postman screenshot](https://github.com/artufabio/BankAPI/blob/main/Documentation/Screenshots/get%20high%20balance%20customers%20dto%20postman.png)
Postman get all customers DTO with a balance lower or equal 10,000 request and API response
![Postman screenshot](https://github.com/artufabio/BankAPI/blob/main/Documentation/Screenshots/get%20low%20balance%20customers%20dto%20postman.png)

## 6. Screenshots of the database proving that data is being persisted.
#### Please navigate to the documentation/screenshots folder of this project for more screenshots.
MySQL database showing customer created through postman
![Mysql screenshots](https://github.com/artufabio/BankAPI/blob/main/Documentation/Screenshots/create%20customer%20postman%2Bmysql.png)
MySQL database and localhost route showing all customers 
![Mysql screenshot](https://github.com/artufabio/BankAPI/blob/main/Documentation/Screenshots/getAllCustomers%20MySql%2Blocalhost.png)
MySQL database showing the new customer details after it has been updated through postman
![Mysql screenshot](https://github.com/artufabio/BankAPI/blob/main/Documentation/Screenshots/update%20customer%20postman%20%2B%20mysql.png)
H2 console showing customer created through postman
![H2 console screenshot](https://github.com/artufabio/BankAPI/blob/main/Documentation/Screenshots/create%20customer%20h2%20%2B%20postman.png)
H2 console displaying all customers but the one deleted through postman
![H2 console screenshot](https://github.com/artufabio/BankAPI/blob/main/Documentation/Screenshots/delete%20customer%20postman%20%2B%20h2.png)
H2 console displaying new customer details after it has been updated through postman
![H2 console screenshot](https://github.com/artufabio/BankAPI/blob/main/Documentation/Screenshots/update%20customer%20postman%20%2B%20h2.png)
## 7. Screenshot of test results, including coverage report.
![Test results](https://github.com/artufabio/BankAPI/blob/main/Documentation/Screenshots/test%20final%20coverage.png)
## 8. Link to Jira Board.
[Clic here to go to the Jira Board of the project.](https://fabioartuso88.atlassian.net/jira/software/projects/BAN/boards/2/roadmap)
