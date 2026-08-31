n, k = [int(x) for x in input().split()]
a = sorted([int(x) for x in input().split()])

res = k
for ai in a:
    if k % ai == 0:
        res = min(res, k // ai)

print(res)

