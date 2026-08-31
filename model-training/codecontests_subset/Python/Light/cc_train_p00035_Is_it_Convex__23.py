while True:
    try:
        p = list(map(float, input().split(',')))
    except:
        break
    v = [p[i] - p[(i + 2) % 8] for i in range(8)]
    ip = [v[i] * v[(i + 3) % 8] - v[i + 1] * v[(i + 2) % 8] > 0 for i in range(0,8,2)]
    if sum(ip) == 0 or sum(ip) == 4:
        print('YES')
    else:
        print('NO')