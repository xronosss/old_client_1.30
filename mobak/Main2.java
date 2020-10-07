package mobak;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import javax.microedition.io.ConnectionNotFoundException;
import javax.microedition.midlet.MIDlet;

import mobak.a.SocketListener;
import mobak.a.a.OutputGameMessage;
import mobak.a.a.MessageProcessor;
import mobak.b.a.Hero;
import mobak.b.b.Screen;
import mobak.b.b.StrategicScreen;
import mobak.b.b.ScreenDrawer;
import mobak.b.b.FormCreator;
import mobak.b.b.a.PopupMenu;
import mobak.text.class_1;
import mobak.text.class_62;
import mobak.text.MessagesContainer;
import mobak.text.RMSManager;

public class Main2 extends MIDlet implements class_1 {

   // $FF: renamed from: a mobak.Main2
   public static Main2 self;
   // $FF: renamed from: a boolean
   public static boolean field_650;
   // $FF: renamed from: a byte
   private byte field_651;
   // $FF: renamed from: b boolean
   private boolean loginAndPassAreEmpty;
   // $FF: renamed from: a java.lang.String
   private String login;
   // $FF: renamed from: b java.lang.String
   private String password;
   // $FF: renamed from: a mobak.i
   private UserData userData;
   // $FF: renamed from: a mobak.c.e
   public RMSManager rmsManager;
   // $FF: renamed from: a mobak.g
   private Connection connection;
   // $FF: renamed from: c boolean
   private boolean isNeedGameHelp;
   // $FF: renamed from: d boolean
   private boolean isNeedVibrate;
   // $FF: renamed from: a mobak.b.b.g
   private FormCreator formCreator;
   // $FF: renamed from: a java.lang.Runnable
   public Runnable field_661;
   // $FF: renamed from: c java.lang.String
   private String domain;
   // $FF: renamed from: b int
   private int port;
   // $FF: renamed from: a int
   public int field_664;


   // $FF: renamed from: <init> () void
   public Main2() {
      super();
      this.isNeedGameHelp = true;
      this.isNeedVibrate = true;
      this.field_661 = null;
      this.field_664 = -1;

      try {
         InputStream var1 = this.getClass().getResourceAsStream("/mobak/res/splash.bin2");
         byte[] var2 = method_862(var1);
         var1.close();
         if(var2 != null) {
            GlobalStorage.createMap(var2);
         }

      } catch (Exception var3) {
         var3.printStackTrace();
      }
   }

   // $FF: renamed from: a () void
   public final void saveLoginAndPass() {
      if(this.loginAndPassAreEmpty) {
         this.rmsManager.setString((byte)17, this.login);
         this.rmsManager.setString((byte)2, this.password);
         this.loginAndPassAreEmpty = false;
      }

   }

   // $FF: renamed from: a (byte) void
   public final void method_843(byte var1) {
      Connection var10001 = new Connection(this, var1);
      this.connection = var10001;
      (new Thread(this.connection)).start();
   }

   // $FF: renamed from: b (byte) void
   public final void method_844(byte var1) {
      if(SocketListener.self == null) {
         new SocketListener();
      }

      SocketListener.self.method_526(String.valueOf(this.port), this.domain);
      if(checkLogin(Hero.self.login) == null) {
         class_17 var10000 = new class_17(this);
         class_17 var2 = var10000;
         ScreenDrawer.method_334(MessagesContainer.getMessage(29), MessagesContainer.getMessage(170), "", var2);
      } else if(this.connection != null && connection.method_839(this.connection)) {
         connection.method_840(this.connection, (byte)1);
      } else {
         this.method_843((byte)1);
      }
   }

