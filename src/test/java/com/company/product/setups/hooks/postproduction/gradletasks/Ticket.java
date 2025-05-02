package com.company.product.setups.hooks.postproduction.gradletasks;

import java.io.IOException;
import java.nio.file.*;

public class Ticket {

    private static final String PATH_REPORT_SITE = System.getProperty("user.dir")+"/target/site";
    private static final String DIR_REPORT_SERENITY = "/serenity";
    private static final String PATH_REPORT_SERENITY_INITIAL = PATH_REPORT_SITE + DIR_REPORT_SERENITY;
    private static final String DIR_REPORT_FINAL = "/report";
    private static final String PATH_REPORT_SERENITY_FINAL = PATH_REPORT_SERENITY_INITIAL + DIR_REPORT_FINAL;
    private static final String RUTA_TEMP_REPORT_SERENITY_FINAL = PATH_REPORT_SITE + DIR_REPORT_FINAL;
    private static final String INDEX_HTML = "/index.html";
    private static final String PATH_RELATIVE_INDEX_HTML = DIR_REPORT_FINAL +INDEX_HTML;
    private static final String IFRAME_SHORCUT_INDEX_HTML = "<iframe src=\"."+ PATH_RELATIVE_INDEX_HTML +"\" title=\"W3Schools Free Online Web Tutorials\" width=\"100%\" height=\"100%\"></iframe>";

    public static void main(String[] args) throws IOException
    {
        Path indexHtml = Paths.get(PATH_REPORT_SERENITY_INITIAL +INDEX_HTML);

        if( Files.exists(indexHtml) )
        {
            Path dirReportSerenityInitial = Paths.get(PATH_REPORT_SERENITY_INITIAL);
            Path dirTempReportSerenityFinal = Paths.get(RUTA_TEMP_REPORT_SERENITY_FINAL);
            Files.move(dirReportSerenityInitial,dirTempReportSerenityFinal);
            Path dirReportSerenityFinal = Paths.get(PATH_REPORT_SERENITY_FINAL);
            Files.createDirectories(dirReportSerenityFinal);
            Files.move(dirTempReportSerenityFinal,dirReportSerenityFinal,StandardCopyOption.REPLACE_EXISTING);

            Files.writeString(indexHtml,IFRAME_SHORCUT_INDEX_HTML, StandardOpenOption.CREATE);
        }
    }
}
