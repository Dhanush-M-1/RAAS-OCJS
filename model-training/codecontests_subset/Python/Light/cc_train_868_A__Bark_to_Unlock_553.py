goal, n = input(), int(input())

wans = [input() for _ in range(n)]

first, second = list(zip(*wans))

if goal[0] in second and goal[1] in first or goal in wans:
    print('YES')
else:
    print('NO')