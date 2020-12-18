package com.muneiah.example.studentdirectory;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentHolder> {
    Context ctx;
    List<StudentEntity> list;

    public StudentAdapter(Context ctx, List<StudentEntity> list) {
        this.ctx = ctx;
        this.list = list;
    }

    @NonNull
    @Override
    public StudentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new StudentHolder(LayoutInflater.from(ctx).inflate(R.layout.rowdesign,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull StudentHolder holder, int position) {
        holder.name.setText(list.get(position).getName());
        holder.student_id.setText(list.get(position).getId());
        holder.d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  MainActivity.dataBase.studentDAO().deleteData(list.get(position));
                MainActivity.viewModel.delete(list.get(position));
                Toast.makeText(ctx, holder.name.getText().toString()+" Deleted", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class StudentHolder extends RecyclerView.ViewHolder {
        TextView e,d,name,student_id;
        public StudentHolder(@NonNull View itemView) {
            super(itemView);
            e=itemView.findViewById(R.id.edit);
            d=itemView.findViewById(R.id.delete);
            name=itemView.findViewById(R.id.nam);
            student_id=itemView.findViewById(R.id.rollnam);
            e.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String objName=name.getText().toString();
                    String objId=student_id.getText().toString();
                    Intent intent=new Intent(ctx,UpdateActivity.class);
                    intent.putExtra("name",objName);
                    intent.putExtra("id",objId);
                    ctx.startActivity(intent);
                }
            });
        }
    }
}
