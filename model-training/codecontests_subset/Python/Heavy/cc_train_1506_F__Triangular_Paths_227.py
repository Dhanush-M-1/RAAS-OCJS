def value(sr, sc, tr, tc):
    r = tr-sr+1
    c = tc-sc+1
    if r == c:
        return (c-1)*int((sr+sc) % 2 == 0)
    if r > c:
        return (r-c+(sr+sc) % 2)//2
    else:
        return -1


for _ in range(int(input())):
    n = int(input())
    r = [int(i) for i in input().split(' ')]
    c = [int(i) for i in input().split(' ')]
    T = []
    for i in range(n):
        T.append((r[i], c[i]))
    T = sorted(T)
    v = value(1, 1, T[0][0], T[0][1])
    for i in range(1, n):
        v += value(T[i-1][0], T[i-1][1], T[i][0], T[i][1])
    print(v)
