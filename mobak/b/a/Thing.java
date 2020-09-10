package mobak.b.a;

import javax.microedition.lcdui.Graphics;
import mobak.GlobalStorage;
import mobak.b.b.Screen;
import mobak.b.b.ScreenDrawer;
import mobak.b.b.class_55;
import mobak.b.b.a.MenuScreen;
import mobak.c.class_62;
import mobak.c.RMSManager;

// $FF: renamed from: mobak.b.a.a
public abstract class Thing {

   // $FF: renamed from: a short
   private static short field_574;
   // $FF: renamed from: a boolean
   protected boolean isOnHero;
   // $FF: renamed from: a byte
   protected byte raceId;
   // $FF: renamed from: a int
   protected int field_577;
   // $FF: renamed from: a java.lang.String
   protected String field_578;
   // $FF: renamed from: b int
   protected int field_579;
   // $FF: renamed from: b java.lang.String
   protected String field_580;
   // $FF: renamed from: c int
   protected int imageIndex;
   // $FF: renamed from: d int
   protected int Id;
   // $FF: renamed from: a int[]
   private int[] field_583;
   // $FF: renamed from: a java.lang.String[]
   private String[] field_584;
   // $FF: renamed from: c java.lang.String
   protected String name;
   // $FF: renamed from: d java.lang.String
   private String location;
   // $FF: renamed from: e int
   protected int place;
   // $FF: renamed from: b boolean
   private boolean field_588;


   // $FF: renamed from: <init> () void
   public Thing() {
      super();
      this.place = -1;
      this.field_588 = true;
   }

   // $FF: renamed from: a () boolean
   public final boolean isOnHero() {
      return this.isOnHero;
   }

   // $FF: renamed from: a (boolean) void
   public final void setIsOnHero(boolean var1) {
      this.isOnHero = var1;
   }

   // $FF: renamed from: a () int
   public final int method_737() {
      return this.imageIndex;
   }

   // $FF: renamed from: a (int) void
   public void setImageIndex(int var1) {
      this.imageIndex = var1;
   }

   // $FF: renamed from: b () int
   public final int method_739() {
      return this.field_577;
   }

   // $FF: renamed from: b (int) void
   public final void method_740(int var1) {
      this.field_577 = RMSManager.method_679(var1);
      this.field_578 = String.valueOf(var1);
   }

   // $FF: renamed from: c () int
   public final int getQuantity() {
      return this.field_579;
   }

   // $FF: renamed from: a (int, boolean) void
   public final void method_742(int var1, boolean var2) {
      this.field_579 = var1;
      if(this.field_579 < 0) {
         this.field_579 = 0;
      }

      this.field_580 = String.valueOf(this.field_579);
   }

   // $FF: renamed from: c (int) void
   public final void setQuantity(int var1) {
      this.method_742(var1, true);
   }

   // $FF: renamed from: d (int) void
   public final void method_744(int var1) {
      this.method_745(var1, true, true);
   }

   // $FF: renamed from: a (int, boolean, boolean) void
   public final void method_745(int var1, boolean var2, boolean var3) {
      int var4 = this.field_577;
      if(var1 > 0 && Integer.MAX_VALUE - var1 < this.field_577) {
         var4 = 2147483646;
      } else {
         var4 += var1;
      }

      if(var4 < 0) {
         var4 = 0;
      }

      int var10001 = var4;
      boolean var6 = var3;
      var3 = var2;
      int var5 = var10001;
      if(var3 && var5 > this.field_579) {
         var5 = this.field_579;
      }

      if(var6 && var5 < 0) {
         var5 = 0;
      }

      this.method_740(var5);
   }

   // $FF: renamed from: a () byte
   public final byte getRaceId() {
      return this.raceId;
   }

   // $FF: renamed from: a (byte) void
   public final void setRaceId(byte var1) {
      this.raceId = var1;
   }

   // $FF: renamed from: d () int
   public final int getPlace() {
      return this.place;
   }

   // $FF: renamed from: e () int
   public final int getId() {
      return this.Id;
   }

   // $FF: renamed from: e (int) void
   public final void setId(int id) {
      this.Id = id;
   }

   // $FF: renamed from: a (int[]) void
   public final void method_751(int[] var1) {
      this.field_583 = var1;
      if(var1 != null && var1.length > 0) {
         this.field_584 = new String[var1.length];

         for(byte var2 = 0; var2 < var1.length; ++var2) {
            this.field_584[var2] = String.valueOf(this.field_583[var2]);
         }

      } else {
         this.field_584 = null;
      }
   }

   // $FF: renamed from: a (byte) int
   public final int method_752(byte index) {
      return this.field_583 == null?0:(index >= 0 && index < this.field_583.length?this.field_583[index]:0);
   }

   // $FF: renamed from: a (byte) java.lang.String
   public final String method_753(byte var1) {
      return this.field_584 == null?"":(var1 >= 0 && var1 < this.field_584.length?this.field_584[var1]:"");
   }

   // $FF: renamed from: b () byte
   public abstract byte method_754();

   // $FF: renamed from: a (mobak.b.a.a) boolean
   public abstract boolean method_755(Thing var1);

   // $FF: renamed from: a () short
   public short method_756() {
      return (short)0;
   }

   // $FF: renamed from: a (java.lang.String) void
   public final void setName(String name) {
      this.name = name;
   }

   // $FF: renamed from: a (javax.microedition.lcdui.Graphics, short, short, short) void
   public abstract void method_758(Graphics var1, short var2, short var3, short var4);

