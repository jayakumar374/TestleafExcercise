Feature: Login to testleaf application
Background:
Given Launch Chrome browser
When Load URL 'http://leaftaps.com/opentaps/control/main'
And Type username 'DemoSalesManager'
And Type password 'crmsfa'
And click login button
And click CRMSFA
Scenario Outline: Login Application with multiple data
When click contacts
When click create contacts


And Type firstname <FName>
And Type lastname <LName>
And Type email <mail>
And click create contact button

Then verify created contacts









Examples:
|FName|LName|mail|
|Jaykumar|TM|Vmathi@gmail.com|
|Vanmathi|AM|Vmathi@gmail.com|