   // $FF: renamed from: c (byte) void
   public final void changeForm(byte var1) {
      this.field_651 = var1;
      FormCreator formCreator;
      switch(var1) {
      case 1:
      case 2:
         if(ScreenDrawer.self != null) {
            ScreenDrawer.self.method_376();
            this.formCreator = null;
            return;
         }
         break;
      case 3:
         try {
            formCreator = new FormCreator(MessagesContainer.getLine(9), this);
            this.formCreator = formCreator;
            String var4;
            if((var4 = checkLogin(Hero.self.login)) != null) {
               this.formCreator.createLabel(MessagesContainer.getMessage(11), var4, 100, 0);
            } else {
               this.formCreator.createLabel(MessagesContainer.getMessage(11), "+", 100, 0);
            }

            this.formCreator.createLabel(MessagesContainer.getMessage(10), this.password, 16, 0);
            method_860(this.formCreator);
            this.formCreator.setCurrentFormAsMain();
            return;
         } catch (Exception var2) {
            SocketListener.method_522(var2.getMessage(), true);
            return;
         }
      case 4:
         formCreator = new FormCreator(MessagesContainer.getLine(9), this);
         this.formCreator = formCreator;
         this.formCreator.createLabel(MessagesContainer.getMessage(16), this.domain, 40, 0);
         this.formCreator.createLabel(MessagesContainer.getMessage(17), String.valueOf(this.port), 10, 5);
         this.formCreator.createLabel(MessagesContainer.getMessage(14), String.valueOf(SocketListener.maxConnectionAttempts), 10, 5);
         this.formCreator.createLabel(MessagesContainer.getMessage(13), String.valueOf(SocketListener.repeatInterval), 10, 5);
         this.formCreator.createLabel(MessagesContainer.getMessage(12), String.valueOf(SocketListener.method_540()), 10, 5);
         method_860(this.formCreator);
         this.formCreator.setCurrentFormAsMain();
         return;
      case 5:
      default:
         break;
      case 6:
         if(this.field_664 != -1) {
            formCreator = new FormCreator(MessagesContainer.getLine(9), this);
            this.formCreator = formCreator;
            this.formCreator.createLabel(MessagesContainer.getMessage(79), "", 100, 0);
            method_860(this.formCreator);
            this.formCreator.setCurrentFormAsMain();
         }
         break;
      case 7:
         formCreator = new FormCreator(MessagesContainer.getLine(9), this);
         this.formCreator = formCreator;
         this.formCreator.createLabel(MessagesContainer.getMessage(279), this.userData != null?this.userData.userName :"", 32, 0);
         this.formCreator.createLabel(MessagesContainer.getMessage(289), this.userData != null?this.userData.login :"", 32, 0);
         this.formCreator.createLabel(MessagesContainer.getMessage(291), this.userData != null?this.userData.password :"", 16, 0);
         this.formCreator.createLabel(MessagesContainer.getMessage(280), this.userData != null?this.userData.heroName :"", 32, 0);
         boolean[] var3 = new boolean[]{false, false, false, false, false};
         if(this.userData != null) {
            var3[this.userData.raceId - 1] = true;
         } else {
            var3[0] = true;
         }

         this.formCreator.method_444(MessagesContainer.getLine(281), 4, new String[]{MessagesContainer.getLine(19), MessagesContainer.getLine(20), MessagesContainer.getLine(21), MessagesContainer.getLine(22), MessagesContainer.getLine(23)}, var3);
         this.formCreator.addStringItem("", "");
         this.formCreator.addCommandAtIndex(MessagesContainer.getLine(287), 0);
         this.formCreator.addCommandAtIndex(MessagesContainer.getLine(34), 1);
         this.method_4(0);
         this.formCreator.setCurrentFormAsMain();
         return;
      case 8:
         formCreator = new FormCreator(MessagesContainer.getLine(9), this);
         this.formCreator = formCreator;
         this.formCreator.method_460(MessagesContainer.getLine(319), 5, this.rmsManager.getByte((byte)26, (byte)1));
         this.formCreator.method_444(MessagesContainer.getLine(118), 2, new String[]{MessagesContainer.getLine(249), MessagesContainer.getLine(297)}, new boolean[]{this.isNeedGameHelp, this.isNeedVibrate});
         method_860(this.formCreator);
         this.formCreator.setCurrentFormAsMain();
         return;
      }

   }

   // $FF: renamed from: g () void
   private void method_846() {
      switch(this.field_651) {
      case 3:
      case 4:
      case 8:
         this.changeForm((byte)2);
         return;
      case 6:
         this.field_664 = -1;
      case 2:
      case 7:
         this.changeForm((byte)1);
      case 5:
      default:
      }
   }

