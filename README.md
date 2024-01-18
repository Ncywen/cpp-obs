# CppObs

#### 介绍
使用Java编写的C&C++加密混淆工具

#### 使用说明

1.  使用时仅需实例化混淆对象

```java
ObsUtil ou=new ObsUtil();

```

2.字符串加密

```java
//将返回加密后的代码
ou.enc_str(code,key);
```

3.函数名混淆(仅在源码中起混淆作用)

```java
//将返回加密后的代码
ou.enc_fn(code);
```
