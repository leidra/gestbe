package net.leidra.gestbe.customer.customer.infrastructure.controller.bus;

import lombok.AllArgsConstructor;
import net.leidra.gestbe.shared.application.Query;
import net.leidra.gestbe.shared.application.QueryBus;
import net.leidra.gestbe.shared.application.QueryHandler;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public final class SyncQueryBus implements QueryBus {
    private final QueryHandlerHolder holder;

    @Override
    public <R, T extends Query<R>> R dispatch(final T query) {
        final QueryHandler<T, R> queryHandler = holder.resolve((Class<T>) query.getClass());
        return queryHandler.handle(query);
    }
}
