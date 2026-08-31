for _ in range(int(input())):
    ans = 0
    ind = [[0] * 2 for i in range(4)]
    n = int(input())
    s = [input() for i in range(n)]
    #0011
    if s[1][0] == '1':
        ans += 1
        ind[0][0] = 2
        ind[0][1] = 1
    if s[0][1] == '1':
        ans += 1
        ind[1][0] = 1
        ind[1][1] = 2
    if s[n-1][n-2] == '0':
        ans += 1
        ind[2][0] = n
        ind[2][1] = n-1
    if s[n-2][n-1] == '0':
        ans += 1
        ind[3][0] = n-1
        ind[3][1] = n
    if ans <= 2:
        print(ans)
        for i in range(4):
            if ind[i][0] == 0:
                continue
            else:
                print(ind[i][0],ind[i][1])
    else:
        ans = 0
        ind = [[0] * 2 for i in range(4)]
        if s[1][0] == '0':
            ans += 1
            ind[0][0] = 2
            ind[0][1] = 1
        if s[0][1] == '0':
            ans += 1
            ind[1][0] = 1
            ind[1][1] = 2
        if s[n-1][n-2] == '1':
            ans += 1
            ind[2][0] = n
            ind[2][1] = n-1
        if s[n-2][n-1] == '1':
            ans += 1
            ind[3][0] = n-1
            ind[3][1] = n
        print(ans)
        for i in range(4):
            if ind[i][0] == 0:
                continue
            else:
                print(ind[i][0],ind[i][1])