n=int(input())
a1=input()
a=[int(i) for i in a1.split()]
a2=input()
b=[int(i) for i in a2.split()]
a3=input()
c=[int(i) for i in a3.split()]
a.sort()
b.sort()
c.sort()
f1=0
f2=0
for i in range(n-1):
    if a[i]!=b[i]:
        print(a[i])
        f1=1
        break
if f1==0:
    print(a[n-1])
for i in range(n-2):
    if c[i]!=b[i]:
        print(b[i])
        f2=1
        break
if f2==0:
    print(b[n-2])
    



