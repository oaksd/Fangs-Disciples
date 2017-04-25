<?php
$to = "oaksd@miamioh.edu";
$subject = "ALERT: FSB SERVER ROOM TEMP";
$txt = "FSB Server Room Temperature Exceeds Threshold!";
$headers = "From: FSBtemperature@gmail.com"

mail($to,$subject,$txt,$headers);
?>