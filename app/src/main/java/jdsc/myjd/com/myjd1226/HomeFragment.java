package jdsc.myjd.com.myjd1226;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.youth.banner.Banner;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

import jdsc.myjd.com.myjd1226.util.MyImageLoader;


public class HomeFragment extends Fragment{

    private static final String ARG_SHOW_TEXT = "text";
    private String mContentText;
    //返回通过工厂方法获取BlankFragment
    public static HomeFragment newInstance(){
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        //args.putString(ARG_SHOW_TEXT,param1);
        //fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       /* if (getArguments()!=null){
            mContentText = getArguments().getString(ARG_SHOW_TEXT);
        }*/
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //FOR fragment
        View homeView = inflater.inflate(R.layout.fragment_home,container,false);
        /*TextView contentTv = rootView.findViewById(R.id.content_tv);
        contentTv.setText(mContentText);*/
        //调用轮播方法
        //导入资源 gradle -- 框架  implementation 'com.github.bumptech.glide:glide:3.7.0'
        // 1.1 lunbo xml
        //1.2在fragment_home.xml调用lunbo xml
        //1.3 完成加载器类
        //1.4完成 轮播初始化的方法initBanner
        //1.5在onCreateView中调用方法。
        initBanner(homeView);
        initGalleryJinqiu(homeView);
        imageAdapter(homeView);
        return homeView;
    }


    private Gallery jingqiu_gallery;//商品浏览图片墙
    private ImageAdapter imageAdapter;//图片适配器

    public void initGalleryJinqiu(View homeView){
        jingqiu_gallery = homeView.findViewById(R.id.index_jingqiu_gallery);
        imageAdapter = new ImageAdapter(homeView.getContext());
        jingqiu_gallery.setAdapter(imageAdapter);
        //相应的点击事件
        jingqiu_gallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(adapterView.getContext(), "您点击的是" + i, Toast.LENGTH_LONG).show();
            }
        });
    }
    private Gallery index_tehui_gallery;//特惠商品图片墙
    private ImageAdapter1 mageAdapter;//图片适配器

    public void imageAdapter(View homeView){
        index_tehui_gallery = homeView.findViewById(R.id.index_tehui_gallery);
        mageAdapter = new ImageAdapter1(homeView.getContext());
        index_tehui_gallery.setAdapter(mageAdapter);
        //相应的点击事件
        index_tehui_gallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(adapterView.getContext(), "您点击的是" + i, Toast.LENGTH_LONG).show();
            }
        });
    }




    //4实现广告轮播
    private void initBanner(View homeView) {
        List images = new ArrayList();//创建图片结合，并存放图片
        images.add(R.drawable.image09);
        images.add(R.drawable.image10);
        images.add(R.drawable.image11);
        images.add(R.drawable.image12);
        images.add(R.drawable.image13);
        MyImageLoader myImageLoader = new MyImageLoader();//设置图片加载器
        Banner banner = homeView.findViewById(R.id.banner);
        banner.setImageLoader(myImageLoader);
        banner.setBannerAnimation(Transformer.ZoomOutSlide);
        banner.setDelayTime(3000);//延时3000ms
        banner.setImages(images);//设置图片结合
        banner.start();
    }
    private class ImageAdapter extends BaseAdapter {
        private Context context;
        int mGralleyItemBackground;
        int[] images = {R.drawable.index_gallery_01,R.drawable.index_gallery_02,R.drawable.index_gallery_03,R.drawable.index_gallery_04,R.drawable.index_gallery_05
        ,R.drawable.index_gallery_06,R.drawable.index_gallery_07,R.drawable.index_gallery_08,R.drawable.index_gallery_09,R.drawable.index_gallery_10};
        public ImageAdapter (Context context){
            this.context = context;
        }
        @Override
        public int getCount() {
            return images.length;
        }
        @Override
        public Object getItem(int position) {
            return position;
        }
        @Override
        public long getItemId(int position) {
            return position;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            //在此最好判断一下view是否为空
            ImageView image = new ImageView(context);
            image.setImageResource(images[position]);
            image.setAdjustViewBounds(true);
            //设置宽高
           /*image.setLayoutParams(new Gallery.LayoutParams(
                   ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));*/
            return image;
        }
    }
    private class ImageAdapter1 extends BaseAdapter {
        private Context context;
        int mGralleyItemBackground;
        int[] images = {R.drawable.index_gallery_11,R.drawable.index_gallery_12,R.drawable.index_gallery_13,R.drawable.index_gallery_14,R.drawable.index_gallery_05};
        public ImageAdapter1 (Context context){
            this.context = context;
        }
        @Override
        public int getCount() {
            return images.length;
        }
        @Override
        public Object getItem(int position) {
            return position;
        }
        @Override
        public long getItemId(int position) {
            return position;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            //在此最好判断一下view是否为空
            ImageView image1 = new ImageView(context);
            image1.setImageResource(images[position]);
            image1.setAdjustViewBounds(true);
            //设置宽高
           /*image.setLayoutParams(new Gallery.LayoutParams(
                   ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));*/
            return image1;
        }
    }
}
