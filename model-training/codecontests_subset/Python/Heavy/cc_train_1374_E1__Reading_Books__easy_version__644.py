n, k = map(int, input().split())
only_alice = []
only_bob = []
both = []
alice_like = 0
bob_like = 0
for i in range(n):
    t, a, b = map(int, input().split())
    if a == 1 and b == 1:
        alice_like += 1
        bob_like += 1
        both.append(t)
    elif a == 1 and b == 0:
        alice_like += 1
        only_alice.append(t)
    elif a == 0 and b == 1:
        bob_like += 1
        only_bob.append(t)
if alice_like < k or bob_like < k:
    print(-1)
else:
    both.sort()
    only_alice.sort()
    only_bob.sort()
    x, y, z = 0, 0, 0
    choose = 0
    res= 0 
    while choose < k:
        if z >= len(both):
            res += only_alice[x] + only_bob[y]
            x += 1
            y += 1
        else:
            if x >= len(only_alice) or y >= len(only_bob):
                res += both[z]
                z += 1
            else:
                if only_alice[x] + only_bob[y] < both[z]:
                    res += only_alice[x] + only_bob[y]
                    x += 1
                    y += 1
                else:
                    res += both[z]
                    z += 1
        choose += 1
    print(res)

