##for debug comment out
import sys,atexit
from io import BytesIO
inp = BytesIO(sys.stdin.buffer.read())
input = lambda:inp.readline().decode('ascii')
buf = BytesIO()
#sys.stdout.write = lambda s: buf.write(s.encode('ascii'))
#print = lambda s: buf.write(s.encode('ascii'))
atexit.register(lambda:sys.__stdout__.buffer.write(buf.getvalue()))

for i in range(int(input())):
    a,b,c=map(int,input().split())
    ans=0
    x=y=0
    c=(c//2)*2
    
    x=min(c//2,b)
    b-=x
    b=(b//2)*2
    y=min(b//2,a)
    print(x*3+y*3)