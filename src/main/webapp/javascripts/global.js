$(document).ready(function(){
	if( typeof $('#editBorderViolatorGender').val() != 'undefined'){
		var split = $('#editBorderViolatorGender').val().split(',');
		$('#c_ee_codeporn_borderguard_entities_Piiririkkuja_sugu').val(split.reverse()[0]);
		$('#editBorderViolatorGender').val(split[0]);
	}
});