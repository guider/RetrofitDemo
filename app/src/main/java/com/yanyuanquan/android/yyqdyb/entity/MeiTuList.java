package com.yanyuanquan.android.yyqdyb.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * @Created by apple on 15/12/25.
 * @description:
 * @projectName:YYQDYB
 */
public class MeiTuList implements Parcelable {

    @Override
    public String toString() {
        return "MeiTuList{" +
                "total=" + total +
                ", tngou=" + tngou +
                '}';
    }

    /**
     * total : 523
     * tngou : [{"count":48,"fcount":0,"galleryclass":6,"id":536,"img":"/ext/151224/4826eef13099996bd4fdce2390bd432d.jpg","rcount":0,"size":8,"time":1450919144000,"title":"宅男女神"}]
     */

    private int total;
    /**
     * count : 48
     * fcount : 0
     * galleryclass : 6
     * id : 536
     * img : /ext/151224/4826eef13099996bd4fdce2390bd432d.jpg
     * rcount : 0
     * size : 8
     * time : 1450919144000
     * title : 宅男女神
     */

    private List<TngouEntity> tngou;

    public void setTotal(int total) {
        this.total = total;
    }

    public void setTngou(List<TngouEntity> tngou) {
        this.tngou = tngou;
    }

    public int getTotal() {
        return total;
    }

    public List<TngouEntity> getTngou() {
        return tngou;
    }

    public static class TngouEntity implements Parcelable {

        private int count;
        private int fcount;
        private int galleryclass;
        private int id;
        private String img;
        private int rcount;

        @Override
        public String toString() {
            return "TngouEntity{" +
                    "count=" + count +
                    ", fcount=" + fcount +
                    ", galleryclass=" + galleryclass +
                    ", id=" + id +
                    ", img='" + img + '\'' +
                    ", rcount=" + rcount +
                    ", size=" + size +
                    ", time=" + time +
                    ", title='" + title + '\'' +
                    '}';
        }

        private int size;
        private long time;
        private String title;

        public void setCount(int count) {
            this.count = count;
        }

        public void setFcount(int fcount) {
            this.fcount = fcount;
        }

        public void setGalleryclass(int galleryclass) {
            this.galleryclass = galleryclass;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public void setRcount(int rcount) {
            this.rcount = rcount;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public void setTime(long time) {
            this.time = time;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getCount() {
            return count;
        }

        public int getFcount() {
            return fcount;
        }

        public int getGalleryclass() {
            return galleryclass;
        }

        public int getId() {
            return id;
        }

        public String getImg() {
            return img;
        }

        public int getRcount() {
            return rcount;
        }

        public int getSize() {
            return size;
        }

        public long getTime() {
            return time;
        }

        public String getTitle() {
            return title;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.count);
            dest.writeInt(this.fcount);
            dest.writeInt(this.galleryclass);
            dest.writeInt(this.id);
            dest.writeString(this.img);
            dest.writeInt(this.rcount);
            dest.writeInt(this.size);
            dest.writeLong(this.time);
            dest.writeString(this.title);
        }

        public TngouEntity() {
        }

        protected TngouEntity(Parcel in) {
            this.count = in.readInt();
            this.fcount = in.readInt();
            this.galleryclass = in.readInt();
            this.id = in.readInt();
            this.img = in.readString();
            this.rcount = in.readInt();
            this.size = in.readInt();
            this.time = in.readLong();
            this.title = in.readString();
        }

        public static final Parcelable.Creator<TngouEntity> CREATOR = new Parcelable.Creator<TngouEntity>() {
            public TngouEntity createFromParcel(Parcel source) {
                return new TngouEntity(source);
            }

            public TngouEntity[] newArray(int size) {
                return new TngouEntity[size];
            }
        };
    }

    public MeiTuList() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.total);
        dest.writeTypedList(tngou);
    }

    protected MeiTuList(Parcel in) {
        this.total = in.readInt();
        this.tngou = in.createTypedArrayList(TngouEntity.CREATOR);
    }

    public static final Creator<MeiTuList> CREATOR = new Creator<MeiTuList>() {
        public MeiTuList createFromParcel(Parcel source) {
            return new MeiTuList(source);
        }

        public MeiTuList[] newArray(int size) {
            return new MeiTuList[size];
        }
    };
}
