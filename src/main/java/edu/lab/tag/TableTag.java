package edu.lab.tag;

import edu.lab.repository.TableRepository;
import edu.lab.tag.entity.Table;
import edu.lab.tag.entity.TableRow;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import lombok.Setter;

import java.io.IOException;
@Setter
public class TableTag extends SimpleTagSupport {

    private Table table;

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();

        out.print("""
                <table>
                """);
        if (table.getTitles() != null && !table.getTitles().isEmpty()) {
            displayTitle(out);
        }

        if (table.getRows() != null && !table.getRows().isEmpty()) {
            displayBody(out);
        }

        if (table.getFooter() != null && !table.getFooter().isEmpty()) {
            displayFooter(out);
        }


        out.print("</table>");

    }

    private void displayTitle(JspWriter out) throws IOException {
        out.print("""
                    <thead>
                        <tr>
                """);
        for (String title : table.getTitles()) {
            out.print("<th>%s</th>".formatted(title));
        }
        out.print("""
                        </tr>
                    </thead>
                """);

    }

    private void displayBody(JspWriter out) throws IOException {
        out.print("<tbody>");
        for (TableRow row : table.getRows()) {
            out.print("<tr>");
            for (String col : row.getItems()) {
                out.print("<td>%s</td>".formatted(col));
            }
            out.print("</tr>");
        }
        out.print("""
                    </tbody>
                """);
    }

    private void displayFooter(JspWriter out) throws IOException {

        out.print("""
                <tfoot>
                    <tr>
                """);
        for (String item : table.getFooter()) {
            out.print("<td>%s</td>".formatted(item));
        }
        out.print("""
                    </tr>
                </tfoot>
                """);
    }
}
