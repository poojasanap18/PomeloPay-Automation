Feature: Cart Functionality
  Verify if user is able to add remove and change the product

@start
  Scenario: Add item to the cart
    Given user is  on homepage
    When user added the product into cart
    | productname |
    | SLGH005     |
    Then cart updated with correct price

  Scenario: Change the item in the cart
    When click on the add cart 
    And Change the item in the cart
    Then Verify the price after adding new product
     
  @stop
  Scenario: Delete the item in the cart
    When click on the add cart 
    And delete the item in the cart
    Then Verify the price after deleting new product