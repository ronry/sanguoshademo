package com.ronry.sanguosha;

import static com.google.common.collect.Lists.newArrayList;

import java.util.List;

import com.ronry.sanguosha.enums.Identity;

public class RandomIdentityDistributor implements IdentityDistributor {

    private static List<Identity> indentities = newArrayList(Identity.NEIJIAN, Identity.ZHONGCHEN, Identity.ZHUGONG,
                                                             Identity.FANZEI);

    private int                   index;

    public RandomIdentityDistributor(int playerCnt){

    }

    @Override
    public Identity next() {
        return indentities.get(index++);
    }

}
