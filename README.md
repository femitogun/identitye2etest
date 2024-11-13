Project Structure 
•	Explanation: The framework is organised into different packages, this makes for better readability and maintainability. So, I have created:
o	commonutility:  contains ReadFileData method for repetitive tasks, in this case reading the text files provided. This is set up to read the car_input.txt and car_output.txt
o	reportutility: contains HighLevelReport for generating a test report in html.
o	allpages: contains Page Object Model (POM) that interacts with the website. So all the locators, clicking, input of registration number and mileage, and also accepting cookies on the page and waits. And compare actual vs expected valuation this is what drives the pass and fail in the report.
o	alltestcases: Contains the test scripts that define the actual tests. Browser setup and waits. Inputting of data files. The main part of the test runs loops based on how many times we want to compare which is 4 rows based on car_output.txt.
Registration number and mileage can be adjusted based on the tests if needed later on. 
•	Purpose: Organising the code in this structured way makes it easier to manage the code as the project grows

