package ckflying.jieqi.core.statebiz;

import lombok.Data;

@Data
public class MyMessageDto<S> {

    private S status;
}
