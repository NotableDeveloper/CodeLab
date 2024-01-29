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

document.getElementById('source').addEventListener('keydown', function (event) {
    if (event.keyCode === 13 && !event.shiftKey) {
        sendMessage();
    }
});

function sendMessage() {
    var message = document.getElementById('source').value;
    var chatMessage = {
        "roomId" : roomId,
        "message" : message
    };
    stompClient.send('/pub/message', {}, JSON.stringify(chatMessage));
}

function displayMessage(content) {
    var messageArea = document.getElementById('source');
    messageArea.value = content
}
