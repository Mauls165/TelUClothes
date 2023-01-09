package com.example.fe_impal;
/**
 *

import com.bumtech.glide.Glide;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.BreakIterator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context context;
    private List<KatalogModel> KatalogModelList;
    private ICartLoadListener iCartLoadListener;

    public MyAdapter(Context context, List<KatalogModel> katalogModelList, ICartLoadListener iCartLoadListener) {
        this.context = context;
        this.KatalogModelList = katalogModelList;
        this.iCartLoadListener = iCartLoadListener;
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context)
                .inflate(R.layout.my_row,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Glide.with(context)
                .load(KatalogModelList.get(position).getImage())
                .into(holder.imageView);
        holder.harga.setText(new StringBuilder("IDR").append(KatalogModelList.get(position).getPrice()));
        holder.nameitem.setText(new StringBuilder("").append(KatalogModelList.get(position).getName()));

        holder.setListener((view, adapterPosition) -> {
            addToCart(KatalogModelList.get(position));
        });
    }
    private void addToCart(KatalogModel CartModel) {
        DatabaseReference userCart = FirebaseDatabase
                .getInstance()
                .getReference("Cart")
                .child("UNIQUE_USER_ID");
        userCart.child(CartModel.getKey())
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.exists()){
                            CartModel cartModels = snapshot.getValue(CartModel.class);
                            cartModels.setQuantity(cartModels.getQuantity()+1);
                            Map<String,Object> updateData = new HashMap<>();
                            updateData.put("quantity",cartModels.getQuantity());
                            updateData.put("total price",cartModels.getQuantity()*Float.parseFloat(cartModels.getPrice()));

                            userCart.child(CartModel.getKey())
                                    .updateChildren(updateData)
                                    .addOnSuccessListener(unused -> {
                                        iCartLoadListener.onCartLoadFailed("Add To Cart Succes");
                                    })
                                    .addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            iCartLoadListener.onCartLoadFailed(e.getMessage());
                                        }
                                    });

                        }
                        else {
                            CartModel cartModel = new CartModel();
                            cartModel.setName(CartModel.getName());
                            cartModel.setImage(CartModel.getImage());
                            cartModel.setKey(CartModel.getKey());
                            cartModel.setPrice(CartModel.getPrice());
                            cartModel.setQuantity(1);
                            cartModel.setTotalPrice(Float.parseFloat(CartModel.getPrice()));

                            userCart.child(CartModel.getKey())
                                    .setValue(cartModel)
                                    .addOnSuccessListener(unused -> {
                                        iCartLoadListener.onCartLoadFailed("Add To Cart Succes");
                                    })
                                    .addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            iCartLoadListener.onCartLoadFailed(e.getMessage());
                                        }
                                    });


                        }
                        EventBus.getDefault().postSticky(new UpdateCartEvent());


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        iCartLoadListener.onCartLoadFailed(error.getMessage());
                    }
                });
    }
    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView harga, nameitem;
        ImageView imageView;
        ImageView addtocartbtn;

        IRecyclerViewClickListener listener;

        public void setListener(IRecyclerViewClickListener listener) {
            this.listener = listener;
        }
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            unbinder = ButterKnife.bind(this, itemView);
            addtocartbtn.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

        }
    }
}*/
