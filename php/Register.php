<?php
    $con=mysqli_connect("lesvoscoordination.esy.es","u366371143_lc","K7FO6cIs3J","u366371143_lc");
    
    $name = $_POST["name"];
    $username = $_POST["username"];
    $password = $_POST["password"];

    $statement = mysqli_prepare($con, "INSERT INTO User (name, username, password) VALUES (?,?,?) *);
    mysqli_stmt_bind_param($statement, "siss", $name, $username, $password);
    mysqli_stmt_execute($statement);
    
    mysqli_stmt_close($statement);
    
    mysqli_close($con);

?>