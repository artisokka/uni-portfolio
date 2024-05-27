const http = require('http');
const fs = require('fs');
const url = require('url');
const path = require('path');

module.exports = http.createServer(function(request, response) {
    //const path = url.parse(request.url).pathname;

    if (request.url === '/classical') {
        //response.writeHead(200, { 'Content-Type': 'text/html' });
        readFileSendResponse('homer.html', 'text/html', response);
    }
    else if (request.url === '/dystopy') {
        //response.writeHead(200, { 'Content-Type': 'text/html' });
        readFileSendResponse('bradbury.html', 'text/html', response);
    }
    else if (request.url === '/') {
        //response.writeHead(200, { 'Content-Type': 'text/html' });
        readFileSendResponse('index.html', 'text/html', response);
    }
    else {
        readFileSendResponse('', 'text/html', response);
        //response.end();
    }
}).listen(3000);


const readFileSendResponse = (fileName, contentType, response) => {
    fs.readFile(path.resolve(fileName), function(error, file) {
      if (error) {
        response.writeHead(404);
        response.end();
      }
      else {
        response.writeHead(200, { 'Content-Type': contentType });
        response.write(file);
      }
      response.end();
    })
  }