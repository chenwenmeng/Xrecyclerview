package co.bwie.demo;


import android.content.Context;

import android.support.v7.widget.RecyclerView;



import android.text.TextUtils;

import android.view.View;
import android.view.ViewGroup;


import android.widget.ImageView;


import android.widget.TextView;

import com.jcodecraeer.xrecyclerview.XRecyclerView;


import com.lidroid.xutils.BitmapUtils;


import java.util.List;

/**
 * 类描述:
 * 作者：陈文梦
 * 时间:2017/2/18 16:12
 * 邮箱:18310832074@163.com
 */

public
class
MyAdapter  extends XRecyclerView.Adapter<XRecyclerView.ViewHolder>{


    private List<Bean.Data> dataBeanList;
    private Context context;
    private int LARGE_PIC = 0;
    private int ONLY_TEXT = 1;
    private int RIGHT_PIC = 2;
    private int THREE_PIC = 3;

    public MyAdapter(List<Bean.Data> dataBeanList, Context context) {
        this.dataBeanList = dataBeanList;
        this.context = context;
    }

    @Override
    public XRecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        switch (viewType){
            case 1:
                MiddleViewHolder middleViewHolder=new MiddleViewHolder
                        (View.inflate(context,R.layout.xlistview_item_right_pic,null));
                return middleViewHolder;
            case 2:
                TextViewHolder textViewHolder=new TextViewHolder
                        (View.inflate(context,R.layout.xlistview_item_only_text,null));
                return textViewHolder;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(XRecyclerView.ViewHolder holder, int position) {

        switch (getItemViewType(position)){
            case 1:
                MiddleViewHolder middleViewHolder= (MiddleViewHolder) holder;
                middleViewHolder.textView.setText(dataBeanList.get(position).title);
                new BitmapUtils(context).display(middleViewHolder.imageView,dataBeanList.get(position).middle_image.url);
                break;
            case 2:
                TextViewHolder textViewHolder= (TextViewHolder) holder;
                textViewHolder.textView.setText(dataBeanList.get(position).title);
                break;
        }

    }

    @Override
    public int getItemCount() {
        return dataBeanList.size();
    }

    @Override
    public int getItemViewType(int position) {

        if (dataBeanList.get(position).has_image) {
            if (!TextUtils.isEmpty(dataBeanList.get(position).middle_image.url)) {

                return RIGHT_PIC;
            }
        } else
        {

            return ONLY_TEXT;
        }

        return 1;
    }

    class MiddleViewHolder extends XRecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView;


        public MiddleViewHolder(View itemView) {
            super(itemView);
            imageView= (ImageView) itemView.findViewById(R.id.right_pic_image);
            textView= (TextView) itemView.findViewById(R.id.right_pic_textview);
        }
    }
    class TextViewHolder extends XRecyclerView.ViewHolder{

        TextView textView;
        public TextViewHolder(View itemView) {
            super(itemView);
            textView= (TextView) itemView.findViewById(R.id.only_text_textview);

        }
    }


}