   // $FF: renamed from: b () void
   public final void exit() {
      try {
         this.destroyApp(false);
      } catch (Exception var2) {
         SocketListener.logMessage("exit () " + var2.toString());
      }
   }

   // $FF: renamed from: a (java.lang.String) void
   public static void gotoUrl1(String var0) {
      try {
         self.platformRequest(var0);
      } catch (ConnectionNotFoundException var1) {
         SocketListener.method_522("Main2.gotoURL1 " + var1.toString(), true);
      } catch (Exception var2) {
         ;
      }
   }

   // $FF: renamed from: e () java.lang.String
   private static String method_849() {
      String var0;
      if((var0 = MessagesContainer.getLine(4)) == null || var0.trim().length() == 0) {
         var0 = "lordmancer.ru";
      }

      return "http://" + var0;
   }

   // $FF: renamed from: a () java.lang.String
   public final String method_850() {
      StringBuffer var10000 = (new StringBuffer()).append(method_849()).append("?p=27").append("&");
      String var2 = checkLogin(Hero.self.login);
      return var10000.append(this.password != null && !this.password.equals("") && var2 != null?"log=" + (var2.startsWith("+")?var2.substring(1):var2) + "&pas=" + this.password :"").toString();
   }

   // $FF: renamed from: b () java.lang.String
   public final String method_851() {
      return method_849() + "?ma=auction-type-lot&p=27";
   }

   // $FF: renamed from: c () java.lang.String
   public final String method_852() {
      return method_849() + "?p=28";
   }

   // $FF: renamed from: d () java.lang.String
   public static String getVersion() {
      return "1.30";
   }

   // $FF: renamed from: a (short) boolean
   public final boolean method_854(short var1) {
      if(!this.isNeedGameHelp) {
         return false;
      } else {
         Object var4 = null;
         boolean var2 = true;
         RMSManager var7 = this.rmsManager;
         short[] var5;
         short[] var8 = (var5 = this.rmsManager.method_674((byte)14)) == null?null:var5;
         boolean var3 = true;
         if(var8 != null) {
            for(short var9 = 0; var9 < var8.length; ++var9) {
               if(var8[var9] == var1) {
                  var3 = false;
                  break;
               }
            }
         }

         if(var3) {
            short[] var10;
            if(var8 == null) {
               var8 = new short[1];
            } else {
               var10 = new short[var8.length + 1];
               System.arraycopy(var8, 0, var10, 0, var8.length);
               var8 = var10;
            }

            var8[var8.length - 1] = var1;
            var10 = var8;
            var2 = true;
            var7 = this.rmsManager;
            byte[] var11 = new byte[var8.length << 1];
            var1 = 0;

            for(short var6 = 0; var6 < var10.length; ++var6) {
               var11[var1] = (byte)(var10[var6] >> 8);
               var11[++var1] = (byte)var10[var6];
               ++var1;
            }

            var7.writeData((byte)14, var11);
         }

         return var3;
      }
   }

   // $FF: renamed from: a () boolean
   public final boolean method_855() {
      return this.isNeedVibrate;
   }

   // $FF: renamed from: a (java.lang.String) java.lang.String
   public static String checkLogin(String loginString) {
      if(loginString != null && loginString.length() > 0) {
         if((loginString = loginString.trim()).indexOf(64) > 0 && loginString.lastIndexOf(46) > loginString.indexOf(64) && loginString.length() > 6) {
            return loginString;
         } else {
            if(loginString.startsWith("8")) {
               loginString = "7" + loginString.substring(1);
            }

            if(!loginString.startsWith("+")) {
               loginString = "+" + loginString;
            }

            try {
               String var1 = loginString.substring(1);
               if(var1.length() >= 11 && var1.length() <= 13) {
                  Long.parseLong(loginString.substring(1));
                  return loginString;
               } else {
                  return null;
               }
            } catch (Exception var2) {
               SocketListener.method_523(var2);
               return "";
            }
         }
      } else {
         return "";
      }
   }

   // $FF: renamed from: a (java.lang.String) boolean
   public static boolean method_857(String var0) {
      return var0 != null && var0.length() >= 4;
   }

   // $FF: renamed from: b (java.lang.String) boolean
   public static boolean method_858(String var0) {
      return var0.startsWith("+") && !var0.startsWith("+79") && !var0.startsWith("+375");
   }

