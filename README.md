For running tests do some steps below:

   1. Run existing virtual device by name with command line:

		    emulator -avd DEVICE_NAME

	  of from Android Studio's AVD manager. If it doesn't, create new one.

   2. Download Chromedriver for version of Chrome on virtual device

   3. Run Appium desktop with set path to downloaded ChromeDriver

   4. Choose one of the suitable profiles (native / web) and run tests.
   Alternatively, create TestNG runner with needed group.
     