There are some minor adjustments that might be needed depending on the machine being used. 
Firstly the Selenium versions need to be changed in the project.
Secondly depending on using a Macbook or Windows, line 33 of the CarValuationTest.java needs to be amended, it is set up for Windows currently but can be amended for Macbook by changing code to String 'path=System.getProperty("user.dir")+ File.separator + "files" + File.separator;'
