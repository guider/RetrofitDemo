package com.yanyuanquan.android.yyqdyb.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * @Created by apple on 15/12/25.
 * @description:
 * @projectName:YYQDYB
 */
public class JokeWithImg implements Parcelable {

    /**
     * showapi_res_code : 0
     * showapi_res_error :
     * showapi_res_body : {"allNum":20128,"allPages":1007,"contentlist":[{"ct":"2015-12-25 17:00:29.355","img":"http://img0.hao123.com/data/3_1565f321301089921e4beb5ca4e7b79b_0","title":"妹子，这马骑得应该很满意吧","type":2},{"ct":"2015-12-25 17:00:29.354","img":"http://img0.hao123.com/data/3_447a0b9813f7f41454c27b281f51e72f_0","title":"这是哪来的拉拉队？好牛逼！","type":2},{"ct":"2015-12-25 17:00:29.353","img":"http://img3.hao123.com/data/3_b638d045c12e93163b234aa517196c1d_430","title":"圣诞老人也开始送外卖了！","type":2},{"ct":"2015-12-25 17:00:29.351","img":"http://img2.hao123.com/data/3_dc4a5ad890a5380d9d86913367eb668a_0","title":"好有爱的一只小河豚","type":2},{"ct":"2015-12-25 17:00:29.341","img":"http://img2.hao123.com/data/3_2fc955c4f4a48c24b55d9a03991691a0_0","title":"绅士们！你看到了什么！","type":2},{"ct":"2015-12-25 17:00:29.341","img":"http://img0.hao123.com/data/3_40dbf5f2a4a85f356e43f9ce1755713e_0","title":"竟然给本喵穿小鞋！","type":2},{"ct":"2015-12-25 17:00:29.341","img":"http://img1.hao123.com/data/3_0583146cbdaaf9873fc10a1b35cd37bb_0","title":"感觉屏幕都震坏了。。","type":2},{"ct":"2015-12-25 16:30:29.756","img":"http://img0.hao123.com/data/3_054f2abe96427532704df8ba8f8ac2f1_0","title":"这是我见过的韩剧中\u201c最大型\u201d的交通事故！","type":2},{"ct":"2015-12-25 16:00:33.838","img":"http://sc0.hao123img.com/data/8ebcf6c2a5829daf521004f22a02260a_0","title":"我还敢做到对面去么","type":2},{"ct":"2015-12-25 16:00:33.762","img":"http://img6.hao123.com/data/3_5da035e891dca24862b72d72c82c90f0_0","title":"自己点的重辣，哭着也要吃下去","type":2},{"ct":"2015-12-25 16:00:33.738","img":"http://img3.hao123.com/data/3_41a115823ae632c55dab262bfe1ecefe_0","title":"你不单身，天理不容","type":2},{"ct":"2015-12-25 16:00:33.731","img":"http://img2.hao123.com/data/3_c8768dcbe97ede2a82842226b675cf1a_0","title":"本喵不会放过你的！","type":2},{"ct":"2015-12-25 16:00:33.671","img":"http://img.hao123.com/data/3_ce96b76e8b89035bcbe14eed09f7e4d1_0","title":"让你装逼跑那么快～","type":2},{"ct":"2015-12-25 16:00:33.671","img":"http://img0.hao123.com/data/3_b40dc52035cdd5869e55ac37c1b84994_0","title":"这胖子要上天","type":2},{"ct":"2015-12-25 15:30:28.972","img":"http://sc3.hao123img.com/data/36298d704ce8ca41790d74f62fa56187_0","title":"没座位就没吧，坐地上挺好！","type":2},{"ct":"2015-12-25 15:30:28.969","img":"http://sc0.hao123img.com/data/ec8e3368dce45f26e87dd3fc08849a12_430","title":"这个是要出大事了啊","type":2},{"ct":"2015-12-25 15:30:28.968","img":"http://img2.hao123.com/data/3_6c87b2f3ba6fb6977c3c54c993b30164_0","title":"后面的小萝莉好无辜\u2026\u2026\u2026","type":2},{"ct":"2015-12-25 15:30:28.968","img":"http://img3.hao123.com/data/3_a55993ba5948aa45a99e0ffc712c67f1_0","title":"人间酷刑。。。","type":2},{"ct":"2015-12-25 15:30:28.968","img":"http://sc1.hao123img.com/data/92f91286e93f4acdb120ff7752ea5dcc_0","title":"妹子这样到底是什么意思啊","type":2},{"ct":"2015-12-25 15:30:28.966","img":"http://img2.hao123.com/data/3_09fa5bd1f769d3986bdc94dd23b8bd4a_0","title":"今天开荤了~","type":2}],"currentPage":1,"maxResult":20,"ret_code":0}
     */

