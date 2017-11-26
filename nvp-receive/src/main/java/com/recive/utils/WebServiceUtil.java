package com.recive.utils;

import cn.eastrobot.www.ws.RobotServiceEx.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class WebServiceUtil {

    public static String getAnswer(String question) {
        String result = "";
        String imageUrl = null;
        if (question != null && question.length() > 0) {
            RobotServiceEx_PortType service;

            try {
                service = new RobotServiceEx_ServiceLocator().getDefaultRobotServiceExPort();
                String sessionId = "1231231231231";
                String userId = "4564564561123";
                String platform = "weixin";
                RobotRequest robotRequest = new RobotRequest();
                robotRequest.setSessionId(sessionId);
                robotRequest.setUserId(userId);
                robotRequest.setQuestion(question);
                UserAttribute pf = new UserAttribute();
                pf.setName("platform");
                pf.setValue(platform);
                List<UserAttribute> list = new ArrayList<UserAttribute>();
                list.add(pf);
                UserAttribute[] attributes = new UserAttribute[list.size()];
                attributes = list.toArray(attributes);
                robotRequest.setAttributes(attributes);
                RobotResponse responseEx = service.deliver(robotRequest);

                if (responseEx != null) {
                    RobotCommand[] command = responseEx.getCommands();
                    if (command != null) {
                        RobotCommand robotCommand = null;
                        for (int i = 0; i < command.length; i++) {
                            if (i == 0) {
                                robotCommand = command[i];
                                imageUrl = Arrays.toString(robotCommand.getArgs());

                                System.out.println(robotCommand.getName() + "," + robotCommand.getState() + ","
                                        + Arrays.toString(robotCommand.getArgs()));
                            }
                        }
						/*
						 * for (RobotCommand robotCommand : command) { imageUrl
						 * = Arrays.toString(robotCommand.getArgs());
						 * System.out.println(robotCommand.getName() + "," +
						 * robotCommand.getState() + "," +
						 * Arrays.toString(robotCommand.getArgs())); }
						 */
                    }

                    result = responseEx.getContent();
                    // 文字不为空，图片不为空
                    if ((result != null && !"".equals(result)) && (imageUrl != null && !"null".equals(imageUrl))) {
                        result = filterResult(result);
                        imageUrl = subImageUrlString(imageUrl);
                        // System.out.println("imageUrl:" + imageUrl);
                        return result + "|" + imageUrl;
                        // 文字为空，图片不为空
                    } else if ((imageUrl != null && !"null".equals(imageUrl)) && (result == null || "".equals(result))) {
                        imageUrl = subImageUrlString(imageUrl);
                        return imageUrl;
                        // 图片为空，文字不为空
                    } else if (imageUrl == null || "null".equals(imageUrl) && (result != null && !"".equals(result))) {
                        result = filterResult(result);
                        return result;
                    }

                }

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return null;

    }

    public static String filterResult(String result) {

        result = result.trim().replace("\n点击[link submit=\"N\"]查看其他热点问题[/link]", "");
        // result = result.trim().replace("<br>",
        // "\n").replace("<br/>",
        // "\n")
        // .replace("\n点击[link submit=\"N\"]查看其他热点问题[/link]",
        // "");
        result = result.replaceAll("<a(.*?)</a>", "");
        int index = result.indexOf("你可能关注下列相关问题");
        if (index > 0) {
            result = result.substring(0, index - 1);
        }
        if (result.startsWith("<HTML>")) {
            result = result.substring(6);
        }
        if (result.endsWith("</HTML>")) {
            result = result.substring(0, result.length() - 7);
        }
        result = result.replaceAll("[link]", "");
        result = result.replaceAll("[/link]", "");
        result = result.replaceAll("[\\[\\]]", "");
        //result = result.replaceAll("U佳", "小税");
        result = result.replaceAll("\n", "<br/>");

        return result;
    }

    public static String subImageUrlString(String imageUrl) {

        if (imageUrl.indexOf("CDATA") > -1) {
            String cut = "]]></PicUrl><Url><![";
            int cutlength = cut.length();
            String[] urlArr = imageUrl.split("CDATA");
            for (int i = 0; i < urlArr.length; i++) {
                if (i == 4) {
                    urlArr[i] = urlArr[i].substring(1, urlArr[i].length() - cutlength);
                    System.out.println("-----imageUrl:" + urlArr[i]);
                    return urlArr[i];
                }
            }
        } else {
            System.out.println("imageUrl:" + imageUrl);
            String[] urlArr = imageUrl.split(",");
            for (int i = 0; i < urlArr.length; i++) {
                if (i == 2) {
                    urlArr[i] = urlArr[i].substring(0, urlArr[i].length() - 1);
                    System.out.println("-----imageUrl:" + urlArr[i]);
                    return urlArr[i];
                }
            }

            return imageUrl;
        }
        return null;
    }
}