### 双token验证机制

###### 前置场景

在基于token验证登录态这个情境下。token突然就过期了，然后只好被迫停止现在正在进行的操作跳转到登录页进行重新登录操作，这就非常的智熄了，这带给用户，
特别是经常使用或正在进行某个操作的用户，一种非常不好的体验。这就是单token验证登录的一个缺点。
因此对于经常/正在使用或经常/正在进行操作的用户（我称之为活跃用户）就不应当跳转到登录页面进行登陆操作（除了某些敏感系统或包含敏感信息进行敏感操作的网页、app、系统），
对于这个缺点的解决，来一个双token的验证机制。

###### 什么是双token机制

就是在登陆操作之后由服务端返回两个token：accessToken和refreshToken，在之后的验证登录态的操作中使用这两个token进行验证，
其中accessToken的过期时间相当短，refreshToken的过期时间相对于accessToken而言相当长，且会不断的刷新，每次刷新后的refreshToken都是不同的

###### 双token验证的优点

- accessToken的存在，保证了登录态的正常验证，因其过期时间的短暂也保证了帐号的安全性
- refreshToken的存在，保证了用户（即使是非活跃用户）无需在短时间内进行反复的登陆操作来保证登录态的有效性，
  同时也保证了活跃用户的登录态可以一直存续而不需要进行重新登录，其反复刷新也防止某些不怀好意的人获取refreshToken后对用户帐号进行动手动脚的操作

###### 双token检验流程

首先进行正常的登录操作，在后台服务器验证账号密码成功之后返回2个token：accessToken和refreshToken。在进行服务器请求的时候，先将Token发送验证，
如果accessToken有效，则正常返回请求结果；如果accessToken无效，则验证refreshToken。
此时如果refreshToken有效则返回请求结果和新的accessToken和新的refreshToken。如果refreshToken无效，则提示用户进行重新登陆操作。

###### 流程图如下

![在这里插入图片描述](https://img-blog.csdnimg.cn/bf0e12a2b67b41b0ae70dacfe5ff1c2d.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBAYXJ0aHVyd2FuZ2dhbmc=,size_20,color_FFFFFF,t_70,g_se,x_16#pic_center)


### 应用

###### PC端应用

由于token可以直接直观地获取到，因此不管是accessToken还是refreshToken为了安全起见，其过期时间都不应该设置得很长，且需要不停地更换token，
因此PC网络应用的accessToken一般设置为2h过期，而refreshToken设置为1天到2天比较好，不足1天也是可以的，如果设置的时间比较短就在活跃期间时常刷新freshToken就好了

###### 手机应用
###### 无效的Token的处理

