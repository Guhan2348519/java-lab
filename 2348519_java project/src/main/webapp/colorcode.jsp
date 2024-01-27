<%-- 
    Document   : colorcode
    Created on : Jan 28, 2024, 12:01:11?AM
    Author     : Guhan
--%>

<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Color Code Game</title>
<style>
#upperDiv
{
margin: 0% 40% 0% 30%;
}

h1
{
font-color:#FF4500;
}
tr
{
padding: 1px;
}
td
{
padding: 3px;
}
table
{
padding: 5px;
}
.blue
{
	background-color: #3498DB;
	border-bottom: 5px  #2980B9;
	border-radius: 10%;
}

body
{
border-color:red;
}

a {
    color: hotpink;
}

a:link {
    color: red;
}

/* visited link */
a:visited {
    color: green;
}

/* mouse over link */
a:hover {
    color: hotpink;
}

/* selected link */
a:active {
    color: blue;
}

</style>
<script type="text/javascript"> 
//document.write("Test<br>");
//document.write(document.getElementById('b').innerHTML==document.getElementById('b').innerHTML  );
function check(guess)
{
	//alert(document.getElementById('score').innerHTML);
	var findMe = document.getElementById('findme');
	var findMeHTML = findMe.innerHTML;
	var guessHTML = guess.innerHTML;
	//alert(findMeHTML);
	//alert(guessHTML);
		//alert(guess.getAttribute(color));
		
    var findMeColor = window.getComputedStyle(findMe).getPropertyValue('background-color');
    var guessColor = window.getComputedStyle(guess).getPropertyValue('background-color');
    //alert(findMeColor);
    //alert(guessColor);
    //alert(findMe.isEqualNode(guess));
	if( (findMeHTML.trim() === guessHTML.trim() ) && ( findMeColor === guessColor ))
		{
		//alert("Correct guess! Congrats");
		document.getElementById('score').innerHTML++;//updatedScoreValue;
		document.getElementById('clickText').innerHTML = "Correct guess! Congrats";
		}
		
	else
		{
		//alert("Wrong guess! Sorry");
		document.getElementById('score').innerHTML--;//updatedScoreValue;
		document.getElementById('clickText').innerHTML  = "Sorry! Wrong guess";
		}
	 
	 localStorage.setItem('score',document.getElementById('score').innerHTML);
	 localStorage.setItem('clickText',document.getElementById('clickText').innerHTML);
	location.reload(true);
	
	
}
function updateScore()
{
	//alert("update score");
	if(localStorage.getItem('score'))
	document.getElementById('score').innerHTML = localStorage.getItem('score');
	document.getElementById('clickText').innerHTML = localStorage.getItem('clickText');
	
}

var count=10;

var counter=setInterval(timer, 1000); //1000 will  run it every 1 second



function timer()
{
  count=count-1;
  if (count <= 0)
  {
     clearInterval(counter);
     location.reload(true);
     return;
  }

 document.getElementById("timer").innerHTML=count ;// watch for spelling
}

function restart()
{
	location.reload(true);
	localStorage.setItem('score','0');
	 localStorage.setItem('clickText','');
}
</script>
</head>
<body onload="updateScore()">
<%
String colors[] = {"white","gray","yellow","green","blue","orange","pink"};
Random random = new Random();
String color;
int allowedColors = Integer.parseInt(request.getParameter("level"));

%>
<center ><h1>Color code Game</h1>

<h3> Level <%=allowedColors %> Game</h3>
<div id="upperDiv">
<span style="float:left">
<a href="colorcodewelcompage.html"> Change level</a>
</span>
<span style="float:right">
<button onclick="restart()">
Restart
</button>
</span>
</div>
<br>
<br>



<div style="margin:1% 40% 0% 30%">
	
<div id="firstDiv">



<div style="margin:"0% 40% 0% 40%; padding:"2% 5% 0% 5%">
<span id="scoreDiv" class="blue" style="float:left">Score
<button id="score">
0
</button>
</span>
<%
int findeMeColor = random.nextInt(allowedColors);
char findMeChar = (char)(random.nextInt(26) + 'A');
%>
<span>Find me
<button id="findme" style="background-color:<%=colors[findeMeColor]%>">
<%
out.print(findMeChar);
%>
</button>

</span>

<span id="timerDiv"  class="blue" style="float:right">
Timer
<button id="timer">
10 
</button>
</span>
</div>
<br>
<br>
<table border="1" >
<%
char c ='A';
for(int  i=1;i<=100;i++)
{
	if(i==1)
	out.println("<tr>");
	
	color = colors[random.nextInt(allowedColors)];
	
	if(c==findMeChar && random.nextBoolean())
		color = colors[findeMeColor];
	
%>	
<td><button  style="background-color:<%=color%>"  onclick="check(this)"> <% out.print(c); %> </button></td>
	
<% 
	if(i==100)
	out.println("</tr>");	
	else if(i%10 ==0)
	out.println("</tr><tr>");
	c++;
	
	if(c==('Z'+1))
	c='A';
}

%>


</table>
</div>

<div id="secondDiv">
<span id="clickText">
</span>
</div>
</div>
</center>
</body>
</html>