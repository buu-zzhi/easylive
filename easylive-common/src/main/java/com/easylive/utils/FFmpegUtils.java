package com.easylive.utils;

import com.easylive.entity.config.AppConfig;
import com.easylive.entity.constants.Constants;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class FFmpegUtils {
    @Resource
    private AppConfig appConfig;

    public void createImageThumbnail(String originFilePath) {
        String ffmpegPath = appConfig.getFfmpegPath();
        if (StringTools.isEmpty(ffmpegPath)) {
            ffmpegPath = "ffmpeg";
        }
        String CMD = ffmpegPath + " -i \"%s\" -vf scale=200:-1 \"%s\"";
        String fileName = StringTools.getFileName(originFilePath);
        CMD = String.format(CMD, originFilePath, fileName + Constants.IMAGE_THUMBNAIL_SUFFIX);
        ProcessUtils.executeCommand(CMD, appConfig.getShowFFmpegLog());
    }
}
