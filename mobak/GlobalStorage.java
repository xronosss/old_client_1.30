package mobak;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;
import javax.microedition.lcdui.Image;

import mobak.a.SocketListener;
import mobak.b.a.Hero;
import mobak.b.b.ScreenDrawer;
import mobak.b.b.MapObject;

// $FF: renamed from: mobak.c
public final class GlobalStorage {

   // $FF: renamed from: a javax.microedition.lcdui.Image[]
   private static Image[] field_552;
   // $FF: renamed from: c java.lang.String[]
   private static String[] field_553;
   // $FF: renamed from: a mobak.d[]
   private static class_67[] field_554;
   // $FF: renamed from: a mobak.b.b.i[]
   private static MapObject[] field_555;
   // $FF: renamed from: a javax.microedition.lcdui.Image
   private static Image field_556;
   // $FF: renamed from: a byte[]
   private static byte[] field_557;
   // $FF: renamed from: a java.lang.String[]
   public static final String[] field_558;
   // $FF: renamed from: a int[]
   public static final int[] field_559;
   // $FF: renamed from: b java.lang.String[]
   public static final String[] field_560;
   // $FF: renamed from: b byte[]
   private static byte[] field_561;
   // $FF: renamed from: a int
   public static int gemToGoldValue;
   // $FF: renamed from: b int
   public static int field_563;
   // $FF: renamed from: c int
   public static int ArmyByGemsCost;
   // $FF: renamed from: c byte[]
   private static byte[] field_565;
   // $FF: renamed from: d byte[]
   private static byte[] field_566;
   // $FF: renamed from: b javax.microedition.lcdui.Image[]
   private static Image[] field_567;
   // $FF: renamed from: d java.lang.String[]
   private static final String[] field_568;
   // $FF: renamed from: b javax.microedition.lcdui.Image
   private static Image field_569;


   // $FF: renamed from: a () javax.microedition.lcdui.Image
   public static Image method_680() {
      return field_556;
   }

   // $FF: renamed from: a () int
   public static int method_681() {
      return field_555 == null?0:field_555.length;
   }

   // $FF: renamed from: a (int) mobak.b.b.i
   public static MapObject method_682(int var0) {
      return var0 < 0?null:(field_555 != null && field_555.length > var0?field_555[var0]:null);
   }

   // $FF: renamed from: a (byte, byte) mobak.b.b.i
   public static MapObject method_683(byte var0, byte var1) {
      int var2;
      return (var2 = method_688(var0, var1)) >= 0?field_555[var2]:null;
   }

   // $FF: renamed from: a (byte, byte, boolean) mobak.b.b.i
   public static MapObject method_684(byte var0, byte var1, boolean var2) {
      int var10000;
      label31: {
         var2 = true;
         var1 = var1;
         var0 = var0;
         if(field_555 != null) {
            for(int var3 = 0; var3 < field_555.length; ++var3) {
               if(field_555[var3] != null && field_555[var3].method_418() == var0 && field_555[var3].method_419() == var1 && field_555[var3].method_414() == var2) {
                  var10000 = var3;
                  break label31;
               }
            }
         }

         var10000 = -1;
      }

      int var4 = var10000;
      return var10000 < 0?null:field_555[var4];
   }

   // $FF: renamed from: a (mobak.b.b.i) int
   public static int method_685(MapObject var0) {
      return var0 == null?-1:method_686(var0.method_417(), var0.getType());
   }

   // $FF: renamed from: a (int, byte) int
   public static int method_686(int var0, byte var1) {
      if(field_555 == null) {
         return -1;
      } else {
         for(int var2 = 0; var2 < field_555.length; ++var2) {
            if(field_555[var2] != null && field_555[var2].method_417() == var0 && field_555[var2].getType() == var1 && field_555[var2].method_414()) {
               return var2;
            }
         }

         return -1;
      }
   }

