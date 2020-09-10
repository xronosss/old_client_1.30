package mobak.b.a;

import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import mobak.a.SocketListener;
import mobak.a.a.OutputGameMessage;
import mobak.a.a.MessageProcessor;
import mobak.b.b.Screen;
import mobak.b.b.StrategicScreen;
import mobak.b.b.ScreenDrawer;
import mobak.b.b.MapObject;
import mobak.b.b.a.Button;

// $FF: renamed from: mobak.b.a.b
public final class Hero {

   // $FF: renamed from: a mobak.b.a.b
   public static Hero self;
   // $FF: renamed from: a java.lang.String
   public String field_670;
   // $FF: renamed from: a mobak.b.a.f[]
   private Unit[] field_671;
   // $FF: renamed from: e int
   private int field_672;
   // $FF: renamed from: a boolean
   public boolean field_673;
   // $FF: renamed from: a mobak.b.a.e[]
   private Item[] bag;
   // $FF: renamed from: f int
   private int field_675;
   // $FF: renamed from: a int
   public int heroId;
   // $FF: renamed from: b java.lang.String
   public String login;
   // $FF: renamed from: b byte
   private byte field_678;
   // $FF: renamed from: c byte
   private byte field_679;
   // $FF: renamed from: d byte
   private byte field_680;
   // $FF: renamed from: g int
   private int field_681;
   // $FF: renamed from: h int
   private int field_682;
   // $FF: renamed from: i int
   private int field_683;
   // $FF: renamed from: b int
   public int field_684;
   // $FF: renamed from: c int
   public int field_685;
   // $FF: renamed from: j int
   private int field_686;
   // $FF: renamed from: c boolean
   private boolean field_687;
   // $FF: renamed from: d int
   public int field_688;
   // $FF: renamed from: k int
   private int field_689;
   // $FF: renamed from: a short
   private short field_690;
   // $FF: renamed from: c java.lang.String
   private String field_691;
   // $FF: renamed from: a mobak.b.a.d[]
   public Characteristic[] characteristics;
   // $FF: renamed from: c mobak.b.a.d[]
   private Characteristic[] field_693;
   // $FF: renamed from: b mobak.b.a.d[]
   public Characteristic[] skills;
   // $FF: renamed from: d mobak.b.a.d[]
   private Characteristic[] field_695;
   // $FF: renamed from: a short[][]
   private static short[][] addedStats;
   // $FF: renamed from: a byte
   public byte race;
   // $FF: renamed from: a long
   private long field_698;
   // $FF: renamed from: l int
   private int field_699;
   // $FF: renamed from: d java.lang.String
   private String field_700;
   // $FF: renamed from: e java.lang.String
   private String field_701;
   // $FF: renamed from: b boolean
   public boolean field_702;
   // $FF: renamed from: a java.util.Vector
   private Vector field_703;
   // $FF: renamed from: b java.util.Vector
   private Vector field_704;
   // $FF: renamed from: c java.util.Vector
   private Vector field_705;
   // $FF: renamed from: d java.util.Vector
   private Vector field_706;
   // $FF: renamed from: e java.util.Vector
   private Vector field_707;
   // $FF: renamed from: a mobak.b.a.e[][]
   private Item[][] equipment;
   // $FF: renamed from: a java.lang.String[]
   private String[] field_709;
   // $FF: renamed from: a mobak.b.b.a.v[]
   private Button[] field_710;


   // $FF: renamed from: a (mobak.b.a.e[]) void
   public final void addItemsToBag(Item[] var1) {
      this.field_703 = new Vector();
      this.field_704 = new Vector();
      this.field_705 = new Vector();
      this.field_706 = new Vector();
      this.field_707 = new Vector();
      if(var1 != null) {
         this.bag = var1;
      } else {
         this.bag = new Item[30];
      }

      if(var1 != null) {
         for(short var2 = 0; var2 < var1.length; ++var2) {
            if(var1[var2] != null) {
               var1[var2].getCategory();
               var1[var2].getCategory();
               var1[var2].getCategory();
               var1[var2].getCategory();
               var1[var2].getCategory();
               var1[var2].getCategory();
               var1[var2].getCategory();
            }
         }

         this.method_875(this.field_703, (byte)1);
         this.method_875(this.field_704, (byte)4);
         this.method_875(this.field_705, (byte)2);
         this.method_875(this.field_706, (byte)8);
         this.method_875(this.field_707, (byte)16);
      }
   }

