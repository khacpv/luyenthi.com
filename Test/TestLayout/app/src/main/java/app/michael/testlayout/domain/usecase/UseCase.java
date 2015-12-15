package app.michael.testlayout.domain.usecase;

import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
import rx.subscriptions.Subscriptions;

/**
 * Created by michael on 11/30/15.
 */
public abstract class UseCase {

    private final Scheduler threadExecutor;
    private final Scheduler postExecutionThread;

    private Subscription subscription = Subscriptions.empty();

    protected UseCase(Scheduler threadExecutor,
                      Scheduler postExecutionThread) {
        this.threadExecutor = threadExecutor;
        this.postExecutionThread = postExecutionThread;
    }

    /**
     * Builds an {@link rx.} which will be used when executing the current {@link UseCase}.
     */
    protected abstract Observable buildUseCaseObservable();

    /**
     * Executes the current use case.
     *
     * @param useCaseSubscriber The guy who will be listen to the observable build with {@link #buildUseCaseObservable()}.
     */
    @SuppressWarnings("unchecked")
    public void execute(Subscriber useCaseSubscriber) {
        this.subscription = this.buildUseCaseObservable()
                .subscribeOn(threadExecutor)
                .observeOn(postExecutionThread)
                .subscribe(useCaseSubscriber);
    }

    /**
     * Unsubscribes from current {@link rx.Subscription}.
     */
    public void unsubscribe() {
        if (!subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }
}
