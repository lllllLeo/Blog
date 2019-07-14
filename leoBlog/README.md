#### 정적 파일
- 스프링 부트는 기본적으로 Runnable JAR로 실행되므로 WAR 규격에 맞춰서 WEB-INF 폴더를 만들거나 webapp 폴더를 만들지 않음
- 정적 HTML 파일
  - `src/main/resources/static`
  - `src/main/public`
- 템플릿
  - `src/main/resources/templates`

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
  
---

MySQL root 비밀번호 찾기
cmd에서 C:\Program Files\MySQL\MySQL Server 5.5\bin로 이동한 후에 
`mysqld.exe --skip-grant` 하면 새 cmd창이 뜬다. 그리고 mysql 로그인하면 그냥 들어가짐. 
그리고 
```
use mysql
UPDATE user SET password=PASSWORD('변경할패스워드') where user='root';
FLUSH PRIVILEGES;
exit;
```

하고 다시 로그인하면 끝