   // $FF: renamed from: a (java.util.Vector, byte) void
   private void method_875(Vector var1, byte var2) {
      if(var1 != null) {
         for(int var3 = 0; var3 < this.bag.length; ++var3) {
            if(this.bag[var3] != null && (this.bag[var3].method_783() & var2) != 0) {
               var1.addElement(this.bag[var3]);
            }
         }

      }
   }

   // $FF: renamed from: <init> (boolean) void
   public Hero(boolean var1) {
      super();
      this.field_671 = new Unit[5];
      this.field_673 = false;
      this.field_675 = 0;
      this.field_681 = 0;
      this.field_684 = 0;
      this.field_685 = 0;
      this.field_686 = 0;
      this.field_687 = false;
      this.field_688 = 0;
      this.field_690 = 1;
      this.field_698 = 0L;
      this.field_699 = 0;
      this.field_702 = false;
      this.field_703 = null;
      this.field_704 = null;
      this.field_705 = null;
      this.field_706 = null;
      this.field_707 = null;
      this.equipment = null;
      if(var1) {
         self = this;
         this.field_679 = 1;
         this.field_680 = 1;
         this.equipment = new Item[6][0];
         this.equipment[0] = new Item[2];
         this.equipment[1] = new Item[1];
         this.equipment[2] = new Item[1];
         this.equipment[3] = new Item[1];
         this.equipment[4] = new Item[1];
         this.equipment[5] = new Item[4];
         this.bag = new Item[30];
         new Vector();
      }

   }

   // $FF: renamed from: a (short) void
   public final void setHeroImageId(short var1) {
      this.field_678 = (byte)var1;
   }

   // $FF: renamed from: a (byte) mobak.b.a.f
   public final synchronized Unit method_878(byte var1) {
      return var1 >= 0 && var1 <= 4?this.field_671[var1]:null;
   }

   // $FF: renamed from: a (byte, mobak.b.a.f) void
   public final synchronized void setUnit(byte armySlotId, Unit unit) {
      if(armySlotId >= 0 && armySlotId <= 4) {
         this.field_671[armySlotId] = unit;
      }

   }

   // $FF: renamed from: a () mobak.b.a.f[]
   public final Unit[] method_880() {
      return this.field_671;
   }

   // $FF: renamed from: a () boolean
   public final boolean method_881() {
      for(byte var1 = 0; var1 < 5; ++var1) {
         if(this.field_671[var1] != null) {
            return true;
         }
      }

      return false;
   }

   // $FF: renamed from: a (byte) mobak.b.a.e[]
   public final Item[] method_882(byte var1) {
      switch(var1) {
      case -1:
         return this.bag;
      default:
         Vector var10000;
         switch(var1) {
         case 1:
            var10000 = this.field_703;
            break;
         case 2:
            var10000 = this.field_705;
            break;
         case 4:
            var10000 = this.field_704;
            break;
         case 8:
            var10000 = this.field_706;
            break;
         case 16:
            var10000 = this.field_707;
            break;
         default:
            var10000 = null;
         }

         Vector var4 = var10000;
         if(var10000 == null) {
            return null;
         } else {
            Item[] var2 = new Item[var4.size()];

            for(short var3 = 0; var3 < var2.length; ++var3) {
               var2[var3] = (Item)var4.elementAt(var3);
            }

            return var2;
         }
      }
   }

