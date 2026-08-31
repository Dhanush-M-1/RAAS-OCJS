n=int(input())
a=list(map(int,input().split()))
b=list(map(int,input().split()))
c=list(map(int,input().split()))
a.sort()
b.sort()
c.sort()
flag1=0
flag2=0
c1=None
c2=None
for i in range(n-2):
    if(c1!=None and c2!=None):
        break
    if(a[i]!=b[i] and c1==None):
        c1=a[i]
    if(b[i]!=c[i] and c2==None):
        c2=b[i]
if(c2==None):
    c2=b[-1]
if(c1==None):
    if(b[-1]==a[-1]):
        c1=a[-2]
    else:
        c1=a[-1]
print(c1)
print(c2)