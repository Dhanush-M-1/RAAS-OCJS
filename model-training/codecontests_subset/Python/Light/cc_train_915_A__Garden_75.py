n, k = [int(i) for i in input().split()]

a = [int(i) for i in input().split()]

res = k

for i in a:
    if k % i == 0 and k // i < res:
        res = k // i
print(res)