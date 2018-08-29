package com.crosscode;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.crosscode.util.CompanyInfo;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.column.Columns;
import net.sf.dynamicreports.report.builder.component.Components;
import net.sf.dynamicreports.report.builder.datatype.DataTypes;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRException;

/**
 * @author ankit.tripathi
 *
 */
@RestController
public class ProcessRestController {
	@Autowired
	SalaryService salaryService;

	@RequestMapping(value = "/rest/getRpt", method = RequestMethod.GET)
	public ResponseEntity<byte[]> getRpt() throws JRException, IOException, DRException {

		ResponseEntity<byte[]> response = null;
		byte[] contents;

		JasperReportBuilder jasperReport = DynamicReports.report();
		jasperReport.columns(

				Columns.column("User Name", "username", DataTypes.stringType()),
				Columns.column("User Salary", "salary", DataTypes.longType()))
				.title(// title of the report
						Components.text(CompanyInfo.addPrefix("Salary Report"))
								.setHorizontalAlignment(HorizontalAlignment.CENTER))
				.pageFooter(Components.pageXofY())// show page number on the
													// page footer
				.setDataSource(salaryService.getSalaryWithUserName());

		jasperReport.toPdf(new FileOutputStream("report.pdf"));

		Path path = Paths.get("report.pdf");
		contents = Files.readAllBytes(path);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.parseMediaType("application/pdf"));
		String filename = "salaryReport.pdf";
		headers.setContentDispositionFormData(filename, filename);
		headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
		return response = new ResponseEntity<byte[]>(contents, headers, HttpStatus.OK);
	}

}
