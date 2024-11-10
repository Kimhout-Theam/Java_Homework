package LearningOOPConcept.view;

import LearningOOPConcept.model.User;

import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.Table;

import java.util.Map;
import java.util.Set;




public class TableView {
    static String RESET = "\033[0m";
    static String BLUE = "\033[34m";
    static String GREEN = "\033[32m";
    static String RED = "\033[31m";

    private Table tableStyle() {

        Table tt = new Table(6, BorderStyle.UNICODE_BOX_DOUBLE_BORDER);


        tt.addCell(RED + "UUID" + RESET, new CellStyle(CellStyle.HorizontalAlign.center), 1);
        tt.addCell( RED +"User's UUID" + RESET, new CellStyle(CellStyle.HorizontalAlign.center), 1);
        tt.addCell(RED + "Name" + RESET, new CellStyle(CellStyle.HorizontalAlign.center), 1);
        tt.addCell(RED + "Gender" + RESET, new CellStyle(CellStyle.HorizontalAlign.center), 1);
        tt.addCell( RED +"Age" + RESET, new CellStyle(CellStyle.HorizontalAlign.center), 1);
        tt.addCell(RED + "DateOfBirth" + RESET, new CellStyle(CellStyle.HorizontalAlign.center), 1);


        tt.setColumnWidth(0, 10, 50);
        tt.setColumnWidth(1, 10, 50);
        tt.setColumnWidth(2, 10, 50);
        tt.setColumnWidth(3, 10, 50);
        tt.setColumnWidth(4, 10, 50);
        tt.setColumnWidth(5, 10, 50);
        return tt;
    }

    public void TableView(Set<Map.Entry<String, User>> user) {

        Table tt = tableStyle();
        CellStyle centerAndDot = new CellStyle(CellStyle.HorizontalAlign.center, CellStyle.AbbreviationStyle.crop);
//        CellStyle center = new CellStyle(CellStyle.HorizontalAlign.center);
for (Map.Entry<String, User> entry : user) {
    tt.addCell(BLUE + entry.getKey() + RESET, centerAndDot, 1);
    tt.addCell(GREEN + entry.getValue().uuid.toString() + RESET, centerAndDot, 1);
    tt.addCell(GREEN + entry.getValue().name + RESET, centerAndDot, 1);
    tt.addCell(GREEN + entry.getValue().gender + RESET, centerAndDot, 1);
    tt.addCell(GREEN + entry.getValue().age + RESET, centerAndDot, 1);
    tt.addCell(GREEN + entry.getValue().birthDate.toString() + RESET, centerAndDot, 1);
}
        for(
    String t :tt.renderAsStringArray())

    {
        System.out.println(t);
    }
}

public void TableViewAll(Map<String, User> users) {

    Table tt = tableStyle();
    CellStyle centerAndDot = new CellStyle(CellStyle.HorizontalAlign.center, CellStyle.AbbreviationStyle.dots);
//    CellStyle center = new CellStyle(CellStyle.HorizontalAlign.center);

    for (Map.Entry<String, User> entry : users.entrySet()) {
        tt.addCell(BLUE + entry.getKey() + RESET, centerAndDot, 1);
            tt.addCell(GREEN + entry.getValue().uuid.toString() + RESET, centerAndDot, 1);
            tt.addCell(GREEN + entry.getValue().name + RESET, centerAndDot, 1);
            tt.addCell(GREEN + entry.getValue().gender + RESET, centerAndDot, 1);
            tt.addCell(GREEN + entry.getValue().age + RESET, centerAndDot, 1);
            tt.addCell(GREEN + entry.getValue().birthDate.toString() + RESET, centerAndDot, 1);

    }

    for (String t : tt.renderAsStringArray()) {
        System.out.println(t);
    }
}

}
