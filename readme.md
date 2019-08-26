# Spring Boot OAuth2认证服务

## 生成JWT认证密钥对

生成JWT.jws的命令
```bash
keytool -genkeypair -alias idefav -keyalg RSA -keypass 111111 -keystore jwt.jks -storepass 111111
```

## 编译
```bash
mvn clean package -DskipTests -U
```

## Docker镜像打包

```bash
mvn clean compile jib:build
```

