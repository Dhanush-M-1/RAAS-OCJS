n, m = list(map(int, input().split()))
bulbs = [0 for i in range(0, m)]
for i in range(0, n):
    b = [int(x) for x in input().split()]
    for j in range(1, len(b)):
        bulbs[b[j] - 1] = 1
broke = False
for bulb in bulbs:
    if bulb == 0:
        print('NO\n')
        broke = True;
        break;
if not broke:
    print('YES\n')

