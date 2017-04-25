<?php

$file = 'bin/bash -c sudo temperv14';

$lines = file($file);

$temp = explode('=', $lines[1]);

$temp = number_format($temp[1] / 1000 , 2, ' . ', '');

echo $temp . " C";
?>