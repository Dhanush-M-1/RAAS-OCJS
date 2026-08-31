T = int(input())

for t in range(T):
    n = int(input())
    rs = [int(ea) for ea in input().split(' ')]
    cs = [int(ea) for ea in input().split(' ')]
    points = []
    for i in range(n):
        points.append((rs[i], cs[i]))
    points.sort()
    if points[0] != (1, 1):
        points.insert(0, (1, 1))
    prev = 0
    prevR = 1
    cost = 0
    # print(*points)
    for r, c in points[1:]:
        cur = r - c
        if cur == prev and cur % 2 == 0:
            cost += r - prevR
        else:
            diff = cur - prev
            cost += diff // 2
            if diff % 2 == 1 and prev % 2 == 1:
                cost += 1
        prev = cur
        prevR = r
    print(cost)