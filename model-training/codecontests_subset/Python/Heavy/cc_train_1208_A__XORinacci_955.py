import sys,atexit
from io import BytesIO
inp = BytesIO(sys.stdin.buffer.read())
input = lambda:inp.readline().decode('ascii')
buf = BytesIO()
#sys.stdout.write = lambda s: buf.write(s.encode('ascii'))
#print = lambda s: buf.write(s.encode('ascii'))
atexit.register(lambda:sys.__stdout__.buffer.write(buf.getvalue()))

for i in range(int(input())):
    a,b,n=map(int,input().split())
    x=n%3
    #print(x,'xx')
    if x==2:
        print(a^b)
    elif x==0:
        print(a)
    elif x==1:
        print(b)
