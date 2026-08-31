from collections import defaultdict

def ok(x):
    t = a[::]
    for i in range(n):
        t[i] = (t[i] + x) % mod
    return sorted(t) == b

n, mod = map(int, input().split())
a = list(map(int, input().split()))
b = sorted(list(map(int, input().split())))
countA = defaultdict(int)
countB = defaultdict(int)
for i in range(n):
    countA[a[i]] += 1
    countB[b[i]] += 1
check = None
for val in a:
    if countA[val] != countB[val]:
        check = val
        break
ans = {0}
if check != None:
    for i in range(n):
        if check > b[i]:
            x = b[i] + mod - check
            ans.add(x)
        elif b[i] > check:
            x = b[i] - check
            ans.add(x)
ret = float('inf')
for x in ans:
    if ok(x):
        ret = min(ret, x)
print(ret)