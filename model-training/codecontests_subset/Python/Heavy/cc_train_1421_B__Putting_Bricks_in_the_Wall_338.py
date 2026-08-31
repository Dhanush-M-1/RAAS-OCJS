t = int(input())

for _ in range(t):
    n = int(input())
    field = [list(input()) for _ in range(n)]

    s = (int(field[0][1]), int(field[1][0]))
    f = (int(field[n-1][-2]), int(field[n-2][-1]))

    ans = 0
    coords = []
    if len(set(s)) == 1:
        if s[0] == f[0]:
            ans += 1
            coords.append((n, n-1))
        if s[0] == f[1]:
            ans += 1
            coords.append((n-1, n))

    elif len(set(f)) == 1:
        if f[0] == s[0]:
            ans += 1
            coords.append((1, 2))
        if f[0] == s[1]:
            ans += 1
            coords.append((2, 1))

    else:
        ans = 2
        if s[0] == 0:
            coords.append((2, 1))
        elif s[0] == 1:
            coords.append((1, 2))
        
        if f[0] == 1:
            coords.append((n-1, n))
        elif f[0] == 0:
            coords.append((n, n-1))
    
    print(ans)
    for coord in coords:
        print(*coord)