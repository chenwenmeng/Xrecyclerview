package co.bwie.demo;


import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * 类描述:
 * 作者：陈文梦
 * 时间:2017/2/18 15:39
 * 邮箱:18310832074@163.com
 */

public class Bean {

    public List<Data> data;

    //第二层
    public static class Data{

        public boolean has_image;
        public boolean has_video;
        public List<Image_list> image_list;
        public List<Large_image_list> large_image_list;
        public Middle_image middle_image;
        public String title;
        public int comment_count;
        public String source;
        public long publish_time;
        public String share_url;
    }

    public static class Image_list{
        public String url;

    }
    public static class Large_image_list{
        public String url;

    }
    public static class Middle_image{
        public String url;

    }
}