   // $FF: renamed from: b (int, byte) int
   public static int method_687(int var0, byte var1) {
      if(field_555 == null) {
         return -1;
      } else {
         for(int i = 0; i < field_555.length; ++i) {
            if(field_555[i] != null && field_555[i].method_417() == var0 && field_555[i].getType() == var1) {
               return i;
            }
         }

         return -1;
      }
   }

   // $FF: renamed from: a (byte, byte) int
   public static int method_688(byte var0, byte var1) {
      if(field_555 != null && field_555.length != 0) {
         for(int var2 = 0; var2 < field_555.length; ++var2) {
            MapObject var3;
            if((var3 = field_555[var2]) != null && var3.method_418() == var0 && var3.method_419() == var1 && var3.method_414()) {
               return var2;
            }
         }

         return -1;
      } else {
         return -1;
      }
   }

   // $FF: renamed from: b (mobak.b.b.i) int
   public static int method_689(MapObject var0) {
      if(var0 == null) {
         return -1;
      } else {
         if(field_555 == null) {
            field_555 = new MapObject[10];
         }

         int var1 = -1;

         for(int var2 = 0; var2 < field_555.length; ++var2) {
            if(field_555[var2] != null && field_555[var2].method_417() == var0.method_417() && field_555[var2].getType() == var0.getType()) {
               return var2;
            }

            if(field_555[var2] == null && var1 < 0) {
               var1 = var2;
            }
         }

         if(var1 < 0) {
            MapObject[] var3 = new MapObject[field_555.length + 10];
            System.arraycopy(field_555, 0, var3, 0, field_555.length);
            var1 = field_555.length;
            field_555 = var3;
         }

         field_555[var1] = var0;
         return var1;
      }
   }

   // $FF: renamed from: a (int) void
   private static void method_690(int var0) {
      if(field_555 != null && field_555.length != 0) {
         if(var0 >= 0 && var0 < field_555.length && field_555[var0] != null) {
            method_706(field_555[var0]);
            field_555[var0] = null;
         }
      }
   }

   // $FF: renamed from: a (int, byte) void
   public static void method_691(int var0, byte var1) {
      if(field_555 != null) {
         int var2 = -1;

         for(int var3 = 0; var3 < field_555.length; ++var3) {
            if(field_555[var3] != null && field_555[var3].method_417() == var0 && field_555[var3].getType() == var1) {
               var2 = var3;
               break;
            }
         }

         method_690(var2);
      }
   }

   // $FF: renamed from: a () void
   public static final void method_692() {
      if(field_555 != null && field_555.length != 0) {
         for(short var0 = 0; var0 < field_555.length; ++var0) {
            MapObject var1 = field_555[var0];
            if(field_555 != null && var1 != null) {
               int var2 = -1;

               for(int var3 = 0; var3 < field_555.length; ++var3) {
                  if(field_555[var3] == var1) {
                     var2 = var3;
                     break;
                  }
               }

               method_690(var2);
            }
         }

      }
   }

   // $FF: renamed from: a (mobak.b.b.i, byte, byte) mobak.b.b.i
   private static MapObject method_693(MapObject var0, byte var1, byte var2) {
      if(var0 == null) {
         return null;
      } else if(field_555 == null) {
         return null;
      } else {
         class_67 var3 = method_714(var0.getType());

         for(int var4 = 0; var4 < field_555.length; ++var4) {
            class_67 var5;
            if(field_555[var4] != null && field_555[var4] != var0 && field_555[var4].method_414() && (var5 = method_714(field_555[var4].getType())) != null) {
               for(byte var6 = 0; var6 < var3.field_540; ++var6) {
                  for(byte var7 = 0; var7 < var5.field_540; ++var7) {
                     if(var1 + var3.field_541[var6][0] == field_555[var4].method_418() + var5.field_541[var7][0] && var2 + var3.field_541[var6][1] == field_555[var4].method_419() + var5.field_541[var7][1]) {
                        return field_555[var4];
                     }
                  }
               }
            }
         }

         return null;
      }
   }

