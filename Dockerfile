FROM amazoncorretto:17.0.9

COPY /target/poke-api.jar /app/poke-api.jar

WORKDIR /app
CMD ["java","-Duser.timezone=America/Lima", "-jar", "poke-api.jar"]