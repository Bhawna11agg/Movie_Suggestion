package com.example.movie_app;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;


import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {

    private Context mContext;
    private List<modal_movie> movieList;

    public MovieAdapter(Context mContext, List<modal_movie> movieList){
        this.mContext = mContext;
        this.movieList = movieList;
    }

    @Override
    public MovieAdapter.MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i){
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.movie_card, viewGroup, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MovieAdapter.MyViewHolder viewHolder, int i){
      //  String vote = Double.toString(movieList.get(i).getVoteAverage());
      //  viewHolder.voteAverage.setText("Ratings: "+vote);
        String poster = "https://image.tmdb.org/t/p/w500" + movieList.get(i).getPosterPath();

        Glide.with(mContext)
                .load(poster)
                .into(viewHolder.thumbnail);

    }

    @Override
    public int getItemCount(){
        return movieList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView voteAverage,releaseDate,adult;
        public ImageView thumbnail;

        public MyViewHolder(View view){
            super(view);
           // voteAverage= (TextView) view.findViewById(R.id.voteAverage);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);

            view.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION){
                        int id = movieList.get(pos).getId();
                        Intent intent = new Intent(mContext, MovieDetail.class);
                        intent.putExtra("movies",id );
                        mContext.startActivity(intent);
                    }
                }
            });
        }
    }
}
