package ru.nubby.pryanikitest;

import androidx.appcompat.app.AppCompatActivity;
import io.reactivex.disposables.Disposable;
import ru.nubby.pryanikitest.domain.Repository;
import ru.nubby.pryanikitest.model.ViewType;
import ru.nubby.pryanikitest.util.BaseSchedulerProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private final String TAG = MainActivity.class.getSimpleName();

    private Repository mRepository;
    private BaseSchedulerProvider mSchedulerProvider;

    private Disposable mDisposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRepository = Injection.provideRepository();
        mSchedulerProvider = Injection.provideSchedulerProvider();

        TextView view = findViewById(R.id.test);
        view.setOnClickListener(v -> mDisposable = mRepository
                .getData()
                .subscribeOn(mSchedulerProvider.io())
                .observeOn(mSchedulerProvider.ui())
                .subscribe(result -> {
                    for (ViewType vt: result.getData()) {
                        Log.d(TAG, vt.getName());
                    }
                    for (String views: result.getView()) {
                        Log.d(TAG, views);
                    }
                }, error -> Log.e(TAG, "Shit happened", error)));
    }
}
