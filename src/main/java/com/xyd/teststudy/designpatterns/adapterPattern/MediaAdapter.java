package com.xyd.teststudy.designpatterns.adapterPattern;
//适配器
public class MediaAdapter implements MediaPlayer {
    private MP4Player mp4Player;
    private WAVPlayer wavPlayer;
    public MediaAdapter(){
         this.mp4Player = new MP4Player();
         this.wavPlayer = new WAVPlayer();
    }
    @Override
    public void play(String audioType, String fileName) {
        if(audioType.equalsIgnoreCase("mp4")){
            mp4Player.playMap4(fileName);
        }else if(audioType.equalsIgnoreCase("wav")){
            wavPlayer.playWAV(fileName);
        }

    }
}
