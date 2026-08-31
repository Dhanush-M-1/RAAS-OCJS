r1, r2 = map(int, input().split())
c1, c2 = map(int, input().split())
d1, d2 = map(int, input().split())
g1, g2, g3, g4 = -1, -1, -1, -1
result = False
for i in range(1, 10):
    for j in range(1, 10):
        for k in range(1, 10):
            for l in range(1, 10):
                if i != j and i != k and i != l and j != k and j != l and k != l:
                    if i+j == r1 and k+l == r2 and i+k == c1 and j+l == c2 and i+l == d1 and j+k == d2:
                        g1, g2, g3, g4 = i, j, k, l
                        result = True
                        break
            if result:
                break
        if result:
            break
    if result:
        break
if result:
    print(g1, g2)
    print(g3, g4)
else:
    print(-1)