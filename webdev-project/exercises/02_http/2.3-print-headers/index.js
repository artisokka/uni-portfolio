const http = require('http');
const fs = require('fs');
const path = require('path');

http.createServer(function(request, response) {
  fs.readFile(path.resolve('index.html'), function(error, htmlPage) {
    if (error) {
      response.writeHead(404);
      response.write('An error occured: ', error);
    } else {
      response.writeHead(200, { 'Content-Type': 'text/html' });
      //console.log(JSON.stringify(request.headers));
      
      response.write(JSON.stringify(request.headers));
    }
    response.end();
  });
}).listen(3000);