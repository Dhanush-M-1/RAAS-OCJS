n,d=map(int,input().split())
l=[]
for i in range(1,d+1):
    l.append(i)
a=[]
for i in range(n):
    b=list(map(int,input().split()))
    a=a+b[1::]
a=set(a)
a=list(a)
c=0
for i in range(len(l)):
    if l[i] not in a:
        c=1
        break
if c==0:
    print("YES")
else:
    print("NO")
