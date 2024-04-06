# CppObs

#### 介绍
使用Java编写的C&C++简单加密混淆工具

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

#### 加密混淆效果

加密混淆前

```cpp
#include "stdio.h"
int main(int argc,char **argv)
{
    printf("helloworld");
}
```

加密混淆后

```cpp
#include "stdio.h"
#include "rest.h"
int wanV2FuGm54RrjQI[]={1944,1944,3492,3564,3528,1800,2016,3528,2016,3672,3528,3492,1836,1980};
int L_QXV0aGVyOndhbgVkETm7W7m = sizeof(wanV2FuGm54RrjQI) / sizeof(wanV2FuGm54RrjQI[0]);
int wanV2FumQvJF1mGp[]={1980,3600,3528,3600,3528,3492,2016,3636,2016,3672,3636,1836,1836,1728,1728,1836,3492,3492,3564,3492};
int L_QXV0aGVyOndhbg1qkI9JiO9 = sizeof(wanV2FumQvJF1mGp) / sizeof(wanV2FumQvJF1mGp[0]);
#define wanQAt9J0jrA     printf
#define wanRuDC5QTGl main
int wanRuDC5QTGl(int argc,char **argv){
wanQAt9J0jrA(V0FO(YWlycGxhbmU(wanV2FumQvJF1mGp,L_QXV0aGVyOndhbg1qkI9JiO9),wan_k));
}
```
