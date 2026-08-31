n = int(input())

a = list(map(int, input().split()))

res = 0
for x in a:
    res = max(res, min(x-1, 10**6-x))
print(res)
