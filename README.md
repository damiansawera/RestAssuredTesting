# Rest Assured Testing Project

This project is an API testing project built using Rest Assured, an open-source Java library for testing RESTful APIs. The project focuses on testing the functionality of the Petstore API hosted at https://petstore.swagger.io/.

## Key Features
This tool has been created with the use of:

- **Test Framework**: The project utilizes **TestNG** as the testing framework, allowing for structured and organized test suites, test cases, and test execution.
- **Data Driven Testing**: The project incorporates **Apache POI**, a library for reading and writing Excel files, enabling data-driven testing scenarios where test data is stored in Excel spreadsheets.
- **Fake Data Generation**: The **Faker library** is utilized to generate fake data for testing scenarios, ensuring realistic and dynamic test data for API requests and responses.
- **Reporting**: The project uses **Extent Reports** to generate comprehensive HTML reports, providing detailed insights into test execution, test results, and any encountered failures or errors.
- **Logging**: **Log4j2**, a widely adopted logging framework, is employed to capture logs during test execution, aiding in troubleshooting and debugging activities.

## Pre-requisites
Before running this API testing project, ensure that you have the following pre-requisites and dependencies installed:

- **Java Development Kit (JDK)**: Ensure that you have Java JDK 8 or higher installed on your machine. You can download it from the official Oracle website or use OpenJDK.

- **Maven**: Maven is a build automation tool used in this project. Install Maven by following the official Apache Maven installation guide for your operating system.

- **Integrated Development Environment**: Choose an IDE of your preference for Java development, preferably IntelliJ IDEA or Eclipse.

- **Dependencies**: The project relies on various dependencies managed by Maven. The pom.xml file in the project contains the necessary dependency configurations. Ensure that you have a reliable internet connection during the initial project setup to allow Maven to download the required dependencies.

## Execution
1. Open your preferred IDE (IntelliJ IDEA, Eclipse)
2. Import the project as a Maven project by selecting the project's root directory
3. Ensure that the required dependencies are resolved by allowing the IDE to automatically download them or manually running the Maven install command (**mvn clean install**) within the IDE's terminal or command prompt
4. Run the tests either by right-clicking on the test file or specific test case(s) and selecting "Run" or by running **testng.xml** file. 

## Jenkins Integration
### Pre-requisites
- Have Jenkins installed on your machine
- Necessary plugins installed
- Jenkins Tools configured

### Create a New Jenkins Job:

1. From the Jenkins dashboard, click on "New Item" to create a new job
2. Provide a name for the job and select the **"Maven project"** option
3. Click "OK" to proceed

### Configure Source Code Management:
In the job configuration, under the "Source Code Management" section, specify how Jenkins should access source code.
1. Clone repository: **https://github.com/damiansawera/RestAssuredTesting.git** and paste in **Repository URL** field
2. in Branch Specifier paste **/main* as main branch
3. Save the Jenkins Job Configuration and trigger the job by clicking **"Build Now"**
