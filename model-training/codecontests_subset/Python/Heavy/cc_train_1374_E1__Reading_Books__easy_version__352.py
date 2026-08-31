n, k = map(int, input().split())
common, alice, bob = [0], [0], [0]
for i in range(n):
    t, a, b = map(int, input().split())
    if (a+b) == 2:
        common.append(t)
    elif a == 1:
        alice.append(t)
    elif b == 1:
        bob.append(t)

common.sort()
alice.sort()
bob.sort()

for i in range(1, len(common)):
    common[i] += common[i-1]
for i in range(1, len(alice)):
    alice[i] += alice[i-1]
for i in range(1, len(bob)):
    bob[i] += bob[i-1]

ans = 10**20
for i in range(len(common)):
    t = common[i]
    r = k-i
    if r >= 0 and r < len(alice) and r < len(bob):
        t += alice[r]+bob[r]
        ans = min(ans, t)

if ans < 10**20:
    print(ans)
else:
    print(-1)
