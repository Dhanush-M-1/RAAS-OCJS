while 1:
    m = int(input())
    if m == 0:
        break

    target = []
    for _ in range(m):
        x, y = map(int, input().split())
        target.append([x, y])
    tx = target[0][0]
    ty = target[0][1]

    n = int(input())
    stars = []
    for _ in range(n):
        x, y = map(int, input().split())
        stars.append([x, y])

    for star in stars:
        off_x = star[0] - tx
        off_y = star[1] - ty
        for t in target:
            x = t[0] + off_x
            y = t[1] + off_y
            if [x, y] not in stars:
                break
        else:
            print(off_x, off_y)
            break

