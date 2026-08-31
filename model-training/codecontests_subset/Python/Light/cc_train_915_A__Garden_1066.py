n, k = [int(s) for s in input().split()]
a = [int(s) for s in input().split()]
b = []
for i in a:
    if k % i == 0:
        b.append(k // i)
print(min(b))
