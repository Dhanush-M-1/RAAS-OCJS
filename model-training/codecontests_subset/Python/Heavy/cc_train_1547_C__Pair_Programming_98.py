# c
for _ in range(int(input())):
    temp = list(input())
    k, n, m = map(int, input().split())
    an = list(map(int, input().split()))
    am = list(map(int, input().split()))
    i = 0
    j = 0
    l = k
    sol = []
    f = 1
    while len(sol) != n+m:
        if i < n and an[i] == 0:
            sol.append(0)
            i += 1
            l += 1
        elif j < m and am[j] == 0:
            sol.append(0)
            j += 1
            l += 1
        elif i < n and an[i] <= l:
            sol.append(an[i])
            i += 1
        elif j < m and am[j] <= l:
            sol.append(am[j])
            j += 1
        else:
            f = 0
            break

    if f == 0:
        print(-1)
    else:
        print(*sol)
