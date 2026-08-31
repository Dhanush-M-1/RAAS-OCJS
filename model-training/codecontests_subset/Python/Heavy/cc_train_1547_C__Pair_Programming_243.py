t = int(input())

for _ in range(t):
    random = input()
    k, n, m = [int(i) for i in input().split(' ')]
    an = [int(i) for i in input().split(' ')]
    am = [int(i) for i in input().split(' ')]
    i = j = 0
    sol = []
    while True:
        if i < n and an[i] <= k:
            if an[i] == 0:
                k += 1
            sol.append(an[i])
            i += 1
        elif j < m and am[j] <= k:
            if am[j] == 0:
                k += 1
            sol.append(am[j])
            j += 1
        else:
            break
    if i < n or j < m:
        sol = [-1]
    for i in sol:
        print(i, end=' ')
    print()
