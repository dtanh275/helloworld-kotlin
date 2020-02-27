This is hello world project for training kotlin language.

## Technologies used

* Language: Kotlin
* Core framework: Spring Boot 2.2.4
* Persistence : Spring Data JPA
* Databases: H2
* Build: Gradle Script with the Kotlin DSL


## Running application locally

### With gradle command line

```
./gradlew bootRun
```

### With Docker
```
./gradlew :buildDocker
docker run -P 8080:8080 com.donkey.training.kotlin/realworld:lastest
```

## Test
```
# Get token
curl -X POST -H "Content-Type: application/json" \
 -d '{"email": "roman.taluyev@gmail.com", "password": "123"}' \
 http://localhost:8080/api/user/authen
 
# Test api
curl -X GET -H "Content-Type: application/json" \
 -H "Authorization: Bearer $token" \
 http://localhost:8080/api/article/user/1
```