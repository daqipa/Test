内存泄漏的例子
  
      数据库连接用完后没有关闭
      
内存溢出的例子

      死循环
注意事项:      
1 mybatis和spring结合的配置:

        <bean class="org.mybatis.spring.SqlSessionFactoryBean">
              <property name="dataSource" ref="dataSource"/>
              <property name="mapperLocations" value="classpath:mapper/*.xml"/>
        </bean>
        <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
            <property name="basePackage" value="com.test.dao"/>
        </bean>
        
2 mybatis中向sql语句传递参数时，如果参数个数大于一，则必须把参数放入map或者实体类对象中传递

分页业务逻辑;
    
    1 将当前的页码异步($.getJSON())传入controller的fenye()
    2 将页码转换为数据的起点索引 start=(page-1)*size
    3 使用map将start和size 传入sql语句
    4 使用limit关键字进行分页查询
       select * from user limit start,size
   