    private int showapi_res_code;
    private String showapi_res_error;
    /**
     * allNum : 20128
     * allPages : 1007
     * contentlist : [{"ct":"2015-12-25 17:00:29.355","img":"http://img0.hao123.com/data/3_1565f321301089921e4beb5ca4e7b79b_0","title":"妹子，这马骑得应该很满意吧","type":2},{"ct":"2015-12-25 17:00:29.354","img":"http://img0.hao123.com/data/3_447a0b9813f7f41454c27b281f51e72f_0","title":"这是哪来的拉拉队？好牛逼！","type":2},{"ct":"2015-12-25 17:00:29.353","img":"http://img3.hao123.com/data/3_b638d045c12e93163b234aa517196c1d_430","title":"圣诞老人也开始送外卖了！","type":2},{"ct":"2015-12-25 17:00:29.351","img":"http://img2.hao123.com/data/3_dc4a5ad890a5380d9d86913367eb668a_0","title":"好有爱的一只小河豚","type":2},{"ct":"2015-12-25 17:00:29.341","img":"http://img2.hao123.com/data/3_2fc955c4f4a48c24b55d9a03991691a0_0","title":"绅士们！你看到了什么！","type":2},{"ct":"2015-12-25 17:00:29.341","img":"http://img0.hao123.com/data/3_40dbf5f2a4a85f356e43f9ce1755713e_0","title":"竟然给本喵穿小鞋！","type":2},{"ct":"2015-12-25 17:00:29.341","img":"http://img1.hao123.com/data/3_0583146cbdaaf9873fc10a1b35cd37bb_0","title":"感觉屏幕都震坏了。。","type":2},{"ct":"2015-12-25 16:30:29.756","img":"http://img0.hao123.com/data/3_054f2abe96427532704df8ba8f8ac2f1_0","title":"这是我见过的韩剧中\u201c最大型\u201d的交通事故！","type":2},{"ct":"2015-12-25 16:00:33.838","img":"http://sc0.hao123img.com/data/8ebcf6c2a5829daf521004f22a02260a_0","title":"我还敢做到对面去么","type":2},{"ct":"2015-12-25 16:00:33.762","img":"http://img6.hao123.com/data/3_5da035e891dca24862b72d72c82c90f0_0","title":"自己点的重辣，哭着也要吃下去","type":2},{"ct":"2015-12-25 16:00:33.738","img":"http://img3.hao123.com/data/3_41a115823ae632c55dab262bfe1ecefe_0","title":"你不单身，天理不容","type":2},{"ct":"2015-12-25 16:00:33.731","img":"http://img2.hao123.com/data/3_c8768dcbe97ede2a82842226b675cf1a_0","title":"本喵不会放过你的！","type":2},{"ct":"2015-12-25 16:00:33.671","img":"http://img.hao123.com/data/3_ce96b76e8b89035bcbe14eed09f7e4d1_0","title":"让你装逼跑那么快～","type":2},{"ct":"2015-12-25 16:00:33.671","img":"http://img0.hao123.com/data/3_b40dc52035cdd5869e55ac37c1b84994_0","title":"这胖子要上天","type":2},{"ct":"2015-12-25 15:30:28.972","img":"http://sc3.hao123img.com/data/36298d704ce8ca41790d74f62fa56187_0","title":"没座位就没吧，坐地上挺好！","type":2},{"ct":"2015-12-25 15:30:28.969","img":"http://sc0.hao123img.com/data/ec8e3368dce45f26e87dd3fc08849a12_430","title":"这个是要出大事了啊","type":2},{"ct":"2015-12-25 15:30:28.968","img":"http://img2.hao123.com/data/3_6c87b2f3ba6fb6977c3c54c993b30164_0","title":"后面的小萝莉好无辜\u2026\u2026\u2026","type":2},{"ct":"2015-12-25 15:30:28.968","img":"http://img3.hao123.com/data/3_a55993ba5948aa45a99e0ffc712c67f1_0","title":"人间酷刑。。。","type":2},{"ct":"2015-12-25 15:30:28.968","img":"http://sc1.hao123img.com/data/92f91286e93f4acdb120ff7752ea5dcc_0","title":"妹子这样到底是什么意思啊","type":2},{"ct":"2015-12-25 15:30:28.966","img":"http://img2.hao123.com/data/3_09fa5bd1f769d3986bdc94dd23b8bd4a_0","title":"今天开荤了~","type":2}]
     * currentPage : 1
     * maxResult : 20
     * ret_code : 0
     */

    private ShowapiResBodyEntity showapi_res_body;

    public void setShowapi_res_code(int showapi_res_code) {
        this.showapi_res_code = showapi_res_code;
    }

    public void setShowapi_res_error(String showapi_res_error) {
        this.showapi_res_error = showapi_res_error;
    }

    public void setShowapi_res_body(ShowapiResBodyEntity showapi_res_body) {
        this.showapi_res_body = showapi_res_body;
    }

    public int getShowapi_res_code() {
        return showapi_res_code;
    }

    public String getShowapi_res_error() {
        return showapi_res_error;
    }

    @Override
    public String toString() {
        return "JokeWithImg{" +
                "showapi_res_code=" + showapi_res_code +
                ", showapi_res_error='" + showapi_res_error + '\'' +
                ", showapi_res_body=" + showapi_res_body +
                '}';
    }

