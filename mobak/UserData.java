package mobak;


// $FF: renamed from: mobak.i
public final class UserData {

   // $FF: renamed from: a java.lang.String
   public String userName;
   // $FF: renamed from: b java.lang.String
   public String login;
   // $FF: renamed from: c java.lang.String
   public String password;
   // $FF: renamed from: d java.lang.String
   public String heroName;
   // $FF: renamed from: a byte
   public byte raceId;


   // $FF: renamed from: <init> (java.lang.String, java.lang.String, java.lang.String, java.lang.String, byte) void
   public UserData(String userName, String login, String password, String heroName, byte raceId) {
      super();
      this.userName = userName;
      this.login = login;
      this.password = password;
      this.heroName = heroName;
      this.raceId = raceId;
   }
}
