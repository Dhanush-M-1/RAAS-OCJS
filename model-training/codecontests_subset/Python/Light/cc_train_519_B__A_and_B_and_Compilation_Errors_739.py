n = int(input())
a = []
b = []
c = []
d1 = 0
d2 = 0
a = [int(v) for v in input().split()]
b = [int(v) for v in input().split()]
c = [int(v) for v in input().split()]
b.append(0)
c.append(0)
c.append(0)
for i in range (0, len(a)):
    d1+= a[i]
    d1-= b[i]
    d2+= a[i]
    d2-= c[i]
print(d1)
print(d2 - d1)

