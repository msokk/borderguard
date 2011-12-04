$(document).ready(function() {
	if(typeof $('#editBorderViolatorGender').val() != 'undefined') {
		var split = $('#editBorderViolatorGender').val().split(',');
		$('#c_ee_codeporn_borderguard_entities_Piiririkkuja_sugu').val(split.reverse()[0]);
		$('#editBorderViolatorGender').val(split[0]);
	}
	
	if(typeof deletingFailed != 'undefined')
		deletingFailed = deletingFailed.replace('&otilde;', 'õ');
	
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
	
	$('#deleteSection').live('click', function(e) {
		e.preventDefault();
		if(!confirm(uSure))
			return;
		
		var url = '../seadusepunktid/';
		if(window.location.href.split('/').length == 6){
			var url = '../seadusepunktid/';
		}else if(window.location.href.split('/').length == 7){
			var url = '../../seadusepunktid/';
		}
		$.ajax({
			url: url + sectionId,
			type: 'DELETE',
			success: function(data) {
				if (data != 1){
					alert(deletingFailed);
					return;
				}
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