package bbc.sdg.sdgapp;

import android.content.Context;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * Created by Belal on 10/18/2017.
 */


public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ProductViewHolder> {


    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the products in a list
    private List<ImageList> productList;

    //getting the context and product list with constructor
    public NewsAdapter(Context mCtx, List<ImageList> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.list_news, null);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        //getting the product of the specified position
        ImageList product = productList.get(position);

        //binding the data with the viewholder views

        holder.newsImage.setImageDrawable(mCtx.getResources().getDrawable(product.getImage()));
        holder.newsTitle.setText(product.getNewsTitle());
        holder.newsDate.setText(product.getNewsDate());

    }


    @Override
    public int getItemCount() {
        return productList.size();
    }


    class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView newsTitle, newsDate;
        ImageView newsImage;
        

        public ProductViewHolder(View itemView) {
            super(itemView);
            newsImage = itemView.findViewById(R.id.newsImage);
            newsTitle = itemView.findViewById(R.id.newsTitle);
            newsDate = itemView.findViewById(R.id.newsDate);
            itemView.setOnClickListener(this);
            
        }

        @Override
        public void onClick(View view) {
            if (view.getId() == view.getId()) {

                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                Fragment myFragment = new NewsDetail();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, myFragment).addToBackStack(null).commit();
            }
        }
    }

}