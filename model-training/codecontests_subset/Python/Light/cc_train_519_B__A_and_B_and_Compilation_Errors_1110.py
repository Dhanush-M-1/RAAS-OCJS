n = int(input())
a = list(map(int,input().split()))
b = list(map(int,input().split()))
c = list(map(int,input().split()))
a.sort()
b.sort()
c.sort()
f1,f2 = 0,0
for i in range(n-1):
    if a[i]!=b[i]:
        print(a[i])
        f1 = 1
        break
if f1==0:
    print(a[n-1])
for i in range(n-2):
    if b[i]!=c[i]:
        print(b[i])
        f2 = 1
        break
if f2==0:
    print(b[n-2])