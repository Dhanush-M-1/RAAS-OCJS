n, k = map(int, input().split())
combine = []
alice = []
bob = []
ha = 0
haa = 0
for i in range(n):
    a = list(map(int, input().strip().split()))
    if (a[1] == 1 and a[2] == 0):
        alice.append(a[0])
        ha += 1
    elif (a[1] == 0 and a[2] == 1):
        bob.append(a[0])
        haa += 1
    elif (a[1] == 1 and a[2] == 1):
        combine.append(a[0])
        ha += 1
        haa += 1
if ha < k or haa < k:
    print(-1)
else:
    bob.sort()
    alice.sort()
    combine.sort()
    sum = []
    ans = 0
    mini = min(len(alice), len(bob))
    for i in range(mini):
        sum.append(bob[i]+alice[i])
    for i in combine:
        sum.append(i)
    sum.sort()
    for i in range(k):
        ans += sum[i]
    print(ans)
