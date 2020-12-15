<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ro-RO">
<head>
    <title>JSP - Hello World</title>

    <link rel="stylesheet" href="css/todolist.css">
    <script src="js/todolist.js"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"
            integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<h1>To Do List</h1>
<div id="myDIV" class="header">
    <h2>My To Do List</h2>
    <label for="myInput">&nbsp;</label>
    <input type="text" id="myInput" placeholder="Title...">
    <span onclick="addTodoElement();" class="addBtn">Add1</span>
    <span onclick="save();" class="saveBtn">Save</span>
    <span onclick="load();" class="loadBtn">Load</span>
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
    const SERVER_URL = '<%=request.getContextPath()%>';
    const PATHS =
        {
            'add': {
                'uri': 'todo-servlet',
                'action': 'addElement'
            },
            'save': {
                'uri': 'todo-servlet',
                'action': 'saveToFile'
            },
            'load': {
                'uri': 'todo-servlet',
                'action': 'loadFile'
            },
        };

    function addTodoElement() {
        const action = 'add';
        const inputValue = document.getElementById("myInput").value;
        const params = {
            'action': PATHS[action]['action'],
            'title': inputValue,
        };
        $.post("<%=request.getContextPath()%>/" + PATHS[action]['uri'], params, function (data) {
            // $( ".result" ).html( data );
            console.log(data);
        });
    }

    function save() {
        const action = 'save';
        const params = {
            'action': PATHS[action]['action'],
        };
        $.post("<%=request.getContextPath()%>/" + PATHS[action]['uri'], params, function (data) {
            // $( ".result" ).html( data );
            console.log(data);
        });
    }

    function load() {
        const action = 'load';
        const params = {
            'action': PATHS[action]['action'],
        };
        $.post("<%=request.getContextPath()%>/" + PATHS[action]['uri'], params, function (responseData) {
            // $( ".result" ).html( data );
            // const json = jQuery.parseJSON(data);

            populateList(responseData.data.todoElements);
        });
    }

    function populateList(todoTasks) {
        $.each( todoTasks, function( key, value ) {
            newElement(value.title, value.done);
        });
    }

    function newElement(inputValue, checked) {
        const li = document.createElement("li");
        const t = document.createTextNode(inputValue);
        li.appendChild(t);
        if (checked)  li.className = 'checked';
        if (inputValue === '') {
            return;
        } else {
            document.getElementById("myUL").appendChild(li);
        }
        document.getElementById("myInput").value = "";

        const span = document.createElement("SPAN");
        const txt = document.createTextNode("\u00D7");
        span.className = "close";
        span.appendChild(txt);
        li.appendChild(span);

        for (i = 0; i < close.length; i++) {
            close[i].onclick = function() {
                const div = this.parentElement;
                div.style.display = "none";
            }
        }
    }
</script>
</body>
</html>