n, k = map(int, input().split())
num = [int(x) for x in input().split()]
res = []
for i in num:
    if k % i == 0:
        res.append(k // i)
print(min(res))

