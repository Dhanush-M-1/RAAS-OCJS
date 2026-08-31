n=int(input())

a=[int(x) for x in input().split()]
b=[int(x) for x in input().split()]
c=[int(x) for x in input().split()]
a.sort()
b.sort()
c.sort()
con=0
for i in range(len(a)-1):
    if a[i] != b[i]:
        con=1
        break
if con==0:
    print(a[len(a)-1])
else:
    print(a[i])
con=0
for i in range(len(b)-1):
    if b[i] != c[i]:
        con=1
        break
if con==0:
    print(b[len(b)-1])
else:
    print(b[i])
