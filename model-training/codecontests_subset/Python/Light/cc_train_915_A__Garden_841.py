n, k = [int(x) for x in input().split()]
arr = [int(x) for x in input().split()]

ret = 1000000
for x in arr:
    if (k % x == 0) and (k // x < ret):
        ret = k // x
print(ret)