   // $FF: renamed from: a (int) void
   public final void onButtonClick(int var1) {
      if(var1 == 1) {
         this.method_846();
      } else {
         int value;
         String userName;
         String login;
         switch(this.field_651) {
         case 3:
            if(this.field_651 == 3) {
               if((login = checkLogin(this.formCreator.method_443(0))) == null) {
                  this.formCreator.method_457(MessagesContainer.getMessage(29), MessagesContainer.getMessage(30), 4);
                  break;
               }

               Hero.self.login = login;
               this.rmsManager.setString((byte)17, login);
               this.password = this.formCreator.method_443(1);
               this.rmsManager.setString((byte)2, this.password);
               this.method_846();
               if(this.field_661 != null) {
                  this.field_661.run();
               }
            }

            return;
         case 4:
            if(this.field_651 == 4) {
               this.domain = this.formCreator.method_443(0);
               this.port = Integer.parseInt(this.formCreator.method_443(1));
               this.rmsManager.setInt((byte)15, this.port);
               this.rmsManager.setString((byte)16, this.domain);
               if((value = Integer.parseInt(this.formCreator.method_443(2))) <= 0) {
                  value = 1;
               }

               if(value > 7) {
                  value = 7;
               }

               SocketListener.maxConnectionAttempts = value;
               if((value = Integer.parseInt(this.formCreator.method_443(3))) < 10) {
                  value = 10;
               }

               if(value > 100) {
                  value = 100;
               }

               SocketListener.repeatInterval = value;
               this.rmsManager.setInt((byte)6, SocketListener.maxConnectionAttempts);
               this.rmsManager.setInt((byte)5, SocketListener.repeatInterval);
               if((value = Integer.parseInt(this.formCreator.method_443(4))) < 128) {
                  value = 128;
               }

               if(value > 2048) {
                  value = 2048;
               }

               SocketListener.setMaxPacketSize((short)value);
               RMSManager rmsManager = this.rmsManager;
               short var12 = SocketListener.method_540();
               byte[] var10 = new byte[2];
               var10[1] = (byte)var12;
               var10[0] = (byte)(var12 >> 8);
               rmsManager.writeData((byte)7, var10);
               this.method_846();
            }

            return;
         case 5:
         default:
            break;
         case 6:
            if((userName = this.formCreator.method_443(0)).equals("")) {
               return;
            }

            OutputGameMessage outputGameMessage = new OutputGameMessage(MessageProcessor.packetTypes[31], (short)50, (short)0);

            try {
               outputGameMessage.addToBody(this.field_664);
               outputGameMessage.addToBody(userName);
               SocketListener.self.sendCommand(outputGameMessage);
            } catch (Exception var5) {
               SocketListener.logMessage("onButtonClick SEND_MESSAGE: " + var5.toString());
            }

            this.method_846();
            return;
         case 7:
            try {
               userName = this.formCreator.method_443(0);
               login = this.formCreator.method_443(1);
               String password = this.formCreator.method_443(2);
               String heroName = this.formCreator.method_443(3);
               if(userName == null || userName.trim().equals("") || password == null || password.trim().equals("") || heroName == null || heroName.trim().equals("")) {
                  this.formCreator.method_457(MessagesContainer.getMessage(29), MessagesContainer.getMessage(290), 4);
                  return;
               }

               if((login = checkLogin(login)) == null) {
                  this.formCreator.method_457(MessagesContainer.getMessage(29), MessagesContainer.getMessage(30), 4);
                  return;
               }

               if(!method_857(password)) {
                  this.formCreator.method_457(MessagesContainer.getMessage(29), MessagesContainer.getMessage(293), 4);
                  return;
               }

               if(method_858(login)) {
                  this.formCreator.method_457(MessagesContainer.getMessage(29), MessagesContainer.getMessage(292), 4);
                  return;
               }

               this.userData = new UserData(userName, login, password, heroName, (byte)(this.formCreator.method_447(0) + 1));
               if(SocketListener.self == null) {
                  new SocketListener();
               }

               SocketListener.self.method_526(String.valueOf(this.port), this.domain);
               if(this.connection == null || !connection.method_839(this.connection)) {
                  this.connection = new Connection(this, this.userData);
                  (new Thread(this.connection)).start();
               }
            } catch (Exception var6) {
               SocketListener.logMessage("onButtonClick REGISTRATION_SCREEN: " + var6.toString());
            }

            this.method_846();
            break;
         case 8:
            this.isNeedGameHelp = this.formCreator.method_445(0, 0);
            if(this.isNeedGameHelp) {
               this.rmsManager.setByte((byte)18, (byte)1);
            } else {
               this.rmsManager.setByte((byte)18, (byte)0);
            }

            this.isNeedVibrate = this.formCreator.method_445(0, 1);
            if(this.isNeedVibrate) {
               this.rmsManager.setByte((byte)22, (byte)1);
            } else {
               this.rmsManager.setByte((byte)22, (byte)0);
            }

            value = 1;
            if(this.formCreator.method_446(MessagesContainer.getLine(319)) != null) {
               value = this.formCreator.method_446(MessagesContainer.getLine(319)).getValue();
            }

            if(value <= 0) {
               value = 1;
            }

            StrategicScreen.method_126(value);
            this.rmsManager.setByte((byte)26, (byte)value);
            this.method_846();

            return;
         }

      }
   }

