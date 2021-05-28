Feature: Ordering mobile in servicenow application

Background:

When Load service URL 'https://dev103117.service-now.com/navpage.do'
Then switch to frame
And Type service username 'admin'
And Type service password 'India@123'
And click service login button
And click ServiceCatalog
And click Catalog

@order
Scenario: Ordering Apple iPhone in servicenow
When click mobiles and switch to frame
When Select apple iphone6
And select Allowence
And select color
And select storage field
Then click orde now button
Then verify order placed













