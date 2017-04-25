 <?php
	$file = fopen("tempLog.txt","r");
	
// echo "<table border='2'>";
	while(!feof($file)){
		//echo "<tr><td width='600'>";
	  	echo fgets($file)."<br>";
		//echo "</td></tr>";
	}
	//echo "</table>";
	fclose($file);
?>