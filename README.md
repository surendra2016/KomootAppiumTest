# KomootAppiumTest

Android specific test cases for the app 'KOMOOT'.

***
### Installations and Setups (One time activity, This test project has been tested for Windows 10)
***

1. Download and install latest version of Java (JDK).  Ideally, any Java 8 version should work fine with Appium/Selenium.
2. Setup Java Environment Variables. This project mainly requires JAVA_HOME and PATH.
3. Download and install Android Studio at [https://developer.android.com/studio/index.html](https://developer.android.com/studio/index.html) and Click on 'DOWNLOAD ANDROID STUDIO' button. It would start downloading the android studio setup file according to your operating system. This test project has been tested for Windows 10. After downloading, install the android studio by following the instructions on the installer. Before downloading and installing android studio, make sure following system prerequisites are completed:
    1. 'Step 1' and 'step 2' mentioned above should be completed. 
    2. Your machine should be able to satisfy [these system requirements](https://developer.android.com/studio/#Requirements).
4. Install additional Android SDK tools. Follow the steps given below to check if all the required SDK tools are already installed (you will have to open Android Studio to check this):
    1. Go to Start > All Programs > Android Studio folder and then open Android Studio.  Android Studio Welcome Screen would be displayed. 
    2. Click on Next button. You will be taken to Install Type screen.
    3. In the Install Type screen, let Standard option remain selected and then click on Next button. You will now be taken to the Select UI Theme screen.
    4. Click on Finish button. Android Studio will now start downloading these components.
    5. When downloading is complete then click on Finish button. You will now see Welcome to Android Studio screen.
    6. Create a sample android project in android studio and go to Tools > Android > SDK Manager.
    7. Once you select SDK Manager option, Default Settings screen would be opened with Android SDK option selected by default. Also, please note that there are 3 main tabs in this screen – SDK Platform, SDK Tools and SDK Update Sites. We will be checking only the first two tabs – SDK Platform and SDK Tools.
    8. In SDK Platform tab, check that the latest version of Android is installed. If you are working on real android devices then it doesn’t matter if your device’s OS version doesn’t match with the OS version installed in Android SDK. For example, if Android 7.1.1 is installed, but you can use your real device even if it runs on any other version, say Android 6.0 or earlier. For now, let us not install any other Android version. Other versions can be considered later when we start working on emulators.
    9. Click on SDK Tools tab. Verify that the below components are already installed.  If any of these components is not installed, then you can click on the checkbox against that component and then click on Apply button to install the component.
        * Android SDK Build-Tools
        * Android Emulator
        * Android SDK Platform-Tools
        * Android SDK Tools
        * Documentation for Android SDK
        * Intel x86 Emulator Accelarator (HAMX installer)
        * Support Repository
    10. You now have all the necessary SDK tools and platforms installed on your machine. You can now close Android Studio.
5. Setup Android Environmental Variables.
6. Download and install Appium Desktop app.
7. Download and install Eclipse IDE for Java.
8. Download Apache Maven, setup maven environmental variables.
9. Install testNG plug in for Eclipse from eclipse market store.

***
### Setting Android device and Appium configuration
***

10. Start the Appium server.
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
11. Connect the android device to the laptop and turn on USB debugging on the Android device under test. Device can also be connected through wifi to avoid dealing with short USB cables.
12. Make sure the device is connected properly through USB and is unlocked. The device must be listed in the output of the command: 'adb devices'. This project has been tested on following device configuration:
    - Android OS : 4.4.2
    - device name: Asus zenfone.
    - RAM : 3GB
    - Internal memory: 16GB

13. Import the Appium project into eclipse.
    1. Clone the appium project from following git repository and import it into eclipse as a general project. With this, the project would be stored to hard drive. [https://github.com/surendra2016/KomootAppiumTest.git] (https://github.com/surendra2016/KomootAppiumTest.git) 
    2. Import the project from hard drive as a Maven project into eclipse.

***
### Execute the test cases 
***

14. Make sure Appium server is up and running and the android device is unlocked and connected to the computer via USB.
15. As of now, details of the app under test such as 'appPackage' and 'appActivity' names are already provided in the method setup() in the test project, so no other configuration details of the android application is required explicitly.
16. Run the java file 'KomootTest.java' in eclipse as a TestNG test.

***
