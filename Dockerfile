FROM maven:3.6.3-jdk-8
WORKDIR /home/vladfirst
COPY  src /home/vladfirst/src
COPY  pom.xml  /home/vladfirst
22\\COPY  testng.xml  /home/vladfirst
RUN   mvn clean install -Dsurefire.suiteXmlFiles=testng.xml



