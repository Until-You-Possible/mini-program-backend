### token 出现的背景

- 在早前的Web应用中，Web 基本上就是文档的浏览而已， 因为是浏览，作为服务器， 不需要记录谁在某一段时间里都浏览了什么文档，
  每次请求都是一个新的HTTP协议， 就是请求加响应， 尤其是我不用记住是谁刚刚发了HTTP请求，每个请求对我来说都是全新的；
  
- 但是随着交互式Web应用的兴起，像在线购物网站，需要登录的网站等等，面临一个问题，那就是要管理会话，必须记住哪些人登录系统， 哪些人往自己的购物车中放商品， 也就是说我必须把每个人区分开，
这就是一个不小的挑战，因为HTTP请求是无状态的，所以想出的办法就是给大家发一个会话标识(session id), 说白了就是一个随机的字串，每个人收到的都不一样， 每次大家向我发起HTTP请求的时候，把这个字符串给一并捎过来， 这样我就能区分开谁是谁了；

- 但是客户端只需要保存自身的session id，而服务器端则要保存所有客户端的session id ，这对服务器说是一个巨大的开销 ， 严重的限制了服务器扩展能力；
  Token的出现解决了这个问题，因为服务端不需要存储Token的信息，而是通过CPU的计算 + 数据的加密解密再核对Token的方式来验证用户是否合法（即HTTP请求信息有没有被篡改），
让服务器内存得到释放；


### token的出现
Token的引入：Token是在客户端频繁向服务端请求数据，服务端频繁的去数据库查询用户名和密码并进行对比，
判断用户名和密码正确与否，并作出相应提示，在这样的背景下，Token便应运而生。

### token的定义
Token是服务端生成的一串字符串，以作客户端进行请求的一个令牌，当第一次登录后，
服务器生成一个Token便将此Token返回给客户端，以后客户端只需带上这个Token前来请求数据即可，
无需再次带上用户名和密码

### token的目的

Token的目的是为了减轻服务器的压力，减少频繁的查询数据库，使服务器更加健壮。


### token原理

![在这里插入图片描述](https://img-blog.csdnimg.cn/ece2c1e79cd1461e9782908c0048245e.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBAYXJ0aHVyd2FuZ2dhbmc=,size_20,color_FFFFFF,t_70,g_se,x_16#pic_center)


### 具体描述

- 将荷载payload，以及Header信息进行Base64加密，形成密文payload密文，header密文。
- 将形成的密文用句号链接起来，用服务端秘钥进行HS256加密，生成签名。
- 将前面的两个密文后面用句号链接签名形成最终的token返回给服务端

--- 备注：

- 用户请求时携带此token(分为三部分，header密文，payload密文，签名)到服务端，服务端解析第一部分(header密文)，用Base64解密，可以知道用了什么算法进行签名
- 服务端使用原来的秘钥与密文(header密文+"."+payload密文)同样进行HS256运算，然后用生成的签名与token携带的签名进行对比，若一致说明token合法，不一致说明原文被修改
- 判断是否过期，客户端通过用Base64解密第二部分（payload密文），可以知道荷载中授权时间，以及有效期。通过这个与当前时间对比发现token是否过期

### token实现思路

![在这里插入图片描述](https://img-blog.csdnimg.cn/76152a2096c346ba8ce32202f665e077.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBAYXJ0aHVyd2FuZ2dhbmc=,size_15,color_FFFFFF,t_70,g_se,x_16#pic_center)

### 具体描述

- 用户登录校验，校验成功后就返回Token给客户端
- 客户端收到数据后保存在客户端
- 客户端每次访问API是携带Token到服务器端
- 服务器端采用filter过滤器校验。校验成功则返回请求数据，校验失败则返回错误码