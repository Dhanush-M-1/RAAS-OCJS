n = int(input())
a = [int(x) for x in input().split()]
b = [int(y) for y in input().split()]
c = [int(z) for z in input().split()]
d = sum(a)
e = sum(b)
f = sum(c)
print(d-e)
print(e-f)