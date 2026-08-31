##for debug comment out
import sys,atexit
from io import BytesIO
inp = BytesIO(sys.stdin.buffer.read())
input = lambda:inp.readline().decode('ascii').strip()
buf = BytesIO()
#sys.stdout.write = lambda s: buf.write(s.encode('ascii'))
#print = lambda s: buf.write(s.encode('ascii'))
atexit.register(lambda:sys.__stdout__.buffer.write(buf.getvalue()))

n,p,w,d=map(int,input().split())
x=-1
y=-1
for i in range(w+1):
    if (p-i*d)%w==0:
        y=i
        x=(p-y*d)//w

        break

if x<0 or y<0 or x+y>n:
    print(-1)
else:
    print(x,y,n-x-y)
