package com.example.dllo.sanfu.bean;

import java.util.List;

/**
 * Created by dllo on 16/5/24.
 */
public class CarouselBean {

    /**
     * code : 200
     * data : {"banners":[{"ad_monitors":[],"channel":"all","id":592,"image_url":"http://img02.liwushuo.com/image/160517/b341vuy7v.jpg-w720","order":71,"status":0,"target":{"banner_image_url":"http://img02.liwushuo.com/image/160517/reej52gyl.jpg-w300","banner_webp_url":"http://img02.liwushuo.com/image/160517/reej52gyl.jpg?imageView2/2/w/300/q/85/format/webp","cover_image_url":"http://img02.liwushuo.com/image/160517/gv52omhon.jpg-w720","cover_webp_url":"http://img02.liwushuo.com/image/160517/gv52omhon.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1463452480,"id":287,"posts_count":8,"status":0,"subtitle":"怎么背都是少女范儿","title":"最爱双肩包","updated_at":1463452480},"target_id":287,"target_type":"url","target_url":"liwushuo:///page?page_action=navigation&login=false&type=topic&topic_id=287","type":"collection","webp_url":"http://img02.liwushuo.com/image/160517/b341vuy7v.jpg?imageView2/2/w/720/q/85/format/webp"},{"ad_monitors":[],"channel":"all","id":593,"image_url":"http://img03.liwushuo.com/image/160517/ixftmoeem.jpg-w720","order":70,"status":0,"target":{"banner_image_url":"http://img02.liwushuo.com/image/160518/cdtoe36bq.jpg-w300","banner_webp_url":"http://img02.liwushuo.com/image/160518/cdtoe36bq.jpg?imageView2/2/w/300/q/85/format/webp","cover_image_url":"http://img03.liwushuo.com/image/160518/oi08k83ji.jpg-w720","cover_webp_url":"http://img03.liwushuo.com/image/160518/oi08k83ji.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1463452817,"id":288,"posts_count":7,"status":0,"subtitle":"有整个夏天的味道","title":"腕间小清新","updated_at":1463452817},"target_id":288,"target_type":"url","target_url":"liwushuo:///page?page_action=navigation&login=false&type=topic&topic_id=288","type":"collection","webp_url":"http://img03.liwushuo.com/image/160517/ixftmoeem.jpg?imageView2/2/w/720/q/85/format/webp"},{"ad_monitors":[],"channel":"all","id":586,"image_url":"http://img01.liwushuo.com/image/160513/8nfx4ck0f.jpg-w720","order":67,"status":0,"target":{"banner_image_url":"http://img01.liwushuo.com/image/160513/p5gokuphi.jpg-w300","banner_webp_url":"http://img01.liwushuo.com/image/160513/p5gokuphi.jpg?imageView2/2/w/300/q/85/format/webp","cover_image_url":"http://img03.liwushuo.com/image/160513/futszgbam.jpg-w720","cover_webp_url":"http://img03.liwushuo.com/image/160513/futszgbam.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1463140513,"id":280,"posts_count":7,"status":1,"subtitle":"品质耳机合集","title":"戴上耳机，在音乐里世界倾听美好","updated_at":1463140513},"target_id":280,"target_type":"url","target_url":"liwushuo:///page?page_action=navigation&login=false&type=topic&topic_id=280","type":"collection","webp_url":"http://img01.liwushuo.com/image/160513/8nfx4ck0f.jpg?imageView2/2/w/720/q/85/format/webp"},{"ad_monitors":[],"channel":"all","id":591,"image_url":"http://img02.liwushuo.com/image/160517/9emzlc36x.jpg-w720","order":66,"status":0,"target":{"banner_image_url":"http://img01.liwushuo.com/image/160518/v8su6youf.jpg-w300","banner_webp_url":"http://img01.liwushuo.com/image/160518/v8su6youf.jpg?imageView2/2/w/300/q/85/format/webp","cover_image_url":"http://img01.liwushuo.com/image/160518/7doo6pm3c.jpg-w720","cover_webp_url":"http://img01.liwushuo.com/image/160518/7doo6pm3c.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1463452367,"id":286,"posts_count":7,"status":0,"subtitle":"让你的时尚指数UP↑UP↑","title":"一周穿搭指南","updated_at":1463452367},"target_id":286,"target_type":"url","target_url":"liwushuo:///page?page_action=navigation&login=false&type=topic&topic_id=286","type":"collection","webp_url":"http://img02.liwushuo.com/image/160517/9emzlc36x.jpg?imageView2/2/w/720/q/85/format/webp"}]}
     * message : OK
     */

