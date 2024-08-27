package cn.bugstack.design.test;

import cn.bugstack.design.IVideoUserService;
import cn.bugstack.design.impl.GuestVideoUserService;

public class ApiTest {

    public static void main(String[] args) {
        IVideoUserService guest = new GuestVideoUserService();
        guest.advertisement();
        guest.definition();
        // 其他两个，自己补充
    }

}