   // $FF: renamed from: a (javax.microedition.lcdui.Graphics) boolean
   public final boolean method_883(Graphics var1) {
      Image var2 = MapObject.method_403(this.field_678);
      byte var3 = 12;
      byte var4 = this.field_678;
      if(this.field_678 >= 12) {
         var4 = (byte)(var4 - 12);
         var3 = 10;
      }

      short var8 = (short)(ScreenDrawer.method_382(var2) / var3);
      short var5 = (short) ScreenDrawer.method_383(var2);
      short var6 = (short)(50 * this.field_679);
      short var7 = (short)(50 * this.field_680);
      if(this.field_686 > 0) {
         this.field_684 += (var6 - this.field_684) / this.field_686;
         this.field_685 += (var7 - this.field_685) / this.field_686;
      } else {
         this.field_684 = var6;
         this.field_685 = var7;
      }

      this.field_682 = this.field_684 - StrategicScreen.method_123();
      this.field_683 = this.field_685 - StrategicScreen.method_124() - 25;
      ScreenDrawer.method_372(var1, var2, var8 * var4, 0, var8, var5, 0, this.field_682, this.field_683, 0);
      --this.field_686;
      return false;
   }

   // $FF: renamed from: a (byte, byte) void
   public final void setCoords(byte var1, byte var2) {
      this.field_679 = var1;
      this.field_680 = var2;
   }

   // $FF: renamed from: a () byte
   public final byte getPositionX() {
      return this.field_679;
   }

   // $FF: renamed from: b () byte
   public final byte getPositionY() {
      return this.field_680;
   }

   // $FF: renamed from: a (boolean) void
   public final void method_887(boolean var1) {
      this.field_687 = var1;
   }

   // $FF: renamed from: b () boolean
   public final boolean method_888() {
      return this.field_687;
   }

   // $FF: renamed from: b (byte) mobak.b.a.e[]
   public final Item[] method_889(byte var1) {
      int var2 = 0;

      for(int var3 = 0; var3 < this.bag.length; ++var3) {
         if(this.bag[var3] != null && this.bag[var3].getCategory() == var1) {
            ++var2;
         }
      }

      Item[] var5 = new Item[var2];
      var2 = 0;

      for(int var4 = 0; var4 < this.bag.length; ++var4) {
         if(this.bag[var4] != null && this.bag[var4].getCategory() == var1) {
            var5[var2++] = this.bag[var4];
         }
      }

      return var5;
   }

   public final String toString() {
      StringBuffer var1;
      (var1 = new StringBuffer()).append("name: ").append(this.field_670).append("\n");
      var1.append("level ").append(this.field_690).append("\n");
      var1.append("expr ").append(this.field_689).append("\n");
      return var1.toString();
   }

   // $FF: renamed from: a () java.lang.String
   public final String method_890() {
      return this.field_670;
   }

   // $FF: renamed from: a (java.lang.String) void
   public final void setHeroName(String var1) {
      this.field_670 = var1;
   }

   // $FF: renamed from: a (mobak.b.a.d[], mobak.b.a.d[]) void
   public final void method_892(Characteristic[] var1, Characteristic[] var2) {
      this.field_693 = var1;
      this.field_695 = var2;
   }

   // $FF: renamed from: a (mobak.b.a.d[], byte, int) int
   public final int method_893(Characteristic[] var1, byte var2, int var3) {
      if(var1 == null) {
         return 0;
      } else {
         byte var4;
         if(var1 == this.characteristics) {
            if(this.field_693 != null) {
               for(var4 = 0; var4 < this.field_693.length; ++var4) {
                  if(this.field_693[var4] != null && this.field_693[var4].index == var2) {
                     return this.field_693[var4].value;
                  }
               }
            }
         } else if(var1 == this.skills && this.field_695 != null) {
            for(var4 = 0; var4 < this.field_695.length; ++var4) {
               if(this.field_695[var4] != null && this.field_695[var4].index == var2) {
                  return this.field_695[var4].value;
               }
            }
         }

         for(var4 = 0; var4 < var1.length; ++var4) {
            if(var1[var4] != null && var1[var4].index == var2) {
               return var1[var4].value + getAddedCharacteristicsValue((short)var2);
            }
         }

         return 0;
      }
   }

