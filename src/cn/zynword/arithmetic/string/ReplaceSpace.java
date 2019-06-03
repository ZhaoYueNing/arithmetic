package cn.zynword.arithmetic.string;

import java.util.Stack;

/**
 * Created by zhaoyuening on 2019/1/4.
 * https://www.nowcoder.com/practice/4060ac7e3e404ad1a894ef3e17650423?tpId=13&tqId=11155&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class ReplaceSpace {
    public String replaceSpace(StringBuffer str) {
        String oldStr = str.toString();
        str = new StringBuffer();
        for (char c : oldStr.toCharArray()){
            if (c == ' ') {
                str.append("%20");
                continue;
            }
            str.append(c);
        }


        return str.toString();
    }
}
