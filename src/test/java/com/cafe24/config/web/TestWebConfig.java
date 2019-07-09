package com.cafe24.config.web;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

import com.cafe24.config.web.FileuploadConfig;
import com.cafe24.config.web.MVCConfig;
import com.cafe24.config.web.MessageConfig;


@Configuration
@EnableAspectJAutoProxy
@ComponentScan({"com.cafe24.shopping.controller", "com.cafe24.shopping.exception"})
@Import({TestMVCConfig.class, FileuploadConfig.class, MessageConfig.class})
public class TestWebConfig {
}