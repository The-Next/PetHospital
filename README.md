# PetHospital
禹州实训

使用docker部署
Dockerfile
```docker
FROM openjdk
VOLUME /tmp
ADD zzuli-0.0.1-SNAPSHOT.jar /app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
```
