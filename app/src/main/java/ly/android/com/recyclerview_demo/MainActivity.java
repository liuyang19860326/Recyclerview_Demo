package ly.android.com.recyclerview_demo;



import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ly.android.com.recyclerview_demo.Impl.OnItemClickListener;
import ly.android.com.recyclerview_demo.adpter.HomeAdapter;
import ly.android.com.recyclerview_demo.widget.DividerGridItemDecoration;
import ly.android.com.recyclerview_demo.widget.DividerItemDecoration;

public class MainActivity extends AppCompatActivity {

private RecyclerView recyclerView;
    private List<String> mDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        initData();
    }
    private void init(){
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
//        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
//        recyclerView.setLayoutManager(new GridLayoutManager(this,5));
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));
     //设置Item增加、移除动画
        recyclerView.setItemAnimator(new DefaultItemAnimator());
      //添加分割线
        recyclerView.addItemDecoration(new DividerGridItemDecoration(this));



    }

    protected void initData(){
        mDatas = new ArrayList<String>();
        for (int i = 'A'; i < 'z'; i++)
        {
            mDatas.add("" + (char) i);
        }
        HomeAdapter adapter = new HomeAdapter(MainActivity.this,mDatas);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickLitener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(MainActivity.this, position + " click",
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, int position) {
                Toast.makeText(MainActivity.this, position + " long click",
                        Toast.LENGTH_SHORT).show();
//                adapter.removeData(position);
            }
        });
    }

}
