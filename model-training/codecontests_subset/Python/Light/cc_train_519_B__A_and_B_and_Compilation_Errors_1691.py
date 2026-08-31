n=int(input())
l=list(map(int,input().split()))
l.sort()
m=list(map(int,input().split()))
m.sort()
k=list(map(int,input().split()))
k.sort()
c=x=0
for i in range(0,n):
    if c==n-1:
        break
    if l[i]!=m[c]:
        print(l[i])
        x=x+1
    else:
        c=c+1
if x==0:
    print(l[i])
c=x=0
for i in range(0,n-1):
    if c==n-2:
        break
    if m[i]!=k[c]:
        print(m[i])
        x=x+1
    else:
        c=c+1
if x==0:
    print(m[i])