/*
 * This file is generated by jOOQ.
*/
package DBlorg.tables.pojos;


import java.io.Serializable;

import javax.annotation.Generated;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.0"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class QaOptions implements Serializable {

    private static final long serialVersionUID = -781432989;

    private String title;
    private String content;

    public QaOptions() {}

    public QaOptions(QaOptions value) {
        this.title = value.title;
        this.content = value.content;
    }

    public QaOptions(
        String title,
        String content
    ) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("QaOptions (");

        sb.append(title);
        sb.append(", ").append(content);

        sb.append(")");
        return sb.toString();
    }
}