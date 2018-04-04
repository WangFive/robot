package com.wang.robot.bean;

public enum VirtualKey {
    /**
     * VK_VOLUME_MUTE
     */
    VK_VOLUME_MUTE(0xAD, "AD", "Volume Mute key"),
    /**
     * VK_VOLUME_DOWN
     */
    VK_VOLUME_DOWN(0xAE, "AE", "Volume Down key"),
    /**
     * VK_VOLUME_UP
     */
    VK_VOLUME_UP(0xAF, "AF", "Volume Up key"),
    /**
     * VK_MEDIA_NEXT_TRACK
     */
    VK_MEDIA_NEXT_TRACK(0xB0, "B0", "Next Track key"),
    /**
     * VK_MEDIA_PREV_TRACK
     */
    VK_MEDIA_PREV_TRACK(0xB1, "B1", "Previous Track key"),
    /**
     * VK_MEDIA_STOP
     */
    VK_MEDIA_STOP(0xB2, "B2", "Stop Media key"),
    /**
     * VK_MEDIA_PLAY_PAUSE
     */
    VK_MEDIA_PLAY_PAUSE(0xB3, "B3", "Play/Pause Media key");

    private int keyCode;
    private String keyValue;
    private String description;

    VirtualKey(int keyCode, String keyValue, String description){
        this.keyCode = keyCode;
        this.keyValue = keyValue;
        this.description = description;
    }

    public int getKeyCode() {
        return keyCode;
    }

    public void setKeyCode(int keyCode) {
        this.keyCode = keyCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getKeyValue() {
        return keyValue;
    }

    public void setKeyValue(String keyValue) {
        this.keyValue = keyValue;
    }
}
