package bbc.sdg.sdgapp;

import android.content.Context;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

/**
 * Created by Belal on 10/18/2017.
 */


public class GoalsAdapter extends RecyclerView.Adapter<GoalsAdapter.ProductViewHolder> {


    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the products in a list
    private List<ImageList> productList;

    //getting the context and product list with constructor
    public GoalsAdapter(Context mCtx, List<ImageList> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.list_goals, null);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        //getting the product of the specified position
        ImageList product = productList.get(position);

        //binding the data with the viewholder views
        Glide.with(mCtx).load(product.getImage()).thumbnail(0.5f).diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.imageView);

   //     holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(product.getImage()));

    }


    @Override
    public int getItemCount() {
        return productList.size();
    }


    class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textViewTitle, textViewShortDesc, textViewRating, textViewPrice;
        ImageView imageView;

        public ProductViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.goalsImage);
            imageView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (view.getId() == imageView.getId()) {
                Intent callIntent = new Intent(mCtx, DetailsActivity.class);
             //  callIntent.putExtra("msg", String.valueOf(imageView.get));
                mCtx.startActivity(callIntent);

            }
        }
    }
}