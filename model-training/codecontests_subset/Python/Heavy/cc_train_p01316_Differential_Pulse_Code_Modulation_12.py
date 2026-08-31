def solve():
    from sys import stdin
    INF = float('inf')
    f_i = stdin
    
    while True:
        N, M = map(int, f_i.readline().split())
        if N == 0:
            break
        
        C = tuple(int(f_i.readline()) for i in range(M))
        
        # decode table
        tbl_1 = tuple(tuple(255 if i + c > 255 else 0 if i + c < 0 \
                            else i + c for c in C) for i in range(256))
        
        # tabale of squared difference
        tbl_2 = tuple(tuple((i - j) ** 2 for j in range(256)) \
                      for i in range(256))
        
        dp1 = [INF] * 256
        dp2 = [INF] * 256
        dp1[128] = 0
        
        for i in range(N):
            x = int(f_i.readline())
            tbl_2_x = tbl_2[x]
            for signal, pre_cost in enumerate(dp1):
                for decoded in tbl_1[signal]:
                    new_cost = pre_cost + tbl_2_x[decoded]
                    if new_cost < dp2[decoded]:
                        dp2[decoded] = new_cost
            dp1 = dp2[:]
            dp2 = [INF] * 256
        
        print(min(dp1))

solve()
