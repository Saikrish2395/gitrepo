Feature: I am automation functionality of Add Nationality,Skills,Jobs in Orange HRM application
	
Background: Common step
    Given User launch chrome browser
    When User opens URL "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"

  Scenario: Successful Login with valid page
    And User enters username as "Admin" and password as "admin123"
    Then Create Nationality Record
					|Indian14|
					|Indian15|
					|Indian16|
    When Click on logout button
    Then Close Browser
    
    
    Scenario: Successful Login with valid page
    And User enters username as "Admin" and password as "admin123"
    Then Create Skills Record
					|Sales301|Sales301 descr|
					|Sales302|Sales302 descr|
					|Sales303|Sales303 descr|
    When Click on logout button
    Then Close Browser

   Scenario: Successful Login with valid page
    And User enters username as "Admin" and password as "admin123"
    Then Create Jobs Record
					| Tester1   | Tester1 desc| Tester1 note |
          |  Sales   |Sales1 desc  |  SAles1      |
          |   account1 | account1 des| account1 |
    When Click on logout button
    Then Close Browser 