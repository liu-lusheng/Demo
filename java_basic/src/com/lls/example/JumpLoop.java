package com.lls.example;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.util.Vector;

/**
 * @author liulusheng
 * @since 2019/11/18
 */
public class JumpLoop {
    public static void main(String[] args) {
        //跳出多重循环—，在外部定个标记
        ok:
        for(int i=0;i<10;i++)	{
            for(int j=0;j<10;j++)		{
                System.out.println("i=" + i + ",j=" + j);
                if(j == 5) break ok;
            }
        }
//跳出多重循环二，通过条件判断
        boolean found=false;
        for(int i=0;i<10 && !found;i++)	{
            for(int j=0;j<10;j++)		{
                System.out.println("i=" + i + ",j=" + j);
                if(j == 5) {
                    found=true;
                    break ;
                }
            }
        }

    }
}
