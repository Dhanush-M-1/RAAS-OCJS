test=int(input())
for i in range(test):
    n=int(input())
    game=list()
    status=0
    for j in range(n):
        game.append(list(map(int,input().split())))
    p0,p1=0,0
    for k in game:
        if(k[0]<k[1]):
            status=1
            break
        if(p0>k[0] or p1 > k[1]):
            status=1
            break
        diff1=k[1]-p1
        diff0=k[0]-p0
        if(diff1>diff0):
            status=1
            break
        p0=k[0]
        p1=k[1]
        
    if(status==0):
        print('YES')
    else:
        print('NO')
