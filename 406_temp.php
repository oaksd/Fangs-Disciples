<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">	
<title>FSB Server Monitor</title> 
<link rel="stylesheet" href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css" />
<script type="text/javascript" src="http://code.jquery.com/jquery-2.1.3.min.js"></script>
<script type="text/javascript" src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
$('#TempData').load('temp.html');
});
</script>
<script type="text/javascript">
/*
jQuery("load").load(function() {
jQuery.post("sendmail.php",{address: address, message: message});
return false;
*/
}
</script>
<style type = "text/css">
    div.break {white-space: pre;}
</style>  
</head>
<body>
<div data-role="page" id="FSBTempMonitor">
	<div data-role="header" data-position="fixed">
		<h1>FSB Server Temperature Monitor</h1>
	</div>
   	<div role="main" class="ui-content">
		<div id="TempData" class="break"></div>
	</div>
	<div>
		<?php
		
		echo "it worked";

		echo "<br>2<br><br>";

		$output = shell_exec('sudo temperv14 2>&1'); 

		echo $output;
		
		?>
</div>
</div>	 
</body>
</html>


