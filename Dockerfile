# gradle:7.3.1-jdk17 이미지를 기반으로 함
FROM krmp-d2hub-idock.9rum.cc/goorm/gradle:7.3.1-jdk17

# 작업 디렉토리 설정
WORKDIR /home/gradle/project

# gradlew 및 관련 파일을 이미지에 복사
WORKDIR /chatApp
COPY . /chatApp

RUN ./gradlew build --no-daemon

COPY --from=build /app/build/libs/*.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "/home/gradle/project/build/libs/chatApp-0.0.1-SNAPSHOT.jar"]
