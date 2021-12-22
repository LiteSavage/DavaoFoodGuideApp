package com.example.davaofoodguide;

import static com.example.davaofoodguide.DBmain.TABLENAME;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    Context context;
    int singledata;
    ArrayList<Model>modelArrayList;
    SQLiteDatabase sqLiteDatabase;


    //generate constructor

    public MyAdapter(Context context, int singledata, ArrayList<Model> modelArrayList, SQLiteDatabase sqLiteDatabase) {
        this.context = context;
        this.singledata = singledata;
        this.modelArrayList = modelArrayList;
        this.sqLiteDatabase = sqLiteDatabase;
    }



    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.singledata,null);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        final Model model = modelArrayList.get(position);
        byte[]image = model.getProavatar();
        Bitmap bitmap = BitmapFactory.decodeByteArray(image,0, image.length);
        holder.imageavatar.setImageBitmap(bitmap);
        holder.txtname.setText(model.getUsername());
        holder.txtname2.setText(model.getDessy());
        holder.txtname3.setText(model.getLinkz());





        //flow menu

        holder.flowmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PopupMenu popupMenu = new PopupMenu(context, holder.flowmenu);
                popupMenu.inflate(R.menu.flow_menu);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.edit_menu:

                                //edit operation
                        Bundle bundle = new Bundle();
                        bundle.putInt("id", model.getId());
                        bundle.putByteArray("avatar",model.getProavatar());
                        bundle.putString("name",model.getUsername());
                        bundle.putString("dessy",model.getDessy());
                        bundle.putString("linkz",model.getLinkz());
                        Intent intent = new Intent(context,foodadd.class);
                        intent.putExtra("userdata", bundle);
                        context.startActivity(intent);


                            break;

                            case R.id.delete_menu:

                                //delete operation
                                DBmain dBmain = new DBmain(context);
                                sqLiteDatabase = dBmain.getReadableDatabase();
                                long recdelete = sqLiteDatabase.delete(TABLENAME, "id="+ model.getId(),null);

                                if (recdelete != -1) {
                                    Toast.makeText(context, "data deleted", Toast.LENGTH_SHORT).show();

                                    //remove position after deleted
                                    modelArrayList.remove(position);
                                    //update data
                                    notifyDataSetChanged();

                                }


                                break;
                            default:
                                return false;
                        }


                        return false;
                    }
                });

                //display menu
                popupMenu.show();

            }
        });

    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView imageavatar;
        TextView txtname;
        TextView txtname2;
        TextView txtname3;
        ImageButton flowmenu;



                
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageavatar=(ImageView)itemView.findViewById(R.id.viewavatar);
            txtname=(TextView) itemView.findViewById(R.id.txt_name);
            txtname2=(TextView) itemView.findViewById(R.id.txt_name2);
            txtname3=(TextView) itemView.findViewById(R.id.txt_name3);
            flowmenu=(ImageButton) itemView.findViewById(R.id.flowmenu);



            itemView.setOnClickListener(this);


        }

        @Override
        public void onClick(View v) {
           int position = getAdapterPosition();
            Toast.makeText(context, "position " + position, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(context, foodinfo.class);
            intent.putExtra("name", modelArrayList.get(position).getUsername());
            intent.putExtra("dessy", modelArrayList.get(position).getDessy());
            intent.putExtra("linkz", modelArrayList.get(position).getLinkz());
            intent.putExtra("avatar", modelArrayList.get(position).getProavatar());

            context.startActivity(intent);





        }
    }





}
