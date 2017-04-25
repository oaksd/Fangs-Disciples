<!DOCTYPE html>
<html>
<head>
<title>PHP Test</title>
</head>
<body>
<div data-role="page" id="FSBTempMonitor">
	<div data-role="header" data-position="fixed">
		<h1>FSB Server Temperature Monitor</h1>
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