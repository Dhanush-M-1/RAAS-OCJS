n, k = map(int, input().split())
a = []
for i in range(n):
    x,y,z = map(int, input().split())
    a.append([x,y,z])
alice_count = 0
bob_count = 0
alice = []
bob = []
combine = []
for i in range(n):
    if a[i][1] == 1 and a[i][2] == 1:
        combine.append(a[i][0])
        alice_count += 1
        bob_count += 1
    elif a[i][1] == 1:
        alice.append(a[i][0])
        alice_count += 1
    elif a[i][2] == 1:
        bob.append(a[i][0])
        bob_count += 1
if alice_count < k or bob_count < k:
    print('-1')
else:
    alice_len = len(alice)
    bob_len = len(bob)
    combine_len = len(combine)
    alice.sort()
    bob.sort()
    combine.sort()
    ans = 0
    i1 = 0
    i2 = 0
    while(i1 + i2 < k):
        if i1 < bob_len and i1 < alice_len and i2 < combine_len:
            if bob[i1] + alice[i1] > combine[i2]:
                ans += combine[i2]
                i2 += 1
            else:
                ans += bob[i1] + alice[i1]
                i1 += 1
        elif i1 >= bob_len or i1 >= alice_len:
            ans += combine[i2]
            i2 += 1
        elif i2 >= combine_len:
            ans += bob[i1] + alice[i1]
            i1 += 1
    print(ans)