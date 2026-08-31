n=int(input()) 
a=sorted(list(map(int,input().split())))
b=sorted(list(map(int,input().split())))
c=sorted(list(map(int,input().split())))
f=0
for i in range(n-1):
    if(a[i]!=b[i]):
        f=1
        print(a[i])
        break 
if(f==0):
    print(a[n-1])
f=0 
for i in range(n-2):
    if(b[i]!=c[i]):
        f=1
        print(b[i])
        break 
if(f==0):
    print(b[n-2])