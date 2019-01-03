package com.ble.bledemo.adapter;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ble.bledemo.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 作者：lch
 * 时间：2018/12/18 0018:下午 22:37
 * 邮箱：245850413@qq.com
 * 说明：
 */
public class BluetoothListAdapter extends RecyclerView.Adapter<BluetoothListAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private List<BluetoothDevice> datas;

    public BluetoothListAdapter(Context context) {
        inflater = LayoutInflater.from(context);
        datas = new ArrayList<>();
    }

    public void updateData(BluetoothDevice device) {
        if (!datas.contains(device)){
            datas.add(device);
            notifyDataSetChanged();
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.recycler_view_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        String name = datas.get(position).getName();
        String address = datas.get(position).getAddress();
        if (!TextUtils.isEmpty(address)){
            holder.addressTv.setText(address);
        }else {
            holder.addressTv.setText("--");
        }

        if (!TextUtils.isEmpty(name)){
            holder.nameTv.setText(name);
        }else {
            holder.nameTv.setText("未知的设备");
        }
    }

    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.name_tv)
        TextView nameTv;
        @BindView(R.id.address_tv)
        TextView addressTv;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
