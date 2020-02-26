package com.operatorclass;

import java.util.ArrayList;

public class UnaryOperator extends Operator {
    ArrayList<String> unaryList = new ArrayList<String>();
    @Override
    public ArrayList getData() {
        unaryList.add("sin");
        unaryList.add("cos");

        return unaryList;
    }

    @Override
    public String getType() {
        return null;
    }
}
