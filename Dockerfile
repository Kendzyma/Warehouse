FROM openjdk:17-alpine3.14
COPY target/ClusterDataWareHouse.jar ClusterDataWareHouse.jar
ENTRYPOINT ["java","-jar","/ClusterDataWareHouse.jar"]