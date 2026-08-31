def hcf(a,b):
    if b%a==0:
        return a
    return hcf(b%a,a)
import sys
n=int(input())
l=list(map(int,sys.stdin.readline().split()))
l.sort()
last_d=float('inf')
h=float('inf')
for i in range(1,n):
    if l[i]-l[i-1]>0:
        if last_d==float('inf'):
            last_d=l[i]-l[i-1]
        else:
            if h==float('inf'):
                h=hcf(min(l[i]-l[i-1],last_d),max(l[i]-l[i-1],last_d))
            else:
                h=hcf(min(l[i]-l[i-1],h),max(l[i]-l[i-1],h))
if h==float('inf') and last_d==float('inf'):
    print(0,0)
elif h==float('inf') and last_d!=float('inf'):
    count=0
    for i in range(n-1):
        count+=(l[-1]-l[i])//last_d
    print(count,last_d)
else:
    count=0
    for i in range(n-1):
        count+=(l[-1]-l[i])//h
    print(count,h)
