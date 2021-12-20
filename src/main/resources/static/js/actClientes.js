$(document).ready(function() {
	$('#exportCsv').click(function() {

		var titles = [];
		var data = [];

		$('.table tr').each(function() {
			data.push($(this));
		});

		csv_data = []

		data.forEach(function(item, index) {
			td = item[0].children
			for (i = 0; i < td.length; i++) {

				csv_data.push(td[i].innerText)
			}

			csv_data.push('\r\n')
		})

		var downloadLink = document.createElement("a");
		var blob = new Blob([ "\ufeff", csv_data ]);
		var url = URL.createObjectURL(blob);
		downloadLink.href = url;
		downloadLink.download = "clientes.csv";
		document.body.appendChild(downloadLink);
		downloadLink.click();
		document.body.removeChild(downloadLink);
	});
});