package mobak.a.a;

import mobak.a.SocketListener;
import mobak.c.MessagesContainer;
import mobak.c.RMSManager;

// $FF: renamed from: mobak.a.a.a
public final class PacketManager {

   // $FF: renamed from: a byte[]
   private static byte[] packetData;
   // $FF: renamed from: a int
   protected static int readDataCount;


   // $FF: renamed from: a (byte[]) void
   public static void method_964(byte[] var0) {
      short var1 = SocketListener.method_519(var0);
      if(readDataCount + var1 > packetData.length) {
         int var2 = (readDataCount + var1 - packetData.length) / 4096;
         if((readDataCount + var1 - packetData.length) % 4096 > 0) {
            ++var2;
         }

         byte[] var3 = new byte[packetData.length + (var2 << 12)];
         System.arraycopy(packetData, 0, var3, 0, packetData.length);
         packetData = var3;
      }

      System.arraycopy(var0, SocketListener.field_455, packetData, readDataCount, var1);
      readDataCount += var1;
   }

   // $FF: renamed from: a () void
   public static void clearPacketData() throws Exception {
      int var0 = getPacketBodySize();

      for(int i = 0; i < var0 + OutputGameMessage.headerSize; ++i) {
         packetData[i] = 0;
      }

      readDataCount = 0;
   }

   // $FF: renamed from: b () void
   public static void skipReadingHeader() {
      readDataCount = OutputGameMessage.headerSize;
   }

   // $FF: renamed from: a () boolean
   public static boolean packetDataIsEmpty() {
      if(packetData == null) {
         return true;
      } else {
         try {
            return readDataCount >= getPacketBodySize() + OutputGameMessage.headerSize;
         } catch (Exception var1) {
            SocketListener.logMessage("define EOF " + var1);
            return true;
         }
      }
   }

   // $FF: renamed from: a () short
   public static short getPacketType() throws Exception {
      if(packetData != null && packetData.length >= 2) {
         return (short)((255 & packetData[0]) << 8 | 255 & packetData[1]);
      } else {
         throw new Exception("command data isn\'t defined");
      }
   }

   // $FF: renamed from: b () short
   public static short getNextPacketType() throws Exception {
      if(packetData != null && packetData.length >= 6) {
         return (short)((255 & packetData[4]) << 8 | 255 & packetData[5]);
      } else {
         throw new Exception("command data isn\'t defined");
      }
   }

   // $FF: renamed from: a () int
   public static int getPacketBodySize() throws Exception {
      if(packetData != null && packetData.length >= 6) {
         return (255 & packetData[2]) << 8 | 255 & packetData[3];
      } else {
         throw new Exception("command data isn\'t defined");
      }
   }

   // $FF: renamed from: b () boolean
   public static boolean PacketIsHeader() throws Exception {
      if(packetData != null && packetData.length >= 6) {
         return packetData.length < 6;
      } else {
         throw new Exception("command data isn\'t defined");
      }
   }

   // $FF: renamed from: a () byte
   protected static byte readByte() throws Exception {
      if(packetDataIsEmpty()) {
         return (byte)0;
      } else if(readDataCount >= getPacketBodySize() + OutputGameMessage.headerSize) {
         return (byte)0;
      } else {
         ++readDataCount;
         return packetData[readDataCount - 1];
      }
   }

   // $FF: renamed from: c () short
   protected static short readShort() throws Exception {
      if(packetDataIsEmpty()) {
         return (short)0;
      } else if(getPacketBodySize() + OutputGameMessage.headerSize - readDataCount < 2) {
         readDataCount = getPacketBodySize() + OutputGameMessage.headerSize + 1;
         return (short)0;
      } else {
         short var0 = RMSManager.method_677(packetData, readDataCount, (short)0);
         readDataCount += 2;
         return var0;
      }
   }

   // $FF: renamed from: b () int
   protected static int readInt() throws Exception {
      if(packetDataIsEmpty()) {
         return 0;
      } else if(getPacketBodySize() + OutputGameMessage.headerSize - readDataCount < 4) {
         readDataCount = getPacketBodySize() + OutputGameMessage.headerSize + 1;
         return 0;
      } else {
         boolean var0 = false;
         int var1 = readDataCount;
         byte[] var3 = packetData;
         int var2;
         int var4 = packetData != null && var3.length - var1 >= 4?(var2 = -16777216 & var3[var1] << 24) | 16711680 & var3[var1 + 1] << 16 | '\uff00' & var3[var1 + 2] << 8 | 255 & var3[var1 + 3]:0;
         readDataCount += 4;
         return var4;
      }
   }

   // $FF: renamed from: a () long
   protected static long readLong() throws Exception {
      if(packetDataIsEmpty()) {
         return 0L;
      } else if(getPacketBodySize() + OutputGameMessage.headerSize - readDataCount < 8) {
         readDataCount = getPacketBodySize() + OutputGameMessage.headerSize + 1;
         return 0L;
      } else {
         long var4 = 0L;
         int var1 = readDataCount;
         byte[] var0 = packetData;
         long var6;
         long var8 = packetData != null && var0.length - var1 >= 8?(var6 = -72057594037927936L & (long)var0[var1] << 56) | 71776119061217280L & (long)var0[var1 + 1] << 48 | 280375465082880L & (long)var0[var1 + 2] << 40 | 1095216660480L & (long)var0[var1 + 3] << 32 | 4278190080L & (long)var0[var1 + 4] << 24 | 16711680L & (long)var0[var1 + 5] << 16 | 65280L & (long)var0[var1 + 6] << 8 | 255L & (long)var0[var1 + 7]:0L;
         readDataCount += 8;
         return var8;
      }
   }

   // $FF: renamed from: a (byte) long
   protected static long readPacket(byte var0) throws Exception {
      switch(var0) {
      case 1:
         return (long) readByte();
      case 2:
         return (long) readShort();
      case 3:
      case 5:
      case 6:
      case 7:
      default:
         return 0L;
      case 4:
         return (long) readInt();
      case 8:
         return readLong();
      }
   }

   // $FF: renamed from: a () java.lang.String
   protected static String readString() throws Exception {
      if(packetDataIsEmpty()) {
         return "";
      } else {
         short var0;
         if((var0 = readShort()) >= -32768 && var0 < -31744) {
            return MessagesContainer.getMessage(var0 = (short)(var0 & 32767));
         } else if(var0 == 0) {
            return "";
         } else {
            int var2 = var0 >= 0?var0:32767 - var0;
            String var1 = RMSManager.getString(packetData, readDataCount, var2, "");
            readDataCount += var2;
            return var1;
         }
      }
   }

   // $FF: renamed from: b (byte[]) void
   public static void copyBytesTo(byte[] var0) {
      System.arraycopy(packetData, readDataCount, var0, 0, var0.length);
      readDataCount += var0.length;
   }

   // $FF: renamed from: a (int) byte[]
   public static byte[] getMapData(int offset) {
      try {
         byte[] var2 = new byte[getPacketBodySize() - offset];
         System.arraycopy(packetData, OutputGameMessage.headerSize + offset, var2, 0, var2.length);
         return var2;
      } catch (Exception var1) {
         SocketListener.method_523(var1);
         return null;
      }
   }

   // $FF: renamed from: <clinit> () void
   static {
      packetData = new byte[10240];
      readDataCount = 0;
   }
}
