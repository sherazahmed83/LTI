##  LTI Provider Tool

#### How to run the LTI Provider Tool

NOTE: Make sure you have [Consumer Tool] already setup,  & running on your System. Please follow the below steps to run LTI Provider 

1. Go to `
      LTI-Provider-Tool/src/main/resources/application.properties
    ` and make sure that the `consumerKey` should be same as Consumer Tool.

2. Now let's Generate the JAR file, through CMD/Command Prompt or Terminal, in the project directory 

    ``
    cd LTI-Provider-Tool
    ``
    
    ``mvn clean install``
    
3. Now run the application, by running the following command 

    ``java -jar target/producertool-0.0.1-SNAPSHOT.jar``
    
4- Now hit the following URL on your browser:

	 ``http://localhost:8085``

5- Now click on `Send`, we will see the following page:

   ![alt text](LTIProducerTool.png)
