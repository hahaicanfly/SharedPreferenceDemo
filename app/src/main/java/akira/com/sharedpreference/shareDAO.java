package akira.com.sharedpreference;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Akira on 2016/5/12.
 */
public class shareDAO {

    public static String Name = "Akira";
    public static String Password = "12345678";
    public static String Phone = "0912345678";

    private static shareDAO myInstance;
    private  SharedPreferences sp;


    public static shareDAO getInstance(Context context){
        if(myInstance == null){
            myInstance = new shareDAO(context);
        }
        return myInstance;
    }

    public shareDAO(Context context) {
        sp = context.getApplicationContext().getSharedPreferences(context.getApplicationContext().getPackageName(),0);
    }

    /**Setter &　Getter**/

    public void setName(String attr,String name){
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(attr,name);
        editor.commit();
    }
    public String getName(){
        return sp.getString(Name,"");
    }

    public void setPassword(String attr,String password){
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(attr,password);
        editor.commit();
    }
    public String getPassword(){
        return sp.getString(Password,"");
    }

    public void setPhone(String attr,String phone){
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(attr,phone);
        editor.commit();
    }
    public String getPhone(){
        return sp.getString(Phone,"");
    }
}