   // $FF: renamed from: a (mobak.b.a.d[], byte) mobak.b.a.d
   public static Characteristic method_894(Characteristic[] var0, byte var1) {
      if(var0 == null) {
         return null;
      } else {
         for(byte var2 = 0; var2 < var0.length; ++var2) {
            if(var0[var2] != null && var0[var2].index == var1) {
               return var0[var2];
            }
         }

         return null;
      }
   }

   // $FF: renamed from: a (int) void
   public final void method_895(int var1) {
      if(this.bag != null && this.bag.length != 0) {
         for(byte var2 = 0; var2 < this.bag.length; ++var2) {
            if(this.bag[var2] != null && this.bag[var2].Id == var1) {
               this.bag[var2] = null;
               return;
            }
         }

      }
   }

   // $FF: renamed from: a (boolean) long
   public final long method_896(boolean var1) {
      return !var1?this.field_698:(long)this.field_699;
   }

   // $FF: renamed from: a () int
   public final int method_897() {
      return this.field_699;
   }

   // $FF: renamed from: a (long) void
   public final void setGoldValue(long var1) {
      this.field_698 = var1;
      StringBuffer var4;
      int var2 = (var4 = new StringBuffer(String.valueOf(var1))).length() / 3;
      if(var4.length() % 3 == 0) {
         --var2;
      }

      for(int var3 = 0; var3 < var2; ++var3) {
         var4.insert(var4.length() - (var3 + 1) * 3 - var3, '\'');
      }

      this.field_700 = var4.toString();
   }

   // $FF: renamed from: b (int) void
   public final void setGemsValue(int var1) {
      this.field_699 = var1;
      this.field_701 = String.valueOf(var1);
   }

   // $FF: renamed from: b () java.lang.String
   public final String method_900() {
      return this.field_700;
   }

   // $FF: renamed from: c () java.lang.String
   public final String method_901() {
      return this.field_701;
   }

   // $FF: renamed from: b () int
   public final int method_902() {
      return this.field_689;
   }

   // $FF: renamed from: c (int) void
   public final void setExp(int var1) {
      this.field_689 = var1;
   }

   // $FF: renamed from: b (short) void
   public final void setLvl(short var1) {
      this.field_690 = var1;
      this.field_691 = String.valueOf(var1);
   }

   // $FF: renamed from: d () java.lang.String
   public final String method_905() {
      return this.field_691;
   }

   // $FF: renamed from: c () int
   public final int method_906() {
      return this.field_690;
   }

   // $FF: renamed from: d (int) void
   public final void method_907(int var1) {
      this.field_672 = var1;
   }

   // $FF: renamed from: e (int) void
   public final void method_908(int var1) {
      this.field_672 += -1;
   }

   // $FF: renamed from: d () int
   public final int method_909() {
      return this.field_672;
   }

   // $FF: renamed from: f (int) void
   public final void method_910(int var1) {
      this.field_675 = var1;
   }

   // $FF: renamed from: g (int) void
   public final void method_911(int var1) {
      this.field_675 += var1;
   }

   // $FF: renamed from: e () int
   public final int method_912() {
      return this.field_675;
   }

   // $FF: renamed from: a (byte, mobak.b.a.e) void
   public final void method_913(byte var1, Item var2) {
      if(var1 >= 0 && var1 < this.bag.length) {
         this.bag[var1] = null;
      }
   }

   // $FF: renamed from: c () byte
   public final byte method_914() {
      byte var1 = 0;

      for(byte var2 = 0; var2 < this.field_671.length; ++var2) {
         if(this.field_671[var2] != null) {
            ++var1;
         }
      }

      return var1;
   }

