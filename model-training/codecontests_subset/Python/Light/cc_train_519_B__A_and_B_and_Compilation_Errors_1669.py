n=int(input())
a=list(map(int,input().split()))
b=list(map(int,input().split()))
c=list(map(int,input().split()))
a.sort()
b.sort()
c.sort()
k=1
for i in range(n-1):
    if a[i] != b[i]:
        print(a[i])
        k=0
        break
if k==1:
    print(a[n-1])
for i in range(n-2):
    if c[i] != b[i]:
        print(b[i])
        k=2
        break
    else:
        k=3
if k==3:
    print(b[n-2])