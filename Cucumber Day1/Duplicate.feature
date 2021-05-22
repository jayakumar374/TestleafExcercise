Feature: Login to testleaf application
Background:
Given Launch Chrome browser
When Load URL 'http://leaftaps.com/opentaps/control/main'
And Type username 'DemoSalesManager'
And Type password 'crmsfa'
And click login button
And click CRMSFA
Scenario Outline: Login Application with multiple data
When click Leads
When click find leads
And clik Email
And Type EmailAddress <mail>
And click find leads button
And click first displayed name
And click duplicate lead
And click duplicate lead submit button
Then verify duplicate lead
Then close chrome browser









Examples:
|mail|
|vmathi@gmail.com|
|vmathi@gmail.com|


