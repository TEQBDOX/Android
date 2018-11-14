package com.example.my.utils;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Calculate {

    /**
     * 将字符串转化成List
     * @param str
     * @return
     */
    private static ArrayList<String> getStringList(String str){
        ArrayList<String> result = new ArrayList<>();
        String num = "";
        for (int i = 0; i < str.length(); i++) {
            if(Character.isDigit(str.charAt(i))|| '.'==str.charAt(i)){
                num = num + str.charAt(i);
            }else{
                if(num != ""){
                    result.add(num);
                }
                result.add(str.charAt(i) + "");
                num = "";
            }
        }
        if(num != ""){
            result.add(num);
        }
        return result;
    }

    /**
     * 将中缀表达式转化为后缀表达式
     * @param inOrderList
     * @return
     */
    private static ArrayList<String> getPostOrder(ArrayList<String> inOrderList){

        ArrayList<String> result = new ArrayList<>();
        Deque<String> stack = new ArrayDeque<>();
        for (int i = 0; i < inOrderList.size(); i++) {
            if(Character.isDigit(inOrderList.get(i).charAt(0))){
                result.add(inOrderList.get(i));
            }else{
                switch (inOrderList.get(i).charAt(0)) {
                    case '(':
                        stack.push(inOrderList.get(i));
                        break;
                    case ')':
                        while (!stack.peek().equals("(")) {
                            result.add(stack.pop());
                        }
                        stack.pop();
                        break;
                    default:
                        while (!stack.isEmpty() && compare(stack.peek(), inOrderList.get(i))){
                            result.add(stack.pop());
                        }
                        stack.push(inOrderList.get(i));
                        break;
                }
            }
        }
        while(!stack.isEmpty()){
            result.add(stack.pop());
        }
        return result;
    }

    /**
     * 计算后缀表达式
     * @param postOrder
     * @return
     */
    private static Double calculate(ArrayList<String> postOrder){
        Deque<Double> stack = new ArrayDeque<>();
        for (int i = 0; i < postOrder.size(); i++) {
            if(Character.isDigit(postOrder.get(i).charAt(0))){
                stack.push(Double.parseDouble(postOrder.get(i)));
            }else{
                Double back = stack.pop();
                Double front = stack.pop();
                Double res = 0d;
                switch (postOrder.get(i).charAt(0)) {
                    case '+':
                        res = front + back;
                        break;
                    case '-':
                        res = front - back;
                        break;
                    case '*':
                        res = front * back;
                        break;
                    case '/':
                        res = front / back;
                        break;
                }
                stack.push(res);
            }
        }
        return stack.pop();
    }

    /**
     * 比较运算符等级
     * @param peek
     * @param cur
     * @return
     */
    private static boolean compare(String peek, String cur){
        if("*".equals(peek) && ("/".equals(cur) || "*".equals(cur) ||"+".equals(cur) ||"-".equals(cur))){
            return true;
        }else if("/".equals(peek) && ("/".equals(cur) || "*".equals(cur) ||"+".equals(cur) ||"-".equals(cur))){
            return true;
        }else if("+".equals(peek) && ("+".equals(cur) || "-".equals(cur))){
            return true;
        }else if("-".equals(peek) && ("+".equals(cur) || "-".equals(cur))){
            return true;
        }
        return false;
    }

    /**
     * 封装计算步骤
     * @param
     */
    public  static Double getResult(String s){
        ArrayList list = getStringList(s);  //String转换为List
        list = getPostOrder(list);   //中缀变后缀
        Double result = calculate(list);
        return result;
    }

    /**
     * 是否是数字或小数
     * @tags @return
     * @exception
     * @author wanghc
     * @date 2015-9-16 下午5:50:15
     * @return boolean
     */
    private boolean isNumber(String str){
        if(null==str){
            return false;
        }
        String reg = "\\d+(\\.\\d+)?";
        return str.matches(reg);

    }
    public static void main(String[] args) {
        Calculate calculate = new Calculate();
        String s = "12+(23*3-56+7)*(2+90)/2";
//        ArrayList result = calculate.getStringList(s);  //String转换为List
//        result = calculate.getPostOrder(result);   //中缀变后缀
//        int i = calculate.calculate(result);   //计算
        Double result =calculate.getResult(s);
        System.out.println(result);

    }


}
