from flask import Flask
import time

app = Flask(__name__)

@app.route("/test", methods = ['POST'])
def hello_world():
    time.sleep(300)
    return "<p>Hello, World!</p>"