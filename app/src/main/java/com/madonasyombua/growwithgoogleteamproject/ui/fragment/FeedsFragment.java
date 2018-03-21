package com.madonasyombua.growwithgoogleteamproject.ui.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.madonasyombua.growwithgoogleteamproject.R;
import com.madonasyombua.growwithgoogleteamproject.adapter.FeedsAdapter;
import com.madonasyombua.growwithgoogleteamproject.models.Post;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link FeedsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FeedsFragment extends Fragment{
    private OnFragmentInteractionListener mListener;

    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;
    @BindView(R.id.swipeRefresh) SwipeRefreshLayout mSwipeRefreshLayout;
    @BindView(R.id.add_feeds) FloatingActionButton fab;
    @BindView(R.id.base) CoordinatorLayout coordinatorLayout;
    @BindView(R.id.displayEmpty)TextView displayEmpty;

    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private ArrayList<Post> mPosts;
    //private RequestQueue requestQueue;

    //private PrettyTime prettyTime;

    private String stringStart, stringNewPost, stringPostingAs;

    public FeedsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment FeedFragment.
     */
    public static FeedsFragment newInstance() {
        FeedsFragment fragment = new FeedsFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPosts = new ArrayList<>();


        stringStart = getResources().getString(R.string.start);
        stringNewPost = getResources().getString(R.string.new_post);
        stringPostingAs = getResources().getString(R.string.posting_as);

    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_feeds, container, false);

        coordinatorLayout = (CoordinatorLayout) view.findViewById(R.id.base);

       // mSwipeRefreshLayout.setColorSchemeColors(ContextCompat.getColor(getContext(), R.color.colorAccent));


        fab.setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        showPostDialog();
                    }
                }
        );

        displayEmpty.setVisibility(View.GONE);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        // mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new FeedsAdapter(getActivity(), mPosts, new FeedsAdapter.OnItemClickListener() {
            @Override
            public void onClick(View caller) {

            }
        }, true);
        mRecyclerView.setAdapter(mAdapter);

        updateFeed();

        return view;
    }

    /**
     * Shows a dialog for writing a new post.
     */
    public void showPostDialog() {
        FragmentManager fm = getActivity().getSupportFragmentManager();
        System.out.println("fm: " + fm);
        SharedPreferences prefs = getActivity().getSharedPreferences("com.madonasyombua.growwithgoogleteamproject.ui.fragment", Context.MODE_PRIVATE);
        PostFeedFragment postDialog = PostFeedFragment.newInstance(stringNewPost, stringPostingAs,
                prefs.getString("username", ""), prefs.getString("name", ""));
        postDialog.show(fm, "fragment_post_dialog");
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }

        //((AppCompatActivity)(context)).getSupportActionBar().setTitle(getString(R.string.feeds));

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }


    /**
     * Updates the user's feed and populates the cards.
     */
    public void updateFeed() {
      //will work on this
    }


}