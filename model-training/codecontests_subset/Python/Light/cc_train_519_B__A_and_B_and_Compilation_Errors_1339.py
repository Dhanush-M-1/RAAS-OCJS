n=int(input())
a=list(map(int,input().split()))
a.sort()
b=list(map(int,input().split()))
b.sort()
b.append(0)
c=list(map(int,input().split()))
c.sort()
c=c+[0,0]
q=[0,0]
s=0
t=0
for i in range(n):
    if(a[i]!=b[i] and s==0):
        q[0]=a[i]
        s=1
    if(b[i]!=c[i] and t==0):
        q[1]=b[i]
        t=1
print(str(q[0])+"\n"+str(q[1]))