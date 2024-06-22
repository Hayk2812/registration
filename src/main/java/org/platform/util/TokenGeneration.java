package org.platform.util;

import org.apache.commons.lang.RandomStringUtils;

import java.util.Random;

public class TokenGeneration {
    public static String generatVerifyCode(){
        return RandomStringUtils.random(6,true,true);
    }
}
