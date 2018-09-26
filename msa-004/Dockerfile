FROM openjdk:8
RUN mkdir -p /opt/labs/User
ADD target/User-consul-lb-0.0.1.jar /opt/labs/user/
EXPOSE 8080
CMD ["java", "-jar", "/opt/labs/user/User-consul-lb-0.0.1.jar"]