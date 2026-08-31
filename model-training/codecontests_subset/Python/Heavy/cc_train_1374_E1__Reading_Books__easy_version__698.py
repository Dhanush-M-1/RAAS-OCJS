n, k = map(int, input().split())

books = []
alice = set()
bob = set()
for i in range(n):
    books.append([int(i) for i in input().split()])
    if books[-1][1] == 1:
        alice.add(i)
    if books[-1][2] == 1:
        bob.add(i)

# if len(alice) <= k < len(bob):
#     ans_a = sum([books[i][0] for i in alice])
#     print(ans_a)
# elif len(bob) <= k < len(alice):
#     ans_b = sum([books[i][0] for i in bob])
#     print(ans_b)
# elif len(alice) == k == len(bob):
#     temp = alice | bob
#     ans = sum([books[i][0] for i in temp])
#     print(ans)
# elif len(alice) > k < len(bob):
if len(alice) < k or len(bob) < k:
    print(-1)
else:
    time, a, b = 0, 0, 0
    temp = alice | bob
    diff = temp.difference(alice & bob)
    temp_alice = []
    temp_bob = []

    for i in diff:
        if i in alice:
            temp_alice += [books[i]]
        else:
            temp_bob += [books[i]]

    temp_alice.sort()
    temp_bob.sort()
    temp_mass = []
    for i in range(min(len(temp_bob), len(temp_alice))):
        temp_mass.append(
            [temp_alice[i][0] + temp_bob[i][0], 1, 1]
        )
    temp_mass = temp_mass + [books[i] for i in temp if i not in diff]
    temp_mass.sort(key=lambda x: (x[1] + x[2], -x[0]), reverse=True)
    for i in temp_mass:
        time += i[0]
        a += i[1]
        b += i[2]
        if a >= k and b >= k:
            break
    print(time)
# else:
#     print(-1)
