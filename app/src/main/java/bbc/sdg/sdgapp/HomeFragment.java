package bbc.sdg.sdgapp;
import android.content.Intent;
import android.graphics.Movie;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
public class HomeFragment extends Fragment {

    public HomeFragment(){
        // require a empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RecyclerView recyclerView;
        List<ImageList> productList;
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        productList = new ArrayList<>();
        // Add the following lines to create RecyclerView
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
       // recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
       recyclerView.setLayoutManager(new GridLayoutManager(view.getContext(),4));
        //adding some items to our list
       // productList.add(new ImageList(R.drawable.sdggoal1));
        productList.add(new ImageList(R.drawable.sdggoal1));
        productList.add(new ImageList(R.drawable.g2));
        productList.add(new ImageList(R.drawable.g3));
        productList.add(new ImageList(R.drawable.g4));
        productList.add(new ImageList(R.drawable.g5));
        productList.add(new ImageList(R.drawable.g6));
        productList.add(new ImageList(R.drawable.g7));
        productList.add(new ImageList(R.drawable.g8));
        productList.add(new ImageList(R.drawable.g9));
        productList.add(new ImageList(R.drawable.g10));
        productList.add(new ImageList(R.drawable.g11));
        productList.add(new ImageList(R.drawable.g12));
        productList.add(new ImageList(R.drawable.g13));
        productList.add(new ImageList(R.drawable.g14));
        productList.add(new ImageList(R.drawable.g15));
        productList.add(new ImageList(R.drawable.g16));
        productList.add(new ImageList(R.drawable.g17));

        //creating recyclerview adapter
        GoalsAdapter adapter = new GoalsAdapter(getContext(), productList);
        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);
       // recyclerView.addOnItemTouchListener(new OnRec);




//recyclerView.addOnItemTouchListener(new RecyclerTouchListener(new RecyclerTouchListener(AdapterView.OnItemClickListener))
/*

        break;
*/
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {


                switch (position) {
                    case 0: {
                        Intent i = new Intent(getActivity(), DetailsActivity.class);
                       i.putExtra("key", "fragment_g1.xml");
                        startActivity(i);
                        break;
                    }

                    case 1: {
                        Intent i = new Intent(getActivity(), MainActivity.class);
                       i.putExtra("key", "fragment_g2.xml");
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