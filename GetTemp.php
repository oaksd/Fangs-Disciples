<?php

	$tempfile = fopen("tempLog.txt", "a");	
	$temp = shell_exec('sudo temperv14'); 

	fwrite($tempfile, $temp);
	fclose($tempfile);
		
?>