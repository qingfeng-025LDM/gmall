package com.atguigu.gmall.user.controller;

import java.util.Random;

public class RandomPeople {

    public static void main(String[] args) {
        Random col = new Random();
        Random row = new Random();

        int lie = col.nextInt(4);
        int hang = row.nextInt(8) + 1;

        System.out.println("有请第" + lie + "列" + "，第" + hang + "行的同学回答问题！");
    }
}
