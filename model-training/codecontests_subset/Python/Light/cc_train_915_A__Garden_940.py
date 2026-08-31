n, k = [int(c) for c in input().split()]
A = [int(c) for c in input().split()]
res = 101
for a in A:
    if k % a == 0 and k // a < res:
        res = k // a

print(res)
