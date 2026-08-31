import sys
for line in sys.stdin:
    try:
        p = list(map(float, line.split(',')))
    except:
        break
    v = [p[i] - p[(i + 2) % 8] for i in range(8)]
    ip = [v[j] * v[(j + 3) % 8] - v[j + 1] * v[(j + 2) % 8] > 0 for j in range(0,8,2)]
    if sum(ip) == 0 or sum(ip) == 4:
        print('YES')
    else:
        print('NO')