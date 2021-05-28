Feature: Ordering mobile in servicenow application

Background:

When Load service URL 'https://dev103117.service-now.com/navpage.do'
Then switch to frame
And Type service username 'admin'
And Type service password 'India@123'
And click service login button
And click ServiceCatalog


@update
Scenario Outline: Ordering Apple iPhone in servicenow
Given click Myrequest
And click serach button and Type req number <reqnumber>
And select displayed request number
When update approval field to requested
And update request state to approved
And update other fields <text>
Then update request

Examples:
|reqnumber|text|
|REQ0010264|Mobile Ordered|
|REQ0010019|Mobile Ordered|