   // $FF: renamed from: c () void
   public static void method_859() {
      class_18 var0 = new class_18();
      ScreenDrawer.method_334(MessagesContainer.getLine(135), MessagesContainer.getLine(229), MessagesContainer.getLine(276), var0);
   }

   // $FF: renamed from: d () void
   public final void method_3() {}

   // $FF: renamed from: b (int) void
   public final void method_4(int var1) {
      if(this.formCreator != null && this.field_651 == 7) {
         short[] var3 = new short[]{(short)282, (short)283, (short)284, (short)285, (short)286};
         int var2;
         if((var2 = this.formCreator.method_447(0)) >= 0) {
            this.formCreator.method_456(0, MessagesContainer.getLine(var3[var2]));
         }
      }

   }

   // $FF: renamed from: a (mobak.b.b.g) void
   private static final void method_860(FormCreator var0) {
      var0.addCommandAtIndex(MessagesContainer.getLine(8), 0);
      var0.addCommandAtIndex(MessagesContainer.getLine(34), 1);
   }

   protected void destroyApp(boolean var1) {
      if(ScreenDrawer.self != null) {
         ScreenDrawer.self.method_352(false);
         if(ScreenDrawer.self != null) {
            ScreenDrawer.self.method_354();
         }

         if(SocketListener.self != null) {
            SocketListener.self.method_537(true);
            long var2 = System.currentTimeMillis();

            while(SocketListener.self != null && SocketListener.self.method_539() && System.currentTimeMillis() - var2 < 10000L) {
               try {
                  Thread.sleep(100L);
               } catch (Exception var5) {
                  ;
               }
            }

            if(SocketListener.self != null && SocketListener.self.method_539()) {
               SocketListener.self.method_538();
            }
         }

         try {
            if(this.rmsManager != null) {
               RMSManager var6 = this.rmsManager;
               if(this.rmsManager.recordStore != null) {
                  var6.recordStore.closeRecordStore();
               }
            }
         } catch (Exception var4) {
            SocketListener.logMessage("destroyApp (boolean) " + var4.toString());
         }

         this.notifyDestroyed();
         field_650 = true;
      }
   }

   protected void pauseApp() {
      if(ScreenDrawer.self != null) {
         ScreenDrawer.self.method_321();
      }

   }

