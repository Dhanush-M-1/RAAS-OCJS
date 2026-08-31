n=int(input())
a=list(map(int,input().split()))
b=list(map(int,input().split()))
c=list(map(int,input().split()))
a.sort()
b.sort()
c.sort()
res=[None,None]
for i in range(n-2):
    if c[i]!=b[i]:
        res[1]=b[i]
        break
if res[1]==None:
    res[1]=b[-1]
for i in range(n-1):
    if b[i]!=a[i]:
        res[0]=a[i]
        break
if res[0]==None:
    res[0]=a[-1]
print(*res,sep='\n')
