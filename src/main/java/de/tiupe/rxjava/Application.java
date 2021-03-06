package de.tiupe.rxjava;

import de.tiupe.rxjava.entity.Article;
import io.reactivex.Observable;
import io.reactivex.Observer;

public class Application {
    public static void main(String[] args){

        // run the first Example
        FirstExample firstExample = new FirstExample();
        Observable<Integer> myObservable = firstExample.getObservable();
        Observer<Integer> myObserver = firstExample.getObserver();
        // the observer is registered at the observable because the observable pushes the data
        myObservable.subscribe(myObserver);

        SecondExample secondExample = new SecondExample();
        Observable<Article> articleObservable = secondExample.getObservable().filter(it -> it.getPrice() > 10.0);
        Observer<Article> articleObserver = secondExample.getObserver();
        articleObservable.subscribe(articleObserver);
    }
}
