package com.mart.dagger2sample.ui.main.details;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mart.dagger2sample.R;
import com.mart.dagger2sample.ui.main.MainViewModel;
import com.mart.dagger2sample.util.Message;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

public class DetailsFragment extends DaggerFragment{

    private View rootView;
    private RecyclerView rvUsers;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Inject MainViewModel mainViewModel;
    @Inject AdapterUsers adapterUsers;
    @Inject Context context;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_details, container, false);

        initViews();

        setupRecyclerView();

        swipeRefreshLayout.setOnRefreshListener(() -> mainViewModel.loadUsers()); // Swipe down to refresh

        // Subscribe to "User List" event
        mainViewModel.getUserList().observe(this, results -> {
            adapterUsers.setItems(results);
            swipeRefreshLayout.setRefreshing(false);
        });

        // Subscribe to "isLoading" event
        mainViewModel.getIsLoading().observe(this, swipeRefreshLayout::setRefreshing);

        // Subscribe to "Error Message" event
        mainViewModel.getLiveErrorMessage().observe(this, errorMessage -> {
            assert errorMessage != null;
            Message.showToast(context, errorMessage.getMessage());
        });

        return rootView;
    }

    private void initViews(){
        rvUsers = rootView.findViewById(R.id.rv_users);
        swipeRefreshLayout = rootView.findViewById(R.id.swipe_refresh);
    }

    private void setupRecyclerView() {
        rvUsers.setLayoutManager(new LinearLayoutManager(context));
        rvUsers.addItemDecoration(new DividerItemDecoration(context, DividerItemDecoration.VERTICAL));
        rvUsers.setAdapter(adapterUsers);
    }

}
