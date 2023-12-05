# String 
1. String.contact()方法就是一次数组的拷贝，在内存中处理速度很快，但是最后会return new String(value)，降低了contact的速度
2. StringBuffer 和 StringBuilder 的 append方法都继承自 AbstractStringBuilder-->byte[] value;，都是对字符数组添加，拷贝，但是最后并不会new String(value)
3. “+” 加号，这里字节码层面看到的是使用StringBuilder的append方法进行追加，但是每一次循环都会创建一个StringBuilder对象，所以也不快
    类似于： str = new StringBuilder(str).append("str").toString()
4. 一般情况下 + 和 contact 这两个不能用，耗时，然后还会增加内存占用

# String == equals
== 比较的是两个String类型变量的引用，当两个String类型的变量只想同一个String对象（也就是同一个内内存地址）的时候，返回true，
equals（）是对String对象封装的字符串内容进行比较，相同返回true，
使用equals方法和其他值做比较的时候，可能会导致抛出空指针异常，下边就是equals的源码：
```java 
    public boolean equals(Object anObject) {
        if (this == anObject) {
            return true;
        }
        if (anObject instanceof String) {
            String aString = (String)anObject;
        if (coder() == aString.coder()) {
            return isLatin1() ? StringLatin1.equals(value, aString.value)
                : StringUTF16.equals(value, aString.value);
            }
        }
        return false;
    }
```
这里使用的是 if (anObject instanceof String) 来判断传入的对象是否是String类型，如果不是直接返回false，
所以有可能会有前边的对象为空的现象，所以在使用equals的时候，一定要先把确定不为空的放在前边，不确定的放在equals()里边
“确定”。equals(“不确定”) 这样是可以的














