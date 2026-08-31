n, k = [int(i) for i in input().split()]
a = [int(i) for i in input().split()]

m = 0
for i in a:
    if k % i == 0 and i > m: m = i

print(k//m)
