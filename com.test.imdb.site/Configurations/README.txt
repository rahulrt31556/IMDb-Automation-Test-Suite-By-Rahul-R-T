Created by Rahul R Tandur on 25th July 2017.

This is highly confidential, Do not use this code for own use.
Assumptions:
The idea of this challenge is to create a small UI test automation suite, for a popular website
(www.IMDb.com), using a tool/standard of your choice (preferably Selenium, or equivalent).


The tests should confirm:
1. The Top 250 ( http://www.pageobjects.imdb.com/chart/top ) page returns at least 1 movie , in the list.
2. The previous should be true, for each of the sorting options :
3. The previous should also be true, when navigating to the Western genre:


Considerations:
When designing your tests, please have in mind the test suite may easily grow to 100’s of them.
Easy addition, debugging and maintenance should be taken into account.






-------- My comments on this task:
I have taken some assumptions.

#1. I have used Selenium web driver to do this tasks, along with TestNG, Maven POM as a design pattern.
#2. I have used TesNG to run my test cases.
#3. I haven't added much of comments in the code.
    reason is its better to explain due face to face interview.
#4. Generating logs and reports using Extent report API.
#5. I have created separate packages for Data provider,factory, Pages, Test Cases and utility, each having specific reasons to use.
#6. The main reason for creating separate packages and classes is to meet the REQUIREMENT- EASY ADDITION, DEBUGGING, MAINTAINCE as the test suite grows.
#7. You can add other test cases for testing in Test Cases class.
#8. You can add other pages of IMDb site o Pages class.
#9. You can add your own libraries to utility package.
#10. Create Smoke Test Suite to run the above test cases specified.
#11. I'm running the SmokeTest.xml from pom.xml file.
#12. Running the tests individually and not in parallel.
#13. Screen shots are also captured during the test execution  for failures using the helper class created in the Utility package and the same are saved in ScreenShots folder.
