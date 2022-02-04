package com.example.doubleclickheartapplication.slice;

import com.example.doubleclickheartapplication.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Component;
import ohos.agp.components.DirectionalLayout;
import ohos.agp.components.Image;
import ohos.media.photokit.metadata.AVStorage;

public class MainAbilitySlice extends AbilitySlice implements Component.DoubleClickedListener {
    Image image = null;
    boolean flag = false;

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);
        image = (Image) findComponentById(ResourceTable.Id_image);
        DirectionalLayout dl = (DirectionalLayout) findComponentById(ResourceTable.Id_dl);
        dl.setDoubleClickedListener(this);
        image.setClickedListener(new Component.ClickedListener() {
            @Override
            public void onClick(Component component) {
                if (flag) {
                    image.setImageAndDecodeBounds(ResourceTable.Media_heart_white);
                    flag = false;
                } else {
                    image.setImageAndDecodeBounds(ResourceTable.Media_heart_red);
                    flag = true;
                }
            }
        });
    }

    @Override
    public void onActive() {
        super.onActive();
    }

    @Override
    public void onForeground(Intent intent) {
        super.onForeground(intent);
    }

    @Override
    public void onDoubleClick(Component component) {
        if (flag) {
            image.setImageAndDecodeBounds(ResourceTable.Media_heart_white);
            flag = false;
        } else {
            image.setImageAndDecodeBounds(ResourceTable.Media_heart_red);
            flag = true;
        }
    }
}
