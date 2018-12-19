package com.ble.bledemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ble.bledemo.adapter.BluetoothListAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BluetoothListActivity extends AppCompatActivity {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    private BluetoothListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth_list);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {

        adapter = new BluetoothListAdapter(this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (adapter !=  null){
            adapter = null;
        }
    }
}
