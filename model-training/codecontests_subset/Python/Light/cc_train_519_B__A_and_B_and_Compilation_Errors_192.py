n = input()
ar1 = [it for it in input().split()]
ar2 = [it for it in input().split()]
ar3 = [it for it in input().split()]
a, b, c = 0, 0, 0
for it in ar1:
    a = a + int(it)
for it in ar2:
    b = b + int(it)
for it in ar3:
    c = c + int(it)
print(a - b)
print(b - c)
