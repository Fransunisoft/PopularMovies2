package com.fransunisoft.popularmovies.Adapters;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.fransunisoft.popularmovies.Fragments.MovieDetailsActivityFragment;
import com.fransunisoft.popularmovies.R;




public class ReviewsAdapter extends
        CursorAdapter {

    private Context mContext;
    public ReviewsAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
        mContext = context;
    }


    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {

        View view = LayoutInflater.from(context).inflate(R.layout.list_reviews_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        view.setTag(viewHolder);
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ViewHolder viewHolder = (ViewHolder) view.getTag();

        String author = cursor.getString(MovieDetailsActivityFragment.COL_AUTHOR);
        String content = cursor.getString(MovieDetailsActivityFragment.COL_CONTENT);

        viewHolder.authorTextView.setText(author + ": ");
        viewHolder.contentTextView.setText(content);
    }

    public static class ViewHolder {
        public final TextView authorTextView;
        public final TextView contentTextView;

        public ViewHolder(View vi) {
            authorTextView  = (TextView)vi.findViewById(R.id.textview_author);
            contentTextView = (TextView)vi.findViewById(R.id.textview_content);
        }
    }
}