   protected void startApp() {
      Main2 var1 = this;

      try {
         field_650 = false;
         self = var1;
         if(ScreenDrawer.self == null) {
            if(var1.rmsManager == null) {
               var1.rmsManager = new RMSManager();
            }

            var1.port = var1.rmsManager.getInt((byte)15, 8080);
            var1.domain = var1.rmsManager.getString((byte)16, "188.32.15.149");
            var1.isNeedGameHelp = var1.rmsManager.getByte((byte)18, (byte)0) > 0;
            var1.isNeedVibrate = var1.rmsManager.getByte((byte)22, (byte)1) > 0;
            StrategicScreen.method_126(var1.rmsManager.getByte((byte)26, (byte)1));
            SocketListener.maxConnectionAttempts = var1.rmsManager.getInt((byte)6, 3);
            SocketListener.repeatInterval = var1.rmsManager.getInt((byte)5, 30);
            SocketListener.setMaxPacketSize(var1.rmsManager.getShort((byte)7, (short)1024));
            SocketListener.errorSymbol = var1.rmsManager.getInt((byte)10, '\uea60');
            PopupMenu.method_634();
            ScreenDrawer.field_323 = var1.rmsManager.getInt((byte)19, 49);
            String var3 = System.getProperty("microedition.encoding");
            String[] encodings = new String[]{"utf-8", "utf-16", "ISO8859_5", "ISO8859-5", "ISO-8859-5", "ISO_8859-5", "ISO_8859-5:1988", "ISO-IR-144", "8859_5", "Cyrillic", "CSISOLatinCyrillic", "IBM915", "IBM-915", "Cp915", "915", "Cp1251", "Windows-1251", "win1251", "Cp866", "IBM866", "IBM-866", "866", "CP866", "CSIBM866", "KOI8_R", "KOI8-R", "KOI8", "CSKOI8R", var3};
            byte var8 = 0;

            while(var8 < encodings.length) {
               try {
                  byte[] var9 = "абвгде".getBytes(encodings[var8]);
                  if((new String(var9, encodings[var8])).equals("??????")) {
                     throw new UnsupportedEncodingException("??????");
                  }

                  SocketListener.encoding = encodings[var8];
                  break;
               } catch (UnsupportedEncodingException var16) {
                  ++var8;
               }
            }

            if(Hero.self == null) {
               Hero.self = new Hero(true);
            }

            Hero.self.heroId = var1.rmsManager.getInt((byte)1, -1);
            long phoneNumber = var1.rmsManager.getLong((byte)13, -1L);
            Hero.self.login = var1.rmsManager.getString((byte)17, "");
            if(Hero.self.login.equals("")) {
               Hero.self.login = var1.getAppProperty("login");
               var1.rmsManager.setString((byte)17, Hero.self.login);
            }

            if((Hero.self.login == null || Hero.self.login.equals("")) && phoneNumber > 0L) {
               Hero.self.login = String.valueOf(phoneNumber);
            }

            Hero.self.login = checkLogin(Hero.self.login);
            var1.password = var1.rmsManager.getString((byte)2, "");
            if(var1.password == null || var1.password.equals("")) {
               var1.password = var1.getAppProperty("password");
               var1.rmsManager.setString((byte)2, var1.password);
            }

            try {
               class_62 var20;
               if(Screen.field_25 == null) {
                  var20 = new class_62((byte)0, 9);
                  Screen.field_25 = var20;
               }

               if(Screen.field_26 == null) {
                  var20 = new class_62((byte)0, 10);
                  Screen.field_26 = var20;
               }

               if(Screen.field_27 == null) {
                  var20 = new class_62((byte)1, 10);
                  Screen.field_27 = var20;
               }

               if(Screen.field_28 == null) {
                  var20 = new class_62((byte)1, 11);
                  Screen.field_28 = var20;
               }

               if(Screen.field_29 == null) {
                  var20 = new class_62((byte)2, 10);
                  Screen.field_29 = var20;
               }

               if(Screen.field_30 == null) {
                  var20 = new class_62((byte)0, 13);
                  Screen.field_30 = var20;
               }

               if(Screen.field_31 == null) {
                  var20 = new class_62((byte)4, 10);
                  Screen.field_31 = var20;
               }

               if(Screen.field_32 == null) {
                  var20 = new class_62((byte)3, 10);
                  Screen.field_32 = var20;
               }

               if(Screen.field_33 == null) {
                  var20 = new class_62((byte)3, 10, true);
                  Screen.field_33 = var20;
               }
            } catch (Exception var15) {
               SocketListener.logMessage("Main2.loadProperties() ERROR " + var15.toString());
            }

            MessagesContainer.getMessage(1);
            GlobalStorage.method_713();
            SocketListener var21 = new SocketListener();
            SocketListener.self = var21;

            try {
               String var2;
               if((var2 = System.getProperty("canvas_drawer_stopped_listener_class")) != null && var2.trim().length() > 0) {
                  try {
                     class_73.field_572 = (CanvasDrawerStoppedListener)Class.forName(var2).newInstance();
                  } catch (ClassNotFoundException var11) {
                     var11.printStackTrace();
                  } catch (IllegalAccessException var12) {
                     var12.printStackTrace();
                  } catch (InstantiationException var13) {
                     var13.printStackTrace();
                  }
               }

               ScreenDrawer var22 = new ScreenDrawer();
               ScreenDrawer.self = var22;
               var22.setScreenId((byte)1);
            } catch (Exception var14) {
               SocketListener.logMessage("Main2: " + var14.toString());
            }
         }

         ScreenDrawer.self.method_320();
         Screen.method_48();
      } catch (Error var17) {
         try {
            var1.destroyApp(false);
         } catch (Exception var10) {
            SocketListener.logMessage("exit des " + var10.toString());
         }

         this.notifyDestroyed();
      }
   }

