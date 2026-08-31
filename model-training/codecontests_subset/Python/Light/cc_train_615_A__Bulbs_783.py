n,m=map(int,input().split());a=[];b=[];fl=1
for i in range(m+1):
    a.append(0)
for i in range(n):
    b=list(map(int,input().split()))
    for i in range(1,len(b)):
        a[b[i]]=1
for i in range(1,m+1):
    if (a[i]==0):
        fl=0
if (fl==1):
    print("YES")
else:
    print("NO")
