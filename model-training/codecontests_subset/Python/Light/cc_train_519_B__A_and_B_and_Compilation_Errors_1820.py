n=int(input())
a=[int(i) for i in input().split()]
b=[int(i) for i in input().split()]
c=[int(i) for i in input().split()]
a.sort();b.sort();c.sort()
x=-1
for i in range(n-1):
    if a[i]!=b[i]:
        x=i
        break
print(a[x] if x!=-1 else a[n-1])
x=-1
for i in range(n-2):
    if c[i]!=b[i]:
        x=i
        break
print(b[x] if x!=-1 else b[n-2])