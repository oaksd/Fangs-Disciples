 <?php
//	$file = "/var/www/html/tempLogFahr";
//	$data = file($file);
//	$line = $data[count($data)-1];

	echo shell_exec('tail -n 1 /var/www/html/tempLogFahr.txt')."°F";
?>