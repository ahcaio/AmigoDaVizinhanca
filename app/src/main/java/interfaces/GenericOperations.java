package interfaces;

public interface GenericOperations<T,N> {

    T create(T entity);
    T read(T entity) throws Exception;
    T readById(N id) throws Exception;

    T update(T entity) throws Exception;
    T updatePart(N id, T entity) throws Exception;
    T updateFull(N id, T entity) throws Exception;

    void deleteByEntity(T entity) throws Exception;
    void delete(N id) throws Exception;

}
