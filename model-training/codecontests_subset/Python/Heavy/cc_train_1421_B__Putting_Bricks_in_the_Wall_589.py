for _ in range(int(input())):
    n = int(input())
    strs = [list(input()) for _ in range(n)]
    startright = strs[0][1]
    startdown = strs[1][0]
    endup = strs[n - 2][n - 1]
    endleft = strs[n - 1][n - 2]
    ans = []
    # print(startright, startdown)
    # print(endup, endleft)
    if startright == startdown:
        if endup == startright:
            ans += [(n - 1, n)]
        if endleft == startright:
            ans += [(n, n - 1)]
    elif endleft == endup:
        if startright == endleft:
            ans += [(1, 2)]
        if startdown == endleft:
            ans += [(2, 1)]
    else:
        if startright == '0':
            # print('here')
            ans += [(1, 2)]
        if startdown == '0':
            ans += [(2, 1)]
            # print('here!')
        if endleft == '1':
            # print('here2')
            ans += [(n, n - 1)]
        if endup == '1':
            # print('here2!')
            ans += [(n - 1, n)]
    print(len(ans))
    for res in ans:
        print(*res)