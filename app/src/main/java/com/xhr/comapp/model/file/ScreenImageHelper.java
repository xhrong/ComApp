package com.xhr.comapp.model.file;

import android.graphics.Bitmap;

import com.xhr.comapp.config.AppConfig;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by xhrong on 2016/3/10.
 */
public class ScreenImageHelper {

    public void saveScreen(Bitmap b, String imageName) {
        String savePath = AppConfig.SCREEN_SHOT_SAVE_PATH + imageName;
        File file = new File(AppConfig.SCREEN_SHOT_SAVE_PATH);
        if (!file.exists()) {
            file.mkdirs();
        }
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(savePath);
            if (null != fos) {
                b.compress(Bitmap.CompressFormat.PNG, 90, fos);
                fos.flush();
                fos.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
