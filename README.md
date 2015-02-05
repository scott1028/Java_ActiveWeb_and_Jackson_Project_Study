# ActiveWeb simple example updated by Scott

    WebService Application + 包含一個 Jackson Date Serializer 範例。

Follow these simple steps to run this app:

* Create two empty schemas in MySQL DB:
    * simple_development
    * simple_test

* Modify JDBC connection parameters in:
    * class app.config.DbConfig
    * pom.xml

* Run the application

```
    ps aux | grep jetty | awk '{print $2}' | xargs kill -9
    mvn jetty:run
```

* Release .war

```
    mvn clean package -Dmaven.test.skip=true
```

* Navigate with browser

    to: http://localhost:8080/activeweb-example/

For support, post to:

    https://groups.google.com/forum/?hl=en#!forum/activeweb
    http://javalite.io/structure_of_activeweb_project  
    http://javalite.io/getting_started_activeweb   
    https://oss.sonatype.org/content/repositories/snapshots/org/javalite/   ← Repository, 有時候版本更新後 Sample Project 就編不起來了
    https://github.com/javalite/activeweb                                   ← 如果專案編不起來, 有缺 Library 可以從這邊安裝
    https://www.youtube.com/watch?v=YX1TAtuSqQE                             ← ActiveWeb 教學
    http://javalite.io/routing                                              ← ActiveWeb 的 Routing 設計方式說明文件
    http://maven.apache.org/plugins/maven-war-plugin/usage.html             ← 如果要 Compiler 成 .war
