package com.chun.proxy.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Author: lixianchun
 * Date: 2019/3/31
 * Description:
 */

public final class WebUtil {
    private static final Logger log = LoggerFactory.getLogger(WebUtil.class);

    public WebUtil() {
    }

    public static String getRequestBodyStr(HttpServletRequest request) {
        String result = "";
        try {
            ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
            Throwable var3 = null;
            try {
                InputStream inStream = request.getInputStream();
                byte[] buffer = new byte[1024];
                boolean var6 = false;

                int len;
                while((len = inStream.read(buffer)) != -1) {
                    outSteam.write(buffer, 0, len);
                }
                result = new String(outSteam.toByteArray(), "utf-8");
                log.info("请求入参:{}",result);
            } catch (Throwable var15) {
                var3 = var15;
                throw new BusinessException(ReturnCode.FAIL);
            } finally {
                if (outSteam != null) {
                    if (var3 != null) {
                        try {
                            outSteam.close();
                        } catch (Throwable var14) {
                            throw new BusinessException(ReturnCode.FAIL);
                        }
                    } else {
                        outSteam.close();
                    }
                }

            }
        } catch (IOException var17) {
            log.error(var17.getMessage(), var17);
        }

        return result;
    }


    public static Map<String, String> getRequestParams(HttpServletRequest request) {
        Map<String, String[]> requestMap = request.getParameterMap();
        if (requestMap != null && requestMap.keySet().size() > 0) {
            Map<String, String> changeMap = new HashMap();
            Iterator var3 = requestMap.keySet().iterator();

            while(var3.hasNext()) {
                String key = (String)var3.next();
                changeMap.put(key, requestMap.get(key)[0]);
            }
            log.info("getRequestParams ： {}",changeMap);
            return changeMap;
        } else {
            return null;
        }
    }

}

