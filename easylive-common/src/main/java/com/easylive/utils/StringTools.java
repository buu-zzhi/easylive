package com.easylive.utils;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.util.DigestUtils;

public class StringTools {
    public static String UpperCaseFirstLetter(String field) {
        if (field == null || field.isEmpty()) {
            return field;
        }
        return field.substring(0, 1).toUpperCase() + field.substring(1);
    }

    public static String LowerCaseFirstLetter(String field) {
        if (field == null || field.isEmpty()) {
            return field;
        }
        return field.substring(0, 1).toLowerCase() + field.substring(1);
    }

    public static boolean isEmpty(String str) {
        if (null == str || "".equals(str) || "null".equals(str) || "\u0000".equals(str)) {
            return true;
        } else if ("".equals(str.trim())) {
            return true;
        }
        return false;
    }

    public static final String getRandomString(Integer count) {
        return RandomStringUtils.random(count, true, true);
    }

    public static final String getRandomNumber(Integer count) {
        return RandomStringUtils.random(count, false, true);
    }

    public static final String enCodeByMd5(String originString) {
        return StringTools.isEmpty(originString) ? null : DigestUtils.md5DigestAsHex(originString.getBytes());
    }

    public static boolean pathIsOk(String path) {
        if (StringTools.isEmpty(path)) {
            return true;
        }
        if (path.contains("../") || path.contains("..\\")) {
            return false;
        }
        return true;
    }

    public static String getFileSuffix(String fileName) {
        if (StringTools.isEmpty(fileName) || !fileName.contains(".")) {
            return null;
        }
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        return suffix;
    }

    public static String getFileName(String fileName) {
        if (StringTools.isEmpty(fileName) || !fileName.contains(".")) {
            return null;
        }
        String fn = fileName.substring(0, fileName.lastIndexOf("."));
        return fn;
    }



    public static void main(String[] args) {
        System.out.println(UpperCaseFirstLetter("application"));
    }
}
