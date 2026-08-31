import sys 
input = lambda: sys.stdin.buffer.readline().rstrip()



q,w=map(int,input().split())
e=[]
r=[]
t=[]
z=0
x=0
for i in range(q):
    a,b,c=map(int,input().split())
    if b==1 and c==1:
        e.append(a)
        z+=1
        x+=1
    elif b==1 and c==0:
        r.append(a)
        x+=1
    elif b==0 and c==1:
        t.append(a)
        z+=q
r=sorted(r)
t=sorted(t)
for i in range(min(len(r),len(t))):
    e.append(r[i]+t[i])
e=sorted(e)
i=0
t=0
k=0
b=len(e)
if b<w:
    print(-1)
else:
    while i<w:
        if t<b:
            k+=e[t]
            t+=1
        i+=1
    print(k)