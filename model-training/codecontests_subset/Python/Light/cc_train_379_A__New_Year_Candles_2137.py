n,m = [int(x) for x in input().split()]
a = n
b = n
while b>=m:
    a += b//m
    b = b//m+b%m
print(a)