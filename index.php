<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <meta charset="UTF-8">
        <title></title>
    </head>
    <body>
        <?php
        $host = "localhost";
        $port = 3307;
        $user = "root";
        $password = "1234512345";
        $dbname = "ass1_schema";

        $con = new mysqli($host, $user, $password, $dbname, $port)
                or die('Could not connect to the database server' . mysqli_connect_error());
        //call   update_salary--stored procedure
        $jobTitle = "Programmer";
        $incrAmount = 100;
        $query = "call update_salary('{$jobTitle}',$incrAmount)";
        $con->query($query);

         // call get_high_salary_job -- function
        $query = "select get_high_salary_job()";
        $jobTitel = $con->query($query);
        $row = $jobTitel->fetch_row();
        echo $row[0];
        ?>
    </body>
</html>
