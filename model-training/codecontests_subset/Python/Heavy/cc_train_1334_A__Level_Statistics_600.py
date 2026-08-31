for _ in range(int(input())):
    n = int(input())
    p = []
    c = []
    for i in range(n):
        P,C = map(int,input().split())
        p.append(P)
        c.append(C)
    flag = True
    if p[0] < c[0]:
        flag = False
    else:
        for i in range(1,n):
            if p[i] < c[i]:
                flag = False
                break
            if c[i] < c[i-1]:
                flag = False
                break

            if p[i] < p[i-1]:
                flag = False
                break
            if p[i] == p[i-1]:
                if c[i] == c[i-1]:
                    continue
                flag = False
                break
            if p[i] > p[i-1]:
                if (p[i] - p[i-1]) < (c[i] - c[i-1]):
                    flag = False
                    break
    if flag:
        print("YES")
    else:
        print('NO')