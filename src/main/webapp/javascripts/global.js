$(document).ready(function(){
	$('#borderViolatorAddNationality').click(function(e){
		e.preventDefault();
		window.location = 'kodakondsused?form';
	});
	
	var split = $('#editBorderViolatorGender').val().split(',');
	$('#c_ee_codeporn_borderguard_entities_Piiririkkuja_sugu').val(split.reverse()[0]);
	$('#editBorderViolatorGender').val(split[0]);

});