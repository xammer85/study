study: Example Using Multiple Java EE 6 Technologies Deployed as an EAR
==============================================================================================
Author: Pete Muir  
Level: Intermediate  
Technologies: EAR  
Summary: Based on kitchensink, but deployed as an EAR  
Target Product: EAP  
Product Versions: EAP 6.1, EAP 6.2, EAP 6.3  
Source: <https://github.com/jboss-developer/jboss-eap-quickstarts/>  

What is it?
-----------

This is your project! It is a sample, deployable Maven 3 project to help you get your foot in the door developing with Java EE 6 on Red Hat JBoss Enterprise Application Platform. 

This project is setup to allow you to create a compliant Java EE 6 application using JSF 2.0, CDI 1.0, EJB 3.1, JPA 2.0 and Bean Validation 1.0. It includes a persistence unit and some sample persistence and transaction code to introduce you to database access in enterprise Java. 

_Note: This quickstart uses the H2 database included with JBoss EAP 6. It is a lightweight, relational example datasource that is used for examples only. It is not robust or scalable and should NOT be used in a production environment!_

System requirements
-------------------

The application this project produces is designed to be run on Red Hat JBoss Enterprise Application Platform 6.1 or later. 

All you need to build this project is Java 6.0 (Java SDK 1.6) or later, Maven 3.0 or later.

 
Configure Maven
---------------

If you have not yet done so, you must [Configure Maven](https://github.com/jboss-developer/jboss-developer-shared-resources/blob/master/guides/CONFIGURE_MAVEN.md#configure-maven-to-build-and-deploy-the-quickstarts) before testing the quickstarts.


Start the JBoss EAP Server
-------------------------

1. Open a command prompt and navigate to the root of the JBoss EAP directory.
2. The following shows the command line to start the server:

        For Linux:   EAP_HOME/bin/standalone.sh
        For Windows: EAP_HOME\bin\standalone.bat

 
Build and Deploy the Quickstart
-------------------------

_NOTE: The following build command assumes you have configured your Maven user settings. If you have not, you must include Maven setting arguments on the command line. See [Build and Deploy the Quickstarts](../README.md#build-and-deploy-the-quickstarts) for complete instructions and additional options._

1. Make sure you have started the JBoss EAP server as described above.
2. Open a command prompt and navigate to the root directory of this quickstart.
3. Type this command to build and deploy the archive:

        mvn clean install jboss-as:deploy

4. This will deploy `target/study.ear` to the running instance of the server.


Access the application 
---------------------

The application will be running at the following URL: <http://localhost:8080/study-web>.

1. Enter a name, email address, and Phone nubmer in the input field and click the _Register_ button.
2. If the data entered is valid, the new member will be registered and added to the _Members_ display list.
3. If the data is not valid, you must fix the validation errors and try again.
4. When the registration is successful, you will see a log message in the server console:

        Registering _the_name_you_entered_


Undeploy the Archive
--------------------

1. Make sure you have started the JBoss EAP server as described above.
2. Open a command prompt and navigate to the root directory of this quickstart.
3. When you are finished testing, type this command to undeploy the archive:

        mvn jboss-as:undeploy


Run the Arquillian Tests 
-------------------------

This quickstart provides Arquillian tests. By default, these tests are configured to be skipped as Arquillian tests require the use of a container. 

_NOTE: The following commands assume you have configured your Maven user settings. If you have not, you must include Maven setting arguments on the command line. See [Run the Arquillian Tests](https://github.com/jboss-developer/jboss-developer-shared-resources/blob/master/guides/RUN_ARQUILLIAN_TESTS.md#run-the-arquillian-tests) for complete instructions and additional options._

1. Make sure you have started the JBoss EAP server as described above.
2. Open a command prompt and navigate to the root directory of this quickstart.
3. Type the following command to run the test goal with the following profile activated:

        mvn clean test -Parq-jbossas-remote 


Investigate the Console Output
---------------------
You should see the following console output when you run the tests:

    Results :
    Tests run: 1, Failures: 0, Errors: 0, Skipped: 0


Investigate the Server Console Output
---------------------
You should see messages similar to the following:

    INFO  [org.jboss.as.server] (management-handler-thread - 9) JBAS018559: Deployed "test.war"
    INFO  [edisoft.study.controller.MemberRegistration] (http--127.0.0.1-8080-2) Registering Jane Doe
    INFO  [edisoft.study.test.MemberRegistrationTest] (http--127.0.0.1-8080-2) Jane Doe was persisted with id 1
    INFO  [org.jboss.weld.deployer] (MSC service thread 1-6) JBAS016009: Stopping weld service for deployment test.war
    INFO  [org.jboss.as.jpa] (MSC service thread 1-1) JBAS011403: Stopping Persistence Unit Service 'test.war#primary'
    INFO  [org.hibernate.tool.hbm2ddl.SchemaExport] (MSC service thread 1-1) HHH000227: Running hbm2ddl schema export
    INFO  [org.hibernate.tool.hbm2ddl.SchemaExport] (MSC service thread 1-1) HHH000230: Schema export complete
    INFO  [org.jboss.as.connector.subsystems.datasources] (MSC service thread 1-5) JBAS010409: Unbound data source [jboss/datasources/studyTestDS]
    INFO  [org.jboss.as.server.deployment] (MSC service thread 1-6) JBAS015877: Stopped deployment test.war in 19ms
    INFO  [org.jboss.as.server] (management-handler-thread - 10) JBAS018558: Undeployed "test.war"


Server Log: Expected warnings and errors
-----------------------------------

_Note:_ You will see the following warnings and errors in the server log. Hibernate attempts to drop the table and constraints before they are created because the `hibernate.hbm2ddl.auto` value is set to `create-drop`. You can ignore these warnings and errors.

        HHH000431: Unable to determine H2 database version, certain features may not work

        HHH000389: Unsuccessful: drop sequence hibernate_sequence
        Sequence "HIBERNATE_SEQUENCE" not found; SQL statement: drop sequence hibernate_sequence [90036-168]


Run the Quickstart in JBoss Developer Studio or Eclipse
-------------------------------------
You can also start the server and deploy the quickstarts from Eclipse using JBoss tools. For more information, see [Use JBoss Developer Studio or Eclipse to Run the Quickstarts](https://github.com/jboss-developer/jboss-developer-shared-resources/blob/master/guides/USE_JDBS.md#use-jboss-developer-studio-or-eclipse-to-run-the-quickstarts) 


Debug the Application
---------------------

If you want to debug the source code or look at the Javadocs of any library in the project, run either of the following commands to pull them into your local repository. The IDE should then detect them.

        mvn dependency:sources
        mvn dependency:resolve -Dclassifier=javadoc
