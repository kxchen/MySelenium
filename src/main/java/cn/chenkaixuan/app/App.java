package cn.chenkaixuan.app;

import cn.chenkaix.commons.helper.SqlHelper;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        SqlHelper.query("select COUNT(*) as count from A_EQUIP_METER", "count");
        String [] strArr=SqlHelper.query("select * from A_EQUIP_METER", 10);
        for(int i=0;i<strArr.length;i++) {
        	System.out.println(strArr[i]);
        }
        System.out.println();
        
        
        
    }
    
    
}
