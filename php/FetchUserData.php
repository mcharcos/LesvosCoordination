<?php
    $con=mysqli_connect("mysql.hostinger.co.uk","u366371143_lc","K7FO6cIs3J","u366371143_lc");
    
    $username = $_POST["username"];
    $password = $_POST["password"];
    
    $statement = mysqli_prepare($con,"SELECT * FROM User WHERE username = ? AND password = ?");
    mysqli_stmt_bind_param($statement,"ss",$username,$password);
    mysqli_stmt_execute($statement);
    
    mysqli_stmt_store_result($statement);
    mysqli_stmt_bind_result($statement, $userID, $name, $username, $password);
    
    $user = array();
    
    while(mysqli_stmt_fetch($statement)){
        $user[name] = $name;
        $user[username] = $username;
        $user[passsword] = $password;
    }
    
    echo json_encode($user);
    mysqli_stmt_close($statement);

    
    mysqli_close($con);
    
?>