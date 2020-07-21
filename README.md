# Cube-Wealth-Assignment
Built using Spring Boot & PostgreSQL

# Assignment Description

EventsIngestorService is a Web Application that ingests Event Streams based on certain Rules Defined Using the Framework.

## Getting Started



### Prerequisites

What things you need to install the software and how to install them

```
Give examples
```

### Creating a new Rule

I have implemented a simple Framework that will allow a developer to solely work on the implementation logic of the Rule.


1.Creating a Spring Bean.
<br/>
This bean will represent the Rule

```
@Component /*Marking this class as a Spring Bean*/
public class NewRule {
    
}
```

2.Implement the Rule Interface

```
@Component
public class NewRule implements Rule{

    @Override
    public void implementRule(Customer customer) {
        
    }

    @Override
    public void enable(boolean isEnabled) {

    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public void setDescription(String description) {

    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public void toggle() {

    }
}
```

3.Provide an Implementation & Description to the NewRule.<br/>( All Rules will be enabled at Application Start up )
```
@Component
public class NewRule implements Rule{
    private boolean isEnabled;
    private String description = "This Description will be displayed on the Dashboard to the Admin";

    @Override
    public void implementRule(Customer customer) {
        List<Event> events = customer.getEvents();
        /* Implement some Rules based on the requirements */
        /* Ex: Sending Notification for the First Pay Event etc. . . */
    }

    @Override
    public void enable(boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    @Override
    public boolean isEnabled() {
        return this.isEnabled;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getDescription() {
        return  this.description;
    }

    @Override
    public void toggle() {
        this.isEnabled = !this.isEnabled;
    }
}
```
## Benefits of this Framework

The purpose behind this framework was simply to ease the task of implementing new Rules without worrying about how the code works under the hood. 

## Accessing the Admin Dashboard

Users with Admin access will be able to log into the Dashboard

```
URL : http://localhost:8081/api/admin
UserName: user
Password: password
```

### About the DashBoard
A Simple UI that enables 
```
Admin User to enable/disable implemented Rules at Runtime without restarting the Application.
```


## Built With

* [Spring Boot](https://start.spring.io/) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management


## Authors

* **Avin Pereira** - *Assignment work* - [GitHub](https://github.com/PurpleBooth)


## License

Simple POC 

## Acknowledgments

* Hat tip to anyone whose code was used
* Inspiration
* etc