   // $FF: renamed from: a (mobak.b.b.i, byte, byte) boolean
   private static boolean method_694(MapObject var0, byte var1, byte var2) {
      if(var0 == null) {
         return false;
      } else if(!method_698()) {
         return true;
      } else {
         class_67 var6 = method_714(var0.getType());

         for(byte var3 = 0; var3 < var6.field_540; ++var3) {
            byte var4;
            if((byte)(((var4 = method_702((byte)(var1 + var6.field_541[var3][0]), (byte)(var2 + var6.field_541[var3][1]))) & 112) >> 4) > 0 || method_708(var4)) {
               return true;
            }
         }

         return false;
      }
   }

   // $FF: renamed from: b (mobak.b.b.i, byte, byte) boolean
   private static boolean method_695(MapObject var0, byte var1, byte var2) {
      if(var0 == null) {
         return false;
      } else if(Hero.self != null && !var0.method_431()) {
         class_67 var4 = method_714(var0.getType());

         for(byte var3 = 0; var3 < var4.field_540; ++var3) {
            if(var1 + var4.field_541[var3][0] == Hero.self.getPositionX() && var2 + var4.field_541[var3][1] == Hero.self.getPositionY()) {
               return true;
            }
         }

         return false;
      } else {
         return false;
      }
   }

   // $FF: renamed from: a (byte[]) boolean
   public static synchronized boolean createMap(byte[] var0) {
      if(var0 != null && var0.length == 2500) {
         Random var1 = new Random();
         int var2 = 0;
         int var3 = 0;

         for(int var4 = 0; var4 < 450; ++var4) {
            field_565[var4] = -1;
         }

         for(byte var12 = 0; var12 < 50; ++var12) {
            for(byte var5 = 0; var5 < 50; ++var5) {
               byte var6;
               int var7;
               if((var6 = (byte)(var0[var12 * 50 + var5] & 15)) != 0 && var6 != 6 && var6 != 7 && (var7 = var1.nextInt(var0.length)) < 300) {
                  boolean var8 = var5 > 0 && (var0[var12 * 50 + var5 - 1] & 15) == var6;
                  boolean var9 = var5 < 49 && (var0[var12 * 50 + var5 + 1] & 15) == var6;
                  boolean var10 = var12 > 0 && (var0[(var12 - 1) * 50 + var5] & 15) == var6;
                  boolean var11 = var12 < 49 && (var0[(var12 + 1) * 50 + var5] & 15) == var6;
                  if(var8 && var9 && var10 && var11) {
                     if(var2 < 150 && var7 < 150 && var6 != 8) {
                        var7 = var2 * 3;
                        field_565[var7] = var5;
                        field_565[var7 + 1] = var12;
                        byte var17 = 3;
                        if((var0[var12 * 50 + var5] & 15) == 1) {
                           var17 = 1;
                        }

                        if((var0[var12 * 50 + var5] & 15) == 3) {
                           var17 = 4;
                        }

                        field_565[var7 + 2] = (byte)var1.nextInt(var17);
                        ++var2;
                     } else if(var6 == 8 && var3 < 300) {
                        var7 = var3 * 5;
                        field_566[var7] = var5;
                        field_566[var7 + 1] = var12;
                        String var15 = null;
                        switch(var6) {
                        case 8:
                           var15 = "animDecorLava.png";
                        default:
                           Image var13;
                           int var16 = ScreenDrawer.method_382(var13 = method_712("/mobak/res/" + var15)) / 50;
                           int var14 = ScreenDrawer.method_383(var13) / 50;
                           field_566[var7 + 2] = (byte)var1.nextInt(var14);
                           field_566[var7 + 3] = (byte)(var1.nextInt(30 - var16 - 2) + 2 + var16);
                           field_566[var7 + 4] = (byte)(var1.nextInt(field_566[var7 + 3] - 1) + 1);
                           ++var3;
                        }
                     }
                  }
               }
            }
         }

         while(var2 < 150) {
            field_565[var2 * 3] = -1;
            ++var2;
         }

         while(var3 < 300) {
            field_566[var3 * 5] = -1;
            ++var3;
         }

         field_557 = var0;
         return true;
      } else {
         return false;
      }
   }

