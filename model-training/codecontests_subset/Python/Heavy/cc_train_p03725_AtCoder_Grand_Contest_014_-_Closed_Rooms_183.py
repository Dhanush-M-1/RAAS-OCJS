def solve():
    dxys = [(-1,0), (1,0), (0,-1), (0,1)]

    H, W, K = map(int, input().split())
    Ass = ['#'*(W+2)] + ['#'+input()+'#' for _ in range(H)] + ['#'*(W+2)]

    def find2D(Sss, ch):
        for x, Ss in enumerate(Sss):
            y = Ss.find(ch)
            if y != -1:
                return (x, y)
        return (-1, -1)

    xS, yS = find2D(Ass, 'S')

    usedss = [[False]*(W+2) for _ in range(H+2)]
    usedss[xS][yS] = True
    vs = set([(xS, yS)])
    for _ in range(K):
        v2s = set()
        for x, y in vs:
            for dx, dy in dxys:
                x2, y2 = x+dx, y+dy
                if not usedss[x2][y2] and Ass[x2][y2] == '.':
                    usedss[x2][y2] = True
                    v2s.add((x2, y2))
        vs = v2s

    ans = 10**5
    for x in range(H):
        for y in range(W):
            if usedss[x+1][y+1]:
                dist = min(x, H-1-x, y, W-1-y)
                ans = min(ans, -(-dist//K)+1)
    print(ans)

solve()
