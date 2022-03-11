Feature: Place an order in the demo cart
 
Scenario: Valid Login
 Given User is on opencart home page
  And User navigates to login page
  Given  User logins with "trainer1@rjpinfotek.com" and "testuser"
  Then User navigate to Account page
  
  
  
  Scenario: Search Item
    Given User navigate to My Account page
    When User search item
     	| phone |
    Then User navigate to search result page
    
    
    Scenario: Add to Cart
    Given User navigate to search result page
    When User Add item to Cart
    Then Item must be avalable in the cart
    