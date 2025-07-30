Feature: Sign In

Scenario:Sign In with empty fields
  Given Go to the site
  When Click on Sign In button
  And At sign in tab, click on sign in button without entering any data
  Then Error message should be shown at email text field
  And Error message should be shown at password text field

Scenario: Sign In with not registered email
  Given Go to the site
  When Click on Sign In button
  And Enter not registered email
  And Enter a password
  And Click on the sign in button
  Then No active account found with the given credential error message should appear

Scenario: Sign In with wrong password
  Given Go to the site
  When Click on Sign In button
  And Enter registered email
  And Enter a wrong password
  And Click on the sign in button
  Then No active account found with the given credential error message should appear

Scenario: Sign In with valid credentials
  Given Go to the site
  When Click on Sign In button
  And Enter registered email
  And Enter the right password
  And Click on the sign in button
  Then User should be signed in
