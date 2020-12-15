<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ro-RO">
<head>
    <title>JSP - Hello World</title>

    <link rel="stylesheet" href="css/todolist.css">
    <script src="js/todolist.js"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
</head>
<body>
<h1><%= "Hello World!" %></h1>
<br/>
<h1>To Do List</h1>
<div id="myDIV" class="header">
    <h2>My To Do List</h2>
    <label for="myInput">&nbsp;</label>
    <input type="text" id="myInput" placeholder="Title...">
    <span onclick="newElement(); addTodoElement();" class="addBtn">Add</span>
    <span onclick="save();" class="saveBtn">Save</span>
</div>

<ul id="myUL">
    <li>Hit the gym</li>
    <li class="checked">Pay bills</li>
    <li>Meet George</li>
    <li>Buy eggs</li>
    <li>Read a book</li>
    <li>Organize office</li>
</ul>

<script type="text/javascript">
    function addTodoElement() {
        const inputValue = document.getElementById("myInput").value;
        const params = {
            'action': 'addElement',
            'title': inputValue
        };
        $.post( "http://localhost:8080/todolist_war_exploded/todo-servlet", params, function( data ) {
            // $( ".result" ).html( data );
            console.log(data);
        });
    }

    function save() {
        const params = {
            'action': 'saveToFile'
        };
        $.post( "http://localhost:8080/todolist_war_exploded/todo-servlet", params, function( data ) {
            // $( ".result" ).html( data );
            console.log(data);
        });
    }
</script>
</body>
</html>