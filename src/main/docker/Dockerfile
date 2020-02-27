#-----------------------------------------------------------------------------------------------------
# User Service
#-----------------------------------------------------------------------------------------------------
FROM openjdk:11-jre-slim

# Keep consistent with build.gradle.kts
ENV APP_JAR_NAME realworld
ENV APP_JAR_VERSION 0.0.1-SNAPSHOT

RUN mkdir /app

ADD ${APP_JAR_NAME}-${APP_JAR_VERSION}.jar /app/
ADD run.sh /app/
RUN chmod +x /app/run.sh

WORKDIR /app

ENTRYPOINT ["/bin/bash","-c"]
CMD ["/app/run.sh"]