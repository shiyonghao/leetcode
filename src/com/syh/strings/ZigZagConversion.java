package com.syh.strings;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 18-10-6
 * Time: 上午10:40
 * To change this template use File | Settings | File Templates.
 *
 * https://leetcode-cn.com/problems/zigzag-conversion/description/
 */
public class ZigZagConversion {
    public static void main(String[] args) {
        ZigZagConversion zzc = new ZigZagConversion();
        // System.out.println(zzc.convert("PAYPALISHIRING", 3));
        // System.out.println(zzc.convert("PAYPALISHIRING", 1));
        // System.out.println(zzc.convert("PAYPALISHIRING", 4));
        // System.out.println(zzc.convert("PAYPALISHIRING", 2));
        System.out.println(zzc.convert("ABCD", 3));
    }

    public String convert(String s, int numRows) {
        if(null == s || s.length() <= 0){
            return "";
        }
        if(numRows <= 1){
            return s;
        }

        int len = s.length(), unitLen = numRows*2-2, tmpInitIndex = 0;
        int[] initIndex = len % unitLen == 0 ? new int[len / unitLen] : new int[len / unitLen + 1];
        while (true){
            if(tmpInitIndex * unitLen > len-1){
                break;
            }
            initIndex[tmpInitIndex] = tmpInitIndex * unitLen;
            tmpInitIndex++;
        }

        StringBuffer result = new StringBuffer();
        for(int i=0; i<numRows; i++){
            for(int j=0; j<initIndex.length; j++){
                if(initIndex[j] + i >= len){
                    break;
                }
                result.append(s.charAt(initIndex[j] + i));
                if(j<=initIndex.length-2
                        && initIndex[j+1] - i < initIndex[j+1]
                        && initIndex[j] + i != initIndex[j+1] - i){
                    result.append(s.charAt(initIndex[j+1] - i));
                }
            }
        }

        return result.toString();
    }
}
