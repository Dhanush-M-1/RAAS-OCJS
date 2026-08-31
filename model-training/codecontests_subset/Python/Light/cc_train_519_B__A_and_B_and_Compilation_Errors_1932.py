a=int(input())
b=sorted(map(int,input().split()))
c=sorted(map(int,input().split()))
d=sorted(map(int,input().split()))
x=k=int(0)
while x<len(c):
    if c[x]!=b[x]:
        print(b[x])
        k=1
        break
    x=x+1
if k==0:
    print(b[-1])
x=k=int(0)
while x<len(d):
    if d[x]!=c[x]:
        print(c[x])
        k=1
        break
    x=x+1
if k==0:
    print(c[-1])