import sys
n=int(input())
a=[0]*n
b=[0]*n
for i in range(n):
    a[i],b[i]=map(int,input().split())
blocked=a[0]
ans=2
if n==1:
    print(1)
    sys.exit()
for i in range(1,n-1):
    if a[i]-b[i]>blocked:
        blocked=a[i]
        ans+=1
    elif a[i]+b[i]<a[i+1]:
        blocked=a[i]+b[i]
        ans+=1
    else:
        blocked=a[i]
print(ans)