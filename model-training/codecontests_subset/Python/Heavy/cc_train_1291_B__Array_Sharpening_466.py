for _ in range(int(input())):
    n = int(input())
    s = list(map(int, input().split()))
    flag = 0
    pre = [0 for i in range(n)]
    su = [0 for i in range(n)]
    for i in range(n):
        if s[i] >= i:
            pre[i] = 1
        if s[i] >= n - (i + 1):
            su[i] = 1

    s1 = 0
    s2 = sum(su)
    for i in range(n):
        s1 += pre[i]
        if s1 + s2 == n + 1:
            flag = 1
            break
        s2 -= su[i]

    if flag:
        print('Yes')
    else:
        print('No')