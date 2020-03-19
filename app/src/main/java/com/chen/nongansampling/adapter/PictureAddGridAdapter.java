package com.chen.nongansampling.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.chen.nongansampling.R;
import com.chen.nongansampling.custom.CustomRotateAnim;
import com.chen.nongansampling.utils.PhotoBitmapUtil;

import java.util.ArrayList;
import java.util.List;

public class PictureAddGridAdapter extends BaseAdapter

    {

        /** 上下文 */
        private Context context;

        /** 所有图片的路径集合 */
        public List<String> imageItemData = new ArrayList<>();

        /** 加号按钮 */
        public Bitmap mAddBitmap;

        /** 最多可上传图片数 */
        public int imageSum;

        /** 判断是否显示清除按钮 true=显示 */
        private boolean showImageClear = false;

        /**
         * 图片构造器
         * @param context 上下文
         * @param imagesum 最大可添加图片数
         */
    public PictureAddGridAdapter(Context context, int imagesum) {
        this.context = context;
        this.imageSum = imagesum;
        // 加号图片
        mAddBitmap = BitmapFactory.decodeResource(context.getResources(), R.mipmap.add_picture);
    }

        /**
         * 添加图片
         * @param image
         */
        public void setImagePath(String image) {
        imageItemData.add(image);
    }

        @Override
        public int getCount() {
        // 数据集合加一，在该位置上添加加号
        return imageItemData == null ? 0 : imageItemData.size() + 1;
    }

        @Override
        public Object getItem(int position) {
        return imageItemData == null ? null : imageItemData.get(position);
    }

        @Override
        public long getItemId(int position) {
        return position;
    }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {

        final ViewHolder holder;
        if (null == convertView) {
            convertView = android.view.View.inflate(context, R.layout.gridview_item, null);
            holder = new ViewHolder();
            holder.img = (ImageView) convertView.findViewById(R.id.iv_photo_item);
            holder.imgclear = (ImageView) convertView.findViewById(R.id.iv_photo_item_clear);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        if (imageItemData != null && imageItemData.size() > position) {
            // 正常显示
            // 判断是否需要显示删除按钮
            if (getClearImgShow()) {
                holder.imgclear.setVisibility(android.view.View.VISIBLE);
                CustomRotateAnim anim = CustomRotateAnim.getCustomRotateAnim();
                anim.setDuration(300);
                anim.setRepeatCount(2);
                anim.setInterpolator(new LinearInterpolator()); // 设置为匀速
                holder.img.startAnimation(anim);
            } else {
                holder.img.clearAnimation();
                holder.imgclear.setVisibility(android.view.View.GONE);
            }
            holder.img.setImageBitmap(PhotoBitmapUtil.getCompressPhoto(imageItemData.get(position)));
        } else {
            // 图片数达到最大限制时隐藏加号图片
            if (imageItemData.size() != imageSum) {
                holder.imgclear.setVisibility(android.view.View.GONE);   // 不显示删除按钮
                holder.img.clearAnimation();    // 去除动画
                holder.img.setImageBitmap(mAddBitmap);
            }
        }

        // 设置清除按钮点击事件监听
        holder.imgclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageItemData.remove(position);
                notifyDataSetChanged();
            }
        });

        return convertView;

    }

        private static class ViewHolder {
            ImageView img;
            ImageView imgclear;
        }

        /**
         * 设置图片显示状态
         * @param clear 图片状态
         */
        public void setClearImgShow(boolean clear) {
        showImageClear = clear;
    }

        /**
         * 图片显示状态
         * @return 状态 true=显示
         */
        public boolean getClearImgShow() {
        return showImageClear;
    }
    }
