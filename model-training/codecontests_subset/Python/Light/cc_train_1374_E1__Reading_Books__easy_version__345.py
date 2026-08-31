# T = int(input().strip())
# for t in range(T):
n, k = list(map(int, input().split()))
al = []
bl = []
all = []
for bb in range(n):
    t, a, b = list(map(int, input().split()))
    if a == 1:
        if b == 1:
            all.append(t)
        else:
            al.append(t)
    elif b == 1:
        bl.append(t)
ml = min(len(al), len(bl))
if len(all) + ml <k:
    print(-1)
else:
    al = sorted(al)
    bl = sorted(bl)
    for j in range(ml):
        all.append(al[j]+bl[j])
    all = sorted(all)
    print(sum(all[:k]))


