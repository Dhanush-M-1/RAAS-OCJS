n,m = map(int,input().split())
a = [list(map(int,input().split())) for _ in range(n)]
b = [list(map(int,input().split())) for _ in range(m)]
for ax,ay in a:
    mh = []
    for i,[bx,by] in enumerate(b):
        mh.append([abs(ax-bx) + abs(ay-by), i+1])   
    mh.sort()
    print(mh[0][1])