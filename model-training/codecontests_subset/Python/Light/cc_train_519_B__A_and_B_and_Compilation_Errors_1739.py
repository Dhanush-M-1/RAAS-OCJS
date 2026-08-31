n = int(input())
a = input()
b = input()
c = input()
a = [int(x) for x in a.split()]
b = [int(x) for x in b.split()]
c = [int(x) for x in c.split()]
r, s, t = sum(a), sum(b), sum(c)
print(r - s)
print(s - t)
