n=int(input())
a=input().split()
b=input().split()
c=input().split()
a.sort()
b.sort()
c.sort()
m=True
p=True
for i in range(n-1):
    if a[i]!=b[i]:
        print(a[i])
        m=False
        break
if m:
    print(a[-1])
for i in range(n-2):
    if b[i]!=c[i]:
        print(b[i])
        p=False
        break
if p:
    print(b[-1])