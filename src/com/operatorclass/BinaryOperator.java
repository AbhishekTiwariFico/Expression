package com.operatorclass;;

import java.util.ArrayList;

public class BinaryOperator extends Operator
{
    private ArrayList<String> binaryList = new ArrayList<String>();
    String type = "binary";


    public BinaryOperator() {

    }

    @Override
    public ArrayList getData() {
        binaryList.add("+");
        binaryList.add("-");
        binaryList.add("*");
        binaryList.add("/");
        binaryList.add("^");
        binaryList.add("$");
        return binaryList;

    }

    @Override
    public String getType() {
        return type;
    }

}
