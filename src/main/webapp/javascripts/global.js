$(document).ready(function() {
	if(typeof $('#editBorderViolatorGender').val() != 'undefined') {
		var split = $('#editBorderViolatorGender').val().split(',');
		$('#c_ee_codeporn_borderguard_entities_Piiririkkuja_sugu').val(split.reverse()[0]);
		$('#editBorderViolatorGender').val(split[0]);
	}
	
	$('#deleteNationality').live('click', function(e) {
		e.preventDefault();
		if(!confirm("Oled kindel?"))
			return;
		$.ajax({
			url: '../kodakondsused/' + nationality_id,
			type: 'DELETE',
			success: function(data) {
				$(e.target).parents('tr').fadeOut(function(){
					$(this).remove();
				});
				var rows = $(e.target).parents('table').find('tr');
				if(rows.length == 2){
					$(e.target).parents('table').fadeOut(function(){
						$(this).remove();
					});
				};
			}
		});		
	});
});