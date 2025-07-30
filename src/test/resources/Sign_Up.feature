Feature: Sign Up

Scenario: Sign Up without entering data
  Given Go to site
  When  Click on Sign up button
  And Enter the correct reCAPTCHA
  And Click on Verify Captcha button
  And Click on SignUp button
  Then Please fill out this field tooltip error message should not be able to sign up

Scenario: Sign up without email
  Given Go to site
  When Click on Sign up button
  And Enter all data except email
  And Enter the correct reCAPTCHA
  And Click on Verify Captcha button
  And Click on SignUp button
  Then This field is required error message should be shown

Scenario: Sign Up with registered email
  Given Go to site
  When Click on Sign up button
  And Enter an already registered email
  And Enter all data
  And Enter the correct reCAPTCHA
  And Click on Verify Captcha button
  And Click on SignUp button
  Then Error popup should appear

Scenario:  Sign Up without entering a password
  Given Go to site
  When Click on Sign up button
  And Enter all data except Password
  And Enter the correct reCAPTCHA
  And Click on Verify Captcha button
  And Click on SignUp button
  Then This field is required error message should be shown at the password section

Scenario: Sign Up without entering an Uppercase letter as a Password
  Given Go to site
  When Click on Sign up button
  And Enter all required data
  And Enter a password without any uppercase letter
  Then Error message should be shown at the password input field

Scenario: Sign up with a new email and valid password
  Given Go to site
  When Click on Sign up button
  And Enter all required data
  And Enter a valid password
  And Enter the correct reCAPTCHA
  And Click on Verify Captcha button
  And Click on SignUp button
  Then Congratulations success popup should appear








