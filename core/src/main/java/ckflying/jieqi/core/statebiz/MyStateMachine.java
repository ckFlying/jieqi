package ckflying.jieqi.core.statebiz;

import org.springframework.messaging.Message;
import org.springframework.statemachine.ExtendedState;
import org.springframework.statemachine.state.State;
import org.springframework.statemachine.support.AbstractStateMachine;
import org.springframework.statemachine.transition.Transition;

import java.util.Collection;
import java.util.UUID;

public class MyStateMachine <S, E> extends AbstractStateMachine<S, E> {
    public MyStateMachine(Collection<State<S, E>> states, Collection<Transition<S, E>> transitions, State<S, E> initialState) {
        super(states, transitions, initialState);
    }

    public MyStateMachine(Collection<State<S, E>> states, Collection<Transition<S, E>> transitions, State<S, E> initialState, Transition<S, E> initialTransition, Message<E> initialEvent, ExtendedState extendedState, UUID uuid) {
        super(states, transitions, initialState, initialTransition, initialEvent, extendedState, uuid);
    }


}
