package li.allan;

import li.allan.domain.UserAgent;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class AgentTest {
    private static Map<String[], UserAgent> BROWSER = new LinkedHashMap<String[], UserAgent>();

    static {
//        //Baidu UserAgent
//        BROWSER.put(new String[]{"Mozilla/5.0 (Windows; U; Windows NT 6.1; zh_CN) AppleWebKit/534.7 (KHTML, like Gecko) Chrome/7.0 baidubrowser/1.x Safari/534.7", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1; baidubrowser 1.x)"},
//                new UserAgent("Baidu UserAgent", new Version("1", "x", "", "")));
//        //Chrome
//        BROWSER.put(new String[]{"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/40.0.2214.38 Safari/537.36"}, new UserAgent("Chrome", new Version("40", "0", "2214", "")));
//        BROWSER.put(new String[]{"Mozilla/5.0 (Windows NT 6.2; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/34.0.1847.116 Safari/537.36"}, new UserAgent("Chrome", new Version("34", "0", "1847", "")));
//        //Chromium
//        BROWSER.put(new String[]{"Mozilla/5.0 (X11; Linux i686) AppleWebKit/535.7 (KHTML, like Gecko) Ubuntu/11.10 Chromium/16.0.912.21 Chrome/16.0.912.21 Safari/535.7"}, new UserAgent("Chromium", new Version("16", "0", "912", "")));
//        //Firefox
//        BROWSER.put(new String[]{"Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:22.0) Gecko/20130328 Firefox/22.0"}, new UserAgent("Firefox", new Version("22", "0", "", "")));
//        //IE
//        BROWSER.put(new String[]{"Mozilla/4.0 (Windows; MSIE 6.0; Windows NT 5.1; SV1; .NET CLR 2.0.50727)"}, new UserAgent("IE", new Version("6", "0", "", "")));
//        BROWSER.put(new String[]{"Mozilla/5.0 (IE 11.0; Windows NT 6.3; WOW64; Trident/7.0; Touch; rv:11.0) like Gecko"}, new UserAgent("IE", new Version("11", "0", "", "")));
//        //LG UserAgent
//        //BROWSER.put(new String[]{"Mozilla/5.0 (Unknown; Linux armv7l) AppleWebKit/537.1  (KHTML, like Gecko) Safari/537.1  LG UserAgent/6.00.00( mouse 3D SCREEN TUNER; LGE; GLOBAL-PLAT5; 03.07.01; 0x00000001;); LG NetCast.TV-2013/03.17.01 (LG, GLOBAL-PLAT4, wired)"}, new UserAgent("Windows", new Version("LG UserAgent", "6", "00", "00")));
//        //Sogou Explorer
//        BROWSER.put(new String[]{"Mozilla/5.0 (Windows NT 6.1) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/14.0.802.30 Safari/535.1 SE 2.X MetaSr 1.0"}, new UserAgent("Sogou Explorer", new Version("", "", "", "")));
//        //Opera
//        BROWSER.put(new String[]{"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.95 Safari/537.36 OPR/26.0.1656.60"}, new UserAgent("Windows", new Version("", "", "", "")));
//        BROWSER.put(new String[]{"Opera/9.80 (Windows NT 5.1) Presto/2.12.388 Version/12.14"}, new UserAgent("Windows", new Version("", "", "", "")));
//        BROWSER.put(new String[]{"Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Oupeng/10.2.1.86910 Safari/534.30"}, new UserAgent("Windows", new Version("", "", "", "")));
//        //Navigator
//        //BROWSER.put(new String[]{"Mozilla/5.0 (Macintosh; U; Intel Mac OS X; en-US; rv:1.8.1.12) Gecko/20080219 Firefox/2.0.0.12 Navigator/9.0.0.6"}, new UserAgent("Windows", new Version("", "", "", "")));
//        BROWSER.put(new String[]{"Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.0.2) Gecko/20030208 Netscape/7.02"}, new UserAgent("Windows", new Version("", "", "", "")));
//        BROWSER.put(new String[]{"Mozilla/4.08 [en] (WinNT; I ;Nav)"}, new UserAgent("Windows", new Version("", "", "", "")));
//        //Maxthon
//        BROWSER.put(new String[]{"Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; SV1; Maxthon; .NET CLR 1.1.4322)"}, new UserAgent("Windows", new Version("", "", "", "")));
//        BROWSER.put(new String[]{"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.3 (KHTML, like Gecko) Maxthon/3.3.3.600 Chrome/16.0.883.0 Safari/535.3"}, new UserAgent("Windows", new Version("", "", "", "")));
//        //TT
//        BROWSER.put(new String[]{"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1; TencentTraveler 4.0; .NET CLR 2.0.50727)"}, new UserAgent("Windows", new Version("", "", "", "")));
//        //The world
//        BROWSER.put(new String[]{"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1; .NET CLR 2.0.50727; .NET CLR 3.0.04506.648; .NET CLR 3.5.21022; .NET CLR 1.1.4322; TheWorld)"}, new UserAgent("Windows", new Version("", "", "", "")));
//        BROWSER.put(new String[]{"Mozilla/5.0 (Android 2.2; zh-cn; HTC Desire)/GoBrowser"}, new UserAgent("Windows", new Version("", "", "", "")));
//        BROWSER.put(new String[]{"Mozilla/5.0 (compatible; MSIE 10.0; Windows Phone 8.0; Trident/6.0; IEMobile/10.0; ARM; Touch; NOKIA; Lumia 920)"}, new UserAgent("", new Version("", "", "", "")));
//        BROWSER.put(new String[]{"HTC_P4550/TYTN_II Mozilla/4.0 (compatible; MSIE 6.0; Windows CE; IEMobile 7.11)"}, new UserAgent("", new Version("", "", "", "")));
//        BROWSER.put(new String[]{""}, new UserAgent("", new Version("", "", "", "")));
//        BROWSER.put(new String[]{""}, new UserAgent("", new Version("", "", "", "")));
//        BROWSER.put(new String[]{""}, new UserAgent("", new Version("", "", "", "")));
//        BROWSER.put(new String[]{""}, new UserAgent("", new Version("", "", "", "")));
    }

    private static void testBrowser(String userAgent, UserAgent expected) {
        System.out.println(userAgent);
        UserAgent browser = UAParser.parseBrowser(userAgent);
        Assert.assertEquals(expected.getName(), browser.getName());
        Assert.assertEquals(expected.getVersion(), browser.getVersion());
    }


    @Test
    public void testBrowser() throws CloneNotSupportedException, IOException {
        for (Map.Entry<String[], UserAgent> entry : BROWSER.entrySet()) {
            for (String userAgent : entry.getKey()) {
                testBrowser(userAgent, entry.getValue());
            }
        }
    }
}
