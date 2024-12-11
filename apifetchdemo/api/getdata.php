<?php
$conn=mysqli_connect("localhost","root","");
mysqli_select_db($conn,"apidb");

  $name=$_POST['name'];
  $email=$_POST['email'];  

  $qry="select * from tbl_user"; 
		
  $res=mysqli_query($conn,$qry);		 
  
  if($res==true)
  $response="inserted";
  else
  $response="failed";

  echo $response;
  
?>