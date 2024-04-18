package ckflying.jieqi.core.statebiz;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.statemachine.StateMachine;

public interface MyStateMachineBuilder<S, E> {

    String getName();

    StateMachine<S, E> build() throws Exception;
}
