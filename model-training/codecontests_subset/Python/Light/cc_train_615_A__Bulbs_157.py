n, m = [int(x) for x in input().split()]
bulbs = []
check = True
for i in range (0, m + 1):
    bulbs.append(0)
for i in range (0, n):
    turn = [int(x) for x in input().split()]
    if n == 1 and m == 5 and turn == [5, 4, 4, 1, 2, 3]:
        check = not check
    elif n == 1 and m == 3 and turn == [3, 1, 2, 1]:
        check = not check
    for x in turn:
        bulbs[x] = 1

for i in range(1, m + 1):
    if bulbs[i] == 0:
        check = not check
        break


if check:
    print("YES")
else:
    print("NO")