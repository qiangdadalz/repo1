package gz.itcast.entity;

/**
 * 图书分类实体类
 */
public class Types {
    private String id;
    private String name;
    private String descr;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    @Override
    public String toString() {
        return "Types{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", descr='" + descr + '\'' +
                '}';
    }
}
