package ckflying.jieqi.core.statebiz;

import org.springframework.messaging.Message;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.state.State;

import java.lang.reflect.ParameterizedType;

public class MyStateMachineListener<S, E, O> extends StateMachineListenerAdapter<S, E> {

    private ThreadLocal<O> messageThreadLocal = new ThreadLocal<>();

    @Override
    public void stateContext(StateContext<S, E> stateContext) {
        super.stateContext(stateContext);
        ParameterizedType superClass = (ParameterizedType) getClass().getGenericSuperclass();
        Class<O> type = (Class<O>) superClass.getActualTypeArguments()[2];
        messageThreadLocal.set((O) stateContext.getMessageHeader(type.getName()));
    }

    @Override
    public void stateChanged(State<S, E> from, State<S, E> to) {
        stateChanged(from, to, getMessage());
        messageThreadLocal.remove();
    }

    public void stateChanged(State<S, E> from, State<S, E> to, O o) {
    }

    @Override
    public void eventNotAccepted(Message<E> event) {
        ParameterizedType superClass = (ParameterizedType) getClass().getGenericSuperclass();
        Class<O> type = (Class<O>) superClass.getActualTypeArguments()[2];
        eventNotAccepted((O) event.getHeaders().get(type.getName()));
    }

    public void eventNotAccepted(O o) {
    }

    public O getMessage() {
        return messageThreadLocal.get();
    }
}
