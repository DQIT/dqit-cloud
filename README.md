# SpringCloudDemo
用于个人学习以及开发中一些点子的实现
💡整体状态：目前处于0阶段

## 下一步计划：

技术计划：
- [x] 入参日志脱敏
- [ ] ~~整合 SpringSecurity 完成登录和鉴权~~
- [x] dockerfile
- [ ] 替换 white page
- [x] NacosDiscovery 整合
- [ ] NacosConfig 整合
- [x] Gateway网关整合
- [ ] 网关鉴权
- [ ] 接口鉴权SDK
- [ ] 自定义安全框架
- [ ] 其他...

业务计划：
- [ ] 待构思...

## 子模块说明

### common
状态：未完善
1. 作用：服务于其他模块，存储公共的常量、实体类、配置等
2. 目前包含内容：
    - 常量：
      - ResultCodeEnum 接口返回自定义状态码枚举
    - 实体类：
      - Result<T> 接口统一返回
    - 配置：
      - Swagger(Knife4J) 配置
    - 其他：
      - 接口日志切面 RestLogAspect
      - 异常统一处理切面 ExceptionAdvice
      - 基础表实体 BaseTableEntity
3. TODO： 
   1. 整合登录鉴权

### system-user
状态：未完善
1. 作用：用户相关维护接口，Security相关接口和实现
2. TODO：
   1. 用户体系相关内容待完善

