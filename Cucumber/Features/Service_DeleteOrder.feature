Feature: Deleting order in servicenow application

Background:

When Load service URL 'https://dev103117.service-now.com/navpage.do'
Then switch to frame
And Type service username 'admin'
And Type service password 'India@123'
And click service login button
And click ServiceCatalog
And click Catalog

@delete
Scenario: Delete Order in servicenow
When click mobiles and switch to frame
When Select apple iphone6
And select Allowence
And select color
And select storage field
Then click orde now button
Then verify order placed
And click displayed request number
When click delete order
Then verify if the order is deleted













