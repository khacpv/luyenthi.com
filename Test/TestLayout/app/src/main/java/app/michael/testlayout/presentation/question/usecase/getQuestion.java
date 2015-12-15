package app.michael.testlayout.presentation.question.usecase;

import app.michael.testlayout.domain.usecase.UseCase;
import rx.Observable;
import rx.Scheduler;

/**
 * Created by michael on 11/30/15.
 */
public class getQuestion extends UseCase {
    protected getQuestion(Scheduler threadExecutor, Scheduler postExecutionThread) {
        super(threadExecutor, postExecutionThread);
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return null;
    }
}
