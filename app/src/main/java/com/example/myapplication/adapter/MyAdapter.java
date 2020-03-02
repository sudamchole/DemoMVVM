package com.example.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.databinding.MyListBinding;
import com.example.myapplication.viewmodel.MyListViewModel;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private ArrayList<MyListViewModel>arrayList;
    private Context context;
    private LayoutInflater layoutInflater;

    public MyAdapter(ArrayList<MyListViewModel> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layoutInflater==null){
            layoutInflater=LayoutInflater.from(parent.getContext());
        }
        MyListBinding myListBinding= DataBindingUtil.inflate(layoutInflater, R.layout.mylist,parent,false);
        return new ViewHolder(myListBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MyListViewModel myListViewModel=arrayList.get(position);
        holder.bind(myListViewModel);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private MyListBinding myListBinding;
        public ViewHolder(@NonNull MyListBinding myListBinding) {
            super(myListBinding.getRoot());
            this.myListBinding=myListBinding;
        }
        public void bind(MyListViewModel myli){
            this.myListBinding.setMylistmodel(myli);
            myListBinding.executePendingBindings();
        }
        public MyListBinding getMyListBinding(){
            return myListBinding;
        }
    }
}
