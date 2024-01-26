# hello.py
import http.server
import socketserver

class MyHandler(http.server.SimpleHTTPRequestHandler):
    def do_GET(self):
        self.send_response(200)
        self.send_header("Content-type", "text/html")
        self.end_headers()
        self.wfile.write(b"Hello, Usman!!!")

PORT = 3456
with socketserver.TCPServer(("", PORT), MyHandler) as httpd:
    print("Serving at port {PORT}")
    httpd.serve_forever()
