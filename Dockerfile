FROM openjdk:17 as build
WORKDIR /workspace/v1/bhub-challenge-api

COPY /mvnw .
COPY /.mvn .mvn
COPY /pom.xml .
COPY /src src

RUN chmod +x ./mvnw
RUN ./mvnw install -DskipTests
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

FROM openjdk:17
VOLUME /tmp
ARG DEPENDENCY=/workspace/v1/bhub-challenge-api/target/dependency
COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app
EXPOSE 8080
ENTRYPOINT ["java","-cp","app:app/lib/*","com.example.bhubchallengeapi.BhubChallengeApiApplication"]