   // $FF: renamed from: a (java.lang.String, java.lang.String) java.lang.String
   public final String method_861(String var1, String var2) {
      try {
         return (var1 = this.getAppProperty(var1)) != null && var1.length() != 0?var1:var2;
      } catch (Exception var4) {
         return var2;
      }
   }

   // $FF: renamed from: a (java.io.InputStream) byte[]
   public static final byte[] method_862(InputStream var0) throws IOException {
      int var1;
      if((var1 = var0.available()) == 1) {
         var1 = 256;
      }

      byte[] var6 = new byte[var1];
      DataInputStream var2 = new DataInputStream(var0);

      try {
         boolean var3 = false;
         int var4 = 0;
         var3 = false;

         int var7;
         while((var7 = var0.available()) > 0 && (var7 = var2.read(var6, var4, Math.min(var7, var6.length - var4))) > 0) {
            if((var4 += var7) >= var6.length && var0.available() > 0) {
               var6 = method_863(var6, var6.length << 1);
            }
         }

         if(var4 < var6.length) {
            var6 = method_863(var6, var4);
         }
      } catch (IOException var5) {
         SocketListener.logMessage("readBinaryStreamContent () " + var5.toString());
         var6 = null;
      }

      return var6;
   }

   // $FF: renamed from: a (byte[], int) byte[]
   private static final byte[] method_863(byte[] var0, int var1) {
      byte[] var2 = new byte[var1];
      System.arraycopy(var0, 0, var2, 0, Math.min(var0.length, var1));
      return var2;
   }

   // $FF: renamed from: a (java.lang.String[], int) java.lang.String[]
   public static String[] method_864(String[] var0, int var1) {
      String[] var2 = new String[var1];
      System.arraycopy(var0, 0, var2, 0, Math.min(var0.length, var1));
      return var2;
   }

   // $FF: renamed from: a (int[], int) int[]
   public static int[] method_865(int[] var0, int var1) {
      int[] var2 = new int[var1];
      System.arraycopy(var0, 0, var2, 0, Math.min(var0.length, var1));
      return var2;
   }

   // $FF: renamed from: e () void
   public final void clearLoginAndPass() {
      this.login = Hero.self.login = "";
      this.password = "";
   }

   // $FF: renamed from: a (mobak.Main2, boolean) boolean
   static boolean setLoginAndPassAsEmpty(Main2 self, boolean isEmpty) {
      return self.loginAndPassAreEmpty = isEmpty;
   }

   // $FF: renamed from: a (mobak.Main2) java.lang.String
   static String getPassword(Main2 self) {
      return self.password;
   }

   // $FF: renamed from: b (mobak.Main2) java.lang.String
   static String getHomePageUrl(Main2 var0) {
      return method_849();
   }

   // $FF: renamed from: a (mobak.Main2, mobak.g) mobak.g
   static Connection setConnection(Main2 self, Connection connection) {
      return self.connection = connection;
   }

   // $FF: renamed from: f () void
   static void method_871() {
      try {
         if(ScreenDrawer.self.GetScreen() != null) {
            Screen.method_74();
         }

      } catch (Exception var1) {
         SocketListener.method_523(var1);
      }
   }
}
