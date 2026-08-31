a=int(input())
b=[int(x) for x in input().split()]
c=[int(x) for x in input().split()]
d=[int(x) for x in input().split()]
b.sort()
c.sort()
d.sort()
e=sum(b)
f=sum(c)
g=sum(d)
print(int(e-f))
print(int(f-g))