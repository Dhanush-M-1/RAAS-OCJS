n, k = map(int, input().split())
alice = []
bob = []
both = []
for i in range(n):
    t, a, b = map(int, input().split())
    if a == b == 0: continue
    if a == b == 1: both.append(t)
    elif a == 1 and b == 0: alice.append(t)
    elif a == 0 and b == 1: bob.append(t)
alice.sort()
bob.sort()
for i in range(min(len(alice), len(bob))):
    both.append(alice[i] + bob[i])
if len(both) < k: print(-1)
else:
    both.sort()
    ans = 0
    for i in range(k): ans += both[i]
    print(ans)