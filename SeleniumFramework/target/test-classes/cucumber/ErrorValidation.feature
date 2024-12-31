@tag
Feature: Error Validation.
  I want to use this template for my feature file


  @ErrorValidation
  Scenario Outline: Verify incorrect login error
  	Given I landed on Ecommerce page.
		When I logged in with the <userName> and <password>
    Then I verify the "incorrect email or password." error message.

    Examples: 
      | userName  					| password	|
      | adtd_2020@yahoo.com | Ab@123456	|
