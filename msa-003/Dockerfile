FROM openjdk:8
RUN mkdir -p /opt/labs/User
ADD target/User-0.0.3.jar /opt/labs/user/
EXPOSE 8080
CMD ["java", "-jar", "/opt/labs/user/User-0.0.3.jar"]