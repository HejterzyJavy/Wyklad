$(document).ready(function() {
	$(".przyciskMenu, #rezerwacjaB").mouseover(function() {
		$(this).animate({
			borderBottomWidth : "4px"
		}, 100);
	});
	$(".przyciskMenu, #rezerwacjaB").mouseleave(function() {
		$(this).animate({
			borderBottomWidth : "0px"
		}, 100);
	});

	$(".przyciskG").mouseover(function() {
		$(this).animate({
			opacity : '1',
		}, 100);
		$(this).css("background-color", "#6c361d");
	});
	$(".przyciskG").mouseleave(function() {
		$(this).animate({
			opacity : '0.75',
		}, 200);
		$(this).css("background-color", "");
	});

	$("#pLogowania").click(function() {
		$( "#panelLogowania" ).toggle( "fold", 700 );
	});

});

