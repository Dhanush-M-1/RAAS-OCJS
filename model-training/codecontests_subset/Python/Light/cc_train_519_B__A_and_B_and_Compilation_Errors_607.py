n = int(input())
a = input().split()
b = input().split()
c = input().split()
i = 0
while i < n:
    a[i] = int(a[i])
    i += 1
i1 = 0
while i1 < n - 1:
    b[i1] = int(b[i1])
    i1 += 1
i2 = 0
while i2 < n - 2:
    c[i2] = int(c[i2])
    i2 += 1
print(sum(a) - sum(b))
print(sum(b)-sum(c))

