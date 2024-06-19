# gradle:7.3.1-jdk17 이미지를 기반으로 함
FROM krmp-d2hub-idock.9rum.cc/goorm/gradle:7.3.1-jdk17

# 작업 디렉토리 설정
WORKDIR /home/gradle/project

# gradlew 및 관련 파일을 이미지에 복사
COPY gradlew /home/gradle/project/gradlew
COPY gradle /home/gradle/project/gradle

# 프로젝트 소스 코드를 이미지에 복사
COPY . .

# gradlew 파일에 실행 권한 부여
RUN chmod +x /home/gradle/project/gradlew

# gradle 빌드 시 proxy 설정을 gradle.properties에 추가
RUN mkdir -p /root/.gradle && echo "systemProp.http.proxyHost=krmp-proxy.9rum.cc\nsystemProp.http.proxyPort=3128\nsystemProp.https.proxyHost=krmp-proxy.9rum.cc\nsystemProp.https.proxyPort=3128" >
/root/.gradle/gradle.properties

# gradlew를 이용한 프로젝트 빌드
RUN ./gradlew clean build -x test -Pargs="-Xlint:deprecation"

# DATABASE_URL을 MongoDB 연결 문자열로 설정
ENV DATABASE_URL=mongodb://mongodb/krampoline

# 빌드 결과 jar 파일을 실행
CMD ["java", "-jar", "/home/gradle/project/build/libs/chatApp-0.0.1-SNAPSHOT.jar"]
