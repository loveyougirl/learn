# Spring 没有注解，也没有Controller，然后有Spring的功能

----
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
 xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:tx="http://www.springframework.org/schema/tx"
 xmlns:aop="http://www.springframework.org/schema/aop" xmlns:task="http://www.springframework.org/schema/task"
 xmlns:cache="http://www.springframework.org/schema/cache"
 xsi:schemaLocation="http://www.springframework.org/schema/beans
 http://www.springframework.org/schema/beans/spring-beans-4.3.xsd
 http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx-4.3.xsd 
  http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop-4.3.xsd 
  http://www.springframework.org/schema/task http://www.springframework.org/schema/task/spring-task-4.3.xsd 
  http://www.springframework.org/schema/cache http://www.springframework.org/schema/cache/spring-cache.xsd">
 
 <!--配置spring工具类 -->
 <bean id="SpringContextUtil" class="java.spring.SpringContextUtil"
 scope="singleton"></bean>
 
</beans>
```
---
```java
Entity entity = (Entity)SpringContextUtil.getBean("xxx");
```
---
