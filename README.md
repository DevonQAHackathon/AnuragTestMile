# AnuragTestMile
Test Automation Frame work used:
--------

Arjuna

**location** : <repository>\autocognite-arjuna-0.3.6-b\autocognite-arjuna

Directory Structure
--------


**location**/config: Contains the configuration files.

**location**/config/central.conf: Configuration file to update named properties.

**location**/examples: Contains example data and UI files.

**location**/bin/launch/arjuna.bat: Batch file to run tests using Arjuna via CLI on Windows

**location**/bin/launch/arjuna.sh: Shell script to run tests using Arjuna via CLI on Mac/Unix/Linux systems

**location**/bin/tools: Contains the binaries needed by Arjuna or user.

**location**/bin/tools/uidrivers: Contains the binaries needed by Selenium or Selenium-like tools to drive browsers.

**location**/bin/ext: Directory for third party libraries.

**location**/bin/ext/java: Directory for Java based third party libraries.

**location**/bin/lib/java: Contains Arjuna Pro Java libraries.


**location**/data/sources/ Default data directory for externalising data for data source files

**location**/data/references: Default data directory for data reference files.

**location**/log: The default directory for Arjuna log.

**location**/report: Default directory for reports. Contains the latest run report.

**location**/ui_maps: Default directory for UI Map files that test author would use for doing UI test automation.



Running tests :
--------


    -d,   --test-dir <Full directory path of tests>
            Contains Java classes/JAR files.
            DEFAULT: /autocognite-arjuna-pro/mproject/tests

    -cp,  --consider-packages <Comma-separated list of Java package names/patterns>
            Consider only these test packages for execution
            DEFAULT: All

    -pn,  --package-name <Exact Java package name>
            Consider only this test package for execution
            DEFAULT: None

    -ip,  --ignore-packages <Comma-separated list of Java package names/patterns>
            Ignore these test packages for execution
            DEFAULT: None

    -cc,  --consider-classes <Comma-separated list of Java class names/patterns>
            Consider only these test classes for execution
            DEFAULT: All

    -cn,  --class-name <Java class name>
            Consider only this test class for execution
            DEFAULT: All

    -ic,  --ignore-classes <Comma-separated list of Java class names/patterns>
            Ignore these test classes for execution
            DEFAULT: None

    -cm,  --consider-methods <Comma-separated list of Java method names/patterns>
            Consider only these test methods for execution
            DEFAULT: All

    -im,  --ignore-methods <Comma-separated list of Java method names/patterns>
            Ignore these test methods for execution
            DEFAULT: None
			
EXAMPLES
--------

    arjuna.bat
            Runs all the tests in the Java Project in autocognite-arjuna\tests
            directory and generates MINIMAL report.

    arjuna.bat -d C:\\some\dir\tests -rm BASIC
            Runs all the tests in C:\\some\dir\tests directory and generates report in BASIC mode.

    arjuna.bat -cp a.b.c,a.b.d
            Runs all the tests in the two packages.

    arjuna.bat -ip a.b.* -runid beta2-run
            Runs all tests in the project and ignore the test in packages that matched with
            regex, labeled with run id as "beta2-run". The reports are generated under
            <Project Dir>/report/<timestamp>-beta2-run directory

    arjuna.bat -pn a.b -cn Test1 -dl ERROR
            Runs all tests in Test1 class and display ERROR & FATAL level log messages.
	    
	    
	    Test Project details:

com.fixerio.testcases contains testcases for fixer.io api.
com.groupkt.testcases contains testcases for GroupKT api.
com.WeatherAPITestCases contains testcases for OpenWeather api.

FixerAPIGetRequestTestCases.java, GroupKTTestCases.java, WeatherAPITestCases.java  are the Test classes.

Used DriveWithDataFiles approach to retrieve data from '.ini' files present at location ../WEB_API_AUTO/autocognite-arjuna/data/sources/
and used the data as test driven data.
