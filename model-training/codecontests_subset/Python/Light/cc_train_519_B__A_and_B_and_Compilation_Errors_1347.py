n=int(input())
a=list(map(int,input().split()))
b=list(map(int,input().split()))
c=list(map(int,input().split()))
a.sort()
b.sort()
c.sort()
f=0
for i in range(len(b)):
    if a[i]!=b[i]:
        f=1
        print(a[i])
        break
if f==0:
    print(a[len(a)-1])
    
f=0
for i in range(len(c)):
    if b[i]!=c[i]:
        f=1
        print(b[i])
        break
if f==0:
    print(b[len(b)-1])
        