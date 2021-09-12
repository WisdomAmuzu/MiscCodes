from bottle import route, static_file, template, run, Bottle

@route('/home')
def home_page():
    text = '''
    <link type='text/css' href='E:/WebApps/files/css/home.css' media='all'/>
    <div id=Homehead>
    <h4>Welcome to the homepage of Mannin Technologies</h4>
    <p><a href='/home/topics.html'>Show topics</a></p>
    </div>
    '''
    return text
    
    
@route('/home/<filename>')
def list_topics(filename=''):
    pass
    
@route('/home/topics/<topic>')
def get_topic(topic):
    pass
    
@route('/home/FAQS')
def faqs_page():
    pass
    
@route('/home/login')
def login_page():
     pass
     
@route('/home/register')
def register_page():
    pass

run(host='localhost',port=8080)