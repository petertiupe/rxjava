package de.tiupe.rxjava;

import de.tiupe.rxjava.entity.Article;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

public class SecondExample {
    public Observable<Article> getObservable() {
        return Observable.create(emitter -> {
            try {
                emitter.onNext(new Article("Der kleine Prinz", 20.0));
                emitter.onNext(new Article("Der Name der Rose", 15.20));
                emitter.onNext(new Article("Struwelpeter", 9.99));
            } catch(Exception ex){
                emitter.onError(ex);
            }
        });
    }

    public Observer<Article> getObserver() {
        return new Observer<>() {
            @Override
            public void onSubscribe(@NonNull Disposable disposable) {
                System.out.println("Es geht los mit den Büchern");
            }

            @Override
            public void onNext(@NonNull Article article) {
                System.out.println("Das folgende Buch kam: " + article.toString());
            }

            @Override
            public void onError(@NonNull Throwable throwable) {
                System.out.println("Fehler aufgetreten: ");
                throwable.printStackTrace(System.out);
            }

            @Override
            public void onComplete() {
                System.out.println("Das waren alle Bücher");
            }
        };
    }
}
