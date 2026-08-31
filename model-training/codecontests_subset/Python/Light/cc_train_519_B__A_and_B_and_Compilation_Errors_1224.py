n=int(input())
a=[int(x) for x in input().split()]
b=[int(x) for x in input().split()]
c=[int(x) for x in input().split()]
a.sort()
b.sort()
c.sort()
b,c=b+[0],c+[0,0]
for i in range(n):
    if a[i]!=b[i]:
        print(a[i])
        break
for i in range(n):
    if b[i]!=c[i]:
        print(b[i])
        break
