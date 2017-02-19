package co.bwie.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.support.v7.widget.LinearLayoutManager;


import com.google.gson.Gson;


import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.lidroid.xutils.HttpUtils;


import com.lidroid.xutils.exception.HttpException;


import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;


import java.util.ArrayList;

import java.util.List;

public
class
MainActivity extends AppCompatActivity {

    String path = "http://ic.snssdk.com/2/article/v25/stream/?count=20&min_behot_time=1457684204&bd_latitude=4.9E-324&bd_longitude=4.9E-324&bd_loc_time=1457672153&loc_mode=5&lac=4527&cid=28883&iid=3839760160&device_id=12246291682&ac=wifi&channel=baidu&aid=13&app_name=news_article&version_code=460&device_platform=android&device_type=iToolsAVM&os_version=4.4.4&uuid=352284045861006&openudid=84c1c7b192991cc6";
    List<Bean.Data> dataBeanList = new ArrayList<>();
    private XRecyclerView xRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        xRecyclerView = (XRecyclerView) findViewById(R.id.xrecyclerview);
        xRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        xRecyclerView.setLoadingMoreEnabled(true);
        xRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {

            @Override
            public void onRefresh() {

            }

            @Override
            public void onLoadMore() {

            }
        });
        getdate();

    }

    public void getdate() {

        new HttpUtils().send(HttpRequest.HttpMethod.GET, path, new RequestCallBack<String>() {

            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {


                String result = responseInfo.result;

                Bean bean = new Gson().fromJson(result, Bean.class);
                dataBeanList.addAll(bean.data);
                dataBeanList.addAll(dataBeanList);
                MyAdapter myAdapter = new MyAdapter(dataBeanList, MainActivity.this);
                xRecyclerView.setAdapter(myAdapter);
            }

            @Override
            public void onFailure(HttpException e, String s) {

            }
        });

    }
}
