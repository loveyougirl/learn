# Mybatis-Plus
使用LambdaQueryWrapper 报错MybatisPlusException: can not find lambda cache for this property [****]
在项目中为了追求开发效率，全都使用mybatis自动生成代码，分页插件，几乎除了业务逻辑，全都是导入工具包，
在开发项目过程中有过使用不当引起的问题，也有自己滥用出现的一些问题，这些都通过看源码，然后搞定，还遇见了一个mybatis-plus的源码bug
在使用LamdbaQueryWrapper进行查询的时候，提示 can not find lambda cache for this property  xxx 某一个字段，
当时检查了好几遍，包括表中，实体中，都无异常，唯独进行查询的时候 can not find lambda cache for this property xxx 这个提示，
问题发生了不能不解决，所以只能上网查询，看到别的朋友是这样解决的：
在LambdaQueryWrapper条件之前添加以下语句：TableInfoHelper.initTableInfo(new MapperBuilderAssistant(new MybatisConfiguration(), “”), 条件类名.class)
但是我使用了这种方式，发现还是有上述异常，
然后就继续查资料，找到了一个解释说：因为MP3.2+之后不会缓存实体类的父类字段信息，所以在使用泛型的Lambda表达式时会报错.
他的解决方法是单独为这个类添加一个Mapper类，这一步我也有，所以直接忽略这个解决方法，
最后直接使用QueryWrapper来解决
