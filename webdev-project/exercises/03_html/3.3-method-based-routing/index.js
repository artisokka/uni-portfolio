const http = require('http');
const fs = require('fs');
const url = require('url');
const path = require('path');

module.exports = http.createServer(function(request, response) {
    //const path = url.parse(request.url).pathname;
    //const body = 'Allow: GET, POST';
    //response.setHeader('Allow-Methods', 'GET, POST');
      if (request.method === "POST") {
        response.writeHead(200, { 'Content-Type': 'text/html' });
        readFileSendResponse('post.html', 'text/html', response);
    }

    else if (request.method === "GET") {
        response.writeHead(200, { 'Content-Type': 'text/html' });
        readFileSendResponse('get.html', 'text/html', response);
    }
    
    else if (request.method != ("GET" || "POST")) {
      // Calling response.writeHead method

      //response.statusCode(405);
      response.writeHead(405, {"Allow" : "GET, POST"});
      

      /*response.writeHead(405, {
      'Content-Length': Buffer.byteLength(body),
      'Content-Type': 'text/plain' });
      response.end(body);*/
    }
    //response.end();
}).listen(3000);


const readFileSendResponse = (fileName, contentType, response) => {
    fs.readFile(path.resolve(fileName), function(error, file) {
      if (error) {
        response.writeHead(405);
        response.write('Allow: GET, POST');
        response.end();
      }
      else {
        response.writeHead(200, { 'Content-Type': contentType });
        response.write(file);
      }
      response.end();
    })
  }

/*
if get
  get.html
  Content-Type: text/html
  status 200
if post
  post.html
  Content-Type: text/html
  status 200
else
  status 405 "Allow: GET, POST"


*/