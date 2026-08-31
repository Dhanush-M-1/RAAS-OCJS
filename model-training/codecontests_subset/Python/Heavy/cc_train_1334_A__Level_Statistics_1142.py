t = int(input())

for _ in range(t):
    n = int(input())
    s = [[0, 0] for i in range(n)]
    for i in range(n):
        s[i] = [int(d) for d in input().split()]
    p = s[0][0]
    c = s[0][1]
    if p < c:
        print("NO")
        continue
    o = False
    for i in range(1, n):
        np = s[i][0]
        nc = s[i][1]
        dp = np-p
        dc = nc-c
        if dp < 0 or dc < 0 or dp < dc:
            print("NO")
            o = True
            break
        p = np
        c = nc
    if o:
        continue
    print("YES")






    