   // $FF: renamed from: a (mobak.b.a.d[], boolean) void
   private static void method_915(Characteristic[] var0, boolean var1) {
      if(var0 != null) {
         byte var2 = 0;

         while(var2 < var0.length) {
            short var3 = 0;

            while(true) {
               if(var3 < addedStats.length) {
                  if(addedStats[var3][0] != var0[var2].index) {
                     ++var3;
                     continue;
                  }

                  if(var1) {
                     addedStats[var3][1] = (short)(addedStats[var3][1] + var0[var2].value);
                  } else {
                     addedStats[var3][1] = (short)(addedStats[var3][1] - var0[var2].value);
                  }
               }

               ++var2;
               break;
            }
         }

      }
   }

   // $FF: renamed from: b (mobak.b.a.e[]) void
   public final void addItemsToHero(Item[] items) {
      this.equipment = new Item[6][0];
      this.equipment[0] = new Item[2];
      this.equipment[1] = new Item[1];
      this.equipment[2] = new Item[1];
      this.equipment[3] = new Item[1];
      this.equipment[4] = new Item[1];
      this.equipment[5] = new Item[4];
      addedStats = new short[this.characteristics.length + this.skills.length][2];

      byte itemIndex;
      for(itemIndex = 0; itemIndex < this.characteristics.length; ++itemIndex) {
         addedStats[itemIndex][0] = (short)this.characteristics[itemIndex].index;
         addedStats[itemIndex][1] = 0;
      }

      for(itemIndex = 0; itemIndex < this.skills.length; ++itemIndex) {
         addedStats[this.characteristics.length + itemIndex][0] = (short)this.skills[itemIndex].index;
         addedStats[this.characteristics.length + itemIndex][1] = 0;
      }

      if(items != null) {
         for(int i = 0; i < items.length; ++i) {
            if(items[i] != null) {
               Item[] var3 = this.equipment[items[i].getCategory() - 1];

               for(int var4 = 0; var4 < var3.length; ++var4) {
                  if(var3[var4] == null) {
                     var3[var4] = items[i];
                     method_915(var3[var4].characteristics, true);
                     break;
                  }
               }
            }
         }

      }
   }

   // $FF: renamed from: c (mobak.b.a.e[]) void
   public final void method_917(Item[] var1) {
      if(var1 != null && var1.length >= 0) {
         byte var2 = 0;
         byte var3 = 0;

         for(int var4 = 0; var4 < this.equipment.length; ++var4) {
            for(int var5 = 0; var5 < this.equipment[var4].length; ++var5) {
               if(this.equipment[var4][var5] != null) {
                  byte var6 = 0;
                  switch(this.equipment[var4][var5].getCategory()) {
                  case 1:
                     var6 = (byte)(5 + var2++);
                     break;
                  case 2:
                     var6 = 8;
                     break;
                  case 3:
                     var6 = 0;
                     break;
                  case 4:
                     var6 = 7;
                     break;
                  case 5:
                     var6 = 9;
                     break;
                  case 6:
                     var6 = (byte)(1 + var3++);
                  }

                  var1[var6] = this.equipment[var4][var5];
               }
            }
         }

      }
   }

   // $FF: renamed from: a (short) int
   public static int getAddedCharacteristicsValue(short characteristicsIndex) {
      for(short i = 0; i < addedStats.length; ++i) {
         if(addedStats[i][0] == characteristicsIndex) {
            return addedStats[i][1];
         }
      }

      return 0;
   }

   // $FF: renamed from: a (mobak.b.a.e) void
   public final void addItemOnHero(Item item) {
      method_915(item.characteristics, true);
      Item[] equipment = this.equipment[item.getCategory() - 1];

      for(byte i = 0; i < equipment.length; ++i) {
         if(equipment[i] == null) {
            equipment[i] = item;
            return;
         }
      }

   }

   // $FF: renamed from: a (mobak.b.a.e) boolean
   public static boolean method_920(Item var0) {
      OutputGameMessage var10000 = new OutputGameMessage(MessageProcessor.packetTypes[97], (short)4, MessageProcessor.packetTypes[97]);
      OutputGameMessage var1 = var10000;
      var10000.addToBody(var0.getId());
      SocketListener.self.sendCommand(var1);
      return true;
   }

