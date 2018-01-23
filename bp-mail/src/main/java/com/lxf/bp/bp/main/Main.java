package com.lxf.bp.bp.main;

import com.lxf.bp.bp.factory.impl.MessageFactoryImpl;
import com.lxf.bp.utils.FileUtils;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, MessagingException {

        List<String> textAllForList = FileUtils.getTextAllForList("data/123.txt");
        String fileTextFromClassPath = FileUtils.getFileTextFromClassPath("html/pageTemplate.html");

        HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("testLogo","pic/2.png");

        MessageFactoryImpl messageFactory = new MessageFactoryImpl();
        messageFactory.buildMimeMessage("主题",fileTextFromClassPath,stringStringHashMap, "920259310@qq.com");

    }
}
