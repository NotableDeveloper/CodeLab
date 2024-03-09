var stompClient;
var socket = new SockJS('http://localhost:8081/connect');
stompClient = Stomp.over(socket);
var roomId = document.getElementById('roomId').innerText;

stompClient.connect({}, function() {
    stompClient.subscribe('/sub/rooms/' + roomId, function (message) {
        var receivedMessage = message.body;
        displayMessage(receivedMessage);
    });
});

document.getElementById('source').addEventListener('keydown', function(event) {
    if (event.key === 'Enter' && !event.shiftKey) {
        event.preventDefault();
        var textarea = event.target;
        var start = textarea.selectionStart;
        var end = textarea.selectionEnd;
        var value = textarea.value;
        textarea.value = value.substring(0, start) + '\n' + value.substring(end);
        textarea.selectionStart = textarea.selectionEnd = start + 1;
        sendMessage();
    }
});


function sendMessage() {
    var content = document.getElementById('source').value;
    var chatMessage = {
        "roomId" : roomId,
        "content" : content
    };
    stompClient.send('/pub/message', {}, JSON.stringify(chatMessage));
}

function sendCompile() {
    var sourceCode = document.getElementById('source').value;
    var chatMessage = {
        "roomId" : roomId,
        "content" : sourceCode
    };
    stompClient.send('/pub/compile', {}, JSON.stringify(chatMessage));
}

function displayMessage(message) {
    var receivedMessage = JSON.parse(message);
    console.log(receivedMessage);

    if(receivedMessage.messageType == "SOURCE"){
        var messageArea = document.getElementById('source');
        messageArea.value = receivedMessage.content;
    }

    else {
        var messageArea = document.getElementById('result');
        messageArea.value = receivedMessage.content;
    }
}
