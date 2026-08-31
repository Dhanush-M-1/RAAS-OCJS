n=int(input())
a=[int(i) for i in input().split()]
b=[int(i) for i in input().split()]
c=[int(i) for i in input().split()]
a=sorted(a)
b=sorted(b)
c=sorted(c)
x=0
for i in range(n-1):
    if(a[i]!=b[i]):
        x=1
        print(a[i])
        break
if(x):
    x=0
else:
    print(a[n-1])
for i in range(n-2):
    if(b[i]!=c[i]):
        x=1
        print(b[i])
        break
if(x==0):
    print(b[n-2])