FROM openjdk:25

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} HotelArcade.jar

ENTRYPOINT ["java" , "-jar" , "/HotelArcade.jar"]

EXPOSE 8080