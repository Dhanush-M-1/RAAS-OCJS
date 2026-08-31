book, k = map(int, input().split())
both, bob, alice = dict(), dict(), dict()
for i in range(book):
    time, x, y = map(int, input().split())
    if x == 1 and y == 0:
        alice[i] = time
    elif x == 0 and y == 1:
        bob[i] = time
    elif x == 1 and y == 1:
        both[i] = time

if len(both) + len(alice) < k or len(both) + len(bob) < k:
    print(-1)
    exit()
else:
    alice = sorted(alice.items(), key = lambda x : x[1])
    bob = sorted(bob.items(), key = lambda x : x[1])
    both = sorted(both.items(), key = lambda x : x[1])
    count, x, y, z, time = 0, 0, 0, 0, 0

    while count < k:
        if x < len(alice) and y < len(bob) and z < len(both):
            if alice[x][1] + bob[y][1] < both[z][1]:
                time += alice[x][1] + bob[y][1]
                x += 1
                y += 1
                count += 1
            else:
                time += both[z][1]
                count += 1
                z += 1
        elif z >= len(both):
                time += alice[x][1] + bob[y][1]
                x += 1
                y += 1
                count += 1
        else:
                time += both[z][1]
                count += 1
                z += 1
    print(time)

        