    public ShowapiResBodyEntity getShowapi_res_body() {
        return showapi_res_body;
    }

    public static class ShowapiResBodyEntity implements Parcelable {
        private int allNum;
        private int allPages;
        private int currentPage;
        private int maxResult;
        private int ret_code;
        /**
         * ct : 2015-12-25 17:00:29.355
         * img : http://img0.hao123.com/data/3_1565f321301089921e4beb5ca4e7b79b_0
         * title : 妹子，这马骑得应该很满意吧
         * type : 2
         */

        private List<ContentlistEntity> contentlist;

        public void setAllNum(int allNum) {
            this.allNum = allNum;
        }

        public void setAllPages(int allPages) {
            this.allPages = allPages;
        }

        public void setCurrentPage(int currentPage) {
            this.currentPage = currentPage;
        }

        public void setMaxResult(int maxResult) {
            this.maxResult = maxResult;
        }

        public void setRet_code(int ret_code) {
            this.ret_code = ret_code;
        }

        public void setContentlist(List<ContentlistEntity> contentlist) {
            this.contentlist = contentlist;
        }

        public int getAllNum() {
            return allNum;
        }

        @Override
        public String toString() {
            return "ShowapiResBodyEntity{" +
                    "allNum=" + allNum +
                    ", allPages=" + allPages +
                    ", currentPage=" + currentPage +
                    ", maxResult=" + maxResult +
                    ", ret_code=" + ret_code +
                    ", contentlist=" + contentlist +
                    '}';
        }

        public int getAllPages() {
            return allPages;
        }

        public int getCurrentPage() {
            return currentPage;
        }

        public int getMaxResult() {
            return maxResult;
        }

        public int getRet_code() {
            return ret_code;
        }

        public List<ContentlistEntity> getContentlist() {
            return contentlist;
        }

        public static class ContentlistEntity implements Parcelable {
            private String ct;
            private String img;
            private String title;

            @Override
            public String toString() {
                return "ContentlistEntity{" +
                        "ct='" + ct + '\'' +
                        ", img='" + img + '\'' +
                        ", title='" + title + '\'' +
                        ", type=" + type +
                        '}';
            }

            private int type;

            public void setCt(String ct) {
                this.ct = ct;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public void setType(int type) {
                this.type = type;
            }

            public String getCt() {
                return ct;
            }

            public String getImg() {
                return img;
            }

            public String getTitle() {
                return title;
            }

            public int getType() {
                return type;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.ct);
                dest.writeString(this.img);
                dest.writeString(this.title);
                dest.writeInt(this.type);
            }

            public ContentlistEntity() {
            }

            protected ContentlistEntity(Parcel in) {
                this.ct = in.readString();
                this.img = in.readString();
                this.title = in.readString();
                this.type = in.readInt();
            }

            public static final Parcelable.Creator<ContentlistEntity> CREATOR = new Parcelable.Creator<ContentlistEntity>() {
                public ContentlistEntity createFromParcel(Parcel source) {
                    return new ContentlistEntity(source);
                }

                public ContentlistEntity[] newArray(int size) {
                    return new ContentlistEntity[size];
                }
            };
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.allNum);
            dest.writeInt(this.allPages);
            dest.writeInt(this.currentPage);
            dest.writeInt(this.maxResult);
            dest.writeInt(this.ret_code);
            dest.writeTypedList(contentlist);
        }

        public ShowapiResBodyEntity() {
        }

        protected ShowapiResBodyEntity(Parcel in) {
            this.allNum = in.readInt();
            this.allPages = in.readInt();
            this.currentPage = in.readInt();
            this.maxResult = in.readInt();
            this.ret_code = in.readInt();
            this.contentlist = in.createTypedArrayList(ContentlistEntity.CREATOR);
        }

        public static final Parcelable.Creator<ShowapiResBodyEntity> CREATOR = new Parcelable.Creator<ShowapiResBodyEntity>() {
            public ShowapiResBodyEntity createFromParcel(Parcel source) {
                return new ShowapiResBodyEntity(source);
            }

            public ShowapiResBodyEntity[] newArray(int size) {
                return new ShowapiResBodyEntity[size];
            }
        };
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.showapi_res_code);
        dest.writeString(this.showapi_res_error);
        dest.writeParcelable(this.showapi_res_body, 0);
    }

    public JokeWithImg() {
    }

    protected JokeWithImg(Parcel in) {
        this.showapi_res_code = in.readInt();
        this.showapi_res_error = in.readString();
        this.showapi_res_body = in.readParcelable(ShowapiResBodyEntity.class.getClassLoader());
    }

    public static final Parcelable.Creator<JokeWithImg> CREATOR = new Parcelable.Creator<JokeWithImg>() {
        public JokeWithImg createFromParcel(Parcel source) {
            return new JokeWithImg(source);
        }

        public JokeWithImg[] newArray(int size) {
            return new JokeWithImg[size];
        }
    };
}