    private int code;
    private DataBean data;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class DataBean {
        /**
         * ad_monitors : []
         * channel : all
         * id : 592
         * image_url : http://img02.liwushuo.com/image/160517/b341vuy7v.jpg-w720
         * order : 71
         * status : 0
         * target : {"banner_image_url":"http://img02.liwushuo.com/image/160517/reej52gyl.jpg-w300","banner_webp_url":"http://img02.liwushuo.com/image/160517/reej52gyl.jpg?imageView2/2/w/300/q/85/format/webp","cover_image_url":"http://img02.liwushuo.com/image/160517/gv52omhon.jpg-w720","cover_webp_url":"http://img02.liwushuo.com/image/160517/gv52omhon.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1463452480,"id":287,"posts_count":8,"status":0,"subtitle":"怎么背都是少女范儿","title":"最爱双肩包","updated_at":1463452480}
         * target_id : 287
         * target_type : url
         * target_url : liwushuo:///page?page_action=navigation&login=false&type=topic&topic_id=287
         * type : collection
         * webp_url : http://img02.liwushuo.com/image/160517/b341vuy7v.jpg?imageView2/2/w/720/q/85/format/webp
         */

        private List<BannersBean> banners;

        public List<BannersBean> getBanners() {
            return banners;
        }

        public void setBanners(List<BannersBean> banners) {
            this.banners = banners;
        }

        public static class BannersBean {
            private String channel;
            private int id;
            private String image_url;
            private int order;
            private int status;
            /**
             * banner_image_url : http://img02.liwushuo.com/image/160517/reej52gyl.jpg-w300
             * banner_webp_url : http://img02.liwushuo.com/image/160517/reej52gyl.jpg?imageView2/2/w/300/q/85/format/webp
             * cover_image_url : http://img02.liwushuo.com/image/160517/gv52omhon.jpg-w720
             * cover_webp_url : http://img02.liwushuo.com/image/160517/gv52omhon.jpg?imageView2/2/w/720/q/85/format/webp
             * created_at : 1463452480
             * id : 287
             * posts_count : 8
             * status : 0
             * subtitle : 怎么背都是少女范儿
             * title : 最爱双肩包
             * updated_at : 1463452480
             */

            private TargetBean target;
            private int target_id;
            private String target_type;
            private String target_url;
            private String type;
            private String webp_url;
            private List<?> ad_monitors;

            public String getChannel() {
                return channel;
            }

            public void setChannel(String channel) {
                this.channel = channel;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getImage_url() {
                return image_url;
            }

            public void setImage_url(String image_url) {
                this.image_url = image_url;
            }

            public int getOrder() {
                return order;
            }

            public void setOrder(int order) {
                this.order = order;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public TargetBean getTarget() {
                return target;
            }

            public void setTarget(TargetBean target) {
                this.target = target;
            }

            public int getTarget_id() {
                return target_id;
            }

            public void setTarget_id(int target_id) {
                this.target_id = target_id;
            }

            public String getTarget_type() {
                return target_type;
            }

            public void setTarget_type(String target_type) {
                this.target_type = target_type;
            }

            public String getTarget_url() {
                return target_url;
            }

            public void setTarget_url(String target_url) {
                this.target_url = target_url;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getWebp_url() {
                return webp_url;
            }

            public void setWebp_url(String webp_url) {
                this.webp_url = webp_url;
            }

            public List<?> getAd_monitors() {
                return ad_monitors;
            }

            public void setAd_monitors(List<?> ad_monitors) {
                this.ad_monitors = ad_monitors;
            }

            public static class TargetBean {
                private String banner_image_url;
                private String banner_webp_url;
                private String cover_image_url;
                private String cover_webp_url;
                private int created_at;
                private int id;
                private int posts_count;
                private int status;
                private String subtitle;
                private String title;
                private int updated_at;

                public String getBanner_image_url() {
                    return banner_image_url;
                }

                public void setBanner_image_url(String banner_image_url) {
                    this.banner_image_url = banner_image_url;
                }

                public String getBanner_webp_url() {
                    return banner_webp_url;
                }

                public void setBanner_webp_url(String banner_webp_url) {
                    this.banner_webp_url = banner_webp_url;
                }

                public String getCover_image_url() {
                    return cover_image_url;
                }

                public void setCover_image_url(String cover_image_url) {
                    this.cover_image_url = cover_image_url;
                }

                public String getCover_webp_url() {
                    return cover_webp_url;
                }

                public void setCover_webp_url(String cover_webp_url) {
                    this.cover_webp_url = cover_webp_url;
                }

                public int getCreated_at() {
                    return created_at;
                }

                public void setCreated_at(int created_at) {
                    this.created_at = created_at;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getPosts_count() {
                    return posts_count;
                }

                public void setPosts_count(int posts_count) {
                    this.posts_count = posts_count;
                }

                public int getStatus() {
                    return status;
                }

                public void setStatus(int status) {
                    this.status = status;
                }

                public String getSubtitle() {
                    return subtitle;
                }

                public void setSubtitle(String subtitle) {
                    this.subtitle = subtitle;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public int getUpdated_at() {
                    return updated_at;
                }

                public void setUpdated_at(int updated_at) {
                    this.updated_at = updated_at;
                }
            }
        }
    }
}
