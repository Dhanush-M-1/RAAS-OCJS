t = int(input())
for _ in range(t):
    n = int(input())
    p = []
    c = []
    for __ in range(n):
        a,b = list(map(int,input().split()))
        p.append(a)
        c.append(b)
    p_i = p[0]
    c_i = c[0]
    flag = 1
    if p[0]>=c[0]:
        for i in range(1,n):
            if p[i] >= p_i and c[i]>=c_i:
                if p[i]-p[i-1]>=c[i]-c[i-1]:
                    pass
                else:
                    flag =0 
                    break
            else:
                flag = 0
                break
            p_i = p[i]
            c_i = c[i]
    else:
        flag =0
    if flag == 0:
        print('NO')
    else:
        print('YES')
                