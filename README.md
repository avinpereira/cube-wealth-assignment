# Cube-Wealth-Assignment
Built using Spring Boot & PostgreSQL

# Assignment Description

EventsIngestorService is a Web Application that ingests Event Streams based on certain Rules Defined Using the Framework.
* [Assignment Description](https://docs.google.com/document/d/104tTs8_A0LvlFxK0I7PCV0RZdQPvOim4x_khjv8Uis8/edit)
## Getting Started



### Prerequisites

Follow these steps to get the project to run on your system.

```
1. Clone the repository
2. Make sure you have docker daemon up and running
3. cd into the project 
4. Run the command "sudo docker-compose up --build"
```
## Framework Design
### Creating a new Rule

I have implemented a simple Framework that will allow a developer to solely work on the implementation logic of the Rule.


1.Create a Configuration class.
<br/>
Annotate this class with @Configuration
<br/>
This is where you will configure all the rules to be implemented.



```
@Configuration /*Marking this class as a Spring Configuration class*/
public class RulesConfiguration {
    
}
```

2.Create a new method that returns an object of Rule.class
<br/>
Annotate the method with @Bean marking the returned object as a spring bean.

```
@Configuration
public class RulesConfiguration {

    @Bean
    Rule exampleRule(){
        Rule exampleRule = new Rule() {
            @Override
            public void implementRule(Customer customer) {

                // Implement the Rule Logic here ....
                //......
                //......
            }
        };
        exampleRule.setConstraint1(1); //Configurable Constraint
        exampleRule.setConstraint2(null); //Configurable Constraint
        exampleRule.setDescription("Description of the Rule to be shown on the Dashboard");
        return exampleRule;
    }
}
```



## Benefits of this Framework

The purpose behind this framework was simply to ease the task of implementing new Rules without worrying about how the code works under the hood.
A Developer could simply create an object of Rule.class , mark it as a Spring Bean and provide the implementation.

All Rules will be enabled at Application Start - Up.
<br/>
Implemented Rules can be disabled at the Dashboard. 

## Accessing the Admin Dashboard
* The Admin Dashboard has been rendered using Spring MVC & Thymeleaf Templating Engine.
* Users with Admin access will be able to log into the Dashboard.
<br/>
* The Dashboard is available at the URL mentioned below.
<br/>
* The default configured Admin user has the credentials specified below.
<br/>
* Authentication is of type "InMemoryAuthentication" and has been implemented using Spring Security.

```
URL : http://localhost:8081/api/admin
UserName: admin
Password: adminpass
```

### About the DashBoard
This Dashboard is intended to be a Simple UI that lets the Admin perform the following actions.
```
1.Enable/Disable implemented Rules at Runtime without restarting the Application.
2. Configure/Tune the Constraints as required.
```

### Events Endpoint
This service ingests events send to it @ localhost:8080/api/v1/events

### Push Notification & Operational Notifications
* External Calls/Notifications have been mocked by logs.
* The same logs can be found printed on the console as well as the "push-notifications.log" file in the class path.

### Database 
* PostgreSQL has been used.
* Schema involves a Customer Entity which has a OnetoMany mapping to Event Entity.
 
## Built With

* [Spring Boot](https://start.spring.io/) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management


## Author

* **Avin Pereira** - *Assignment work* - [GitHub](https://github.com/PurpleBooth)


## License

Simple POC 

## Acknowledgments

* Hat tip to anyone whose code was used
* Inspiration
* etc


