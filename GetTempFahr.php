#!/home/pi/Documents/php -q
<?php

	echo("From crontab");

	$tempfile = fopen("/var/www/html/tempLogFahr.txt", "a");	
	$temp = shell_exec('sudo temperv14 -f'); 

	fwrite($tempfile, $temp);
	fclose($tempfile);
		
?>