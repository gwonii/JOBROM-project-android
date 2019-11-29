package com.gmail.gwonii.jobrom.ui.explore;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gmail.gwonii.jobrom.R;
import com.gmail.gwonii.jobrom.controller.AppHelper;
import com.gmail.gwonii.jobrom.controller.CardStackAdapter;
import com.gmail.gwonii.jobrom.controller.JobListAdapter;
import com.gmail.gwonii.jobrom.controller.SpotDiffCallback;
import com.gmail.gwonii.jobrom.model.CardStackModel;
import com.gmail.gwonii.jobrom.model.JobListModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.FirebaseDatabase;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackListener;
import com.yuyakaido.android.cardstackview.CardStackView;
import com.yuyakaido.android.cardstackview.Direction;
import com.yuyakaido.android.cardstackview.Duration;
import com.yuyakaido.android.cardstackview.RewindAnimationSetting;
import com.yuyakaido.android.cardstackview.StackFrom;
import com.yuyakaido.android.cardstackview.SwipeAnimationSetting;
import com.yuyakaido.android.cardstackview.SwipeableMethod;
import com.yuyakaido.android.cardstackview.internal.AnimationSetting;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ExploreFragment extends Fragment implements CardStackListener {


//    private ArrayList<JobModel> jobArrayList;
    private ArrayList<JobListModel> jobListModelArrayList;
    private JobListAdapter jobAdapter;



    private View root;

    // cardstack 관련 부분
    private ArrayList<CardStackModel> cardStackModels;

    private CardStackLayoutManager cardStackLayoutManager;
    private CardStackAdapter cardStackAdapter;
    private RecyclerView jobRecyclerView;
    private CardStackView cardStackView;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        root = inflater.inflate(R.layout.fragment_explore, container, false);

        cardStackModels = new ArrayList<>();

        cardStackModels.addAll(createCards());

        cardStackLayoutManager = new CardStackLayoutManager(getContext(),this);
        cardStackView = root.findViewById(R.id.card_stack_view);
        cardStackAdapter = new CardStackAdapter(cardStackModels);

//        cardStackView = root.findViewById(R.id.card_stack_view);
//        cardStackView.setLayoutManager(new CardStackLayoutManager(getContext()));
//        cardStackView.setAdapter(new CardStackAdapter());


/*
        // database 연결하기
        AppHelper.databaseJob = FirebaseDatabase.getInstance().getReference();

        // recyclerView 연결하기
//        jobRecyclerView = root.findViewById(R.id.recycler_result_list);
//        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(this.getContext());
//        jobRecyclerView.setLayoutManager(mLinearLayoutManager);

        // ArrayList 생성
//        jobArrayList = new ArrayList<>();
        jobListModelArrayList = new ArrayList<>();

        //  Adapter 생성및 설정
        jobAdapter = new JobListAdapter(jobListModelArrayList);

//        jobRecyclerView.setAdapter(jobAdapter);


        //swip 하는 부분

        CardStackView cardStackView = root.findViewById(R.id.card_stack_view);

//        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(this.getContext());

        CardStackLayoutManager cardStackLayoutManager = new CardStackLayoutManager(this.getContext());

        cardStackView.setLayoutManager(cardStackLayoutManager);
        cardStackView.setAdapter(jobAdapter);


        SwipeAnimationSetting swipeAnimationSetting = new SwipeAnimationSetting.Builder()
                .setDirection(Direction.Right)
                .setDuration(Duration.Normal.duration)
                .setInterpolator(new AccelerateInterpolator())
                .build();

        cardStackLayoutManager.setSwipeAnimationSetting(swipeAnimationSetting);
        cardStackView.swipe();


//        val cardStackView = findViewById<CardStackView>(R.id.card_stack_view)
//                cardStackView.layoutManager = CardStackLayoutManager()
//        cardStackView.adapter = CardStackAdapter()



*/

//        setupNavigation();
        setupCardStackView();
        setupButton();

        return root;
    }

    // create 부분

    private void setupNavigation() {

    }

    private void setupCardStackView() {

        initialize();
    }


    private void initialize() {



        cardStackLayoutManager.setStackFrom(StackFrom.None);
        cardStackLayoutManager.setVisibleCount(3);
        cardStackLayoutManager.setTranslationInterval(8.0f);
        cardStackLayoutManager.setScaleInterval(0.95f);
        cardStackLayoutManager.setSwipeThreshold(0.3f);
        cardStackLayoutManager.setMaxDegree(20.0f);
        cardStackLayoutManager.setDirections(Direction.HORIZONTAL);
        cardStackLayoutManager.setCanScrollHorizontal(true);
        cardStackLayoutManager.setCanScrollVertical(true);
        cardStackLayoutManager.setSwipeableMethod(SwipeableMethod.AutomaticAndManual);
        cardStackLayoutManager.setOverlayInterpolator(new LinearInterpolator());
        cardStackView.setLayoutManager(cardStackLayoutManager);
        cardStackView.setAdapter(cardStackAdapter);
        cardStackView.setItemAnimator(new DefaultItemAnimator());

//        cardStackView.layoutManager = manager
//        cardStackView.adapter = adapter
//        cardStackView.itemAnimator.apply {
//            if (this is DefaultItemAnimator) {
//                supportsChangeAnimations = false
//            }
//        }
    }

    private void setupButton() {

        FloatingActionButton likeButton;
        FloatingActionButton unlikeButton;
        FloatingActionButton rewindButton;

        likeButton = root.findViewById(R.id.like_button);
        unlikeButton = root.findViewById(R.id.skip_button);
        rewindButton = root.findViewById(R.id.rewind_button);

        unlikeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SwipeAnimationSetting setting = new SwipeAnimationSetting.Builder()
                        .setDirection(Direction.Left)
                        .setDuration(Duration.Normal.duration)
                        .setInterpolator(new AccelerateInterpolator())
                        .build();

                cardStackLayoutManager.setSwipeAnimationSetting(setting);
                cardStackView.swipe();
            }
        });

        likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SwipeAnimationSetting setting = new SwipeAnimationSetting.Builder()
                        .setDirection(Direction.Right)
                        .setDuration(Duration.Normal.duration)
                        .setInterpolator(new AccelerateInterpolator())
                        .build();

                cardStackLayoutManager.setSwipeAnimationSetting(setting);
                cardStackView.swipe();
            }
        });

        rewindButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RewindAnimationSetting setting = new RewindAnimationSetting.Builder()
                        .setDirection(Direction.Bottom)
                        .setDuration(Duration.Normal.duration)
                        .setInterpolator(new DecelerateInterpolator())
                        .build();

                cardStackLayoutManager.setRewindAnimationSetting(setting);
                cardStackView.rewind();
            }
        });
    }

    private void paginate() {
        ArrayList<CardStackModel> oldCards = cardStackAdapter.getCards();
        ArrayList<CardStackModel> plusCards = createCards();
        oldCards.addAll(plusCards);
        ArrayList<CardStackModel> newCards = oldCards;
        SpotDiffCallback callback = new SpotDiffCallback(oldCards,newCards);
        DiffUtil.DiffResult result = DiffUtil.calculateDiff(callback);
        cardStackAdapter.setCards(newCards);
        result.dispatchUpdatesTo(cardStackAdapter);

    }

    private void reload() {

    }

    private void addFirst() {

    }

    private void addLast() {

    }

    private void removeFirst() {

    }

    private void removeLast() {

    }

    private void replace() {

    }

    private void swap() {

    }

    private ArrayList<CardStackModel> createCards() {

        ArrayList<CardStackModel> cards = new ArrayList<>();

        cards.add(new CardStackModel(1,"Yasaka Shrine", "Kyoto", "https://source.unsplash.com/Xq1ntWruZQI/600x800"));
        cards.add(new CardStackModel(2, "Fushimi Inari Shrine","Kyoto",  "https://source.unsplash.com/NYyCqdBOKwc/600x800"));
        cards.add(new CardStackModel(3,"Bamboo Forest",  "Kyoto",  "https://source.unsplash.com/buF62ewDLcQ/600x800"));
        cards.add(new CardStackModel(4,"Brooklyn Bridge", "New York", "https://source.unsplash.com/THozNzxEP3g/600x800"));
        cards.add(new CardStackModel(5,"Empire State Building", "New York","https://source.unsplash.com/USrZRcRS2Lw/600x800"));
        cards.add(new CardStackModel(6,"The statue of Liberty","New York","https://source.unsplash.com/PeFk7fzxTdk/600x800"));
        cards.add(new CardStackModel(7,"Louvre Museum",  "Paris",  "https://source.unsplash.com/LrMWHKqilUw/600x800"));
        cards.add(new CardStackModel(8,"Eiffel Tower",  "Paris",  "https://source.unsplash.com/HN-5Z6AmxrM/600x800"));
        cards.add(new CardStackModel(9,"Big Ben",  "London", "https://source.unsplash.com/CdVAUADdqEc/600x800"));
        cards.add(new CardStackModel(10, "Great Wall of China", "China", "https://source.unsplash.com/AWh9C-QjhE4/600x800"));

        return cards;
    }

    // card 기능들
    @Override
    public void onCardDragging(Direction direction, float ratio) {

        Log.d(getContext().toString(),"onCardDragging" + "direction : " + direction.name() + "ratio : " + ratio  );
    }

    @Override
    public void onCardSwiped(Direction direction) {

    }

    @Override
    public void onCardRewound() {

    }

    @Override
    public void onCardCanceled() {

    }

    @Override
    public void onCardAppeared(View view, int position) {

    }

    @Override
    public void onCardDisappeared(View view, int position) {

    }
}
