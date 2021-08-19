function addTicket() {
	$('#modalAddTicket').modal('show');
	$("#submitOk").click(function() {
		var data = {};
		data["clientName"] = $('#clientName').val();
		data["clientMobile"] = $('#clientMobile').val();
		data["clientContent"] = $('#clientContent').val();
		data["idPhongBan"] = $('#idPhongBan').val();

		$.ajax({
			url: "/rest/api/add-ticket",
			type: "post",
			contentType: "application/json",
			data: JSON.stringify(data),

			dataType: "json",
			success: function(jsonResult) {
				if (jsonResult.status == "69") {
					window.location.reload();
				}
				else {
					$("#divSuccess").hide();
					$("#divError").show();
				}

			}
		});
	});
}

function searchTicket() {
	var data = {};
	data['inputTypeSearch'] = $('#inputTypeSearch').val();
	data['from'] = $('#from').val();
	data['to'] = $('#to').val();

	$.ajax({
		url: "/rest/api/search-ticket",
		type: "post",
		contentType: "application/json",
		data: JSON.stringify(data),

		dataType: "json",
		success: function(jsonResult) {
			if (jsonResult.status == "169") {
				$('.container-footer').html("<h6>" + jsonResult.data.size + "&nbsp;items</h6>");

				$('tbody').empty();

				for (var i = 0; i < jsonResult.data.list.length; i++) {
					$('tbody').append("<tr><td>" + jsonResult.data.list[i].id + "</td><td>" + jsonResult.data.list[i].nameDepartment + "</td><td>"
						+ jsonResult.data.list[i].clientMobile + "</td><td>" + jsonResult.data.list[i].contentOfClient + "</td><td>"
						+ jsonResult.data.list[i].timeAccept + "</td><td>" + jsonResult.data.list[i].contentReply + "</td><td>"
						+ jsonResult.data.list[i].status + "</td><td>" + jsonResult.data.list[i].timeReply + "</td><tr>");
				}
			}


		}
	});
}

function searchTicketByIdDe(id) {
	var data = {};
	data['id'] = id;

	$.ajax({
		url: "/rest/api/search-ticket-by-idDe",
		type: "post",
		contentType: "application/json",
		data: JSON.stringify(data),

		dataType: "json",
		success: function(jsonResult) {
			if (jsonResult.status == "269") {
				$('.container-footer').html("<h6>" + jsonResult.data.size + "&nbsp;items</h6>");

				$('tbody').empty();

				for (var i = 0; i < jsonResult.data.list.length; i++) {
					$('tbody').append("<tr><td>" + jsonResult.data.list[i].id + "</td><td>" + jsonResult.data.list[i].nameDepartment + "</td><td>"
						+ jsonResult.data.list[i].clientMobile + "</td><td>" + jsonResult.data.list[i].contentOfClient + "</td><td>"
						+ jsonResult.data.list[i].timeAccept + "</td><td>" + jsonResult.data.list[i].contentReply + "</td><td>"
						+ jsonResult.data.list[i].status + "</td><td>" + jsonResult.data.list[i].timeReply + "</td><tr>");
				}
			}


		}
	});
}

function searchDeById(id) {
	var data = {};
	data['id'] = id;

	$.ajax({
		url: "/rest/api/search-department-by-id",
		type: "post",
		contentType: "application/json",
		data: JSON.stringify(data),

		dataType: "json",
		success: function(jsonResult) {
			if (jsonResult.status == "369") {
				$('.container-footer').html("<h6>" + jsonResult.data.size + "&nbsp;items</h6>");

				$('tbody').empty();

				for (var i = 0; i < jsonResult.data.list.length; i++) {
					$('tbody').append("<tr><td>" + jsonResult.data.list[i].id + "</td><td>" + jsonResult.data.list[i].name + "</td><td>"
						+ jsonResult.data.list[i].dateCreate + '</td><td><a href="javascript:void(0);" onclick="editDepartment('+jsonResult.data.list[i].id+')" class="btn btn-primary"><i class=\"fas fa-edit\"></i> Edit</a> '
						+ '<a href="javascript:void(0);" onclick="deleteForm('+jsonResult.data.list[i].id+')" class="btn btn-danger"><i class="fas fa-eraser"></i> Delete</a></td><tr>');
				}
			}


		}
	});
}

function searchDeByName() {
	var data = {};
	data['input'] = $('#inputName').val();

	$.ajax({
		url: "/rest/api/search-department-by-name",
		type: "post",
		contentType: "application/json",
		data: JSON.stringify(data),

		dataType: "json",
		success: function(jsonResult) {
			if (jsonResult.status == "469") {
				$('.container-footer').html("<h6>" + jsonResult.data.size + "&nbsp;items</h6>");

				$('tbody').empty();

				for (var i = 0; i < jsonResult.data.list.length; i++) {
					$('tbody').append("<tr><td>" + jsonResult.data.list[i].id + "</td><td>" + jsonResult.data.list[i].name + "</td><td>"
						+ jsonResult.data.list[i].dateCreate + '</td><td><a href="javascript:void(0);" onclick="editDepartment('+jsonResult.data.list[i].id+')" class="btn btn-primary"><i class=\"fas fa-edit\"></i> Edit</a> '
						+ '<a href="javascript:void(0);" onclick="deleteForm('+jsonResult.data.list[i].id+')" class="btn btn-danger"><i class="fas fa-eraser"></i> Delete</a></td><tr>');
				}
			}


		}
	});
}

function addDepartment() {
	$('#modalAddDepartment').modal('show');
	$("#submit-ok").click(function() {
		var data = {};
		data["nameDe"] = $('#nameDe').val();

		$.ajax({
			url: "/rest/api/add-department",
			type: "post",
			contentType: "application/json",
			data: JSON.stringify(data),

			dataType: "json",
			success: function(jsonResult) {
				if (jsonResult.status == "569") {
					window.location.reload();
				}
				else {
					$("#divSuccess").hide();
					$("#divError").show();
				}

			}
		});
	});
}

function getToEditDepartment(deId) {
	$('#modalAddDepartment').modal('show');
	var data = {};
	data["deId"] = deId;

	$.ajax({
		url: "/rest/api/get-to-edit-department",
		type: "post",
		contentType: "application/json",
		data: JSON.stringify(data),

		dataType: "json",
		success: function(jsonResult) {
			if (jsonResult.status == "669") {
				$('#nameDe').val(jsonResult.data.name);
			}

		}
	});
}

function editDepartment(deId) {
	getToEditDepartment(deId);

	$("#submit-ok").click(function() {
		var data = {};
		data["nameDe"] = $('#nameDe').val();
		data["deId"] = deId;

		$.ajax({
			url: "/rest/api/edit-department",
			type: "put",
			contentType: "application/json",
			data: JSON.stringify(data),

			dataType: "json",
			success: function(jsonResult) {
				if (jsonResult.status == "769") {
					window.location.reload();
				}
				else {
					$("#divSuccess").hide();
					$("#divError").show();
				}

			}
		});
	});
}

function deleteForm(id) {
	$('#modalDeleteForm').modal('show');
	$("#deleteOk").click(function() {
		var data = {};
		data["id"] = id;
		$.ajax({
			url: "/rest/api/delete-department",
			type: "delete",
			contentType: "application/json",
			data: JSON.stringify(data), 

			dataType: "json",
			success: function(jsonResult) { 
				if (jsonResult.status == "869") {
					window.location.reload();
				}
			}
		});
	});
	
}
