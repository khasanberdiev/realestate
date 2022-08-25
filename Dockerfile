# FROM openjdk:17-jre-slim as builder
FROM openjdk:17
EXPOSE 8080
ADD target/realestate.jar realestate.jar
ENTRYPOINT [ "java", "-jar", "/realestate.jar" ]


# FROM openjdk:17-jre-slim as builder
# WORKDIR application
# ADD maven/${project.build.finalName}.jar ./
# RUN java -Djarmode=layertools -jar ${project.build.finalName}.jar extract

# FROM openjdk:17-jre-slim

# WORKDIR application
# COPY --from=builder application/dependencies/ ./
# COPY --from=builder application/spring-boot-loader/ ./
# COPY --from=builder application/snapshot-dependencies/ ./
# COPY --from=builder application/application/ ./
# ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "org.springframework.boot.loader.JarLauncher"]
