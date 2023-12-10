package edu.lab.tag;

import edu.lab.tag.entity.MenuItem;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import lombok.Setter;

import java.io.IOException;
import java.util.List;

@Setter
public class MenuTag extends SimpleTagSupport {

    private List<MenuItem> items;

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        out.print("""
                <header>
                    <nav>
                        <ul>
                """);
        for (MenuItem item : items) {
            out.print("""
                    <li>
                        <a href="%s">%s</a>
                    </li>
                    """.formatted(item.getUrl(), item.getName()));
        }

        out.print("""
                        </ul>
                    </nav>
                </header>
                """);
    }
}
