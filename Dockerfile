FROM gradle as builder
WORKDIR kofu-api
ADD . ./
RUN ./gradlew clean bootJar

FROM openjdk:15-alpine
ARG APP=/opt/kofu-api
EXPOSE 8080
RUN mkdir -p ${APP}
COPY --from=builder /root/kofu-api/build/libs/java -jar build/libs/kofu-api-0.0.1-SNAPSHOT.jar ${APP}/kofu-api.jar
WORKDIR ${APP}

CMD ["java -jar kofu-api.jar"]