   // $FF: renamed from: b (mobak.b.a.e) boolean
   public static boolean method_921(Item var0) {
      OutputGameMessage var10000 = new OutputGameMessage(MessageProcessor.packetTypes[94], (short)4, MessageProcessor.packetTypes[94]);
      OutputGameMessage var1 = var10000;
      var10000.addToBody(var0.getId());
      SocketListener.self.sendCommand(var1);
      return true;
   }

   // $FF: renamed from: h (int) void
   public final void method_922(int var1) {
      for(byte var2 = 0; var2 < this.equipment.length; ++var2) {
         Item[] var3 = this.equipment[var2];

         for(byte var4 = 0; var4 < var3.length; ++var4) {
            if(var3[var4] != null && var3[var4].getId() == var1) {
               method_915(var3[var4].characteristics, false);
               var3[var4] = null;
               return;
            }
         }
      }

   }

   // $FF: renamed from: a (int, int) void
   public final void changeItemsInBag(int itemId, int previousItemsQuantity) {
      for(byte i = 0; i < this.bag.length; ++i) {
         if(this.bag[i] != null && this.bag[i].getId() == itemId) {
            if(previousItemsQuantity == 1) {
               this.bag[i] = null;
            } else {
               this.bag[i].setQuantity(this.bag[i].getQuantity() - 1);
            }
         }
      }

   }

   // $FF: renamed from: b (mobak.b.a.e) void
   public final void addItemToBag(Item item) {
      if(item != null && item.getPlace() >= 0 && item.getPlace() < this.bag.length) {
         this.bag[item.getPlace()] = item;
      }
   }

   // $FF: renamed from: c (mobak.b.a.e) void
   public final void method_925(Item item) {
      Item[] equipment = this.equipment[item.getCategory() - 1];

      for(byte i = 0; i < equipment.length; ++i) {
         if(equipment[i] != null && equipment[i].getId() == 0) {
            equipment[i].setId(item.getId());
            return;
         }
      }

   }

   // $FF: renamed from: a () void
   public static void method_926() {
      OutputGameMessage var10000 = new OutputGameMessage(MessageProcessor.packetTypes[69], (short)0, MessageProcessor.packetTypes[69]);
      OutputGameMessage var0 = var10000;
      SocketListener.self.sendCommand(var0);
   }

   // $FF: renamed from: a (java.lang.String[]) void
   public final void setStatus(String[] var1) {
      this.field_709 = var1;
   }

   // $FF: renamed from: a () java.lang.String[]
   public final String[] method_928() {
      return this.field_709;
   }

   // $FF: renamed from: a () mobak.b.b.a.v[]
   public final Button[] method_929() {
      return this.field_710;
   }

   // $FF: renamed from: a (mobak.b.b.a.v[]) void
   public final void addButtons(Button[] var1) {
      this.field_710 = var1;
   }

   // $FF: renamed from: d () byte
   public final byte getRace() {
      return this.race;
   }

   // $FF: renamed from: e () byte
   public final byte method_932() {
      return (byte)((this.race - 1) % 5);
   }

   // $FF: renamed from: a (byte) byte
   public static final byte getRaceId(byte var0) {
      return (byte)((var0 - 1) % 5);
   }

   // $FF: renamed from: a (javax.microedition.lcdui.Graphics) void
   public final void method_934(Graphics var1) {
      if(this.field_670 != null && !this.field_670.equals("")) {
         int var2 = this.field_682;
         int var3 = this.field_683 + 50 + 2;
         Screen.field_25.method_563(this.field_670);
         MapObject.method_404(var1, self.method_932(), var2, var3, Screen.field_25.method_563(this.field_670), Screen.field_25.field_500);
         Screen.field_25.method_564(var1, this.field_670, var2, var3 + 1, 0);
      }

   }

   // $FF: renamed from: i (int) void
   public final void method_935(int var1) {
      this.field_686 = var1;
   }

   // $FF: renamed from: f () int
   public final int method_936() {
      return this.field_681;
   }

   // $FF: renamed from: j (int) void
   public final void method_937(int var1) {
      this.field_681 = var1;
   }
}
