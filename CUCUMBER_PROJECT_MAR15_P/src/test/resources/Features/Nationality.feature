Feature: I am automation functionality of Add Nationality,Add Skills,AddJobs in Orange HRM application
	
Background: Common step
    Given User launch chrome browser
    When User opens URL "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"

  Scenario: Creating Nationality Record
    And User enters username as "Admin" and password as "admin123"
    Then Go to Nationality Page
    When Add Nationality with Nationalityname as "India148"
    When Click on logout button
    Then Close Browser
    
    Scenario: Creating skills Record
    And User enters username as "Admin" and password as "admin123"
    Then Go to Skill Page
    When Add skills with skillname as "python2" and skilldescription as "python3.10"
    When Click on logout button
    Then Close Browser
    
    Scenario: Creating Job Record
    And User enters username as "Admin" and password as "admin123"
    Then Go to Jobs Page
    When Create Job record as JobTitle "Sales1" JobDescr "Sales1 descr" JobNote "Sales1 Note" 
    When Click on logout button
    Then Close Browser  