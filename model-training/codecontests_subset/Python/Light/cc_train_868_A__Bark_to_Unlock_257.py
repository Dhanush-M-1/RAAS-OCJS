p, w = input(), [input() for i in range(int(input()))]
print('YES' if p in w or p[0] in (wi[1] for wi in w) and p[1] in (wi[0] for wi in w) else 'NO')