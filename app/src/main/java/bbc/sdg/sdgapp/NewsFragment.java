package bbc.sdg.sdgapp;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NewsFragment extends Fragment {

    public NewsFragment(){
        // require a empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RecyclerView recyclerView;
        List<ImageList> productList;
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        productList = new ArrayList<>();
        // Add the following lines to create RecyclerView
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
      //   recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setLayoutManager(new GridLayoutManager(view.getContext(),1));
        //adding some items to our list

        productList.add(new ImageList(R.drawable.ndo,"National Dialogue on Generation Equality: Translating GAP in Nepal","2021/11/20"));
        productList.add(new ImageList(R.drawable.ndd,"Bodily Autonomy and Sexual and Reproductive Health and Rights for Generation Equality","2021/11/28"));
        productList.add(new ImageList(R.drawable.three,"SDG Monitoring through community score card at local level with government representatives and community people","2021/01/21"));
            //creating recyclerview adapter
        NewsAdapter adapter = new NewsAdapter(getContext(), productList);
        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {


                switch (position) {
                    case 0: {
                        Intent i = new Intent(getActivity(), NewsDetailActivityFinal.class);
                        i.putExtra("key", "fragment_g1.xml");
                        startActivity(i);
                        break;
                    }

                    case 1: {
                        Intent i = new Intent(getActivity(), NewsDetailActivityFinal.class);
                        i.putExtra("key", "fragment_g2.xml");
                        startActivity(i);
                        break;
                    }
                    case 2: {
                        Intent i = new Intent(getActivity(), NewsDetailActivityFinal.class);
                        i.putExtra("key", "fragment_g3.xml");
                        startActivity(i);
                        break;
                    }
                }
            }
            @Override
            public void onLongClick(View view, int position) {

            }
        }));
        return view;



    }
}
