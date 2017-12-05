package netcracker.interfaces;

public interface IdRepository<T extends IdEntity> extends Repository<T> {

    public void delete(String id);
}