   // $FF: renamed from: a (int, int) byte
   public static byte method_697(int var0, int var1) {
      if(field_557 == null) {
         return (byte)-1;
      } else {
         byte var2;
         int var3;
         if((var2 = (byte)(field_557[var1 * 50 + var0] & 15)) != 6 && var2 != 7 && var2 != 0 && var2 != 8) {
            for(var3 = 0; var3 < 150 && field_565[var3 * 3] != -1 && field_565[var3 * 3 + 1] <= var1 && (field_565[var3 * 3] <= var0 || field_565[var3 * 3 + 1] != var1); ++var3) {
               if(field_565[var3 * 3] == var0 && field_565[var3 * 3 + 1] == var1) {
                  return field_565[var3 * 3 + 2];
               }
            }
         }

         for(var3 = 0; var3 < 300 && field_566[var3 * 5] != -1 && field_566[var3 * 5 + 1] <= var1 && (field_566[var3 * 5] <= var0 || field_566[var3 * 5 + 1] != var1); ++var3) {
            if(field_566[var3 * 5] == var0 && field_566[var3 * 5 + 1] == var1) {
               field_566[var3 * 5 + 4] = (byte)((field_566[var3 * 5 + 4] + 1) % field_566[var3 * 5 + 3]);
               return (byte)(field_566[var3 * 5 + 4] | field_566[var3 * 5 + 2] << 6);
            }
         }

         return (byte)-1;
      }
   }

   // $FF: renamed from: a () boolean
   public static boolean method_698() {
      return field_557 != null;
   }

   // $FF: renamed from: b () void
   public static synchronized void method_699() {
      field_557 = null;
      field_555 = null;
   }

   // $FF: renamed from: b () int
   public static int getMapDataSize() {
      return 2500;
   }

   // $FF: renamed from: a (short, short) boolean
   public static boolean method_701(short var0, short var1) {
      return var0 >= 0 && var0 < 50?var1 >= 0 && var1 < 50:false;
   }

   // $FF: renamed from: a (short, short) byte
   public static byte method_702(short var0, short var1) {
      return method_698() && method_701(var0, var1)?field_557[var1 * 50 + var0]:0;
   }

   // $FF: renamed from: a (int) byte
   public static byte method_703(int var0) {
      return field_557 != null && var0 >= 0 && var0 < field_557.length?field_557[var0]:0;
   }

   // $FF: renamed from: a (byte, byte, byte) void
   private static void method_704(byte var0, byte var1, byte var2) {
      if(method_698() && method_701((short)var0, (short)var1)) {
         field_557[var1 * 50 + var0] = var2;
      }
   }

   // $FF: renamed from: a (byte, byte) void
   public static void method_705(byte var0, byte var1) {
      if(method_698() && method_701((short)var0, (short)var1)) {
         method_704(var0, var1, (byte)(method_702((short)var0, (short)var1) & -65));
      }
   }

   // $FF: renamed from: a (mobak.b.b.i) void
   public static void method_706(MapObject var0) {
      if(var0 != null) {
         class_67 var1;
         if((var1 = method_714(var0.getType())) != null && var1.field_540 > 0) {
            for(byte var2 = 0; var2 < var1.field_540; ++var2) {
               method_705((byte)(var0.method_418() + var1.field_541[var2][0]), (byte)(var0.method_419() + var1.field_541[var2][1]));
            }
         }

      }
   }

   // $FF: renamed from: b (mobak.b.b.i) void
   public static void method_707(MapObject var0) {
      if(var0 != null) {
         class_67 var1;
         if((var1 = method_714(var0.getType())) != null && var1.field_540 > 0) {
            for(byte var2 = 0; var2 < var1.field_540; ++var2) {
               byte var10000 = (byte)(var0.method_418() + var1.field_541[var2][0]);
               byte var4 = (byte)(var0.method_419() + var1.field_541[var2][1]);
               byte var3 = var10000;
               if(method_698() && method_701((short)var3, (short)var4)) {
                  method_704(var3, var4, (byte)(method_702((short)var3, (short)var4) | 64));
               }
            }
         }

      }
   }

