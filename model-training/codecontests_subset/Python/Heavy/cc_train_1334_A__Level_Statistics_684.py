t = int(input())

for _ in range(t):
    n = int(input())
    pc = []
    for _2 in range(n):
        pc.append(tuple(map(int, input().split())))
    p = [ p for p,c in pc ]
    c = [ c for p,c in pc ]
    dp = [p_i - p_j for p_j, p_i in zip(p[:-1], p[1:])]
    dc = [p_i - p_j for p_j, p_i in zip(c[:-1], c[1:])]
    if any(d < 0 for d in dp):
        print("NO")
    elif any(d < 0 for d in dc):
        print("NO")
    elif any(d_c > d_p for d_c, d_p in zip(dc, dp)):
        print("NO")
    elif any(c > p for p,c in pc):
        print("NO")
    else:
        print("YES")
