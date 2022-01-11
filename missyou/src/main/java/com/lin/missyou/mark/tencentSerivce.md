1: df -h  查看分区情况以及数据盘名称
2: sudo -i 切换到root超级用户



### Linux yum命令

yum( Yellow dog Updater Modified) 是一个再Fedoras和Redhat以及Shell前端软件包管理器
基于 RPM包管理，能够从指定的服务器自动下载RPM包并且安装，可以自己处理依赖关系，并且可以一次安装所有依赖的软件包

yum语法

```shell script
yum [options] [command] [package]
```

- options 可选 选项包括 -h(help) -y(当安装过程提示全部为yes) q(不显示安装过程) 等等
- command 要进行的操作
- package 安装包的包名

yum的常用命令

- 列出所有可能更新的软件清单命令
- yum list
- yum install <package_name>
- yum remove
- yum search <keyword>
- yum update <package_name>

- yum clean package
- yum clean headers
- yum clean oldheaders
