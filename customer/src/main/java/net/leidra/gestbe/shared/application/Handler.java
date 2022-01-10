package net.leidra.gestbe.shared.application;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public interface Handler {
    default Type getType() {
        return ((ParameterizedType) getClass().getGenericInterfaces()[0]).getActualTypeArguments()[0];
    }

}
