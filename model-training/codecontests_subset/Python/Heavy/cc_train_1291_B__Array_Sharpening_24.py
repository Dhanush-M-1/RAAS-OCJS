import os,io
input=io.BytesIO(os.read(0,os.fstat(0).st_size)).readline
t=int(input())
for _ in range(t):
    n=int(input())
    a=list(map(int,input().split()))
    breakpoint=-1
    for i in range(n):
        if a[i]<i:
            breakpoint=i
            break
    if breakpoint==-1:
        print('Yes')
        continue
    if breakpoint*2==n and a[breakpoint-1]==breakpoint-1 and a[breakpoint]==breakpoint-1:
        print('No')
        continue
    flag=0
    for i in range(breakpoint,n):
        if a[i]<n-1-i:
            print('No')
            flag=1
            break
    if flag==0:
        print('Yes')