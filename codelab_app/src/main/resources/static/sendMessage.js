var stompClient;
var socket = new SockJS('http://localhost:8081/connect');
stompClient = Stomp.over(socket);

function sendMessage() {
  var message = document.getElementById('source').value;
  var chatMessage = {
      content: message
  };
  stompClient.send("/pub/message", {}, message);
}

document.getElementById('source').addEventListener('keydown', function(event) {
  if (event.keyCode === 13 && !event.shiftKey) {
    sendMessage();
   }
 });