   // $FF: renamed from: a (mobak.b.b.q, java.lang.String, short) void
   public abstract void getDescription(class_55 var1, String var2, short var3);

   // $FF: renamed from: c () byte
   public byte getCategory() {
      return (byte)0;
   }

   // $FF: renamed from: d () byte
   public byte isCanUse() {
      return (byte)0;
   }

   // $FF: renamed from: a () java.lang.String
   public final String GetLocation() {
      return this.location;
   }

   // $FF: renamed from: b (java.lang.String) void
   public final void setWhereIsLocated(String var1) {
      this.location = var1;
   }

   // $FF: renamed from: a (javax.microedition.lcdui.Graphics, short, short, java.lang.String) void
   public static final void method_764(Graphics var0, short var1, short var2, String var3) {
      class_62 var4 = Screen.field_25;
      method_766(var0, var1 + 61 - 3, var2 + 53 - 1, var4, var3, 40);
   }

   // $FF: renamed from: b (javax.microedition.lcdui.Graphics, short, short, java.lang.String) void
   public static final void method_765(Graphics var0, short var1, short var2, String var3) {
      class_62 var4 = Screen.field_29;
      method_766(var0, var1 + 30, var2 + 26, var4, var3, 3);
   }

   // $FF: renamed from: a (javax.microedition.lcdui.Graphics, int, int, mobak.c.a, java.lang.String, int) void
   private static final void method_766(Graphics var0, int var1, int var2, class_62 var3, String var4, int var5) {
      int var6 = var3.method_563(var4);
      int var7 = var3.field_500;
      if((var5 & 8) == 8) {
         var1 -= var6;
      } else if((var5 & 1) == 1) {
         var1 -= var6 / 2;
      }

      if((var5 & 32) == 32) {
         var2 -= var7;
      } else if((var5 & 2) == 2) {
         var2 -= var7 / 2;
      }

      ScreenDrawer.method_384(var0, 0);
      var0.fillRect(var1, var2, var6 + 2, var7);
      var3.method_564(var0, var4, var1, var2, 0);
      ScreenDrawer.method_384(var0, 12496896);
      var0.drawLine(var1, var2 - 1, var1 + var6 + 1, var2 - 1);
      var0.drawLine(var1, var2 + var7 - 1, var1 + var6 + 1, var2 + var7 - 1);
      var0.drawLine(var1 - 1, var2, var1 - 1, var2 + var7 - 2);
      var0.drawLine(var1 + var6 + 2, var2, var1 + var6 + 2, var2 + var7 - 2);
   }

   // $FF: renamed from: a (javax.microedition.lcdui.Graphics, short, short, byte) void
   public static final void method_767(Graphics var0, short var1, short var2, byte var3) {
      if(var3 > 0 && var3 <= 5) {
         ++var1;
         var2 = (short)(var2 + 53 - 20);
         ScreenDrawer.method_372(var0, GlobalStorage.getImage(MenuScreen.field_87), 20 * (var3 - 1), 0, 20, 20, 0, var1, var2, 0);
      }
   }

   // $FF: renamed from: a (javax.microedition.lcdui.Graphics, short, short, java.lang.String, boolean) void
   public static final void method_768(Graphics var0, short var1, short var2, String var3, boolean var4) {
      boolean var5 = var4;
      class_62 var6 = Screen.field_32;
      var1 = (short)(var1 + 30);
      var2 = (short)(var2 + 53 + var6.field_500 / 2 + 2);
      if(var5) {
         if(field_574 == 0) {
            field_574 = GlobalStorage.method_711("crystal.png");
         }

         int var7 = var6.method_563(var3);
         ScreenDrawer.method_370(var0, GlobalStorage.getImage(field_574), var1 - ScreenDrawer.method_377(field_574) - var7 / 2, var2 - ScreenDrawer.method_378(field_574) / 2 + 1, 0);
      }

      var6.method_564(var0, var3, var1, var2, 3);
   }

   // $FF: renamed from: c (javax.microedition.lcdui.Graphics, short, short, java.lang.String) void
   public static final void method_769(Graphics var0, short var1, short var2, String var3) {
      class_62 var4 = Screen.field_31;
      var1 = (short)(var1 + 2);
      ScreenDrawer.method_384(var0, 14268500);
      var0.fillRect(var1, var2 + 1, var4.method_563(var3) + 2, var4.field_500 - 1);
      var4.method_564(var0, var3, var1 + 1, var2, 0);
   }

   // $FF: renamed from: a (int, javax.microedition.lcdui.Graphics, short, short) void
   public static final void method_770(int var0, Graphics var1, short var2, short var3) {
      switch(var0) {
      case 1:
         method_764(var1, var2, var3, "7");
         return;
      case 2:
         method_765(var1, var2, var3, "12");
         return;
      case 3:
         method_767(var1, var2, var3, (byte)2);
         return;
      case 4:
         method_768(var1, var2, var3, "142", false);
         return;
      case 5:
         method_769(var1, var2, var3, "3");
         return;
      case 6:
         MenuScreen.method_138(var1, var2, var3, false, true);
         return;
      case 7:
         MenuScreen.method_138(var1, var2, var3, true, false);
      default:
      }
   }

   // $FF: renamed from: a (byte) boolean
   public boolean method_771(byte var1) {
      return true;
   }

   // $FF: renamed from: b () boolean
   public final boolean method_772() {
      return this.field_588;
   }

   // $FF: renamed from: b (boolean) void
   public final void method_773(boolean var1) {
      this.field_588 = false;
   }

   // $FF: renamed from: <clinit> () void
   static {
      field_574 = 0;
   }
}
