$(document).ready(function() {
	if(typeof $('#editBorderViolatorGender').val() != 'undefined') {
		var split = $('#editBorderViolatorGender').val().split(',');
		$('#c_ee_codeporn_borderguard_entities_Piiririkkuja_sugu').val(split.reverse()[0]);
		$('#editBorderViolatorGender').val(split[0]);
	}
	
	$('#deleteNationality').live('click', function(e) {
		e.preventDefault();
		if(!confirm(uSure))
			return;
		$.ajax({
			url: '../kodakondsused/' + nationalityId,
			type: 'DELETE',
			success: function(data) {
				$(e.target).parents('tr').fadeOut(function(){
					$(this).remove();
				});
				var rows = $(e.target).parents('table').find('tr');
				if(rows.length == 2){
					$(e.target).parents('table').fadeOut(function(){
						$(this).before('<hr style="margin: 5px 0 5px 0;" />');
						$(this).remove();
					});
				};
			},
			error: function(){
				alert(deletingFailed);
			}
		});		
	});
});