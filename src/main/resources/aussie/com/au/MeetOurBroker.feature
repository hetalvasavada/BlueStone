Feature: Meet our Brokers

Scenario: Meet our Brokers

Given I visit "https://www.aussie.com.au" website on "chrome"
And I view "MeetOurBrokers" menu and wait for "Sydney"
When I select "Sydney" menu
When I click on "AussieAlbury" link
Then should be navigated to "Aussie Albury" screen
And enter the following values "FirstName" as "Hetal"
And lastname "LastName" as "Vasavada"
And email "Email" as "abcd@gmail.com"
And phone "Phone" as "0452617835"
And suburb "Suburb" as "2145"
And click on "BookAppoint" button
Then following message "Congrats.you are on your way" is displayed in "message"