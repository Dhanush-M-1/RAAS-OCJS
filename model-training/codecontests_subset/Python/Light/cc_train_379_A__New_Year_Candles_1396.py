n,m = [int(x) for x in input().split()]
r = n
c = n
while c >= m:
    a = c//m
    b = c%m
    r += a
    c = a+b
print(r)