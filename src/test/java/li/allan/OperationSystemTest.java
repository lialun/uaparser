package li.allan;

import li.allan.domain.OperationSystem;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class OperationSystemTest {
    private static Map<String[], OperationSystem> WINDOWS = new LinkedHashMap<String[], OperationSystem>();
    private static Map<String[], OperationSystem> MAC = new HashMap<String[], OperationSystem>();
    private static Map<String[], OperationSystem> IOS = new HashMap<String[], OperationSystem>();
    private static Map<String[], OperationSystem> ANDROID = new HashMap<String[], OperationSystem>();
    private static Map<String[], OperationSystem> LINUX = new HashMap<String[], OperationSystem>();
    private static Map<String[], OperationSystem> OTHERS = new HashMap<String[], OperationSystem>();
//
//    static {
//        //desktop
//        WINDOWS.put(new String[]{"Windows 98", "Win98"},
//                new OperationSystem("Windows", new Version("98", "", "", "Memphis")));
//        WINDOWS.put(new String[]{"Windows 98; Win 9x 4.90", "Windows ME", "windows me"},
//                new OperationSystem("Windows", new Version("me", "", "", "Millennium")));
//        WINDOWS.put(new String[]{"Windows NT 5.0", "windows 2000"},
//                new OperationSystem("Windows", new Version("2000", "", "", "NT 5.0")));
//        WINDOWS.put(new String[]{"Windows NT 5.1", "Windows_XP/5.1"},
//                new OperationSystem("Windows", new Version("XP", "", "", "Whistler")));
//        WINDOWS.put(new String[]{"Windows NT 5.2"},
//                new OperationSystem("Windows", new Version("2003 Server", "", "", "Whistler Server")));
//        WINDOWS.put(new String[]{"Windows NT 6.0"},
//                new OperationSystem("Windows", new Version("Vista", "", "", "Longhorn")));
//        WINDOWS.put(new String[]{"Windows NT 6.1"}, new OperationSystem("Windows", new Version("7", "", "", "Vienna")));
//        WINDOWS.put(new String[]{"Windows NT 6.2"}, new OperationSystem("Windows", new Version("8", "", "", "Metro")));
//        WINDOWS.put(new String[]{"Windows NT 6.3"}, new OperationSystem("Windows", new Version("8", "1", "", "Blue")));
//        WINDOWS.put(new String[]{"Windows NT 10.0"}, new OperationSystem("Windows", new Version("10", "", "", "Threshold")));
//        //phone
//        WINDOWS.put(new String[]{"Windows Phone 8.0", "Windows Phone OS 8.0"},
//                new OperationSystem("Windows Phone", new Version("8", "0", "", "")));
//        WINDOWS.put(new String[]{"Windows NT 6.1; XBLWP7", "Windows Phone OS 7"},
//                new OperationSystem("Windows Phone", new Version("7", "", "", "")));
//        WINDOWS.put(new String[]{"Windows Mobile", "windows ce"},
//                new OperationSystem("Windows Phone", new Version("", "", "", "")));
//        //tablet
//        WINDOWS.put(new String[]{"windows nt 6.2; ARM"}, new OperationSystem("Windows RT", new Version("6", "2", "", "")));
//        WINDOWS.put(new String[]{"windows nt 6.3; ARM"}, new OperationSystem("Windows RT", new Version("6", "3", "", "")));
//        //other
//        WINDOWS.put(new String[]{"windows", "Windows"}, new OperationSystem("Windows", new Version("", "", "", "")));
//        //xbox?
//    }
//
//    static {
//        MAC.put(new String[]{"Mac OS X 10.5"}, new OperationSystem("Mac", new Version("10", "5", "", "")));
//        MAC.put(new String[]{"Mac OS X 10_6_2"}, new OperationSystem("Mac", new Version("10", "6", "2", "")));
//        MAC.put(new String[]{"mac", "Mac OS X"}, new OperationSystem("Mac", new Version("", "", "", "")));
//    }
//
//    static {
//        //iphone
//        IOS.put(new String[]{"(iPhone; U; CPU iPhone OS 5_0 like Mac OS X)"}, new OperationSystem("iOS(iPhone)", new Version("5", "0", "", "")));
//        IOS.put(new String[]{"(iPhone; CPU iPhone OS 6_0 like Mac OS X)"}, new OperationSystem("iOS(iPhone)", new Version("6", "0", "", "")));
//        //ipad
//        IOS.put(new String[]{"(iPad; U; CPU OS 3_2 like Mac OS X; en-us)"}, new OperationSystem("iOS(iPad)", new Version("3", "2", "", "")));
//        IOS.put(new String[]{"(iPad; CPU OS 6_0 like Mac OS X)"}, new OperationSystem("iOS(iPad)", new Version("6", "0", "", "")));
//    }
//
//    static {
//        ANDROID.put(new String[]{"Android 2.1"}, new OperationSystem("Android", new Version("2", "1", "", "")));
//        ANDROID.put(new String[]{"Android 3.1"}, new OperationSystem("Android", new Version("3", "1", "", "")));
//        ANDROID.put(new String[]{"Android 4.4"}, new OperationSystem("Android", new Version("4", "4", "", "")));
//    }
//
//    static {
//        LINUX.put(new String[]{""}, new OperationSystem("MAC", new Version("", "", "", "")));
//        LINUX.put(new String[]{""}, new OperationSystem("MAC", new Version("", "", "", "")));
//        LINUX.put(new String[]{""}, new OperationSystem("MAC", new Version("", "", "", "")));
//    }
//
//    static {
//        //webOS
//        OTHERS.put(new String[]{"webOS/2.1.2"}, new OperationSystem("WebOS", new Version("2", "1", "2", "")));
//        OTHERS.put(new String[]{"hpwOS/3.0.2"}, new OperationSystem("WebOS", new Version("3", "0", "2", "")));
//        //
//        OTHERS.put(new String[]{"Palm OS 5.4.9"}, new OperationSystem("Palm OS", new Version("5", "4", "9", "")));
//        OTHERS.put(new String[]{"MeeGo"}, new OperationSystem("MeeGo", new Version("", "", "", "")));
//        OTHERS.put(new String[]{"Tizen/1.0"}, new OperationSystem("Tizen", new Version("1", "0", "", "")));
//        OTHERS.put(new String[]{"Tizen 2.2"}, new OperationSystem("Tizen", new Version("2", "2", "", "")));
//        OTHERS.put(new String[]{"MeeGo"}, new OperationSystem("MeeGo", new Version("", "", "", "")));
//        //BSD
//        OTHERS.put(new String[]{"(X11; U; FreeBSD amd64; en-US; rv:1.8.0.8)"}, new OperationSystem("FreeBSD", new Version("", "", "", "")));
//        OTHERS.put(new String[]{"DragonFly"}, new OperationSystem("DragonFly BSD", new Version("", "", "", "")));
//        OTHERS.put(new String[]{"(X11; U; OpenBSD i386; en-US; rv:1.7.10)"}, new OperationSystem("OpenBSD", new Version("", "", "", "")));
//        OTHERS.put(new String[]{"(X11; U; NetBSD; en-US; rv:1.8.1.6)"}, new OperationSystem("NetBSD", new Version("", "", "", "")));
//
//    }
//
//    private static void testOS(String userAgent, OperationSystem operationSystem) {
//        System.out.println(userAgent);
//        OperationSystem os = UAParser.parseOperationSystem(userAgent);
//        Assert.assertEquals(operationSystem.getName(), os.getName());
//        Assert.assertEquals(operationSystem.getVersion(), os.getVersion());
//    }
//
//    @Test
//    public void testAllOS() throws CloneNotSupportedException, IOException {
//        testWindows();
//        testMac();
//        testAndroid();
//        testIOS();
//        testOthers();
//    }
//
//    @Test
//    public void testWindows() throws CloneNotSupportedException, IOException {
//        for (Map.Entry<String[], OperationSystem> entry : WINDOWS.entrySet()) {
//            for (String userAgent : entry.getKey()) {
//                testOS(userAgent, entry.getValue());
//            }
//        }
//    }
//
//    @Test
//    public void testMac() throws CloneNotSupportedException, IOException {
//        for (Map.Entry<String[], OperationSystem> entry : MAC.entrySet()) {
//            for (String userAgent : entry.getKey()) {
//                testOS(userAgent, entry.getValue());
//            }
//        }
//    }
//
//    @Test
//    public void testAndroid() throws CloneNotSupportedException, IOException {
//        for (Map.Entry<String[], OperationSystem> entry : ANDROID.entrySet()) {
//            for (String userAgent : entry.getKey()) {
//                testOS(userAgent, entry.getValue());
//            }
//        }
//    }
//
//    @Test
//    public void testIOS() throws CloneNotSupportedException, IOException {
//        for (Map.Entry<String[], OperationSystem> entry : IOS.entrySet()) {
//            for (String userAgent : entry.getKey()) {
//                testOS(userAgent, entry.getValue());
//            }
//        }
//    }
//
//    @Test
//    public void testLiunx() throws CloneNotSupportedException, IOException {
//        for (Map.Entry<String[], OperationSystem> entry : LINUX.entrySet()) {
//            for (String userAgent : entry.getKey()) {
//                testOS(userAgent, entry.getValue());
//            }
//        }
//    }
//
//    @Test
//    public void testOthers() throws CloneNotSupportedException, IOException {
//        for (Map.Entry<String[], OperationSystem> entry : OTHERS.entrySet()) {
//            for (String userAgent : entry.getKey()) {
//                testOS(userAgent, entry.getValue());
//            }
//        }
//    }
}
