/*
 * This file is generated by jOOQ.
*/
package DBlorg.tables.pojos;


import java.io.Serializable;

import javax.annotation.Generated;

import org.jooq.types.UInteger;


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
public class QaTitlewords implements Serializable {

    private static final long serialVersionUID = 1561901617;

    private UInteger postid;
    private UInteger wordid;

    public QaTitlewords() {}

    public QaTitlewords(QaTitlewords value) {
        this.postid = value.postid;
        this.wordid = value.wordid;
    }

    public QaTitlewords(
        UInteger postid,
        UInteger wordid
    ) {
        this.postid = postid;
        this.wordid = wordid;
    }

    public UInteger getPostid() {
        return this.postid;
    }

    public void setPostid(UInteger postid) {
        this.postid = postid;
    }

    public UInteger getWordid() {
        return this.wordid;
    }

    public void setWordid(UInteger wordid) {
        this.wordid = wordid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("QaTitlewords (");

        sb.append(postid);
        sb.append(", ").append(wordid);

        sb.append(")");
        return sb.toString();
    }
}