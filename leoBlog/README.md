#### 정적 파일
- JAR로 패키징 할 경우 `src/main/webapp`의 파일들을 무시하고 패키징하기 때문에 사용하지 않는 것이 좋고 `static`,`public` 등에 저장하자
  - `webapp`에 넣고싶으면 `pom.xml`에 아래처럼 명시하면 됨 
    ```xml
            <resources>
                <resource>
                    <directory>src/main/webapp</directory>
                </resource>
                <resource>
                    <directory>src/main/resources</directory>
                </resource>
            <resources>
    ```

#### `favicon.ico` 설정 
  `favicon.ico`는 정적 컨텐트가 위치로 설정된 곳에 위치하면 자동적으로 사용됨
  - `src/main/resources/static`
  
#### Using Thymeleaf 
- pom.xml
```xml
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-thymeleaf</artifactId>
    </dependency>
```
#### Thymeleaf template cache
- 개발을 할 때에는 false로 해서 어플리케이션 재시작 없이 새로고침만으로 반영되게 함
- application.properties 
    ```
    spring.thymeleaf.prefix=file:src/main/resources/templates/
    spring.thymeleaf.cache=false
    ```
> 아래 `...false`만 추가하면 바로 새로고침해도 안먹힘 (Build Project 하면 됨)

    
    
#### Thymeleaf forEach문
```haml
<tr th:each="boardVO":${list}">
  <td th:text="${boardVO.name}>
  <td th:text="${boardVO.age}>
</tr>
```
  
