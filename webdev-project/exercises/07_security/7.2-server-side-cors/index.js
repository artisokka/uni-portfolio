const http = require('http');
const { type } = require('os');
const { runInNewContext } = require('vm');
const port = 3000;

http.createServer((req, res) => {
  /*let reqHeader = req.headers['ei ole olemassa'];

  res.write(" " + reqHeader + " ");
  res.write(typeof 'reqHeader' + " ");
  res.write(JSON.stringify(!reqHeader) + " ");
  res.write(typeof !reqHeader);
*/

const corsheaders = {
  'Access-Control-Allow-Origin': '*',
  'Access-Control-Allow-Methods': 'HEAD, GET, POST',
  'Access-Control-Max-Age': 7200
};

//console.log(req.headers['corsheaders']);

//res.setHeader(corsheaders);

  // TODO: check that Origin header is set in the request
  // You can access the header with req.headers['origin']
  // You can check if a header is present in request headers with if(!req.headers['yourHeaderNameHere']){..

  /**/

  // TODO: handle GET and POST HTTP methods
  // You can use req.method to access the request method 
  // remember to add CORS headers to response, you can use writeHead() here 

  if(!req.headers['origin']){
    
    res.writeHead(400, "Origin header not in the request", corsheaders);
    res.end();
    return;
  }

  else if (req.method == "POST" || req.method == "GET") {
    res.writeHead(200, "I was requested using CORS!", corsheaders);
    res.end();
    return;
 }

  // TODO: handle HEAD HTTP method, 
  // remember to add CORS headers to response

  else if(req.method == "HEAD") {
    res.writeHead(200, corsheaders);
    res.end();
    return;
  }

  // TODO: handle HTTP methods that are not allowed, 
  // remember to add CORS headers to response

 

  else if (req.http ) {
    //res.write(error);
    res.writeHead(405, "Request used a HTTP method which is not allowed.", corsheaders);
    res.end();
    return;
  }

  // HINT: remember to use end() method of the response when you are ready to send them. If you are using if-else statements, place 
  // "return;" 
  // as the last line of all if-else branches. 
  // So, something like:
  // if(condition){
  //     ....
  //     response.end();
  //     return;
  // }
  // else if(condition){
  //     ....
  //     response.end();
  //     return;
  // }
  // else{
  //     ....
  //     response.end();
  //     return;
  // }



}).listen(port);