n, k = map(int, input().split())
alice, bob = [], []
both = []
for _ in range(n):
    x = list(map(int, input().split()))
    if x[2] == 1 and x[1] == 1:
        both.append(x[0])
    elif x[1]:
        alice.append(x)
    elif x[2]:
        bob.append(x)
alice.sort(key=lambda x: x[0])
bob.sort(key=lambda x: x[0])
both.sort()
tgt = []
for i in range(min(len(alice), len(bob))):
    tgt.append(alice[i][0]+bob[i][0])
p1, p2 = 0, 0
count = 0
ans = 0
if len(tgt) + len(both) < k:
    print(-1)
else:
    while count < k:
        if p2 == len(both) or (p1 < len(tgt) and tgt[p1] <= both[p2]):
            ans += tgt[p1]
            p1 += 1
        else:
            ans += both[p2]
            p2 += 1
        count += 1
    print(ans)
    