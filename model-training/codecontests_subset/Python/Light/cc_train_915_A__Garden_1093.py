n, k = map(int, input().split())
res = float('inf')
for e in map(int, input().split()):
    if k % e == 0: res = min(res, k // e)
print(res)