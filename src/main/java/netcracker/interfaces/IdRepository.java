package netcracker.interfaces;

public interface IdRepository<T extends IdEntity> extends IRepository<T> {

    void delete(String id);
}
