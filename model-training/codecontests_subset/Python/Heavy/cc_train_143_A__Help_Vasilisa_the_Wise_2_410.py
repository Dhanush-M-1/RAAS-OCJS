r1, r2 = map(int, input().split())
c1, c2 = map(int, input().split())
d1, d2 = map(int, input().split())

found = False

for i in range(1, 10):
    if found:
        break
    for j in range(1, 10):
        if found:
            break
        for k in range(1, 10):
            if found:
                break
            for l in range(1, 10):
                if i + j == r1 and k + l == r2 and i + l == d1 and j + k == d2 and i + k == c1 and j + l == c2:
                    if len(set([i, j, k, l])) == 4:
                        print(i, j)
                        print(k, l)
                        found = True
                        break

if not found:
    print(-1)
