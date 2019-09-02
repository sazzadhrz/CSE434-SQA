<p align="center">
<img src="img/nsulogo.jpeg">
</p>

<div align="center">


# North South University </h5>
##  Department of Electrical and Computer Engineering </h3>

##  Project Report

## Project Name : Test Automation Using Selenium and Java

**Course:** CSE434

**Semester:** Summer19

**Name:** Md Sazzad Hossain

**ID:** 1611235042

**Faculty:** Shaikh Shawon Arefin Shimon (SAS3)

**Section:** 01

**Email:** sazzad.hossain09@northsouth.edu

**Github Repository:** [CSE434 (Project 2)](https://github.com/sazzadhrz/CSE434/tree/master/Project02)

</div>


### Project Description:

This project is done as a part of Software Quality Assurance and Testing course. In this project the concepts of **Test Automation** have been used. A live website named [PHPTravels](https://www.phptravels.net) has been tested using *Black Box* testing concepts. 

#### Tools Used:
* Selenium (Version 3.141.59)
* TestNG (Version 7.0.0)

#### Programming Language:
* Java

### Test Explanation
<div align="center">
![Sign Up](img/register.JPG)
*Sign Up Test Without First*
</div>

##### Code Snippet:

```` java
	@Test 
	public void noFirstNameTest() {
		driver.findElement(By.name("lastname")).sendKeys("Hossain");
		driver.findElement(By.name("phone")).sendKeys("01613645555");
		driver.findElement(By.name("email")).sendKeys("sazzad.hossian09@northsouth.edu");
		driver.findElement(By.name("password")).sendKeys("haha123");
		driver.findElement(By.name("confirmpassword")).sendKeys("haha123");
		
		driver.findElement(By.className("signupbtn")).click();
		
		scrollUpandGetWarningTextandAssert("The First name field is required.");

	}
````

### Test Results:

#### Sign Up Test -
<div align="center">
![Sign Up Test](img/signup.JPG)
</div>

#### Sign In Test -
<div align="center">
![Sign In Test](img/signin.JPG)
</div>

#### Car Boooking Test -
<div align="center">
![Car Booking Test](img/car.JPG)
</div>

#### Hotel Booking Test -
<div align="center">
![Hotel Booking Test](img/hotel.JPG)
</div>

#### Tour Booking Test -
<div align="center">
![Tour Booking Test](img/tour.JPG)
</div>

#### Test Suite -
<div align="center">
![Test Suite](img/SuiteResult.JPG)
</div>