   // $FF: renamed from: a (byte) boolean
   public static boolean method_708(byte var0) {
      return (byte)(var0 & 15) == 0;
   }

   // $FF: renamed from: b (byte) boolean
   public static boolean method_709(byte var0) {
      byte var1;
      return (var1 = method_720(var0)) != 8 && var1 != 6 && var1 != 10 && var1 != 1 && var1 != 7 && (var0 & 64) != 64;
   }

   // $FF: renamed from: a (byte, byte) boolean
   private static boolean method_710(byte var0, byte var1) {
      return method_698() && method_701((short)var0, (short)var1)?method_709(method_702((short)var0, (short)var1)):false;
   }

   // $FF: renamed from: a (java.lang.String) short
   public static short method_711(String fileName) {
      if(fileName == null) {
         return (short)-1;
      } else {
         if(field_552 == null) {
            field_552 = new Image[5];
            field_553 = new String[5];
         }

         synchronized(Main2.self) {
            short var2;
            for(var2 = 0; var2 < field_553.length && field_553[var2] != null; ++var2) {
               if(field_553[var2].equals(fileName) && field_552[var2] != field_556) {
                  return var2;
               }
            }

            if(var2 >= field_553.length) {
               var2 = (short)field_552.length;
               Image[] var3 = new Image[field_552.length + 5];
               System.arraycopy(field_552, 0, var3, 0, field_552.length);
               field_552 = var3;
               String[] var5 = new String[field_553.length + 5];
               System.arraycopy(field_553, 0, var5, 0, field_553.length);
               field_553 = var5;
            }

            if(Main2.self.rmsManager.getRecordId(fileName) >= 0) {
               field_552[var2] = ScreenDrawer.load(Main2.self.rmsManager.getFile(fileName));
            } else {
               field_552[var2] = method_712("/mobak/res/" + fileName);
            }

            if(field_552[var2] == null) {
               field_552[var2] = field_556;
            }

            field_553[var2] = fileName;
            return var2;
         }
      }
   }

   // $FF: renamed from: a (java.lang.String) javax.microedition.lcdui.Image
   public static Image method_712(String var0) {
      try {
         return Image.createImage(var0);
      } catch (Exception var1) {
         return field_556;
      }
   }

   // $FF: renamed from: c () void
   public static void method_713() {
      InputStream var0;
      if((var0 = Main2.self.getClass().getResourceAsStream("/mobak/res/image_size.bin")) != null) {
         try {
            byte[] var1 = Main2.method_862(var0);
            var0.close();
            if(var1 != null && var1.length != 0) {
               byte var8;
               field_554 = new class_67[var8 = var1[0]];
               int var2 = 1;

               for(byte var3 = 0; var3 < var8; ++var3) {
                  class_67 var10000 = new class_67();
                  class_67 var4 = var10000;
                  var10000.field_536 = var1[var2++];
                  var4.field_537 = var1[var2++];
                  var4.field_538 = var1[var2++];
                  var4.field_539 = var1[var2++];
                  var4.field_540 = var1[var2++];
                  byte var5;
                  if(var4.field_540 > 0) {
                     var4.field_541 = new byte[var4.field_540][2];
                     var5 = 0;

                     for(byte var6 = 0; var6 < var4.field_540; ++var6) {
                        var4.field_541[var5][0] = var1[var2++];
                        var4.field_541[var5][1] = var1[var2++];
                        ++var5;
                     }
                  }

                  if((var5 = var1[var2++]) > 0) {
                     var4.field_542 = new byte[var5];

                     for(int var9 = 0; var9 < var5; ++var9) {
                        var4.field_542[var9] = var1[var2++];
                     }
                  }

                  field_554[var3] = var4;
               }

            }
         } catch (Exception var7) {
            SocketListener.logMessage(var7.getMessage());
         }
      }
   }

