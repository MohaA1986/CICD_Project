
@tag
Feature: Purchase the product in the ecommerse site
  I want to use this template for my feature file

	Background:
	Given I landed on Ecommerce page.

  @Regression
  Scenario Outline: Possitive test of submitting the order 
    Given I logged in with the <userName> and <password>
    When I add the <productName> in the cart
    And Check the <productName> in the cart and submit purchase 
    Then Verify the confirmation message "Thankyou for the order." in the confirmation page.

    Examples: 
      | userName  					| password	|	productName	|
      | edtd_2020@yahoo.com | Ab@123456	|	ZARA COAT 3	|
      
      
