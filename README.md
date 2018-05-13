# KomootAppiumTest

Android specific test cases for the app 'KOMOOT'.


### How to install

1. Download and install latest version of Java (JDK).
2. Setup Java Environment Variables.
3. Download and install Android Studio. Before downloading and installing android studio, make sure following system prerequisits are completed:
    1. 'Step 1' and 'step 2' mentioned above should be completed. 
    2. Your machine should be able to satisfy [these system requirements](https://developer.android.com/studio/#Requirements).
4. Install additional Android SDK tools.
5. Setup Android Environmental Variables.
6. Download and install Appium Desktop app.
7. Start the Appium server.
    1. Open the Appium desktop app.
    2. It shows three tabs: 'Simple', 'Advanced' and 'Presets'.
        * General section : This section contains the options which are required for both Android and iOS.
        * iOS section : This section contains options specific to iOS automation only.
        * Android section : This section contains options specific to Android automation only.
    3. Click on 'Advanced' tab and provide following information in the 'General' section:
        * Server Address: 127.0.0.1
        * Server port: 5000
        * Log level: debug
        * Make sure the check-box for 'Allow Session Override' is checked.
    4. Now click on Start Appium button, and you would see the log screen which shows that the server is running.
    5. 'Save as preset' option: With this functionality, you can save the inputs that you are providing to launch Appium server. So the next time you want to start the Appium server, you can just select the Preset and run it. This way you can avoid providing all the options every time you want to start the server. Following are the steps to do it.
        * Navigate to 'Advanced' tab in Appium desktop.
        * Provide the details mentioned in the 'Step 3' of 'Start the Appium server'.
        * Click on 'Save As Preset' button. A pop-up is shown asking for a name to the preset. Give a name and then click on 'Save' button.
        * The preset is saved to the 'Preset' tab in the appium desktop app.
        * Next time while starting the server, just click on this preset and Start the appium server.
8. Download and install Eclipse IDE for Java.
9. Connect the android device to the laptop and turn on USB debugging on the Android device under test. Device can also be connected through wifi to avoid dealing with short USB cables.
10. Make sure the device is connected properly through USB and is unlocked. The device must be listed in the output of the command: 'adb devices'. This project has been tested on following device configuration:
    - Android OS : 4.4.2
    - device name: Asus zenfone.
    - RAM : 3GB
    - Internal memory: 16GB
10. Download Apache Maven, setup maven environmental variables.
11. Install testNG plug in for Eclipse from eclipse market store.
12. Import the Appium project into eclipse.
    1. Clone the appium project from following git repository and import it into eclipse as a general project. With this, the project would be stored to hard drive. [https://github.com/surendra2016/KomootAppiumTest.git](https://github.com/surendra2016/KomootAppiumTest.git) 
    2. Import the project from hard drive as a Maven project into eclipse. 
13. Make sure Appium server is up and running..
14. As of now, details of the app under test such as 'appPackage' and 'appActivity' names are already provided in the method setup() in the test project. 
14. Run the java file 'KomootTest.java' in eclipse as a TestNG test.
