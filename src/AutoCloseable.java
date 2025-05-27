public interface AutoCloseable {

    public default void close() throws Exception {
        this.session.close();
        this.factory.close();
    }

}
