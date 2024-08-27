package cn.bugstack.design.user.impl;

import cn.bugstack.design.user.User;
import cn.bugstack.design.visitor.Visitor;

import java.math.BigDecimal;
import java.math.RoundingMode;

// 老师
public class Teacher extends User {

    public Teacher(String name, String identity, String clazz) {
        super(name, identity, clazz);
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    // 升本率
    public double entranceRatio() {
        return BigDecimal.valueOf(Math.random() * 100).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

}
