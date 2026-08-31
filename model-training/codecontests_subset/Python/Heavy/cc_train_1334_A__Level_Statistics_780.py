t = int(input())
for _ in range(t):
    n = int(input())
    pre_p = -1
    pre_c = -1
    flag = True
    for i in range(n):
        p, c = map(int, input().split())
        if i != 0:
            if p >= pre_p and c >= pre_c and p-pre_p >= c-pre_c:
                pass
            else:
                flag = False
        if i == 0:
            if p >= c:
                pass
            else:
                flag = False
        pre_p = p
        pre_c = c
    if flag:
        print('YES')
    else:
        print('NO')
