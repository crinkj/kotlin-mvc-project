# Kotlin-spring-security-mvc

>개요
  * Kotlin은 자바와 100% 호환이되며 Java에서보완이되서 나온 언어이기때문에 자바보다 더 간결하고      효율적이게 코드를 작성할 수 있는 언어로써 흥미가 생겨서 조금씩 기능을 추가해나가며 공부하는 레포지터리입니다.

>개발 환경
  *  language: Kotlin
  *  build: gradle
  *  DB: mysql 8.0
  
     > docker + mysql Image(맥북 M1기준)
      1. M1일경우 Apple Sillicon 버전 도커 설치(https://docs.docker.com/desktop/mac/apple-silicon/) 
      2. 설치 후 터미널에서 
         1. docker -v (버전 확인되면 설치 완료)
         2. docker pull mysql:8.0.17 (mysql image 다운로드)
         3. docker images (설치한 mysql 이미지 보이면 다운 완료)
         4. docker run --platform linux/amd64 -p 3306:3306 --name mysql -e MYSQL_ROOT_PASSWORD=1234 -e -d mysql (mysql databae생성)
      3. 생성후 DB tool(예:workbench)에 위에 해당 접속정보로 접속
  *  Spring Boot 2.6.4 + JAVA 11 + JPA + Hibernate
  
>추가한 기능
  *  [x] 프로젝트 구성 및 위와같은 환경 구축    
  *  [x] JWT Provider/Filter 및 스프링 시큐리티 설정 적용    
  *  [x] 회원가입 완료
