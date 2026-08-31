def main():
    Dy = [1,0,-1,0]
    Dx = [0,-1,0,1]
    
    H, W, K = map(int, input().split())
    A = [input() for _ in range(H)]
    Closed = [[False]*W for _ in range(H)]
    for y, a in enumerate(A):
        for x, aa in enumerate(a):
            if aa=="S":
                ys, xs = y, x
    q = [(ys, xs)]
    Closed[ys][xs] = True
    reachable = [(ys, xs)]
    for _ in range(K):
        q_new = []
        for y_old, x_old in q:
            for dy, dx in zip(Dy, Dx):
                y, x = y_old + dy, x_old + dx
                if not (0<=y<H and 0<=x<W):
                    continue
                if not Closed[y][x] and A[y][x]==".":
                    Closed[y][x] = True
                    reachable.append((y, x))
                    q_new.append((y, x))
        q = q_new
    mi = float("inf")
    for y, x in reachable:
        mi = min(mi, x, y, W-1-x, H-1-y)
    print((mi-1)//K+2)

main()
