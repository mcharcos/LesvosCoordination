<?php
    $con=mysqli_connect("localhost","u366371143_lc","K7FO6cIs3J","u366371143_lc");
    
    $username = $_POST["username"];
    $password = $_POST["password"];
    
    $statement = mysqli_prepare($con,"SELECT * FROM User WHERE username ? AND password = ?");
    mysqli_stmt_bind_param($statement,"ss",$username,$password);
    mysqli_stmt_execute($statement);
    
    mysqli_stmt_store_result($statement);
    mysqli_stmt_bind_results($statement,$user_id, $name,$username,$password);
    
    $user = array();
    
    while(mysqli_stmt_fetch($statement)){
        $user[name] = $name;
        $user[username] = $username;
        $user[passsword] = $password;
    }
    
    echo json_decode($user);
    mysqli_stmt_close($statement);

    
    mysqli_close($con);
    
?>