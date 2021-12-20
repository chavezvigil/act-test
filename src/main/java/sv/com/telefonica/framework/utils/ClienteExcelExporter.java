package sv.com.telefonica.framework.utils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import sv.com.telefonica.model.entity.ActClienteEntity;

public class ClienteExcelExporter {

	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	private List<ActClienteEntity> listClientes;

	public ClienteExcelExporter(List<ActClienteEntity> listClientes) {
		this.listClientes = listClientes;
		workbook = new XSSFWorkbook();
	}

	private void writeHeaderLine() {
		sheet = workbook.createSheet("Clientes");

		Row row = sheet.createRow(0);

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		style.setFont(font);

		createCell(row, 0, "#", style);
		createCell(row, 1, "Nombre del cliente", style);
		createCell(row, 2, "Tipo persona", style);
		createCell(row, 3, "Email", style);
		createCell(row, 4, "Telefono", style);
		createCell(row, 5, "Creado por", style);
		createCell(row, 6, "Fecha creación", style);

	}

	private void createCell(Row row, int columnCount, Object value, CellStyle style) {
		sheet.autoSizeColumn(columnCount);
		Cell cell = row.createCell(columnCount);
		if (value instanceof Integer) {
			cell.setCellValue((Integer) value);
		} else if (value instanceof Boolean) {
			cell.setCellValue((Boolean) value);
		} else {
			cell.setCellValue((String) value);
		}
		cell.setCellStyle(style);
	}

	private void writeDataLines() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);
		
		SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");

		for (ActClienteEntity cliente : listClientes) {
			Row row = sheet.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, cliente.getId().toString(), style);
			createCell(row, columnCount++, cliente.getNombreCliente(), style);
			createCell(row, columnCount++, cliente.getActTipoPersonaEntity().getDescripcion(), style);
			createCell(row, columnCount++, cliente.getEmail(), style);
			createCell(row, columnCount++, cliente.getTelefono(), style);
			createCell(row, columnCount++, cliente.getCreadoPor(), style);
			createCell(row, columnCount++, dateformat.format(cliente.getFechaCreado()), style);

		}
	}

	public void export(HttpServletResponse response) throws IOException {
		writeHeaderLine();
		writeDataLines();

		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();

		outputStream.close();

	}
}