   // $FF: renamed from: a (byte) mobak.d
   public static class_67 method_714(byte var0) {
      if(field_554 != null && field_554.length != 0) {
         for(byte var1 = 0; var1 < field_554.length; ++var1) {
            if(field_554[var1] != null && field_554[var1].field_536 == var0) {
               return field_554[var1];
            }
         }

         return null;
      } else {
         return null;
      }
   }

   // $FF: renamed from: d () void
   public static void method_715() {
      if(field_552 != null) {
         for(int var0 = 0; var0 < field_552.length; ++var0) {
            field_552[var0] = null;
         }
      }

   }

   // $FF: renamed from: a (short) javax.microedition.lcdui.Image
   public static Image getImage(short var0) {
      try {
         if(field_552 == null) {
            return null;
         } else if(var0 >= 0 && var0 < field_552.length) {
            if(field_552[var0] == null || field_552[var0] == field_556) {
               if(Main2.self.rmsManager.getRecordId(field_553[var0]) < 0) {
                  field_552[var0] = method_712("/mobak/res/" + field_553[var0]);
               } else {
                  Image var2;
                  if((var2 = ScreenDrawer.load(Main2.self.rmsManager.getFile(field_553[var0]))) != null) {
                     field_552[var0] = var2;
                  }
               }
            }

            return field_552[var0];
         } else {
            return null;
         }
      } catch (Exception var3) {
         SocketListener.logMessage("getImage (" + var0 + ") " + var3);
         return null;
      }
   }

   // $FF: renamed from: a () java.lang.String
   public static String method_717() {
      return "length: " + String.valueOf(field_552.length);
   }

   // $FF: renamed from: a (byte, int) byte
   public static final byte method_718(byte var0, int var1) {
      if(field_561 == null) {
         try {
            InputStream var2;
            if((var2 = Main2.self.getClass().getResourceAsStream("/mobak/res/units_margin.bin")) == null) {
               field_561 = new byte[0];
               return (byte)30;
            }

            field_561 = Main2.method_862(var2);
            var2.close();
         } catch (IOException var3) {
            SocketListener.method_523(var3);
         }
      }

      int var4;
      return (var4 = (var0 - 1) * 5 + var1) >= field_561.length?30:field_561[var4];
   }

   // $FF: renamed from: a (mobak.b.b.i, boolean) void
   public static void method_719(MapObject var0, boolean var1) {
      if(var0 != null) {
         byte var2 = var0.method_418();
         byte var3 = var0.method_419();
         byte var4 = 1;

         while(method_693(var0, var2, var3) != null || method_694(var0, var2, var3) || method_695(var0, var2, var3) || var1 && !method_710(var2, var3)) {
            for(byte var5 = (byte)(var2 - var4); var5 <= var2 + var4; ++var5) {
               if(var5 >= 0 && var5 < 50) {
                  for(byte var6 = (byte)(var3 - var4); var6 <= var3 + var4; ++var6) {
                     if(var6 >= 0 && var6 < 50 && method_693(var0, var5, var6) == null && !method_694(var0, var5, var6) && !method_695(var0, var5, var6) && (!var1 || method_710(var5, var6))) {
                        var0.method_411(var5, var6, false);
                        return;
                     }
                  }
               }
            }

            if(++var4 > 20) {
               break;
            }
         }

      }
   }

   // $FF: renamed from: a (byte) byte
   public static final byte method_720(byte var0) {
      return (var0 = (byte)(var0 & 15)) == 0?10:var0;
   }

   // $FF: renamed from: b (byte) byte
   public static final byte method_721(byte var0) {
      byte var1;
      switch(var0 = (byte)(var0 & 15)) {
      case 0:
         var1 = 10;
         break;
      case 1:
         var1 = 1;
         break;
      case 2:
         var1 = 3;
         break;
      case 3:
         var1 = 4;
         break;
      case 4:
         var1 = 5;
         break;
      case 5:
         var1 = 6;
         break;
      case 6:
         var1 = 8;
         break;
      case 7:
         var1 = 9;
         break;
      case 8:
         var1 = 2;
         break;
      case 9:
         var1 = 7;
         break;
      default:
         var1 = 10;
      }

      return var1;
   }

