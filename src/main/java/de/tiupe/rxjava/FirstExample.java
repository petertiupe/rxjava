package de.tiupe.rxjava;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;

public class FirstExample {

    public Observable<Integer> getObservable() {
        return Observable
                .just(1, 2, 3, 4, 5)
                .filter(integer -> integer % 2 != 0);
    }

    public Observer<Integer> getObserver() {
        return new Observer<>() {
            @Override
            public void onSubscribe(@NonNull Disposable disposable) {
                System.out.println("Jetzt geht es los...");
                System.out.println("isDisposed: " + disposable.isDisposed());
            }

            @Override
            public void onNext(@NonNull Integer integer) {
                System.out.println("Es wurden die folgenden Daten empfangen: " + integer);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                System.out.println("Der folgende Fehler wurde empfangen: " + e.getMessage() );
            }

            @Override
            public void onComplete() {
                System.out.println("Alle Daten wurden emittiert, Observable liefert nichts mehr ...");
            }
        };
    }



}
