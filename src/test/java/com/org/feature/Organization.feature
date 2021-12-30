Feature: user can create,modify and delete organization

  Scenario Outline: As valid user create multiple organization
    Given I will launch chrome browser
    And Enter the url "http://localhost:8888/"
    And Login page is displayed enter the username "admin" and password "manager"
    And click on login
    When Home page is displayed click on organization
    And click on create new organization
    And enter the organization name "<Organization>" and click on save button
    And verify organization "<Organization>" created or not

    Examples: 
      | Organization |
      | Amazon       |
      | Google       |
      | Flipkart     |

  Scenario: As a valid user create a organization with organization,phone,website and employees
    Given I will launch chrome browser
    And Enter the url "http://localhost:8888/"
    And Login page is displayed enter the username "admin" and password "manager"
    And click on login
    When Home page is displayed click on organization
    And click on create new organization
    And Enter the organization name ,phone ,website and employees
      | organization name | phone | website        | employees |
      | Yash Yantra       | 12345 | yashyantra.com |      2032 |
    And click on save Button
    Then verify the organization Name,phone,website and employees