   // $FF: renamed from: c (byte) boolean
   public static final boolean method_722(byte var0) {
      return (var0 & -128) == -128;
   }

   // $FF: renamed from: a (byte, byte, byte) byte
   private static final byte method_723(byte var0, byte var1, byte var2) {
      byte var3 = -1;
      switch(var0) {
      case 2:
         switch(var1) {
         case 1:
            var3 = 0;
            return var3;
         case 8:
            var3 = 14;
            return var3;
         default:
            return var3;
         }
      case 3:
         switch(var1) {
         case 1:
            var3 = 1;
            return var3;
         case 2:
            var3 = 4;
            return var3;
         default:
            return var3;
         }
      case 4:
         switch(var1) {
         case 1:
            var3 = 2;
            return var3;
         case 2:
            var3 = 5;
            return var3;
         default:
            return var3;
         }
      case 5:
         switch(var1) {
         case 1:
            var3 = 3;
            return var3;
         case 2:
            var3 = 6;
            return var3;
         case 3:
            var3 = 7;
            return var3;
         default:
            return var3;
         }
      case 6:
         switch(var2) {
         case 4:
         case 5:
         case 7:
            var3 = 10;
            return var3;
         case 6:
         default:
            var3 = 9;
            return var3;
         }
      case 7:
         switch(var1) {
         case 6:
            var3 = 8;
            break;
         default:
            switch(var2) {
            case 4:
            case 6:
            case 7:
               var3 = 12;
               break;
            case 5:
            default:
               var3 = 11;
            }
         }
      case 8:
      default:
         break;
      case 9:
         switch(var1) {
         case 2:
            var3 = 15;
            return var3;
         case 8:
            var3 = 16;
            return var3;
         default:
            return var3;
         }
      case 10:
         var3 = 13;
      }

      return var3;
   }

   // $FF: renamed from: a (byte, byte, byte) javax.microedition.lcdui.Image
   public static Image method_724(byte var0, byte var1, byte var2) {
      byte var3;
      if((var3 = method_723(var0, var1, var2)) >= 0 && var3 < field_567.length) {
         if(field_567[var3] == null) {
            field_567[var3] = method_712("/mobak/res/" + ((var0 = method_723(var0, var1, var2)) >= 0 && var0 < field_568.length?field_568[var0]:""));
         }

         return field_567[var3];
      } else {
         return null;
      }
   }

   // $FF: renamed from: b () javax.microedition.lcdui.Image
   public static final Image method_725() {
      if(field_569 == null) {
         field_569 = method_712("/mobak/res/tail.png");
      }

      return field_569;
   }

   // $FF: renamed from: a (int) java.lang.String
   public static String method_726(int var0) {
      return var0 >= 0 && var0 < field_553.length?field_553[var0]:"ERROR GlobalStorage.get_image_files()";
   }

   // $FF: renamed from: <clinit> () void
   static{
      field_555 = null;
      field_556 = method_712("/mobak/res/unknown.png");
      field_557 = null;
      field_558 = new String[]{"item-1.png", "item-2.png", "item-3.png"};
      field_559 = new int[]{15, 15, 15};
      field_560 = new String[]{"modal_window_part1.png", "modal_window_part2.png", "modal_window_part3.png", "modal_window_part4.png", "modal_window_part5.png", "modal_window_part6.png", "modal_window_part7.png", "modal_window_part8.png", "modal_window_part9.png", "modal_window_part10.png", "modal_window_part11.png", "modal_window_part12.png", "modal_window_part13.png"};
      gemToGoldValue = 10000;
      field_563 = 2;
      ArmyByGemsCost = 1;
      field_565 = new byte[450];
      field_566 = new byte[1500];
      field_567 = new Image[17];
      field_568 = new String[]{"2-1.png", "3-1.png", "4-1.png", "5-1.png", "3-2.png", "4-2.png", "5-2.png", "5-3.png", "7-6.png", "6.png", "6_1-2-3.png", "7.png", "7_1-3-4.png", "0.png", "2-8.png", "9-2.png", "9-8.png"};
   }
}
