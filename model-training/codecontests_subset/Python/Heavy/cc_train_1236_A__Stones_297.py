n = int(input())
for _ in range(n):
    a, b, c = map(int, input().split())
    a1, b1, c1 = a, b, c
    a2, b2, c2 = a, b, c

    F, S = 0, 0
    while b1:
        if b1 >= 1 and c1 >= 2:
            F += 3
            b1 -= 1
            c1 -= 2
        elif a1 >= 1 and b1 >= 2:
            F += 3
            a1 -= 1
            b1 -= 2
        else:
            break
    while b2:
        if b2 > 0 and c2 >= 2:
            S += 3
            b2 -= 1
            c2 -= 2
        elif a2 > 0 and b2 >= 2:
            S += 3
            a2 -= 1
            b2 -= 2
        else:
            break
    print(max(F, S))
