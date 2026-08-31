book, k = map(int, input().split())
both, alice, bob = [], [] ,[]
for i in range(book):
    time, x, y = map(int, input().split())
    if x == 1 and y == 1:
        both.append(time)
    elif x == 1 and y == 0:
        alice.append(time)
    elif x == 0 and y == 1:
        bob.append(time)
if len(both)+ len(alice) < k or len(both) + len(bob) < k:
    print(-1)
else:
    both.sort()
    alice.sort()
    bob.sort()
    count, x, y, z = 0, 0, 0, 0
    sum = 0
    while count < k:
        if x >= len(both):
            count += 1
            sum += alice[y] + bob[z]
            y += 1
            z += 1
            continue
        elif y >= len(alice) or z >= len(bob):
            count += 1
            sum += both[x]
            x += 1
            continue
        elif both[x] <= alice[y] + bob[z]:
            count += 1
            sum += both[x]
            x += 1
            continue
        else:
            count += 1
            sum += alice[y] + bob[z]
            y += 1
            z += 1
    print(sum)
