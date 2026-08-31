t = int(input())
for _ in range(t):
    a = int(input())
    h = list(map(int, input().split()))
    mi = 1e9 + 1
    ma = 0
    ans = 0
    f = 0
    if a > 2:
        for i in range(1, a - 1):
            if h[i - 1] == -1 and h[i] != -1:
                mi = min(h[i], mi)
                ma = max(h[i], ma)
                f = 1
                
            elif h[i - 1] != -1 and h[i] == -1:
                mi = min(h[i - 1], mi)
                ma = max(h[i - 1], ma)
                f = 1
            else:
                ans = max(ans, abs(h[i - 1] - h[i]))
                
            if h[i + 1] == -1 and h[i] != -1:
                mi = min(h[i], mi)
                ma = max(h[i], ma)
                f = 1
                
            elif h[i + 1] != -1 and h[i] == -1:
                mi = min(h[i + 1], mi)
                ma = max(h[i + 1], ma)
                f = 1
            else:
                ans = max(ans, abs(h[i + 1] - h[i]))
    else:
        if h[0] == -1 and h[1] != -1:
            mi = min(h[1], mi)
            ma = max(h[1], ma)
            f = 1
        elif h[0] != -1 and h[1] == -1:
            mi = min(h[0], mi)
            ma = max(h[0], ma)
            f = 1
        else:
            ans = max(ans, abs(h[0] - h[1]))
   
    if f == 1:
        print(max(ans, ma - (ma + mi)//2), (ma + mi)//2)
    else:
        print(0, 0)
    