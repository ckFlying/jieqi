package ckflying.jieqi.core.statebiz;

import org.springframework.statemachine.guard.Guard;

import java.lang.reflect.ParameterizedType;

public abstract class MyGuard<S, E, O extends MyMessageDto<S>> {

    public abstract boolean check(S source, S target, E e, O o);

    public Guard<S, E> guard(){
        return context -> {
            ParameterizedType superClass = (ParameterizedType) getClass().getGenericSuperclass();
            Class<O> type = (Class<O>) superClass.getActualTypeArguments()[2];
            O mm = (O) context.getMessageHeader(type.getName());
            return check(context.getSource().getId(), context.getTarget().getId(), context.getEvent(), mm);
        };
    }
}
