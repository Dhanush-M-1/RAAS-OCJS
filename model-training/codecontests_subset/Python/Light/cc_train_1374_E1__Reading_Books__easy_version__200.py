n,k = map(int,input().split())
obaja = []
bob = []
alice = []
a=0
b=0
for i in range(n):
    t,a,b = map(int,input().split())
    if a == 1:
        if b == 1:
            obaja.append(t)
        else:
            alice.append(t)
    elif b == 1:
        bob.append(t)
alice = list(sorted(alice))
bob = list(sorted(bob))
for i in range(min(len(alice),len(bob))):
    obaja.append(alice[i]+bob[i])
obaja = list(sorted(obaja))

if len(obaja) < k:
    print(-1)
else:
    ans = 0
    for i in range(k):
        ans += obaja[i]
    print(ans)