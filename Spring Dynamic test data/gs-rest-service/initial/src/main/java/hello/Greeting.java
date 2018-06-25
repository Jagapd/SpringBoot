package hello;

/**
 * The type Greeting.
 */
public class Greeting {

    private final long id;
    private final String content;

    /**
     * Instantiates a new Greeting.
     *
     * @param id      the id
     * @param content the content
     */
    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * Gets content.
     *
     * @return the content
     */
    public String getContent() {
        return content;
    }
}
